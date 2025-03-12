package TrabalhoJavaversao2510;

import java.time.LocalDate;
import java.util.Scanner;

public class Chocolate extends Produto {
    
    //construtores
    public Chocolate(int id, String nome, double preco, LocalDate validade, String tipo, String marca) {
        super(id, nome, preco, validade);
        this.marca = marca;
        this.tipo = tipo;
        tipoProduto = "Chocolate";
    }


    //Tipo pode ser um array de 3 com negro,branco,leite lá dentro)
    //atributos
    private String marca;
    private String tipo;
    
    //métodos
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
