import java.io.*;
import java.net.*;

public class LeituraHTML{


    // Metodo para conferir se a string de entrada eh a ultima
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }


    public static int isX1(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'a'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX2(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'e'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX3(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'i'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX4(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'o'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX5(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'u'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX6(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'á'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX7(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'é'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX8(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'í'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX9(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'ó'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX10(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'ú'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX11(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'à'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX12(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'è'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX13(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'ì'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX14(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'ò'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX15(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'ù'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX16(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'ã'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX17(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'õ'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX18(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'â'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX19(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'ê'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX20(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'î'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX21(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'ô'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX22(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'û'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX23(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if((line.charAt(i) > 97 && line.charAt(i) < 101) || (line.charAt(i) > 101 && line.charAt(i) < 105) || (line.charAt(i) > 105 && line.charAt(i) < 111) || (line.charAt(i) > 111 && line.charAt(i) < 117) || (line.charAt(i) > 117 && line.charAt(i) < 123)){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }

    public static int isX24(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == '<' && line.charAt(i+1) == 'b' && line.charAt(i+2) == 'r' && line.charAt(i+3) == '>'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

        return resp;
    }
    
    public static int isX25(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        int resp = 0;
        String line;

        try{
            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == '<' && line.charAt(i+1) == 't' && line.charAt(i+2) == 'a' && line.charAt(i+3) == 'b' && line.charAt(i+4) == 'l' && line.charAt(i+5) == 'e' && line.charAt(i+6) == '>'){
                        resp++;
                    }
                }
            }
        }catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        try{
            is.close();
        }catch (IOException ioe){}

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
        
        for(int i = 0; i < numEntrada; i = i+2){
            
            MyIO.setCharset("UTF-8");
            MyIO.println("a(" + isX1(entrada[i+1]) + ") " + "e(" + isX2(entrada[i+1]) + ") " + "i(" + isX3(entrada[i+1]) + ") " + "o(" + isX4(entrada[i+1]) + ") " + "u(" + isX5(entrada[i+1]) + ") " + "á(" + isX6(entrada[i+1]) + ") " + "é(" + isX7(entrada[i+1]) + ") " + "í(" + isX8(entrada[i+1]) + ") " + "ó(" + isX9(entrada[i+1]) + ") " + "ú(" + isX10(entrada[i+1]) + ") " + "à(" + isX11(entrada[i+1]) + ") " + "è(" + isX12(entrada[i+1]) + ") " + "ì(" + isX13(entrada[i+1]) + ") " + "ò(" + isX14(entrada[i+1]) + ") " + "ù(" + isX15(entrada[i+1]) + ") " + "ã(" + isX16(entrada[i+1]) + ") " + "õ(" + isX17(entrada[i+1]) + ") " + "â(" + isX18(entrada[i+1]) + ") " + "ê(" + isX19(entrada[i+1]) + ") " + "î(" + isX20(entrada[i+1]) + ") " + "ô(" + isX21(entrada[i+1]) + ") " + "û(" + isX22(entrada[i+1]) + ") " + "consoante(" + isX23(entrada[i+1]) + ") " + "<br>(" + isX24(entrada[i+1]) + ") " + "<table>(" + isX25(entrada[i+1]) + ") " + entrada[i]);
        }
    }

}