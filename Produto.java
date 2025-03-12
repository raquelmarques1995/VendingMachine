package TrabalhoJavaversao2510;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Produto implements Serializable {
    
    //construtores
    public Produto(int id, String nome, double preco, LocalDate validade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
    }

    //atributos
    protected int id;
    protected String nome;
    protected double preco;
    protected LocalDate validade;
    protected String tipoProduto;
    
            
    //Se usarmos data com possibilidade de fazer contas podemos ter um 'warning' na abertura do menu que diz a quantidade de produtos fora de prazo ou
    //Quase fora de prazo
    //métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getValidade() { //ALTERADO AQUI
        DateTimeFormatter pt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return validade.format(pt);
    }

    public void setValidade(LocalDate validade) { //ALTERADO AQUI
        this.validade = validade;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

}
