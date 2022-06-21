import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TP03Q05{
   
    public static boolean isFim(String s){
		return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
	}

    public static void main(String[] args) {
        long tempoInicial = System.currentTimeMillis();
        
        //================================================
        //entrada padrão
        String[] entrada = new String[1000];
        int numEntrada = 0;

        Scanner leitor = new Scanner(System.in);
        do {
            entrada[numEntrada] = leitor.nextLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;
        leitor.close();
        //================================================
        
        //================================================
        //preenchendo a lista
        Lista filmes = new Lista(100);
        for (int i = 0; i < numEntrada; i++) {
            Filme tmp = new Filme();
            try {
                tmp.ler(entrada[i]);
                filmes.inserirFim(tmp);
            } catch (Exception e) {}
        }
        //================================================

        filmes.heapSort();
        filmes.mostrar();

        Arq.openWrite("matrícula_heapsort.txt");
        Arq.println("689755" + "\t" + filmes.countC + "\t" + filmes.countM + "\t" + (System.currentTimeMillis() - tempoInicial));
        Arq.close();

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

class Lista{
    private Filme[] array;
    private int n;//quantidade de registros momentâneos no array.
    //'n' Também é usado muitas vezes como referência para as posições da lista
    public int countM, countC;//contadores dos numeros de movimentações e comparações

    /**
     * Costrutor vazio da classe
     */ 
    Lista(){
        this(6);
    }

    /**
     * Construtor da classe.
     * @param tamanho Tamanho da lista.
     */
    Lista(int tamanho){
        array = new Filme[tamanho];
        n = 0;
        countC = 0;
        countM = 0;
    }

    public void inserirInicio(Filme x) throws Exception{
        if(n >= array.length){
            throw new Exception("Sem espaço!");
        }
        
        for(int i = n; i > 0; i--){
            array[i] = array[i-1];
        }

        array[0] = x;
        n++;
    }

    public void inserir(Filme x, int pos) throws Exception{
        if(n >= array.length || pos < 0 || pos > n){
            throw new Exception("Erro na inserção!");
        }

        for(int i = n; i > pos; i--){
            array[i] = array[i-1];
        }

        array[pos] = x;
        n++;
    }

    /**
     * Para essa questão, alterei a ordem dos dois ultimos comandos, pois para ordenação em Heap a primeira posição
     * do meu array deve ser a 1 e não a 0.
     */
    public void inserirFim(Filme x) throws Exception{
        if(n >= array.length){
            throw new Exception("Sem espaço!");
        }
        n++;
        array[n] = x;
    }

    
    public Filme removerInicio() throws Exception{
        if(n == 0){
            throw new Exception("Lista vazia para remoção!");
        }

        Filme resp = array[0];
        n--;

        for(int i = 0; i < n; i++){
            array[i] = array[i+1];
        }

        return resp;
    }

    public Filme remover(int pos) throws Exception{
        if(n == 0 || pos < 0 || pos >= n){
            throw new Exception("Erro na ramoção!");
        }

        Filme resp = array[pos];
        n--;

        for(int i = pos; i < n; i++){
            array[i] = array[i+1];
        }

        return resp;
    }

    public Filme removerFim() throws Exception{
        if(n == 0){
            throw new Exception("Lista vazia para remoção!");
        }

        return array[--n];
    }


    public void mostrar(){
        for(int i = 1; i <= n; i++){
            array[i].imprimir(); 
        }
    }

    //Métodos exclusivos do HeapSort
    //==========================================================================
    public void heapSort(){

        //construção do heap 
        for(int tam = 2; tam <= n; tam++){
            construir(tam);
        }

        //ordenação
        int tam = n;
        while(tam > 1){
            swap(1, tam--);
            reconstruir(tam);    
        }
    }

    private void construir(int tam){

        for(int i = tam; i > 1 && array[i].getGenre().compareTo(array[i/2].getGenre()) > 0; i /= 2){
            swap(i, i/2);
            countC++;
        }
    }

    private void reconstruir(int tam){

        int i = 1;
        while(hasFilho(i, tam) ==  true){
            int filho = getMaiorFilho(i, tam);
            if(array[i].getGenre().compareTo(array[filho].getGenre()) < 0){
                swap(i, filho);
                i = filho;
            }else{
                i = tam;
            }
            countC++;
        }
    }

    private boolean hasFilho(int i, int tam) {
        return (i <= (tam/2));
    }

    private int getMaiorFilho(int i, int tam) {
        int filho;
        if(2*i == tam || array[2*i].getGenre().compareTo(array[2*i+1].getGenre()) > 0){
            filho = 2*i;
        }else{
            filho = 2*i+1;
        }
        countC++;
        return filho;
    }
    //==========================================================================

    private void swap(int a, int b){
        Filme tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
        countM += 3;
    }

}
