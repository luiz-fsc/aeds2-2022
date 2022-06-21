//hash com reserva
public class TabelaHash {
    public Pessoa[] tabela;
    int tam1, tam2, tam;
    public int n;//conta quantos elementos estão na área de reserva

    TabelaHash(){
        this(13,7);
    }

    TabelaHash(int tam1, int tam2){
        this.tam1 = tam1;
        this.tam2 = tam2;
        this.tam = tam1 + tam2;
        this.n = 0;
        this.tabela = new Pessoa[tam];
        for(int i = 0; i < tam1; i++){
            this.tabela[i] = null;
        }
    }

    public int h(int elemento){
        return elemento % tam1;
    }

    public boolean inserir(Pessoa x) throws Exception{
        boolean resp = false;
        if(x != null){
            int pos = h(x.id);
            if(tabela[pos] == null){
                tabela[pos] = x;
                resp = true;
            }else if(n < tam2){
                tabela[tam1 + n] = x;
                n++;
                resp = true;
            }
        }
        return resp;
    }

    public boolean pesquisar(Pessoa x){
        boolean resp = false;
        int pos = h(x.id); 
        if(tabela[pos].id == x.id){
            resp = true;
        }else if(tabela[pos] != null){
            for(int i = 0; i < n; i++){
                if(tabela[tam1 + i].id == x.id){
                    resp = true;
                    i = n;
                }
            }
        }
        return resp;
    }

    public boolean remover(Pessoa x){
        boolean resp = false;
        int pos = h(x.id);
        if(tabela[pos].id == x.id){
            for(int i = 0; i < n; i++){
                if(h(tabela[tam1+i].id) == pos){
                    tabela[pos] = tabela[tam1 + i];
                    tabela[tam1 + i] = null;
                    i = n;
                    n--;
                }else{
                    tabela[pos] = null;
                }
                resp = true;
            }
        }else{
            for(int i = 0; i < n; i++){
                if(tabela[tam1 + i].id == x.id){
                    n--;
                    int j = tam1 + i;
                    while(j < tam1 + n){
                        tabela[j] = tabela[j+1];
                        j++;
                    }
                    i = n;
                    resp = true;
                }
            }
        }
        return resp;

    }
    
}

