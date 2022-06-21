public class PalindromoRec {
    

    public static Boolean isPalindromo(String original){
        return isPalindromo(original, 0, (original.length()-1));
    }
    //os parametros i e j servem para eu caminhar pela string pelo inicio e pelo final dela
    public static Boolean isPalindromo(String original, int i, int j){
        
        boolean resp = true;

        if(j >= i){
            if(original.charAt(i) != original.charAt(j)){
                resp = false;
            }
            else{
                resp = isPalindromo(original, i+1, j-1);
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
