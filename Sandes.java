package TrabalhoJavaversao2510;
import java.time.LocalDate;

public class Sandes extends Produto {
    
    //construtores
    public Sandes( int id, String nome, double preco, LocalDate validade, String tipos, String produtor) {
        super(id, nome, preco, validade);
        this.tipos = tipos;
        this.produtor = produtor;
        tipoProduto = "Sandes";
    }
    
    //Tipo pode ser um array de 3 com mista, queijo, fiambre
    //atributos
    private String tipos;
    private String produtor;
    
    //métodos
    public String getTipos() {
        return tipos;
    }

    public void setTipos(String tipos) {
        this.tipos = tipos;
    }

    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

}
