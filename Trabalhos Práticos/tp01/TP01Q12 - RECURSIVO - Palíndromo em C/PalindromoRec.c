#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define NUMENTRADA 1000
#define TAMLINHA   1000

//metodo para verificar se eh a ultima linha d leitura do arquivo
bool isFim(char *s)
{
    return (strlen(s) >= 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

bool isPalindromo(char* original, int i, int j){
    bool resp = true;

    if(j >= i){
        if(original[i] != original[j]){
            resp = false;
        }
        else{
            resp = isPalindromo(original, i+1, j-1);
        }
    }

    return resp;
}

int main()
{
    // inicio leitura pub.in
    char linha[NUMENTRADA][TAMLINHA];
    int numEntrada = 0;

    do
    {
        fgets(linha[numEntrada], TAMLINHA, stdin);
    } while (isFim(linha[numEntrada++]) == false);
    numEntrada--;
    // fim leitura pub.in
    

    //aqui eu chamo a função isPalindroo para cada uma das entradas do pubin;
    for(int i = 0; i < numEntrada; i++ ){
        if(isPalindromo(linha[i], 0, (strlen(linha[i])-2)) == true){
            printf("SIM\n");
        }else{
            printf("NAO\n");
        }
    }


    return 0;
}