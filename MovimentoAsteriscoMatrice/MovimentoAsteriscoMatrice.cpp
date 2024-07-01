#include <iostream>
using namespace std;

const int MAX = 20;
char map[MAX][MAX];
int i, j;
int ipg = 1, jpg = 1;
char m;
char pg = 'o';

int main() {
	

	do {
		cin >> m;
		switch (m) {
		case 'w':
			jpg = jpg + 1;
			break;
		case's':
			jpg = jpg - 1;
		case 'a':
			ipg = ipg - 1;
			break;
		case'd':
			ipg = ipg + 1;

		default:
			break;
		}

		for (i = 0; i < MAX; i++) {
			for (j = 0; j < MAX; j++) {
				if (i == 0 || j == 0 || j == MAX - 1 || i == MAX - 1) {
					map[i][j] = '#';
				}
				else {
					map[i][j] = ' ';
				}
			}
		}

		map[ipg][jpg] = pg;

		for (i = 0; i < MAX; i++) {
			for (j = 0; j < MAX; j++) {
				cout << map[i][j];
			}
			cout << endl;
		}
	} while (ipg == MAX || jpg == MAX);
	
	return 0;
}

/*
void spostaPg() {
	for (int i = 0; i < MAX; i++) {
		for (int j = 0; j < MAX; j++) {
			if (i == 0) {
				map[i][j] = 1;
			}
			else {
				map[i][j] = 0;
			}
		}
	}

}

void stampaMap() {
	for (int i = 0; i < MAX; i++) {
		for (int j = 0; j < MAX; j++) {
			cout << map[i][j];
		}
		cout << endl;
	}
}
*/
