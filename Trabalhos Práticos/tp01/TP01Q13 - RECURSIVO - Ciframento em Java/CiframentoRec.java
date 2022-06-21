public class CiframentoRec{

    // Metodo para conferir se a string de entrada eh a ultima
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }


    public static String cifraStr(String orig, String novaStr){
        return(cifraStr(orig, novaStr, 0));
    }

    public static String cifraStr(String original, String novaStr, int count){
               
        int chave = 3;
        //condição de parada quando o contador for mais que a lenght da string
        //não havera mais chars dentro da string para cifrar
        if(original.length() > count){
            novaStr += (char)(original.charAt(count) + chave);
            return cifraStr(original, novaStr, count + 1);
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
        
        String novaStr;

        for(int i = 0; i < numEntrada; i++){
            novaStr = "";
            MyIO.println(cifraStr(entrada[i], novaStr));
            
        }
    }


}