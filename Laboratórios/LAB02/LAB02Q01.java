public class LAB02Q01 {


    public static boolean balançoParentese(String s){
        int i, count=0;
        boolean resp = true;

        for(i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                count ++;
            } else if(s.charAt(i) == ')'){
                count --;
                if(count < 0){
                    resp = false;
                    i = s.length();
                }
            }
        }
        if(count > 0)
            resp = false;

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
            if(balançoParentese(entrada[i]) == true){
                System.out.println("correto");
            }else{
                System.out.println("incorreto");
            }
        }
        
    }
}