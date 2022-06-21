import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.jar.Attributes.Name;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;

/**
 * @author Thiago de Campos Ribeiro Nolasco
 */
class Film {
    // Attributes
    private String name;
    private String ogTitle;
    private Date releaseDate;
    private Integer duration;
    private String genre;
    private String ogLanguage;
    private String situation;
    private Float budget;
    private String[] arrKeyWds;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Constructors
    public Film() {
    }

    /**
     * @param name
     * @param ogTitle
     * @param releaseDate
     * @param duration
     * @param genre
     * @param ogLanguage
     * @param situation
     * @param budget
     */
    public Film(String name, String ogTitle, Date releaseDate, Integer duration, String genre, String ogLanguage, String situation, Float budget) {
        this.name = name;
        this.ogTitle = ogTitle;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.genre = genre;
        this.ogLanguage = ogLanguage;
        this.situation = situation;
        this.budget = budget;
        this.arrKeyWds = null;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOgTitle() {
        return ogTitle;
    }

    public void setOgTitle(String ogTitle) {
        this.ogTitle = ogTitle;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getOgLanguage() {
        return ogLanguage;
    }

    public void setOgLanguage(String ogLanguage) {
        this.ogLanguage = ogLanguage;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public Float getBudget() {
        return budget;
    }

    public void setBudget(Float budget) {
        this.budget = budget;
    }

    public String[] getArrKeyWds() {
        return arrKeyWds;
    }

    public void setArrKeyWds(String[] arrKeyWds) {
        this.arrKeyWds = arrKeyWds;
    }

    public Film clone(){
        Film cloned = new Film();

        cloned.name = this.name;
        cloned.ogTitle = this.ogTitle;
        cloned.releaseDate = this.releaseDate;
        cloned.duration = this.duration;
        cloned.genre = this.genre;
        cloned.ogLanguage = this.ogLanguage;
        cloned.situation = this.situation;
        cloned.budget = this.budget;
        cloned.arrKeyWds = this.arrKeyWds;

        return cloned;
    }


    /**
     * @param fileName
     */
    public void ler(String fileName){
        // Getting the right path for each read file
        String path = "/tmp/filmes/"+fileName;
        //D:\\RPG\\Filmes\\ ./filmes/

        // Method that will split chunks of the read HTML and will assign the value to each Film's attribute
        splittingString(path);
    }

    private void splittingString(String path){
        // Data declaration
        String line = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"))) {

            // Film name
            while(!reader.readLine().contains("title ott"));
            while(!reader.readLine().contains("h2"));
            this.name = removeTags(reader.readLine().trim());

            // Film release date
            while(!reader.readLine().contains("\"release\""));
            this.releaseDate = sdf.parse(removeTags(reader.readLine().trim()));

            // Film genre
            while(!reader.readLine().contains("genres"));
                // In this case, will use "line" because the last readLine will have the content that we want
            while(!(line = reader.readLine()).contains("<a href"));
            this.genre = removeTags(line).trim();

            // Film duration
            while(!reader.readLine().contains("runtime"));
            reader.readLine(); // Needed because an empty line was found
            this.duration = hoursToMinutes(reader.readLine().trim());

            // Film original title (if there is) & situation
            this.ogTitle = this.name;
            while( !(line = reader.readLine()).contains("Situação</bdi>") ) {
                if(line.contains("Título original")){
                    this.ogTitle = removeTags(line.replace("Título original", " ")).trim();
                }
            }
            this.situation = removeTags(line.replace("Situação", " ")).trim();

            // Film original language
            while( !(line = reader.readLine()).contains("Idioma original</bdi>") );
            this.ogLanguage = removeTags(line.replace("Idioma original", " ")).trim();

            // Film budget
            while( !(line = reader.readLine()).contains("Orçamento</bdi>") );
            String aux = removeTags(line.replace("Orçamento", " ")).trim();
            this.budget = (aux.equals("-")) ? 0.0F : convertBudget(aux);

            // Film key-words
            line = "";
            while( !reader.readLine().contains("Palavras-chave</bdi>") );
            while( !(line += reader.readLine().trim() + " ").contains("</ul>") );
            if(!line.contains("Nenhuma palavra-chave foi adicionada")){
                arrKeyWds = removeTags(line).trim().split("  ");
            }


        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("File cannot be read");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Receives a line that contains an HTML content and removes its tags
     * @param line
     * @return
     */
    private String removeTags(String line){
        // Data declaration
        String resp = "";
        int i = 0;

        /*
           The main idea here is to check if the char is equals to '<', if it's, it means that an HTML tag has opened
           So, CAN'T read anything until the tag is closed, '>' is found.

           It's also checking if any HTML special character (&....;) or if any "()" is found
           IF found, don't read anything until it has ended.
         */
        while (i < line.length()) {
            if (line.charAt(i) == '<') {
                i++;
                while (line.charAt(i) != '>') i++;
            }else {
                resp += line.charAt(i);
            }
            i++;
        }
        // Returning cleaned line
        return resp.replace("&nbsp;", "");
    }

    /**
     * Receives a String that contains hours, and convert it to minutes (Integer)
     * @param value
     * @return
     */
    private int hoursToMinutes(String value){
        // Data declaration
        int result = 0, minutes = 0;

        String[] splitValue = value.split(" ");
        if(splitValue.length > 1) {
            int hour = Integer.parseInt(removeLetters(splitValue[0]));
            minutes = Integer.parseInt(removeLetters(splitValue[1]));
            result = (60 * hour) + minutes;
        } else {
            if(splitValue[0].contains("h")){
                minutes = Integer.parseInt(removeLetters(splitValue[0]))*60;
            } else {
                minutes = Integer.parseInt(removeLetters(splitValue[0]));
            }
            result = minutes;
        }
        return result;
    }

    /**
     * Receives a String that contains hours, and leave only the numbers (ex: 1h 49m = 1 49)
     * @param value
     * @return
     */
    private String removeLetters(String value){
        // Data declaration
        String result = "";

        for(int i = 0; i < value.length(); i++){
            // If char is a number, a blank space, or a '.' (Used on convertBudget), will be stored into "result"
            if( (value.charAt(i) >= 48 && value.charAt(i) <= 57) || value.charAt(i) == ' ' || value.charAt(i) == '.')
                result += value.charAt(i);
        }
        return result;
    }

    /**
     * Receives a String that contains a FLOAT number, and converts it to a FLOAT number
     * (PS: It's necessary to remove few characters because String has ',' on it)
     * @param value
     * @return
     */
    private Float convertBudget(String value){
        return Float.parseFloat(removeLetters(value));
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(name);
        sb.append(" ").append(ogTitle);
        sb.append(" ").append(sdf.format(getReleaseDate()));
        sb.append(" ").append(duration);
        sb.append(" ").append(genre);
        sb.append(" ").append(ogLanguage);
        sb.append(" ").append(situation);
        sb.append(" ").append(budget);
        sb.append(" ").append(arrKeyWds == null ? "[]" : Arrays.asList(arrKeyWds).toString());
        return sb.toString();
    }

    public void imprimir(int i){
        System.out.println("["+i+"] "+this.toString());
    }

}

class Circular {
    Film[] array;
    public int primeiro;  //remove do indice "primeiro";
    public int ultimo;    //remove do indice "ultimo";
 
 
    /**
     * Construtor da classe.
     */
    public Circular () {
       this(6);
    }
 
 
    /**
     * Construtor da classe.
     * @param tamanho Tamanho da Circular.
     */
    public Circular (int tamanho){
        array = new Film[tamanho];
        primeiro = ultimo = 0;
    }

    /**
     * Insere um elemento na ultima posicao da Circular.
     * @param x int elemento a ser inserido.
     * @throws Exception Se a Circular estiver cheia.
     */
    public void inserir(Film x) throws Exception {
        //validar insercao
        if(((ultimo+1)%array.length) == primeiro){
            try{
                remover();
            }catch (Exception e){}
        }
        array[ultimo] = x;
        ultimo=(ultimo+1)%array.length;
        mostrarMediaDuracao();
    }
 

 
    /**
     * Remove um elemento da ultima posicao da Circular.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a Circular estiver vazia.
     */
    public Film remover() throws Exception {
 
       //validar remocao
        if (primeiro == ultimo) {
            throw new Exception("Vazio!");
        }
        Film resp = array[primeiro];
        primeiro=(primeiro+1)%array.length;
        return resp;
    }
 
 

    /**
     * Mostra os elementos da Circular separados por espacos.
     */
    public void mostrar (){
        int j=0;
        for(int i = primeiro; i != ultimo; i=((i+1)%array.length)){
            array[i].imprimir(j);
            j++;
        }
    }
    public void mostrarMediaDuracao(){
        double media=0;
        int j = 0;
        for(int i = primeiro; i != ultimo; i=((i+1)%array.length)){
            media+=array[i].getDuration();
            j++;
        }
        media=(media/j);
        System.out.println(Math.round(media));
    }
}

public class questao7{
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void opCode(String s, Circular Circular){
        String[] split = new String[2];
        split = s.split(" ",2);
        String op   = split[0];
        String html = "";
        //int posicao = 0;
        if(op.charAt(0)=='I'){
            html = split[1];
        }
        /*resolve a operacoes */
        Film aux2 = new Film();
        //INSERIR
        if(op.charAt(0)=='I'){
            aux2.ler(html);
            try {
                Circular.inserir(aux2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //REMOVER
        else if(op.charAt(0)=='R'){
            try {
                aux2=Circular.remover();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("(R) "+aux2.getName());
        }
        
    }

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;
        Scanner entrada1 = new Scanner(System.in);
        do{
            entrada[numEntrada] = entrada1.nextLine();
        }while(isFim(entrada[numEntrada++]) == false);
        
        numEntrada--;
        Circular Circular = new Circular(6);
        for(int i=0;i<numEntrada;i++){
            Film aux = new Film();
            try {
                aux.ler(entrada[i]);
                Circular.inserir(aux);
            } catch (Exception e) {
            }
        }
        numEntrada++;
        
        entrada[numEntrada] = entrada1.nextLine();
        //tmp -> guarda primeira posicao da parte 2
        int tmp = numEntrada;
        //total de instrucoes a serem feitas (primeira linha da parte 2)
        int instrucoes = Integer.parseInt(entrada[numEntrada]);
        do{
            entrada[numEntrada]=entrada1.nextLine();
            opCode(entrada[numEntrada], Circular);
        }while(numEntrada++ < (instrucoes+tmp-1));
        Circular.mostrar();
        entrada1.close();
    }

}