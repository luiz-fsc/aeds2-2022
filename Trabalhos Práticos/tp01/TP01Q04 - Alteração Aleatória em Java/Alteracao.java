import java.util.Random;

public class Alteracao {

    // Metodo para conferir se a string de entrada eh a ultima
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String alteraStr(String original, Random gerador) {

        //dois char gerados aleatoriamente para fazer a substituição
        char a = ((char)('a' + (Math.abs(gerador.nextInt()) %26 )));
        char b = ((char)('a' + (Math.abs(gerador.nextInt()) %26 )));

        String novaStr = "";
        
        /*nesse for eu percorro char por char para tentar achar o primeiro char sorteado.
        se a posição verificada estiver com o 1o char sorteado, eu adiciono na novaStr o 2o char, se nao eu adiciono o char
        referente a posição verificada na original*/
        for(int i = 0; i < original.length(); i++){
            if(original.charAt(i) == a){
                novaStr += b;
            }else{
                novaStr += original.charAt(i);
            }
        }

        return novaStr;
    }

    public static void main(String[] args) {

        // inicio Leitura da entrada padrao
        String[] entrada = new String[1000];
        int numEntrada = 0;

        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        // fim Leitura da entrada padrao

        Random gerador = new Random();
        gerador.setSeed(4); 

        // imprime as linhas do pubin com os chars trocados
        for (int i = 0; i < numEntrada; i++) {
            MyIO.println(alteraStr(entrada[i], gerador));
        }
    }

}
