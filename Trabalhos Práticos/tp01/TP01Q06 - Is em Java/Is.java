class Is{

    // Metodo para conferir se a string de entrada eh a ultima
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean isVogal(String s){
        boolean resp = true;
        //se houver algum char na string recebida que seja diferente das vogais, eu entro no if e resp recebe false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o' && s.charAt(i) != 'u' 
            && s.charAt(i) != 'A' && s.charAt(i) != 'E' && s.charAt(i) != 'I' && s.charAt(i) != 'O' && s.charAt(i) != 'U'){
                resp = false;
            }
        }
        return resp;
    }

    public static boolean isConsoante(String s){
        boolean resp = true;
        //verifico no for se tem algum char q sej vogal ou numero ou '.' ou ','
        // se houver, eu entro dentro do if e resp recebe false
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' 
            || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U'
            || (s.charAt(i) > 47 && s.charAt(i) < 58) || s.charAt(i) == '.' || s.charAt(i) == ','){
                resp = false;
            }
        }
        return resp;
    }

    public static boolean isInteiro(String s){
        boolean resp = true;
        //verifico se existe algum char fora dos limites dos numeros na tabela ascii
        //se hover entro dentro do if e resp recebe falseS
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) < 48 || s.charAt(i) > 57){
                resp = false;
            }
        }
        return resp;
    }

    public static boolean isReal(String s){
        boolean resp = true;

        //variavel para contar numero de ',' e '.' da String
        int count = 0;
        //aqui eu percorro a String e conta quantas virgulas e quantos pontos ela tem
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '.' || s.charAt(i) == ','){
                count++;
            }
        }
        //se houver alguma string com mais de 1 '.' ou ',' resp recebe false
        //nao existe real com mais de 1 '.' ou ','
        if(count > 1){
            resp = false;
        }
    
        //aqui eu verifico se existe algum char que não seja nem numero e nem '.' ou ','
        for(int j = 0; j < s.length(); j++){
            if((!(s.charAt(j) > 47 && s.charAt(j) < 58) && !(s.charAt(j) == '.') && !(s.charAt(j) == ','))){
                resp = false;
            }
        }
        
        
        
        return resp;
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
        
        String X1 = "", X2 = "", X3 = "", X4 = "";

        for(int i = 0; i < numEntrada; i++){
            
            if(isVogal(entrada[i]) == true){
                X1 = "SIM";
            }else{
                X1 = "NAO";
            }

            if(isConsoante(entrada[i]) == true){
                X2 = "SIM";
            }else{
                X2 = "NAO";
            }

            if(isInteiro(entrada[i]) == true){
                X3 = "SIM";
            }else{
                X3 = "NAO";
            }

            if(isReal(entrada[i]) == true){
                X4 = "SIM";
            }else{
                X4 = "NAO";
            }
            
            MyIO.println(X1+" "+X2+" "+X3+" "+X4);
        }
    }

}