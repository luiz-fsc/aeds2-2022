import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class TP04Q01 {
    
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        long tempoInicial = System.currentTimeMillis();

        String[] entrada = new String[1000];
        int numEntrada = 0;
        Scanner sc = new Scanner(System.in);

        //leitura da 1a entrada
        //============================================
        do{
            entrada[numEntrada] = sc.nextLine(); 
        }while(isFim(entrada[numEntrada++]) == false);
        numEntrada--;

        //inserindo 1a entrada na árvore
        //============================================
        ArvoreBininaria arvore = new ArvoreBininaria();
        for(int i = 0; i < numEntrada; i++){
            Film tmp = new Film();
            try {
                tmp.ler(entrada[i]);
                arvore.inserir(tmp);
            } catch (Exception e) {}
        } 

        //leitura da 2a entrada
        //============================================
        int num = Integer.parseInt(sc.nextLine());
        for(int j = 0; j < num; j++){
            arvore.doComandos(sc.nextLine());
        }

        //leitura da 3a entrada
        //============================================
        String entrada2 = sc.nextLine();
        while(!isFim(entrada2)){
            System.out.println(entrada2);
            Boolean resp;
            resp = arvore.pesquisar(entrada2);
            System.out.println(resp == true ? "SIM" : "NAO");
            entrada2 = sc.nextLine();
        }
        sc.close();
        Arq.openWrite("matr??cula arvoreBinaria.txt");
        Arq.println("689755" + "\t" + (System.currentTimeMillis() - tempoInicial) + "\t" + arvore.countC);
        Arq.close();
        
    }
}

class ArvoreBininaria{
    No raiz;
    int countC;

    ArvoreBininaria(){
        this.raiz = null;
    }

    public void inserir(Film f) throws Exception{
        raiz = inserir(f, raiz);
    }

    private No inserir(Film f, No i) throws Exception{
        if(i == null){
            i = new No(f); 
        }else if(f.getOgTitle().compareTo(i.filme.getOgTitle()) < 0){
            countC++;
            i.esq = inserir(f, i.esq);
        }else if(f.getOgTitle().compareTo(i.filme.getOgTitle()) > 0){
            i.dir  = inserir(f, i.dir);
            countC+=2;
        }else{
            countC+=2;
            throw new Exception("Filmes Iguais!!");
        }
        return i;
    }
    
    public boolean pesquisar(String f){
        System.out.print("=>raiz ");
        return pesquisar(f, raiz);
    }

    private boolean pesquisar(String f, No i){
        boolean resp = false;
        if(i == null){
            resp = false;
        }else if(f.equals(i.filme.getOgTitle())){
            countC++;
            resp = true;
        }else if(f.compareTo(i.filme.getOgTitle()) < 0){
            System.out.print("esq ");
            countC+=2;
            resp = pesquisar(f, i.esq);
        }else if(f.compareTo(i.filme.getOgTitle()) > 0){
            countC+=3;
            System.out.print("dir ");
            resp = pesquisar(f, i.dir);
        }

        return resp;
    }
    
    public void caminharCentral(){
        caminharCentral(raiz);
    }

    private void caminharCentral(No i){
        if(i != null){
            caminharCentral(i.esq);
            i.filme.imprimir();
            caminharCentral(i.dir);
        }
    }

    public void caminharPos(){
        caminharPos(raiz);
    }

    private void caminharPos(No i) {
        if (i != null) {
            caminharPos(i.esq);
            caminharPos(i.dir);
            i.filme.imprimir();
        }
    }

    public void caminharPre(){
        caminharPre(raiz);
    }

    private void caminharPre(No i) {
        if (i != null) {
            i.filme.imprimir();
            caminharPre(i.esq);
            caminharPre(i.dir);
        }
    }

    public void remover(String f) throws Exception{
        raiz = remover(f, raiz);
    } 

    private No remover(String f, No i) throws Exception{
        if(i == null){ 
            throw new Exception("Elemento a ser removido não encontrado");
        }else if(f.compareTo(i.filme.getOgTitle()) < 0){
            countC++;
            i.esq = remover(f, i.esq);
        }else if(f.compareTo(i.filme.getOgTitle()) > 0){
            countC+=2;
            i.dir = remover(f, i.dir); 
        }else if(i.dir == null){
            countC+=3;
            i = i.esq;
        }else if(i.esq == null){
            countC+=4;
            i = i.dir;
        }else{
            countC+=4;
            i.esq = maiorEsq(i, i.esq);
        }

        return i;
    }

    private No maiorEsq(No i, No j){
        if(j.dir == null){
            countC++;
            i.filme = j.filme;
            j = j.esq;
        }else{
            countC++;
            j.dir = maiorEsq(i, j.dir);
        }
        return j;
    }

    public void doComandos(String s){
        String[] aux = s.split(" ", 2);
        
        if(aux[0].charAt(0) == 'I'){
            Film tmp = new Film();
            try {
                tmp.ler(aux[1]);
                inserir(tmp);
            } catch (Exception e) {}
        }else{
            try {
                remover(aux[1]);
            } catch (Exception e) {}
        }
    }
}

class No{
    Film filme;
    No esq, dir;

    No(){
        this(new Film(), null, null);
    }

    No(Film filme){
        this(filme, null, null);
    }

    No(Film filme, No esq, No dir){
        this.filme = filme;
        this.esq = esq;
        this.dir = dir;
    }
}

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
        this(null, null, null, null, null, null, null, null);
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
        String path = "/tmp/filmes/" + fileName;

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

    public void imprimir(){
        System.out.println(this.toString());
    }
}