#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define NUMENTRADA 1000
#define TAMLINHA   1000

bool isFim(char* s){
	return (strlen(s) >= 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

bool isMaiuscula(char c){
    return (c >= 'A' && c <= 'Z');
}

int contarMaiusculas(char* s){
    int resp = 0;
    for(int pos = 0; pos < strlen(s); pos++){
        if(isMaiuscula(s[pos]) == true){
            resp++;
        }
    }
    return resp;
}

int main(){

    //Inicio leitura do programa
    char linha[NUMENTRADA][TAMLINHA];
    int numEntrada = 0;

    do{
        fgets(linha[numEntrada], TAMLINHA, stdin);
    }while (isFim(linha[numEntrada++]) == false);
    numEntrada--;
    //Fim leitura do programa

    for(int i = 0; i < numEntrada; i++){
        printf("%i\n", contarMaiusculas(linha[i]));
    }
    
    return 0;
}