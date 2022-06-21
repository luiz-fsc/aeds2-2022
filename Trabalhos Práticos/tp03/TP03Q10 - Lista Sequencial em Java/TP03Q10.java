import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TP03Q10{
   
    public static boolean isFim(String s){
		return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
	}

    /**
     * recebe uma String, e divide ela de acordo com os camandos que deve realizar.
     * Após a divisão, o método realiza as operações na lista de acordo com os comandos recebidos
     * @param s String que contem o comando
     * @param lista Array de Filmes que receberá as alterações
     */
    public static void doComands(String s, ListaSimples lista) {

        /**
         * nessa primeira etapa eu preencho dados que me ajudarão na hora de realizar as operações
         * comando = operação a ser realizada
         * pos = posição de inserção
         * html = arquivo a ser lido
        **/


        // Primeira etapa
        //====================================================
        Filme tmp = new Filme();// auxiliar na inserção de filmes na lista
        String[] split = new String[3];
        int pos = 0;
        String comando = "";
        String html = "";
        if(s.charAt(0) == 'I'){
            if(s.charAt(1) == '*'){
                split = s.split(" ",3);
                comando = split[0];
                pos = Integer.parseInt(split[1]);
                html = split[2];
            }else{
                split = s.split(" ", 2);
                comando = split[0];
                html = split[1];
            }

        }else if(s.charAt(0) == 'R'){
            if(s.charAt(1) == '*'){
                split = s.split(" ");
                comando = split[0];
                pos = Integer.parseInt(split[1]);
            }else{
                comando = s;
            }
        }
        //Fim da primeira etapa
        //====================================================


        //Realizando Comandos - segunda etapa
        //inserções
        if(comando.charAt(0) == 'I'){
            try {
                tmp.ler(html);
            } catch (Exception e) {}
            if(comando.charAt(1) == 'I'){
                try {
                    lista.inserirInicio(tmp);
                } catch (Exception e) {}
            }
            else if(comando.charAt(1) == 'F'){
                try {
                    lista.inserirFim(tmp);
                } catch (Exception e) {}
            }
            else if(comando.charAt(1) == '*'){
                try {
                    lista.inserir(tmp, pos);
                } catch (Exception e) {}
            }

        
        }
        //remoções
        else if(comando.charAt(0) == 'R'){
            if(comando.charAt(1) == 'I'){
                try {
                    System.out.println("(R) "+lista.removerInicio().getName());
                } catch (Exception e) {}
            }
            else if(comando.charAt(1) == 'F'){
                try {
                    System.out.println("(R) "+lista.removerFim().getName());
                } catch (Exception e) {}
            }
            else if(comando.charAt(1) == '*'){
                try {
                    System.out.println("(R) "+lista.remover(pos).getName());
                } catch (Exception e) {}
            }
        }
    }

    public static void main(String[] args) throws Exception{
        
        //================================================
        //1a entrada
        String[] entrada = new String[1000];
        int numEntrada = 0;

        Scanner leitor = new Scanner(System.in);
        do {
            entrada[numEntrada] = leitor.nextLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;
        //=================================================

        //=================================================
        //prenchendo lista de filmes com a 1a entrada
        ListaSimples filmes = new ListaSimples();
        for (int i = 0; i < numEntrada; i++) {
            Filme tmp = new Filme();
            try {
                tmp.ler(entrada[i]);
                filmes.inserirFim(tmp);
            } catch (Exception e) {}
        }
        //=================================================
        

        int num = Integer.parseInt(leitor.nextLine());
        //o doComands ja realiza as operações de cada linha
        for(int i = 0; i < num; i++){
            doComands(leitor.nextLine(), filmes);
        }
        
        filmes.mostrar();
        leitor.close();
    }
    
}

class ListaSimples{
    private Celula primeiro, ultimo;

    ListaSimples(){
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserirInicio(Filme f){
        Celula tmp = new Celula(f);
        tmp.setProx(primeiro.getProx());
        primeiro.setProx(tmp);
        if(primeiro == ultimo){
            ultimo = tmp;
        }
        tmp = null;
    }

    public void inserirFim(Filme f){
        ultimo.setProx(new Celula(f));
        ultimo = ultimo.getProx();
    }

    public void inserir(Filme f, int pos) throws Exception{
        int tamanho = tamanho();
        if(pos < 0 || pos > tamanho){
            throw new Exception("Posição inválida");
        }else if(pos == 0){
            inserirInicio(f);
        }else if(pos == tamanho){
            inserirFim(f);
        }else{
            Celula i = primeiro;
            for(int j = 0; j < pos; j++, i = i.getProx());
            Celula tmp = new Celula(f);
            tmp.setProx(i.getProx());
            i.setProx(tmp);
            tmp = i = null;
        }   
    }


    public Filme removerInicio() throws Exception{
        if(primeiro == ultimo){
            throw new Exception("Lista Vazía!");
        }

        Celula tmp = primeiro;
        primeiro = primeiro.getProx();
        Filme filme  = primeiro.getFilme();
        tmp.setProx(null);
        tmp = null;
        return filme;
    }

    public Filme removerFim() throws Exception{
        if(primeiro == ultimo){
            throw new Exception("Lista Vazia!");
        }
        Celula i;
        for(i = primeiro; i.getProx() != ultimo; i = i.getProx());
        Filme filme = ultimo.getFilme();
        ultimo = i;
        i = null;
        ultimo.setProx(null);

        return filme;        
    }

    public Filme remover(int pos) throws Exception{
        Filme filme;
        int tamanho = tamanho();
        if(primeiro == ultimo || pos < 0 || pos >= tamanho){
            throw new Exception("Erro ao remover");
        }else if(pos == 0){
            filme = removerInicio();
        }else if(pos == tamanho-1){
            filme = removerFim();
        }else{
            Celula i = primeiro;
            for(int j = 0; j < pos; j++, i = i.getProx());
            Celula tmp = i.getProx();
            filme = tmp.getFilme();
            i.setProx(tmp.getProx());
            tmp.setProx(null);
            i = tmp = null;
        }
        return filme;
    }

    
    public void mostrar() throws Exception{
        if(primeiro == ultimo){
            throw new Exception("Lista Vazía!");
        }
        int j = 0;
        for(Celula i = primeiro.getProx(); i != null; i = i.getProx(), j++){
            System.out.print("["+j+"] ");
            i.getFilme().imprimir();
        }
    }

    
    private int tamanho(){
        int tam = 0;
        if(primeiro == ultimo){
            tam = 0;
        }else{
            for(Celula i = primeiro.getProx(); i != null; i = i.getProx()){
                tam++;
            }
        }
        return tam;
    }

}


class Celula{
    private Filme filme;
    private Celula prox;

    Celula(){
        this(new Filme());
    }

    Celula(Filme filme){
        this.filme = filme;
        prox = null;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    public void setProx(Celula prox) {
        this.prox = prox;
    }

    public Filme getFilme() {
        return filme;
    }
    public Celula getProx() {
        return prox;
    }    
}

class Filme {

    private String Name;
    private String OriginalTitle;
    private Date RealeaseDate;
    private int Duration;
    private String Genre;
    private String Language;
    private String Status;
    private double budget;
    private String[] keyWord;
    private int tamVetKeyWord;

    Filme() {
        this.Name = "";
        this.OriginalTitle = "";
        this.RealeaseDate = new Date();
        this.Duration = 0;
        this.Genre = "";
        this.Language = "";
        this.Status = "";
        this.budget = 0;
        this.keyWord = new String[50];
        this.tamVetKeyWord = 0;
    }

    Filme(String Name, String OriginalTitle, Date RealeaseDate, int Duration, String Genre, String Language,
          String Status, float budget, String[] keyWord, int tamVetKeyWord) {
        this.Name = Name;
        this.OriginalTitle = OriginalTitle;
        this.RealeaseDate = RealeaseDate;
        this.Duration = Duration;
        this.Genre = Genre;
        this.Language = Language;
        this.Status = Status;
        this.budget = budget;
        this.keyWord = keyWord;
        this.tamVetKeyWord = tamVetKeyWord;
    }

    public String getName() {
        return Name;
    }

    public String getOriginalTitle() {
        return OriginalTitle;
    }

    public Date getRealeaseDate() {
        return RealeaseDate;
    }

    public int getDuration() {
        return Duration;
    }

    public String getGenre() {
        return Genre;
    }

    public String getLanguage() {
        return Language;
    }

    public String getStatus() {
        return Status;
    }

    public double getBudget() {
        return budget;
    }

    public String[] getKeyWord() {
        return keyWord;
    }

    public int getTamVetKeyWord() {
        return tamVetKeyWord;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setOriginalTitle(String originalTitle) {
        OriginalTitle = originalTitle;
    }

    public void setRealeaseDate(Date realeaseDate) {
        RealeaseDate = realeaseDate;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setKeyWord(String[] keyWord) {
        this.keyWord = keyWord;
    }

    public void setTamVetKeyWord(int tamVetKeyWord) {
        this.tamVetKeyWord = tamVetKeyWord;
    }

    public Filme clone() {
        Filme copia = new Filme();
        copia.Name = this.Name;
        copia.OriginalTitle = this.OriginalTitle;
        copia.RealeaseDate = this.RealeaseDate;
        copia.Duration = this.Duration;
        copia.Genre = this.Genre;
        copia.Language = this.Language;
        copia.Status = this.Status;
        copia.budget = this.budget;
        System.arraycopy(this.keyWord, 0, copia.keyWord, 0, this.tamVetKeyWord);
        return copia;
    }

    public void imprimir() {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print(getName() + " " + getOriginalTitle() + " " + formato.format(getRealeaseDate()) + " " + getDuration() + " "
                + getGenre() + " " + getLanguage() + " " + getStatus() + " " + getBudget() + " [");

        for (int i = 0; i < getTamVetKeyWord(); i++) {
            if (i == getTamVetKeyWord() - 1) {
                System.out.print(getKeyWord()[i]);
            } else {
                System.out.print(getKeyWord()[i] + ", ");
            }
        }
        System.out.println("]");
    }

    public void ler(String nomeArq) throws Exception{
        String caminho = "/tmp/filmes/" + nomeArq;
        FileReader fr = new FileReader(caminho);
        BufferedReader bf = new BufferedReader(fr);
        
        String linha = new String();
        linha = bf.readLine();

        //Name
        while(!linha.contains("h2 class")){
            linha = bf.readLine();
        }
        linha = bf.readLine().trim();
        linha = removeTags(linha);
        /*if(linha.contains("&amp;")){
            linha = linha.replace("&amp;", "");
        }*/
        setName(linha);
       

        //Release Date
        while(!linha.contains("class=\"release\"")){
            linha = bf.readLine();
        }
        linha = bf.readLine().trim();
        linha = linha.split(" ")[0];
        setRealeaseDate(formatDate(linha));
        

        //Genre
        while(!linha.contains("class=\"genres\"")){
            linha = bf.readLine();
        }
        bf.readLine();
        linha = removeTags(bf.readLine().trim());
        linha = linha.replace("&nbsp;", "");
        setGenre(linha);
      
        
        //Duration
        while(!linha.contains("class=\"runtime\"")){
            linha = bf.readLine();
        }
        bf.readLine();
        linha = bf.readLine().trim();
        setDuration(formatDuration(linha));
       

        //Original Title
        while(!linha.contains("<strong>")){
            linha = bf.readLine();
        }
        if(linha.contains("Título original")){
            linha = removeTags(linha.trim());
            linha = formatString(linha, 16);
            setOriginalTitle(linha);
        }else{
            setOriginalTitle(getName());
        }

        //status
        while(!linha.contains("Situação")){
            linha = bf.readLine();
        }
        linha = removeTags(linha.trim());
        linha = formatString(linha, 9);
        setStatus(linha);
  

        //Language
        while(!linha.contains("Idioma original")){
            linha = bf.readLine();
        }
        linha = removeTags(linha.trim());
        linha = formatString(linha, 16);
        setLanguage(linha);
  
        //Budget
        while(!linha.contains("Orçamento")){
            linha = bf.readLine();
        }
        linha = removeTags(linha.trim());
        if(linha.contains("-")){
            setBudget(0.0);
        }else{
            linha = formatString(linha, 11);
            linha = linha.replace( ",", "");
            float orçamento = Float.parseFloat(linha);
            setBudget(orçamento);
        }

        //Keyword
        String[] vet = new String[50];
        int countVet = 0;
        while(!linha.contains("Palavras-chave")){
            linha = bf.readLine();
        }
        for(int j = 0; j < 4; j++){
            linha = bf.readLine();
        }
        while(linha.contains("<li>")){
            linha = removeTags(linha).trim();
            vet[countVet] = linha;
            countVet++;
            bf.readLine();
            linha = bf.readLine();
        }
        setTamVetKeyWord(countVet);
        setKeyWord(vet);

        bf.close();
    }

    //nesse metodo as horas são convertidas em minutos e eu somo o valor da conversão com os minutos e retorno esse valor
    public int formatDuration(String linha) {
        int i = 0;
        String h = "";
        int horas = 0;
        if(linha.contains("h")){
            while(linha.charAt(i) != 'h'){
                h += linha.charAt(i);
                i++;
            }
            i += 2;
            horas = Integer.parseInt(h);
            horas = horas*60;
        }    

        String m = "";
        while(linha.charAt(i) != 'm'){
            m += linha.charAt(i);
            i++;
        }
        int minutos = Integer.parseInt(m);


        // aux serve para armazenar a duração em minutos do filme no formato de inteiro
        int aux = horas + minutos;

        return aux;
    }

    //Nesse metodo eu uso o SimpledateFormat
    public Date formatDate(String linha) throws ParseException {
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = formato.parse(linha);

        return dataFormatada;
    }

    //Nesse metodo eu guardo em uma String limpa tudo que estiver dentro das tags de uma linha
    public String removeTags(String orig) {
        String nova = "";

        for(int i = 0; i < orig.length(); i++){
            if (orig.charAt(i) == '<') {
                while (orig.charAt(i) != '>') {
                    i++;
                }
            } else {
                nova += orig.charAt(i);
            }
        }

        return nova;
    }

    //Metodo recebe um valor que sera a posição inicil de leitura da String passada como parametro
    /*ex: linha = "luiz fernando";
          inicio = 6;
          return = fernando;
    */
    public String formatString(String linha, int inicio) {
        String nova = "";

        for(int i = inicio; i<linha.length(); i++){
            nova += linha.charAt(i);
        }

        return nova;
    }
}