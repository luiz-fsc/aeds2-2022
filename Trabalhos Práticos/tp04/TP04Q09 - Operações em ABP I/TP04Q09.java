import java.util.*;

public class TP04Q09 {
    public static void main(String[] args) throws Exception {
        String linha;
        Scanner sc = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();
        do{
            linha = sc.nextLine();
            arvore.doComands(linha);
        }while(sc.hasNextLine());
        sc.close();
    }
}

/**
 * Arvore binaria de pesquisa
 * @author Max do Val Machado
 */
class ArvoreBinaria {
	private No raiz; // Raiz da arvore.

	/**
	 * Construtor da classe.
	 */
	public ArvoreBinaria() {
		raiz = null;
	}

	/**
	 * Metodo publico iterativo para pesquisar elemento.
	 * @param x Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(char x) {
		return pesquisar(x, raiz);
	}

	/**
	 * Metodo privado recursivo para pesquisar elemento.
	 * @param x Elemento que sera procurado.
	 * @param i No em analise.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	private boolean pesquisar(char x, No i) {
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

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void caminharCentral() {
		caminharCentral(raiz);
        System.out.println();
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i No em analise.
	 */
	private void caminharCentral(No i) {
		if (i != null) {
			caminharCentral(i.esq); // Elementos da esquerda.
			System.out.print(i.elemento + " ");
			caminharCentral(i.dir); // Elementos da direita.
		}
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void caminharPre() {
		caminharPre(raiz);
        System.out.println();
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i No em analise.
	 */
	private void caminharPre(No i) {
		if (i != null) {
			System.out.print(i.elemento + " ");
			caminharPre(i.esq); // Elementos da esquerda.
			caminharPre(i.dir); // Elementos da direita.
		}
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void caminharPos() {
		caminharPos(raiz);
        System.out.println();
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i No em analise.
	 */
	private void caminharPos(No i) {
		if (i != null) {
			caminharPos(i.esq); // Elementos da esquerda.
			caminharPos(i.dir); // Elementos da direita.
			System.out.print(i.elemento + " ");
		}
	}


	/**
	 * Metodo publico iterativo para inserir elemento.
	 * @param x Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserir(char x) throws Exception {
		raiz = inserir(x, raiz);
	}

	/**
	 * Metodo privado recursivo para inserir elemento.
	 * @param x Elemento a ser inserido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se o elemento existir.
	 */
	private No inserir(char x, No i) throws Exception {
		if (i == null) {
         		i = new No(x);

      		} else if (x < i.elemento) {
         		i.esq = inserir(x, i.esq);

      		} else if (x > i.elemento) {
         		i.dir = inserir(x, i.dir);

      		} else {
         		throw new Exception("Erro ao inserir!");
      		}

		return i;
	}

    public void doComands(String x) throws Exception{
        if(x.length() == 3){
            if(x.charAt(0) == 'I'){
                inserir(x.charAt(2));
            }else{
                if(pesquisar(x.charAt(2))){
                    System.out.println(x.charAt(2) + " existe");
                }else{
                    System.out.println("nao existe");
                }
            }
        }else{
            if(x.equals("INFIXA")){
                caminharCentral();
            }else if(x.equals("PREFIXA")){
                caminharPre(); 
            }else if(x.equals("POSFIXA")){
                caminharPos();     
            }
        }
    }

}

class No {
    char elemento;
    No esq, dir;

    No(char elemento){
        this(elemento, null, null);
    }

    No(char elemento, No esq, No dir){
        this.elemento = elemento;
        this.dir = dir;
        this.esq = esq;
    }
}


 