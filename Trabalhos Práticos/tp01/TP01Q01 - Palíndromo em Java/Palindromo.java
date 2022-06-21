public class Palindromo {

    public static boolean isPalindromo(String s) {
        //a aux serve para armaznar os mesmos caracters da string original, mas invertidos.
        String aux = "";
        //aqui aux eh prenchida 
        for(int i = s.length()-1; i >= 0; i--){
            aux += s.charAt(i);
        }
        //aqui eu verifico se aux eh igual a string original, para vrificar se a original eh palindromo
        boolean resp = true;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != aux.charAt(i)){
                resp = false;
            }
        }

        return resp;
    }

    // Metodo para conferir se a string de entrada eh a ultima
    public static boolean isFim(String s) {
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
        
        for(int i = 0; i < numEntrada; i++){
            if(isPalindromo(entrada[i]) == true){
                MyIO.println("SIM");
            }else{
                MyIO.println("NAO");
            }
        }
    }
}
