public class Cometa {
    public static boolean isFim(String s){
        return(s.length() == 1 && s.charAt(0) == '0');
    }


    public static int proxPassagem(String s){
        int anoAtual = Integer.parseInt(s);
        int aux = 76 - ((anoAtual - 1986)%76);
        int anoPassgem;
        if(aux == 0){
            anoPassgem = anoAtual + 76;
        }else{
            anoPassgem = anoAtual + aux;
        }
        return anoPassgem;
    }

    public static void main(String[] args) {
     
        String[] entrada = new String[1000];
        int numEntrada = 0;

        do{
            entrada[numEntrada] = MyIO.readLine();
        }while(isFim(entrada[numEntrada++]) == false);
        numEntrada--;

        for(int i = 0; i < numEntrada; i++){
            MyIO.println(proxPassagem(entrada[i]));
        }

    }
}
