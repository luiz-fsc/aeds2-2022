class DonaMonica{
    
    public static boolean isFim(String s){
        return(s.length() == 1 && s.charAt(0) == '0');
    }


    public static int calculaIdade(String linha) {
        String idadeMonica = "";
        String idadeFilho1 = "";
        String idadeFilho2 = "";
        int i = 0;
        while(linha.charAt(i) != ' '){
            idadeMonica += linha.charAt(i);
            i++;
        }i++;
        while(linha.charAt(i) != ' '){
            idadeFilho1 += linha.charAt(i);
            i++;
        }i++;
        while(i < linha.length()){
            idadeFilho2 += linha.charAt(i);
            i++;
        }

        int ageMonica;
        int idades[] = new int[3];

        ageMonica = Integer.parseInt(idadeMonica);
        idades[0] = Integer.parseInt(idadeFilho1);
        idades[1] = Integer.parseInt(idadeFilho2);

        idades[2] = ageMonica - (idades[0]+idades[1]);

        int maior = idades[2];
        for(int j = 0; j < 2; j++){
            if(idades[j] > maior){
                maior = idades[j];
            }
        }
        return maior;
    }

    public static void main(String[] args) {
        
        String[] entrada = new String[1000];
        int numEntrada = 0;

        do{
            entrada[numEntrada] = MyIO.readLine();
        }while(isFim(entrada[numEntrada++]) == false);
        numEntrada--;

        for(int i = 0; i < numEntrada; i++){
            MyIO.println(calculaIdade(entrada[i]));
        }

    }
}