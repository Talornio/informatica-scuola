#include <iostream>
using namespace std;

const int MAXXA = 10;
const int MAXYA = 10;
const int MAXXB = 10;
const int MAXYB = 10;

int main() {
	int i = 0, j = 0, k=0;
	int dimxa, dimxb, dimya, dimyb;
	int a[MAXYA][MAXXA];
	int b[MAXYB][MAXXB];
	int ab[MAXYA][MAXXB];

	//inserimento dimensioni delle matrici a e b
	do {
		cout << "Inserisci dimensione y della matrice a" << endl;
		cin >> dimya;
	} while (dimya < 1 || dimya>100);
	do {
		cout << "Inserisci dimensione x della matrice a" << endl;
		cin >> dimxa;
	} while (dimxa < 1 || dimxa>100);
	do {
		cout << "Inserisci dimensione y della matrice b" << endl;
		cin >> dimyb;
		if (dimxa != dimyb) {
			cout << "Errore, reinserisci questa dimensione" << endl;
		}
	} while (dimyb < 1 || dimyb>100 || dimxa != dimyb);
	do {
		cout << "Inserisci dimensione x della matrice b" << endl;
		cin >> dimxb;
	} while (dimxb < 1 || dimxb>100);
	cout << endl;

	//inserimento dei numeri nella matrice dall' utente
	cout << "Matrice a:" << endl;
	for (i = 0; i < dimya; i++) {
		cout << "Inserisci il numero nella riga " << i + 1 << endl;
		for (j = 0; j < dimxa; j++) {
			cout << "Nella colonna " << j + 1 << endl;
			cin >> a[i][j];
		}
	}
	cout << endl;

	cout << "Matrice b:" << endl;
	for (i = 0; i < dimyb; i++) {
		cout << "Inserisci il numero nella riga " << i + 1 << endl;
		for (j = 0; j < dimxb; j++) {
			cout << "Nella colonna " << j + 1 << endl;
			cin >> b[i][j];
		}
	}
	cout << endl;

	//calcolo matrice ab
	for (i = 0; i < dimya; i++) {
		for (j = 0; j < dimxb; j++) {
			 ab[i][j] = 0;
			for(k=0; k<dimxb; i++){
				ab[i][j] = ab[i][j] + (a[i][k] * b[k][j]);
			}
		}
	}
	cout << endl;
	
	
	//stampa matrice
    cout << "La matrice prodotto: " << endl;
	for(i = 0; i < dimya; i++){ 
		for(j = 0; j < dimxb; j++){
			cout << ab[i][j];
		}
		cout << endl;
	}
	cout << endl;
	
	return 0;
}
