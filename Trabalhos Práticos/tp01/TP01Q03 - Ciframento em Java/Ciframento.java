public class Ciframento {
    
    public static String cifraStr(String original){
        
        //criei uma nova string para receber caracter por caracter so que com a chave
        //para o ciframento
        String novaStr = "";
        int chave = 3;
        for(int i = 0; i < original.length(); i++){
            novaStr = novaStr + (char)(original.charAt(i)+ chave);
        }

        return novaStr;
    }


    // Metodo para conferir se a string de entrada eh a ultima
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
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
        
        //imprime as linhas do pubin cifradas
        for(int i = 0; i < numEntrada; i++){
            MyIO.println(cifraStr(entrada[i]));
        }
    }


}
