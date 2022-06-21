public class IsRec {
    
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean isVogal(String s){
        return (isVogal(s, 0));
    }

    public static boolean isVogal(String s, int count){
        boolean resp;
        //se houver algum char na string recebida que seja diferente das vogais, eu entro no if e resp recebe false;
       
        if(count == s.length()){
            resp = true;
        }else if(s.charAt(count) != 'a' && s.charAt(count) != 'e' && s.charAt(count) != 'i' && s.charAt(count) != 'o' && s.charAt(count) != 'u' 
        && s.charAt(count) != 'A' && s.charAt(count) != 'E' && s.charAt(count) != 'I' && s.charAt(count) != 'O' && s.charAt(count) != 'U'){
            resp = false;
        }else{
            resp = isVogal(s, count + 1);
        }
       
        return resp;
    }

    public static boolean isConsoante(String s){
        return (isConsoante(s, 0));
    }

    public static boolean isConsoante(String s, int count){
        boolean resp;
        //verifico no for se tem algum char q seja vogal ou numero ou '.' ou ','
        // se houver, eu entro dentro do if e resp recebe false
        
        if(count == s.length()){
            resp = true;
        }else if(s.charAt(count) == 'a' || s.charAt(count) == 'e' || s.charAt(count) == 'i' || s.charAt(count) == 'o' || s.charAt(count) == 'u' 
        || s.charAt(count) == 'A' || s.charAt(count) == 'E' || s.charAt(count) == 'I' || s.charAt(count) == 'O' || s.charAt(count) == 'U'
        || (s.charAt(count) > 47 && s.charAt(count) < 58) || s.charAt(count) == '.' || s.charAt(count) == ','){
            resp = false;
        }else{
            resp = isConsoante(s, count + 1);
        }
        return resp;
    }

    public static boolean isInteiro(String s){
        return (isConsoante(s, 0));
    }

    public static boolean isInteiro(String s, int count){
        boolean resp;
        //verifico se existe algum char fora dos limites dos numeros na tabela ascii
        //se hover entro dentro do if e resp recebe falseS

        if(count == s.length()){
            resp = true;
        }else if(s.charAt(count) < 48 || s.charAt(count) > 57){
            resp = false;
        }else{
            resp = isInteiro(s, count+1);
        }
        return resp;
    }

    public static int contaVirgula(String s){
        return (contaVirgula(s, 0));
    }

    public static int contaVirgula(String s, int count){
        int resp = 0;

        if(count == s.length()){
            resp = resp + 0;//se for igual a lenght, nao há mais o que somar e ele so ira retornar o valor
        }else if(s.charAt(count) == '.' || s.charAt(count) == ','){
            resp++;
            resp = contaVirgula(s, count+1);
        } else{
            resp = contaVirgula(s, count+1);
        }

        return resp;
    }

    public static boolean isReal(String s){
        return (isReal(s,0));
    }

    public static boolean isReal(String s, int count){
        boolean resp;

        //se houver alguma string com mais de 1 '.' ou ',' resp recebe false
        //nao existe real com mais de 1 '.' ou ','
        if(contaVirgula(s) > 1){
            resp = false;
        }
    
        //aqui eu verifico se existe algum char que não seja nem numero e nem '.' ou ','

        if(count == s.length()){
            resp = true;
        }else if((!(s.charAt(count) > 47 && s.charAt(count) < 58) && !(s.charAt(count) == '.') && !(s.charAt(count) == ','))){
            resp = false;
        }else{
            resp = isReal(s, count+1);
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
