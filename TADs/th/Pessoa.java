import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Pessoa {
    public String nome;
    public int id;
    public Calendar nascimento;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Pessoa(){
        nome = "fulano de tal";
        nascimento = Calendar.getInstance();
        id = 0;
    }

    Pessoa(String nome, int id, int dia, int mes, int ano){
        this.nome = nome;
        this.id = id;
        nascimento = Calendar.getInstance();
        this.nascimento.set(Calendar.DAY_OF_MONTH, dia);
        this.nascimento.set(Calendar.MONTH, mes - 1);
        this.nascimento.set(Calendar.YEAR, ano);
    }

    public void mostrar(){
        System.out.println(nome + " - " + sdf.format(nascimento.getTime()));
    }
    
}
