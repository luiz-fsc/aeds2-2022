package TADs.th;

public class ReHash {
    int tabela[];
    int m;
    final int NULO = -1;

    ReHash(){
        this(13);
    }

    ReHash(int m){
        this.m = m;
        this.tabela = new int[this.m];
        for (int i = 0; i < m; i++) {
            tabela[i] = NULO;
        }
    }

    public int h(int elemento) {
        return elemento % m;
    }

    public int reh(int elemento) {
        return ++elemento % m;
    }

    public boolean inserir(int elemento) {
        boolean resp = false;
        if (elemento != NULO) {
            int pos = h(elemento);
            if (tabela[pos] == NULO) {
                tabela[pos] = elemento;
                resp = true;
            } else {
                pos = reh(elemento);
                if (tabela[pos] == NULO) {
                    tabela[pos] = elemento;
                    resp = true;
                }
           }
        }
        return resp;
    }

    public boolean pesquisar(int elemento) {
        boolean resp = false;
        int pos = h(elemento);
        if (tabela[pos] == elemento) {
            resp = true;
        } else if (tabela[pos] != NULO) {
            pos = reh(elemento);
            if (tabela[pos] == elemento) {
                resp = true;
            }
        }
        return resp;
    }

    boolean remover(int elemento) {
        boolean resp = false;
        int pos = h(elemento);
        if (tabela[pos] == elemento){
            int pos2 = reh(elemento);
            if (h(tabela[pos2]) == pos){
                tabela[pos] = tabela[pos2];
                tabela[pos2] = NULO;
            }else{
                tabela[pos] = NULO;
            }	
        }else if(elemento == tabela[reh(elemento)]){
            int pos2 = reh(elemento);
            int pos3 = reh(reh(elemento));
            if(h(tabela[pos3]) == pos2){
                tabela[pos2] = tabela [pos3];
                tabela[pos3] = NULO;
            }else{
                tabela[pos2] = NULO;
            }
       
        }
        return resp;
     }
}
