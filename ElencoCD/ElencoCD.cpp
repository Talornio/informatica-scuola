#include <iostream>
#include <string>

using namespace std;

const int MAX = 10;

struct cd {
	string code;
	string title;
	string author;
	int price;
};

void printAllCd(cd v[MAX], int n) {
	for (int i = 0; i < n; i++) {
		cout << "Codice del " << i + 1 << "o cd: " << v[i].code << endl;
		cout << "Titolo del " << i + 1 << "o cd: " << v[i].title << endl;
		cout << "Autore del " << i + 1 << "o cd: " << v[i].author << endl;
		cout << "Prezzo del " << i + 1 << "o cd: " << v[i].price << endl;
		cout << endl;
	}
	cout << endl;
}

void printCd(cd v[MAX], int i) {
	cout << "Codice del " << i + 1 << "o cd: " << v[i].code << endl;
	cout << "Titolo del " << i + 1 << "o cd: " << v[i].title << endl;
	cout << "Autore del " << i + 1 << "o cd: " << v[i].author<< endl;
	cout << "Prezzo del " << i + 1 << "o cd: " << v[i].price<< endl;
}

int arrayMaxDim() {
	int max;
	cout << "Inserisci quanti cd vuoi ordinare." << endl;
	cin >> max;
	while (max < 1 || max > MAX) {
		cout << "Numero inserito errato." << endl;
		cout << "Inserisci di nuovo il numero di cd." << endl;
		cin >> max;
	}
	cout << endl;
	return max;
}

void insDataAllCd(cd v[MAX], int max) {
	for (int i = 0; i < max; i++) {
		cout << "Inserisci il codice del "<< i+1 <<"o cd" << endl;
		cin >> v[i].code;
		cout << "Inserisci il titolo del " << i+1 << "o cd" << endl;
		cin >> v[i].title;
		cout << "Inserisci il l'autore del " << i+1 << "o cd" << endl;
		cin >> v[i].author;
		cout << "Inserisci il prezzo del " << i+1 << "o cd" << endl;
		cin >> v[i].price;
		cout << endl;
	}
}

void insDataCd(cd v[MAX], int n) {
	cout << "Inserisci il codice del " << n << "o cd" << endl;
	cin >> v[n].code;
	cout << "Inserisci il titolo del " << n  << "o cd" << endl;
	cin >> v[n].title;
	cout << "Inserisci il l'autore del " << n << "o cd" << endl;
	cin >> v[n].author;
	cout << "Inserisci il prezzo del " << n << "o cd" << endl;
	cin >> v[n].price;
	cout << endl;
}

void cdSearch(cd v[MAX], int max) {
	string search;
	cout << "Codice: ";
	cin >> search;
	int i = -1;
	bool found = false;
	do {
		i++;
		if (v[i].code == search) {
			found = true;
			printCd(v, i);
		}
	} while (found == false || i < max);
	if (found == false) {
		cout << "CD non trovato." << endl;
	}
	cout << endl;
}

//ordinamento per sostituzione
void replaceSort(cd v[MAX], int n) {
	cd scambio;
	for (int i = 0; i < n - 1; i++) {
		for (int j = 0; j < n; j++) {
			if (v[i].code < v[j].code) {
				scambio = v[i];
				v[i] = v[j];
				v[j] = scambio;
			}
		}
	}
}

//ordinamento per selezione
void selectSort(cd v[MAX], int n) {
	cd scambio;
	int min;
	for(int i = 0; i < n - 1; i++){
	min = i;
        for(int j = i + 1; j < n; j++){
        	if (v[j].code < v[min].code){
        		min = j;
			}  
		}
        scambio = v[min];
        v[min] = v[i];
        v[i] = scambio;
    }
}

void bubbleSort(cd v[MAX], int n) {
	cd scambio;
	for (int j = 0; j < n - 1; j++) {
		for (int i = 0; i < n - 1; i++) {
			if (v[i].code > v[i + 1].code){
				scambio = v[i];
				v[i] = v[i + 1];
				v[i + 1] = scambio;
			}
		}
	}
}

void cdDelete(cd v[MAX], int& max) {
	int n;
	cout << "Inserisci la posizione del cd che vuoi eliminare: " << endl;
	cin >> n;
	for (int i = n + 1; i < max; i++) {
		v[n] = v[i];
	}
	max--;
}

void cdAdd(cd v[MAX], int& max) {
	max++;
	cout << "Inserisci dati del nuovo cd: " << endl;
	insDataCd(v, max);
}

int main() {
	cd v[MAX];
	int max = arrayMaxDim();
	int selection;

	insDataAllCd(v, max);

	cout << "Inserisci 1 per ricercare un CD dato il suo codice." << endl;
	cout << "Inserisci 2 per eliminare un CD dalla raccolta." << endl;
	cout << "Inserisci 3 per aggiungere un cd alla raccolta." << endl;
	cout << "Inserisci 4 per visualizzare la raccolta ordinata per codice." << endl;   //guarda pg 237
	cout << "Inserisci 0 per uscire dal programma." << endl;

	cin >> selection;

	switch (selection) {
	case 1:
		cdSearch(v, max);
	    break;
	case 2:
		cdDelete(v, max);
		cout << "I cd rimasti sono: " << max << endl;
		printAllCd(v, max);
		break;
	case 3:
		if (max < MAX) {
			cdAdd(v, max);
			printAllCd(v, max);
		}
		else {
			cout << "Non si possono aggiungere altri cd." << endl;
		}
		break;
	case 4:
		cout << "Inserisci 1 per ordinare con ordinamento per sostituzione." << endl;
		cout << "Inserisci 2 per ordinare con ordinamento per selezione." << endl;
		cout << "Inserisci 3 per ordinare con ordinamento a bolla." << endl;
		cin >> selection;
		switch (selection){
		case 1:
			replaceSort(v, max);
			printAllCd(v, max);
			break;
		case 2:
			selectSort(v, max);
			printAllCd(v, max);
			break;
		case 3:
			bubbleSort(v, max);
			printAllCd(v, max);
			break;
		default:
			cout << "Numero inserito non valido, uscita dal programma in corso..." << endl;
			break;
		}
		break;
	case 0:
		cout << "Uscita dal programma in corso..." << endl;
		break;
	}
	
	return 0;
}