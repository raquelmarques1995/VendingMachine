package TrabalhoJavaversao2510;
import java.time.LocalDate;

public class Refrigerante extends Produto{
    
    //construtores
    public Refrigerante(int id, String nome, double preco, LocalDate validade, String acucar, String marca) {
        super(id, nome, preco, validade);
        this.acucar = acucar;
        this.marca = marca;
        tipoProduto = "Refrigerante";
    }
    
    
    //Marca pode ser um array de 3 com Pepsi,Sumol,Lipton
    //atributos
    private String acucar;
    private String marca;
    
    //métodos


    public String getAcucar() {
        return acucar;
    }

    public void setAcucar(String acucar) {
        this.acucar = acucar;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
    