#include <iostream>
#include <string>
using namespace std;

const int MAX = 40;

int main() {
	int a, pmin=0, pmax=0;                                                   //a = alunni, max = voto maggiore, min = voto minore
	int i=0;                                                                   //variabile per i contatori
	bool trovato = false;
	string cogn[MAX];
	float voti[MAX];
	float max = 0.0, min = 0.0; 

	cout << "Quanti alunni ci sono nella classe?" << endl;
	cin >> a;

	for (i = 0; i < a; i++) {
		cout << "Qual e' il cognome dell' alunno " << i+1 << "?" << endl;
		cin >> cogn[i];
		cout << "E qual e' la sua media dei voti?" << endl;
		cin >> voti[i];
	}

	min = voti[0];
	max = voti[0];

	for (i = 0; i < a; i++) {
		if (voti[i] < min) {
			min = voti[i];
			pmin = i;
		}
		else if (voti[i] > max) {
			max = voti[i];
			pmax = i;
		}
	}
	cout << "L'alunno " << cogn[pmin] << " ha la media minore: " << min << endl;
	cout << "L'alunno " << cogn[pmax] << " ha la media maggiore: " << max << endl;

	return 0;
}
