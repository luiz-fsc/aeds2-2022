public class Algebra{
    
    public static boolean algebraBool(String str){

        boolean resp;
        int numEntradas = Integer.valueOf(str.charAt(0));
        if(numEntradas == 2){
            int a = Integer.valueOf(str.charAt(2));
            int b = Integer.valueOf(str.charAt(4));
        }else if(numEntradas == 3){
            int a = Integer.valueOf(str.charAt(2));
            int b = Integer.valueOf(str.charAt(4));
            int c = Integer.valueOf(str.charAt(6));
        }
        
    }

    public static String limpaStr(String str){
        int i=0;
        String novaStr = "";
        while(str.charAt(i) != '('){
            i++;
        }i++;
        while(str.charAt(i)!= ')'){
            
        }


    }


    // Metodo para conferir se a string de entrada eh a ultima
    public static boolean isFim(String s) {
        return (s.length() == 1 && s.charAt(0) == '0');
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

        
        for (int i = 0; i < numEntrada; i++) {
            
        }
    }

}