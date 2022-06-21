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

// aqui veriica se a string e palindromo
bool isPalindromo(char *s, int tam)
{
    bool resp = true;
    int i = 0;
    //nesse while eu uso do i e do tam para verificar se o char no inicio da string e igual ao char no final dela
    //se for igual eu nem entro no if e ando o tam e o i para continuar a verificação até o meio do vetor
    while(tam >= i){
        if(s[i] != s[tam]){
            resp = false;
        }
        i++;
        tam--;
    }
    
    //utilizei esse printf para fazer algumas verificações quando desenvolvi o programa
    //printf("string:%s\ttamanho:%i\n", s, tam);
    

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
        int tam = (strlen(linha[i])-2);
        if(isPalindromo(linha[i], tam) == true){
            printf("SIM\n");
        }else{
            printf("NAO\n");
        }
    }

    //utilizei esse for junto com o printf comentado no metodo isPalindromo para fazer algumas verificações
    /*for(int i = 0; i < numEntrada; i++ ){
        int tam = strlen(linha[i]);
        tam = tam-3;
        isPalindromo(linha[i], tam);
    }*/



    return 0;
}