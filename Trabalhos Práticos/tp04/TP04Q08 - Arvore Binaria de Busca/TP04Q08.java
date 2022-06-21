import java.util.Scanner;

public class TP04Q08 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < c; i++){
            Arvore arvore = new Arvore();
            int n = sc.nextInt();
            sc.nextLine();
            String aux = sc.nextLine().trim();
            String[] split = aux.split(" ");
            for(int j = 0; j < n; j++){
                arvore.inserir(Integer.parseInt(split[j]));
            }

            System.out.println("Case " + (i+1) + ":");
            System.out.print("Pre.: ");
            arvore.caminharPre(arvore.raiz);
            System.out.print("\n");
            System.out.print("in..: ");
            arvore.caminharCentral(arvore.raiz);
            System.out.print("\n");
            System.out.print("Post: ");
            arvore.caminharPos(arvore.raiz);
            System.out.println("\n");
            
        }
        sc.close();
    }

}

class Arvore {

    public No raiz;

    public Arvore() {
        raiz = null;
    }

    public void inserir(int x) throws Exception {
        raiz = inserir(x, raiz);
    }

    private No inserir(int x, No i) throws Exception {
        if (i == null) {
            i = new No(x);
        } else if (x < i.elemento) {
            i.esq = inserir(x, i.esq);
        } else if (x > i.elemento) {
            i.dir = inserir(x, i.dir);
        } else {
            throw new Exception("Iguais");
        }
        return i;
    }

    public boolean pesquisar(int x) {
        return pesquisar(x, raiz);
    }

    private boolean pesquisar(int x, No i) {
        boolean resp;
        if (i == null) {
            resp = false;
        } else if (x == i.elemento) {
            resp = true;
        } else if (x < i.elemento) {
            resp = pesquisar(x, i.esq);
        } else {
            resp = pesquisar(x, i.dir);
        }
        return resp;
    }

    public void caminharCentral(No i) {
        if (i != null) {
            caminharCentral(i.esq);
            System.out.print(i.elemento + " ");
            caminharCentral(i.dir);
        }
    }

    public void caminharPos(No i) {
        if (i != null) {
            caminharPos(i.esq);
            caminharPos(i.dir);
            System.out.print(i.elemento + " ");
        }
    }

    public void caminharPre(No i) {
        if (i != null) {
            System.out.print(i.elemento + " ");
            caminharPre(i.esq);
            caminharPre(i.dir);
        }
    }

    public void remover(int x) throws Exception {
        raiz = remover(x, raiz);
    }

    private No remover(int x, No i) throws Exception {
        if (i == null) {
            throw new Exception("Erro!");
        } else if (x < i.elemento) {
            i.esq = remover(x, i.esq);
        } else if (x > i.elemento) {
            i.dir = remover(x, i.dir);
        } else if (i.dir == null) {
            i = i.esq;
        } else if (i.esq == null) {
            i = i.dir;
        } else {
            i.esq = maiorEsq(i, i.esq);
        }
        return i;
    }

    private No maiorEsq(No i, No j) {
        if (j.dir == null) {
            i.elemento = j.elemento;
            j = j.esq;
        } else {
            j.dir = maiorEsq(i, j.dir);
        }
        return j;
    }

}

class No{
    public int elemento;
    public No esq, dir;

    public No(int elemento){
        this(elemento, null, null);
    }

    public No(int elemento, No esq, No dir){
        this.elemento = elemento;
        this.dir = dir;
        this.esq = esq;
    }
}