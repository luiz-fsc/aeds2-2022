#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

#define NUMENTRADA 1000
#define TAMLINHA   1000

bool isFim(char* s){
    return(strlen(s) >= 1 && s[0] == '0');
}

int proxPassagem(char* s){

    int anoAtual = atoi(s);
    int aux = 76 - ((anoAtual - 1986)%76);
    int anoPassgem;
    if(aux == 0){
        anoPassgem = anoAtual + 76;
    }else{
        anoPassgem = anoAtual + aux;
    }
    return anoPassgem;
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
        printf("%d\n", proxPassagem(linha[i]));
    }

}