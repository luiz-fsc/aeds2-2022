package TADs.th;

public class HashLista {
    Lista tabela[];
    int tamanho;
    final int NULO = -1;

    public HashLista() {
        this(7);
    }
    
    public HashLista(int tamanho) {
        this.tamanho = tamanho;
        tabela = new Lista[tamanho];
        for (int i = 0; i < tamanho; i++) {
           tabela[i] = new Lista();
        }
    }

    public int h(int elemento) {
        return elemento % tamanho;
    }

    boolean pesquisar(int elemento) {
        int pos = h(elemento);
        return tabela[pos].pesquisar(elemento);
    }

    public void inserirInicio(int elemento) {
        int pos = h(elemento);
        tabela[pos].inserirInicio(elemento);
    }

    public int remover(int elemento) throws Exception {
        int resp = NULO;
        if (pesquisar(elemento) == false) {
           throw new Exception("Erro ao remover!");
        } else {
           int pos = h(elemento);
           resp = tabela[pos].remover(elemento);
        }
        return resp;
    }
}
