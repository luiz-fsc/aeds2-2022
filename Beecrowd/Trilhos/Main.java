import java.io.*;
import java.util.Scanner;
import java.util.Stack;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        Stack pilha = new Stack<String>();
        Stack a = new Stack<String>();
        Stack b = new Stack<String>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String resp = "";
        while(n != 0){
            
            String ladoA = sc.nextLine();
            for (int i = 0; i < ladoA.length(); i += 2) {
                a.push(ladoA.charAt(i));
            }
            String ladoB = sc.nextLine();
            for (int i = 0; i < ladoB.length(); i += 2) {
                b.push(ladoB.charAt(i));
            }
            for(int j = 0; j < n; j++){
                if(!(a.empty())){
                    while(b.peek() != a.peek()){
                        pilha.push(a.peek());
                        a.pop();
                        resp += "I";
                    }
                    pilha.push(a.peek());
                    a.pop();
                    resp += "I";
                    pilha.pop();
                    resp += "R";
                }else{
                   resp += "R"; 
                }
                
            }
            System.out.println(resp);
            n = sc.nextInt();
        }
        sc.close();
    }
 
}