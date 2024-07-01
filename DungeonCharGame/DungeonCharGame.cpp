#include <iostream>
#include <Windows.h>
#include <fstream>
#include <string>
#include <cmath>
#include <cstdlib>
#include <stdio.h>
#include <ctime>
#include "BearLibTerminal.h"

using namespace std;

const int MAXENTITY = 50;
const int MAXGATE = 10;

struct border {
	int down;
	int top;
	int lateral;
};

struct Map {
	int floor;
	border wall;
	
};

//raggruppa le posizioni
struct position {
	int x;
	int y;
};

//raggruppa le entità
class Entity {     //   <-- OGGETTIIIIII
public:
	Entity(int x, int y, int hp, int def, int atk, char glyph, bool key, bool exist) : pos_{ x, y }, hp(hp), def(def), atk(atk), glyph_(glyph), key_(key), exist_(exist) {}
	Entity(const position& position, int hp, int def, int atk, const char glyph, bool key, bool exist) : pos_(position), hp(hp), def(def), atk(atk), glyph_(glyph), key_(key), exist_(exist) {}

private:

	position pos_;
	int glyph_;
	bool key_;
	bool exist_;
	
public:
	int hp;
	int def;
	int atk;
	char n[20];

	[[nodiscard]] int x() const {
		return pos_.x;
	}
	[[nodiscard]] int y() const {
		return pos_.y;
	}

	bool haveKey() {
		return key_;
	}
	void getKey() {
		key_ = true;
	}
	void useKey() {
		key_ = false;
	}

	void move(const int dx, const int dy) {                
		pos_.x += dx;
		pos_.y += dy;
		//clamp(pos_.x, 0, MAXX - 1);
		//clamp(pos_.y, 0, MAXY - 1);
		
	}

	void up(const int amount = 1) {
		move(0, -amount);
	}
	void down(const int amount = 1) {
		move(0, amount);
	}
	void right(const int amount = 1) {
		move(amount, 0);
	}
	void left(const int amount = 1) {
		move(-amount, 0);
	}

	bool isAtPos(const int x, const int y) const {
		return pos_.x == x && pos_.y == y;
	}
	bool isNear(int x, int y) {
		return ((x == pos_.x - 1 && y == pos_.y) || (x == pos_.x + 1 && y == pos_.y) || (x == pos_.x && y == pos_.y - 1) || (x == pos_.x && y == pos_.y + 1));
	}
	void eliminatePosition() {
		pos_.x = 0;
		pos_.y = 0;
	}
	void setPosition(int x, int y) {
		pos_.x = x;
		pos_.y = y;
	}

	int getGlyph() const {
		return glyph_;
	}

	void newStats(int health, int defence, int attack) {
		hp = health;
		def = defence;
		atk = attack;
	}

	bool isExisting() {
		return exist_;
	}
	void notExist() {
		exist_ = false;
		eliminatePosition();
	}
	void exist() {
		exist_ = true;
	}

	void setUp(int x, int y, int glyph, bool key, bool exist, int health, int defence, int attack) {
		pos_.x = x;
		pos_.y = y;
		glyph_ = glyph;
		key_ = key;
		exist_ = exist;
		hp = health;
		def = defence;
		atk = attack;
	}
};

class Gate {
private:
	position pos_;
	bool status_;
public:
	Gate(int x, int y, bool status) : pos_{ x, y }, status_(status) {}
	Gate(const position& position, bool status) : pos_(position), status_(status) {}

	[[nodiscard]] int x() const {
		return pos_.x;
	}
	[[nodiscard]] int y() const {
		return pos_.y;
	}

	bool status() {
		return status_;
	}
	void isOpen() {
		status_ = true;
	}
	void isClosed() {
		status_ = false;
	}

	void eliminatePosition() {
		pos_.x = 0;
		pos_.y = 0;
	}
	void setPosition(int x, int y) {
		pos_.x = x;
		pos_.y = y;
	}

	void setUp(int x, int y, bool status) {
		pos_.x = x;
		pos_.y = y;
		status_ = status;
	}
};

//trigger con isnear e isatpos se il giocatore è vicino ad un nemico, se vero combattono, quando il giocatore non ha più vita il gioco termina
void combat(Entity& hero, Entity& enemy) {
	if (hero.isNear(enemy.x(), enemy.y()) || hero.isAtPos(enemy.x(), enemy.y())) {
		hero.hp -= (enemy.atk - hero.def/5);
		enemy.hp -= (hero.atk - enemy.def/5);
		terminal_layer(1);
		terminal_clear_area(0, 22, TK_WIDTH, 9);
		terminal_printf(9, 23, "[color=red]%s[/color][color=green] inflict [/color][color=red]%d[/color][color=green] damage to [/color][color=red]%s[/color]", hero.n, hero.atk, enemy.n);   //stampa i danni che si infliggono le 2 entità che stanno combattendo
		terminal_printf(9, 25, "[color=red]%s[/color][color=green] inflict [/color][color=red]%d[/color][color=green] damage to [/color][color=red]%s[/color]", enemy.n, enemy.atk, hero.n);
		if (enemy.hp <= 0) {
			enemy.notExist();
			if (enemy.haveKey()) {
				enemy.useKey();
				hero.getKey();
				terminal_layer(1);
				terminal_clear_area(0, 22, TK_WIDTH, 9);
				terminal_print(9, 23, "[color=red]Hero[/color][color=green] get a [/color][color=red]Key[/color]");
			}
		}
		terminal_refresh();
		terminal_delay(500);
	}
}

//usa un oggetto quando il player si trova sopra e lo cancella
void useObject(Entity& user, Entity& object) {
	if (user.isAtPos(object.x(), object.y())) {
		user.hp += object.hp;
		user.def += object.def;
		user.atk += object.atk;
		object.notExist();
		terminal_layer(1);
		terminal_clear_area(0, 21, TK_WIDTH, 9);
		terminal_printf(9, 23, "[color=red]%s[/color][color=green] picked up [/color][color=red]%s[/color]", user.n, object.n);     //stampa che oggetto è stato raccolto
		terminal_refresh();
	}
}

//stampa le statistiche di un entità
void printStats(Entity entity){
	terminal_printf(98, 5, "[color=green]Health = [/color]%d", entity.hp);
	terminal_printf(98, 7, "[color=azure]Defense = [/color]%d", entity.def);
	terminal_printf(98, 9, "[color=red]Attack = [/color]%d", entity.atk);
}

int main() {
	//tutte le enitità preimpostate per il livello 1
	Entity hero{ {11, 6}, 100, 0, 20, 0x040, false, true};
	strcpy(hero.n, "Hero");          //un casino per usare i nomi
	Entity orc{ {17, 9}, 100, 0, 10, 0x006F, true, true };
	strcpy(orc.n, "Orc");
	Entity dragon{ {34, 16}, 100, 15, 20, 0x0044, true, true};
	strcpy(dragon.n, "Dragon");
	//tutti gli oggetti 
	Entity potion{ {38, 14}, 30, 0, 0, 0x0021, false, true};
	strcpy(potion.n, "Potion");
	Entity sword{ {46, 7}, 0, 0, 20, 0x0029, false, true};
	strcpy(sword.n, "Sword");
	Entity armor{{26, 6}, 0, 20, 0, 0x005B, false, true};
	strcpy(armor.n, "Armor");
	//componimento mappa
	Map map{ 0x02E, {0x2500, 0x005F, 0x007C} };
	//locked passages
	Gate door{ {23, 11}, false };
	Gate downstairs{ {29, 17}, false };
	bool game_running = true;
	int level = 1;
	int init_level = 1;

	//apre il terminale di BearLibTerminal
	terminal_open();
	terminal_set("window.title = 'Game'; window.size=120x30;");
	terminal_composition(TK_ON);
	terminal_bkcolor(color_from_name("black"));

	while (game_running) {
		//pulisce lo schermo
		terminal_layer(1);
		terminal_clear_area(0, 0, TK_WIDTH, 22); 

		//stampa i divisori tra mappa e stats
		for (int i = 0; i < 21; i++) {
			terminal_print(65, i, L" | \n");
		}
		for (int i = 0; i < 21; i++) {
			terminal_print(93, i, L" | \n");
		}
		for (int i = 0; i < TK_WIDTH; i++) {
			terminal_print(i, 21, L"─ \n");
		}

		//stampa le statistiche del player
		terminal_printf(70, 2, "[color=red]Your stats: [/color]");
		terminal_printf(70, 5, "[color=green]Health = [/color]%d", hero.hp);
		terminal_printf(70, 7, "[color=azure]Defense = [/color]%d", hero.def);
		terminal_printf(70, 9, "[color=red]Attack = [/color]%d", hero.atk);
		//rimane stampato "enemy stats: "
		terminal_printf(98, 2, "[color=red]Enemy stats: [/color]");
		//stampa le coordinate del giocatore
		terminal_printf(9, 1, "x: %d  y: %d", hero.x(), hero.y());

		if (level == 1) {
			terminal_layer(0);
			//stampa la mappa
			terminal_print
			(
				9, 3,
				L"_________________________                    \n"
				L"|.......................|                    \n"
				L"|.......................|       __________   \n"
				L"|.......................|       |........|   \n"
				L"|.......................|   #####........|   \n"
				L"|.......................#####   |........|   \n"
				L"|.......................|       ──────────   \n"
				L"|.......................|                    \n"
				L"──────────────#──────────                    \n"
				L"              #   _______________            \n"
				L"              ### |.............|            \n"
				L"                ###.............|            \n"
				L"                  |.............|            \n"
				L"                  |.............|            \n"
				L"                  |.............|            \n"
				L"                  ───────────────            \n"
			);

			//scale per piano sottostante
			terminal_put(29, 17, 0x003E);
			

			terminal_layer(1);
			//se esistono stampa gli oggetti/entità
			if (orc.isExisting()) {
				terminal_put(orc.x(), orc.y(), orc.getGlyph());
			}
			if (dragon.isExisting()) {
				terminal_put(dragon.x(), dragon.y(), dragon.getGlyph());
			}
			if (potion.isExisting()) {
				terminal_put(potion.x(), potion.y(), potion.getGlyph());
			}
			if (sword.isExisting()) {
				terminal_put(sword.x(), sword.y(), sword.getGlyph());
			}
			if (armor.isExisting()) {
				terminal_put(armor.x(), armor.y(), armor.getGlyph());
			}

			//se il giocatore è vicino a entità stampa le statistiche
			if (hero.isNear(orc.x(), orc.y())) {
				printStats(orc);
			}
			if (hero.isNear(dragon.x(), dragon.y())) {
				printStats(dragon);
			}

			//stampa il giocactore
			terminal_put(hero.x(), hero.y(), hero.getGlyph());
			
			

			terminal_refresh();

			//teletrasporto per cambio stanza
			if (hero.isAtPos(33, 8)) {
				hero.setPosition(42, 7);
			}
			if (hero.isAtPos(door.x(), door.y())) {
				if (!hero.haveKey() && !door.status()) {
					terminal_layer(1);
					terminal_clear_area(0, 21, TK_HEIGHT, 9);
					terminal_printf(9, 23, "[color=green]The door is locked, [color=red]Hero[/color][color=green] can't go on[/color]");
					hero.setPosition(23, 10);
				}
				else if (hero.haveKey() || door.status()) {
					terminal_layer(1);
					terminal_clear_area(0, 21, TK_HEIGHT, 9);
					terminal_printf(9, 23, "[color=red]Hero[/color][color=green] used a [/color][color=red]Key[/color]");
					hero.useKey();
					door.isOpen();
					hero.setPosition(28, 14);
				}
			}
			if (hero.isAtPos(27, 14)) {
				hero.setPosition(23, 10);
			}
			if (hero.isAtPos(41, 7)) {
				hero.setPosition(32, 8);
			}
			if (hero.isAtPos(downstairs.x(), downstairs.y())) {
				if (!hero.haveKey() && !downstairs.status()) {
					terminal_layer(1);
					terminal_clear_area(0, 21, TK_HEIGHT, 9);
					terminal_printf(9, 23, "[color=green]The stairs are locked, [color=red]Hero[/color][color=green] can't go down[/color]");
				}
				else if (hero.haveKey() || downstairs.status()) {
					hero.useKey();
					downstairs.isOpen();
					level = 2;
					hero.setPosition(48, 13);
				}
			}

			//inizia il combattimento automatico tra 2 entità
			combat(hero, orc);
			combat(hero, dragon);

			//il primo elemento utilizza il secondo
			useObject(hero, potion);
			useObject(hero, sword);
			useObject(hero, armor);
		}

		if (level == 2) {
			terminal_layer(0);
			terminal_print
			(
				9, 3,
				L"__________                                    \n"
				L"|........|                         _______    \n"
				L"|........#### ____________         |.....|    \n"
				L"|........|  ###..........|         |.....|    \n"
				L"─#────────    |..........|         ───#───    \n"
				L" #            |..........|  __________#_____  \n"
				L" #            |..........|  |..............|  \n"
				L" #            ─────────#──  |..............|  \n"
				L" #####                 #    |..............|  \n"
				L"     # ________        ######..............|  \n"
				L"     ###......|             |..............|  \n"
				L"       |......|             |..............|  \n"
				L"       |......|             ────────#───────  \n"
				L"       |......#######################         \n"
				L"       ────────                               \n"
				L"                                              \n"
			);

			terminal_layer(1);
			//stampa il giocactore
			terminal_put(hero.x(), hero.y(), hero.getGlyph());

			terminal_refresh();
		}
		

		terminal_layer(0);
		//prende ed esegue l'input dell'utente
		while (terminal_has_input()) {
			int key = terminal_read();
			switch (key) {
			case TK_W:
				if (terminal_pick(hero.x(), hero.y() - 1) != map.wall.top) {
					hero.up();
				}
				break;
			case TK_S:
				if (terminal_pick(hero.x(), hero.y() + 1) != map.wall.down) {
					hero.down();
				}
				break;
			case TK_D:
				if (terminal_pick(hero.x() + 1, hero.y()) != map.wall.lateral) {
					hero.right();
				}

				break;
			case TK_A:
				if (terminal_pick(hero.x() - 1, hero.y()) != map.wall.lateral) {
					hero.left();
				}
				break;
			case TK_ESCAPE:
				game_running = false;         //quit game
				break;
			}
		}

		//se il giocatore muore, pulisce lo schermo e stampa "you died"
		if (hero.hp <= 0) {
			while (terminal_read() != TK_ESCAPE) {
				terminal_clear();
				terminal_layer(3);
				terminal_printf
				(
					55, 10,
					"[color=red]YOU DIED[/color]"
				);
				terminal_refresh();
			}
			game_running = false;
		}
	}
	terminal_close();
	return 0;
}



//void clamp(int& value, int pos_min, int pos_max) {
//	if (value <= pos_min) {
//		value = pos_min;
//		return;
//	}
//	else if (value >= pos_max) {
//		value = pos_max;
//		return;
//	}
//}


//pulisce lo schermo -- non serve più in quanto ora si usa la clear della libreria BearLibTerminal
//void clear() {
//	COORD topLeft = { 0, 0 };
//	HANDLE console = GetStdHandle(STD_OUTPUT_HANDLE);
//	CONSOLE_SCREEN_BUFFER_INFO screen;
//	DWORD written;
//
//	GetConsoleScreenBufferInfo(console, &screen);
//	FillConsoleOutputCharacterA(
//		console, ' ', screen.dwSize.X * screen.dwSize.Y, topLeft, &written
//	);
//	FillConsoleOutputAttribute(
//		console, FOREGROUND_GREEN | FOREGROUND_RED | FOREGROUND_BLUE,
//		screen.dwSize.X * screen.dwSize.Y, topLeft, &written
//	);
//	SetConsoleCursorPosition(console, topLeft);
//}


/*
int main() {
	terminal_open();
	terminal_set("window.title='Omni: basic output'");
	terminal_clear();
	terminal_color("white");

	// Wide color range
	int n = terminal_printf(2, 1, "[color=orange]1.[/color] Wide color range: ").width;
	const char long_word[] = "antidisestablishmentarianism.";
	const size_t long_word_length = sizeof(long_word) - 1;
	for (size_t i = 0; i < long_word_length; i++)
	{
		float factor = float(i) / long_word_length;
		int red = (1.0f - factor) * 255;
		int green = factor * 255;
		terminal_color(color_from_argb(255, red, green, 0));
		terminal_put(2 + n + i, 1, long_word[i]);
	}
	terminal_color("white");

	terminal_print(2, 3, "[color=orange]2.[/color] Backgrounds: [color=black][bkcolor=gray] grey [/bkcolor] [bkcolor=red] red ");

	terminal_print(2, 5, L"[color=orange]3.[/color] Unicode support: Кириллица Ελληνικά α=β²±2°");

	terminal_print(2, 7, L"[color=orange]4.[/color] Tile composition: a + [color=red]/[/color] = a[+][color=red]/[/color], a vs. a[+][color=red]¨[/color]");

	terminal_printf(2, 9, "[color=orange]5.[/color] Box drawing symbols:");

	terminal_print
	(
		5, 11,
		L"   ┌────────┐  \n"
		L"   │!......s└─┐\n"
		L"┌──┘........s.│\n"
		L"│............>│\n"
		L"│...........┌─┘\n"
		L"│<.@..┌─────┘  \n"
		L"└─────┘        \n"
	);

	terminal_refresh();
	for (int key = 0; key != TK_CLOSE && key != TK_ESCAPE; key = terminal_read());
}
*/	