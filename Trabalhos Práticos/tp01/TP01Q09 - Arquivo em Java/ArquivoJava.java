import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

public class ArquivoJava {
    

    public static void lerReais(int num) throws Exception{
        
        RandomAccessFile raf = new RandomAccessFile("reais.txt", "rw");

        double d = 0.0;

        for(int i = 0; i < num; i++){
            d = MyIO.readDouble();
            raf.writeDouble(d);
        }


        raf.close();
    }

    public static void printaReais(int num) throws Exception{
        RandomAccessFile raf = new RandomAccessFile("reais.txt", "r");
        //x e y sao variáveis que vou utilizar para ajudar a printar os numeros no formato certo
        int x = 0;
        double y = 0.00;

        //o num-- eh para acessar a ultima posição do arquivo com o raf.seek e ler o arquivo ao contrário
        for(int i = 0; i < num; num--){
            // como a RAF lê bit por bit, então para ir para o ulitmo valor do arquivo eu fiz (num-1)*8, onde começa o primeiro bit do ultimo numero
            raf.seek((num-1)*8);
            y = raf.readDouble();
            x = (int)y;
            //se meu y double for igual a x, ou seja o numero guardado no arquivo estiver no formato de um int, eu imprimo o x que é um int
            if(y == (long) y){
                MyIO.println(x);
            }else{
                MyIO.println(y);
            }
        }

        raf.close();
    }

    public static void main(String[] args) throws Exception{
        int num = Integer.parseInt(MyIO.readLine());
        lerReais(num);
        printaReais(num);
    }
}
