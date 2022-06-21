#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define NUMENTRADA 1000
#define TAMLINHA   1000


typedef struct{
   char *nome;
   char *originalTitle;
   char *releaseDate;
   int duration;
   char *genre;
   char *originalLanguage;
   char *status;
   double budget;
   char **keyWord;
}Filme;

void setNome(Filme *filme, char *nome){
    filme->nome = (char*)malloc((strlen(nome)+1)*sizeof(char));
    strcpy(filme->nome, nome);
}

void setOriginalTitle(Filme *filme, char *originalTitle){
    filme->originalTitle = (char*)malloc((strlen(originalTitle)+1)*sizeof(char));
    strcpy(filme->originalTitle, originalTitle);
}

void setReleaseDate(Filme *filme, char *releaseDate){
    filme->releaseDate = (char*)malloc((strlen(releaseDate)+1)*sizeof(char));
    strcpy(filme->releaseDate, releaseDate);
}

void setDuration(Filme *filme, int duration){
    filme->duration = duration;
}

void setGenre(Filme *filme, char *genre){
    filme->genre = (char*)malloc((strlen(genre)+1)*sizeof(char));
    strcpy(filme->genre, genre);
}

void setOriginalLanguage(Filme *filme, char *originalLanguage){
    filme->originalLanguage = (char*)malloc((strlen(originalLanguage)+1)*sizeof(char));
    strcpy(filme->originalLanguage, originalLanguage);
}

void setStatus(Filme *filme, char *status){
    filme->status = (char*)malloc((strlen(status)+1)*sizeof(char));
    strcpy(filme->status, status);
}

void setBudget(Filme *filme, double budget){
    filme->budget = budget;
}


Filme inicializa(Filme f1){
    strcpy(f1.nome, "\0");
    strcpy(f1.originalTitle, "\0");
    strcpy(f1.releaseDate, "\0");
    f1.duration = 0;
    strcpy(f1.genre, "\0");
    strcpy(f1.originalLanguage, "\0");
    strcpy(f1.status, "\0");
    f1.budget = 0;
    strcpy(f1.keyWord, "\0");
}

//metodo para verificar se eh a ultima linha d leitura do arquivo
bool isFim(char *s)
{
    return (strlen(s) >= 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
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
    
    Filme filmes[100];
    int count = 0;

    for(int i = 0; i < numEntrada; i++){
        filmes[count] = inicializa(filmes[count]);
    }
    

    return 0;
}