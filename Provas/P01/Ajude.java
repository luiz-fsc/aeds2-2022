public class Ajude {
    public static boolean is0(String s){
        return(s.length() == 1 && s.charAt(0) == '0');
    }

    public static void main(String[] args) {
        int contador;
        String linha = "";
        linha = MyIO.readLine();
        do{
            contador = 0;
            int n = Integer.parseInt(linha);
            String[] assOrig = new String[n];
            String[] auxOrig = new String[n];
            for(int i = 0; i < n; i++){
                linha = MyIO.readLine(); 
                auxOrig[i] = linha.split(" ")[0];
                assOrig[i] = linha.split(" ")[1];
            }

            int m = Integer.parseInt(MyIO.readLine());
            String[] assAula = new String[n];
            String[] auxAula = new String[n];
            for(int i = 0; i < m; i++){
                linha = MyIO.readLine();
                auxAula[i] = linha.split(" ")[0];
                assAula[i] = linha.split(" ")[1];
            }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(auxAula[i].compareTo(auxOrig[j]) == 0){
                        if(contaErros(assOrig[j], assAula[i]) > 1){
                            contador++;
                        }
                    }
                }
                
            }
            System.out.println(contador);
            linha = MyIO.readLine();
        }while(is0(linha) == false);
        
    }

    public static int contaErros(String orig, String test){
        int count = 0;
        
        for(int i = 0; i < orig.length(); i++){
            if(orig.charAt(i) != test.charAt(i)){
                count++;
            }
        }

        return count;
    }
    
}