#include <iostream>
using namespace std;

int maxtime(int hour, int minute, int second) {
	int totsecond;
	minute = minute + hour * 60;
	second = second + minute * 60;
	totsecond = second;
	//si potrebbe ritornare direttamente second senza usare un' altra variabile d' appoggio
	return totsecond;
}

int main() {
	int h, m, s, stot1, stot2;     //anche qui si potrebbe usare ditrettamente s come conteggio totale dei secondi

	for (int i = 0; i < 2; i++) {
		cout << "Inserisci la " << i + 1 << "a quantita' di tempo." << endl;
		cout << "Ore = ";
		cin >> h;
		while (h < 0) {
			cout << "Non si accettano quantita' negative, reinserisci il valore." << endl;
			cin >> h;
		}
		cout << "Minuti = ";
		cin >> m;
		while (m < 0) {
			cout << "Non si accettano quantita' negative, reinserisci il valore." << endl;
			cin >> m;
		}
		cout << "Secondi = ";
		cin >> s;
		while (s < 0) {
			cout << "Non si accettano quantita' negative, reinserisci il valore." << endl;
			cin >> s;
		}
		cout << endl;

		if (i == 0) {
			stot1 = maxtime(h, m, s);
		}
		else if (i == 1) {
			stot2 = maxtime(h, m, s);
		}
	}

	if (stot1 > stot2) {
		cout << "La quantita' maggiore di tempo e' la prima con: " << stot1 << " secondi." << endl;
		cout << "La seconda e' di " << stot2 << " secondi.";
	}
	else {
		cout << "La quantita' maggiore di tempo e' la seconda con: " << stot2 << " secondi." << endl;
		cout << "La prima e' di " << stot1 << " secondi.";
	}

	return 0;
}
