#include <stdio.h>
#include <stdlib.h>

int main(){

    int num;
    scanf("%d", num);

    FILE *file;
    file = fopen("reais.txt", "w+");

    //variavel criada para armazenar numero lido no formato correto
    float aux;

    for(int i = 0; i < num; i++){
        scanf("%f", &num);
        fwrite(&aux,sizeof(float),1 , file);
    }

    fclose(file);

    file = fopen("reais.txt", "r");
    


    return 0;
}