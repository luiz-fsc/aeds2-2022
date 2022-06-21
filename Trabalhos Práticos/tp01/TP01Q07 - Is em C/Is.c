#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define NUMENTRADA 1000
#define TAMLINHA 1000

bool isFim(char *s)
{
    return (strlen(s) >= 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

bool isVogal(char *s, int tam)
{
    bool resp = true;
    // se houver algum char na string recebida que seja diferente das vogais, eu entro no if e resp recebe false;
    for (int i = 0; i < tam; i++)
    {
        if (s[i] != 'a' && s[i] != 'e' && s[i] != 'i' && s[i] != 'o' && s[i] != 'u' && s[i] != 'A' && s[i] != 'E' && s[i] != 'I' && s[i] != 'O' && s[i] != 'U')
        {
            resp = false;
        }
    }
    return resp;
}

bool isConsoante(char *s, int tam)
{
    bool resp = true;
    // verifico no for se tem algum char q sej vogal ou numero ou '.' ou ','
    //  se houver, eu entro dentro do if e resp recebe false
    for (int i = 0; i < tam; i++)
    {
        if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U' || (s[i] > 47 && s[i] < 58) || s[i] == '.' || s[i] == ',')
        {
            resp = false;
        }
    }
    return resp;
}

bool isInteiro(char *s, int tam)
{
    bool resp = true;
    // verifico se existe algum char fora dos limites dos numeros na tabela ascii
    // se hover entro dentro do if e resp recebe falseS
    for (int i = 0; i < tam; i++)
    {
        if (s[i] < 48 || s[i] > 57)
        {
            resp = false;
        }
    }
    return resp;
}

bool isReal(char *s, int tam)
{
    bool resp = true;

    // variavel para contar numero de ',' e '.' da String
    int count = 0;
    // aqui eu percorro a String e conta quantas virgulas e quantos pontos ela tem
    for (int i = 0; i < tam; i++)
    {
        if (s[i] == '.' || s[i] == ',')
        {
            count++;
        }
    }
    // se houver alguma string com mais de 1 '.' ou ',' resp recebe false
    // nao existe real com mais de 1 '.' ou ','
    if (count > 1)
    {
        resp = false;
    }

    // aqui eu verifico se existe algum char que não seja nem numero e nem '.' ou ','
    for (int j = 0; j < tam; j++)
    {
        if ((!(s[j] > 47 && s[j] < 58) && !(s[j] == '.') && !(s[j] == ',')))
        {
            resp = false;
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

    

    for (int i = 0; i < numEntrada; i++)
    {
        int tamanho = strlen(linha[i])-1;
        
        if (isVogal(linha[i], tamanho) == true)
        {
            printf("SIM ");
        }
        else
        {
            printf("NAO ");
        }

        if (isConsoante(linha[i], tamanho) == true)
        {
            printf("SIM ");
        }
        else
        {
            printf("NAO ");
        }

        if (isInteiro(linha[i], tamanho) == true)
        {
            printf("SIM ");
        }
        else
        {
            printf("NAO ");
        }

        if (isReal(linha[i], tamanho) == true)
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }

    }
    return 0;
}