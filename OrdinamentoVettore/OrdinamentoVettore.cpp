#include <iostream>
using namespace std;
const int MAX = 10;

void scambia(int& a, int& b){
	int c;
	c = a;
	a = b;
	b = c;
}

//ordinamento per sostituzione
void ordina(int v[MAX]){
	for(int i = 0; i<MAX - 1; i++){
		for(int j = 0; j<MAX; j++){
			if(v[i]<v[j]){
				scambia(v[i], v[j]);
			}
		}
	}
}

//ordinamento per selezione          //mo va
void ordina2(int v[MAX]){
	int app;
	int min;
	for(int i=0;i<MAX-1;i++)
    {
	min=i;
        for(int j=i+1;j<MAX;j++){
        	if (v[j]<v[min]){
        		min= j;
			}  
		}
        app=v[min];
        v[min]=v[i];
        v[i]=app;
    }
}

//bubble sort
void ordina3(int v[MAX]){
	int app;
	for(int j = 0; j < MAX - 1; j++){
		for(int i = 0; i < MAX - 1; i++){
			if(v[i] > v[i + 1]){
				app = v[i];
				v[i] =v [i+1];
				v[i+1] = app;
			}
		}
	}
}




int main() {
	int v[MAX];
	cout<<"Inserisci 10 numeri da ordinare: "<<endl;
	for(int i = 0; i<MAX; i++){
		cin>>v[i];
	}
	ordina3(v);
	cout<<endl<<"I numeri ordinati: "<<endl;
	for(int i = 0; i<MAX; i++){
		cout<<v[i]<<" ";
	}
	return 0;
}
