#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

#define NUMENTRADA 1000
#define TAMLINHA   1000

bool isFim(char* s){
    return(strlen(s) >= 1 && s[0] == '0');
}

int calculaIdade(char* s){
    char idadeMonica[5];
    char idadeFilho1[5];
    char idadeFilho2[5];
    int j = 0;

    int i = 0;
    while(s[i] != ' '){
        idadeMonica[j] = s[i];
        i++;
        j++;
    }i++;
    j = 0;
    while(s[i] != ' '){
        idadeFilho1[j] = s[i];
        i++;
        j++;
    }i++;
    j=0;
    while(i < strlen(s)){
        idadeFilho2[j] = s[i];
        i++;
        j++;
    }

    int ageMonica;
    int idades[3]; 
    ageMonica = atoi(idadeMonica);
    idades[0] = atoi(idadeFilho1);
    idades[1] = atoi(idadeFilho2);

    idades[2] = ageMonica - (idades[0]+idades[1]);

    int maior = idades[2];
        for(int z = 0; z < 2; z++){
            if(idades[z] > maior){
                maior = idades[z];
            }
        }
    return maior;

}

int main(){

    // inicio leitura pub.in
    char linha[NUMENTRADA][TAMLINHA];
    int numEntrada = 0;

    do
    {
        fgets(linha[numEntrada], TAMLINHA, stdin);
    } while (isFim(linha[numEntrada++]) == false);
    numEntrada--;
    // fim leitura pub.in

    for(int i = 0; i < numEntrada; i++){
        printf("%d\n", calculaIdade(linha[i]));
    }

}