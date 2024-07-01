#include <iostream>
#include <string>
using namespace std;

struct car {
	int serialNumber;
	int matriculation;
	int displacement;
	string ownerName;
	string ownerSurname;
};

void initCar(car& car_selected);
void printCar(car car_selected);

int main(){
	car car_number1, car_number2;
	cout << "inserisci dati macchina 1: " << endl;
	initCar(car_number1);
	cout << "inserisci dati macchina 2: " << endl;
	initCar(car_number2);
	cout << "la macchina 1: " << endl;
	printCar(car_number1);
	cout << "la macchina 2: " << endl;
	printCar(car_number2);

	return 0;
}

void initCar(car& car_selected) {
	cout << "numero di serie della macchina: ";
	cin >> car_selected.serialNumber;
	while (car_selected.serialNumber > 999) {
		cout << "puoi inserire massimo 3 cifre, inserisci nuovamente il numero di serie." << endl;
		cin >> car_selected.serialNumber;
	}
	cout << endl;
	cout << "anno di immatricolazione: ";
	cin >> car_selected.matriculation;
	cout << endl;
	cout << "cilindrata della macchina: ";
	cin >> car_selected.displacement;
	cout << endl;
	cout << "nome e cognome del proprietario: ";
	cin >> car_selected.ownerName >> car_selected.ownerSurname;
	cout << endl;
}


void printCar(car car_selected) {
	cout << "numero di serie: " << car_selected.serialNumber << endl;
	cout << "anno di immatricolazione: " << car_selected.matriculation << endl;
	cout << "cilindrata: " << car_selected.displacement<<"cc" << endl;
	cout << "proprietario: " << car_selected.ownerName << ' ' << car_selected.ownerSurname << endl;
	cout << endl; 
}

