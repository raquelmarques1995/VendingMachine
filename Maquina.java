package TrabalhoJavaversao2510;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;



public class Maquina implements Serializable {
    private static final long serialVersionUID = 1L;

    //CONSTRUCTOR
    public Maquina(String name) {
        this.name = name;
    }

    transient Scanner leitor = new Scanner(System.in);
    ArrayList<Produto> stock = new ArrayList<>();
    ArrayList<Produto> historico = new ArrayList<>();

    //ATRIBUTOS
    private String name;
    private double saldo;
    private double aux;
    private final int maxchocolate = 20;
    private final int maxrefrigerante = 15;
    private final int maxsandes = 10;
    private double totalvendas;
    private String choc = "Chocolate";
    private String refri = "Refrigerante";
    private String sande = "Sandes";

    //MÉTODOS
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTotalvendas() {
        return totalvendas;
    }

    public void setTotalvendas(double totalvendas) {
        this.totalvendas = totalvendas;
    }


    //PERMITE EXPORTAR O OBJECTO MAQUINA NO FICHEIRO STOCK.DAT
    public void guardarObjecto() {
        File file = new File("stock.dat");
        try (FileOutputStream fileOut = new FileOutputStream(file);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(this);
            //System.out.println("Máquina Guardada com sucesso!"); Mensagem utilizada para testar funcionalidade
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao guardar a máquina !\n" + e.getMessage());
        }
    }


    //PERMITE IMPORTAR O OBJECTO MAQUINA PARA A MAQUINA (!!!! ATENÇÃO AO RETURN AQUI !!!!)
    public void importarObjecto() {
        File file = new File("stock.dat");
        if (file.exists()) {
            try (FileInputStream fileIn = new FileInputStream(file);
                 ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

                Maquina venda = (Maquina) objectIn.readObject();
                stock = venda.stock;
                historico = venda.historico;
                totalvendas = venda.totalvendas;
                //System.out.println("Máquina Carregada com sucesso!"); Mensagem utilizada para testar funcionalidade
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Ocorreu um erro ao importar a máquina !\n" + e.getMessage());
            }
        } else {
            System.out.println("Não foi encontrado stock.");
            return;
        }
    }

    //Funções para fazer verificação de int e de double
    public int inputint() {
        int num;

        while (true){
            try {

                num = Integer.parseInt(leitor.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Input inválido. Introduza um número inteiro dentro das opções:");
            }
        }
        return num;
    }

    public double inputdouble() {
        double num;

        while (true){
            try {

                num = Double.parseDouble(leitor.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Input inválido. Introduza um número real:");
            }
        }
        return num;
    }

    //PERMITE VERIFICAR SE EXISTE STOCK E DEVOLVE UM BOOLEANO A PASSAR A INFORMAÇÃO
    public boolean verificarStock(){
        if (stock.isEmpty()) {
            System.out.println("O stock encontra-se vazio.");
            return false;
        } else {
            return true;
        }
    }

    // ------------------------------------------- CLIENTE ------------------------------------------------//

    //PERMITE AO CLIENTE INTRODUZ O SALDO
    public void adicionarSaldo() {
        do {
            System.out.print("\nQuanto saldo deseja adicionar: ");
            aux = inputdouble();

            if (aux < 0) {
                System.out.print("Saldo negativo introduzido, introduza um valor positivo ou 0.");
            }
        } while (aux < 0);
        setSaldo(getSaldo() + aux);
        System.out.println("Saldo actual é " + getSaldo() +"€.");
    }


    // PERMITE DEFINIR A CATEGORIA DO PRODUTO
    public String listarcategoria() {
        String aux="";
        int ex1;
        do {
            System.out.println("** Categorias disponiveis ** \n ");
            System.out.println("1.Chocolate ");
            System.out.println("2.Refrigerante ");
            System.out.println("3.Sandes ");
            System.out.print("\nEscolha uma das opções: ");
            ex1 = inputint();

            switch (ex1) {
                case 1:
                    System.out.println(choc);
                    listarProdutos(choc);
                    aux= choc;
                    break;

                case 2:
                    System.out.println(refri);
                    listarProdutos(refri);
                    aux= refri;
                    break;

                case 3:
                    System.out.println(sande);
                    listarProdutos(sande);
                    aux= sande;
                    break;


                default:
                    System.out.println("Introduziu um número inválido. Por favor indique uma das seguintes opções: \n1. Chocolate; \n2. Refrigerante; \n3. Sandes");
            }
        } while (ex1 != 1 && ex1 != 2 && ex1 != 3);
        return aux;
    }

    //PERMITE  LISTAR TODOS OS PRODUTOS EXISTENTES ATRAVÉS DO USO DO METODO LISTAR PRODUTOS
    public void listarProdutoscat(){
        listarProdutos(choc);
        listarProdutos(refri);
        listarProdutos(sande);
    }


    // PERMITE LISTAR OS PRODUTOS EXISTENTES NO STOCK POR CATEGORIA
    public void listarProdutos(String listade) {
        if (stock.isEmpty()) {
            System.out.println("O stock encontra-se vazio.");
        } else {
            if(contarProduto (listade) == 0){
                System.out.println("Não existem produtos de " + listade + ".");
            }
            else{
                System.out.println("Os produtos de " + listade + " são :");
                for (Produto aux : stock) {
                    if (listade.equals(choc)) {
                        if (aux.getTipoProduto().equals(choc)) {
                            Chocolate choc = (Chocolate) aux;
                            System.out.print("ID: " + choc.getId() + "  || ");
                            System.out.print("Nome: " + choc.getNome() + "  || ");
                            System.out.print("Preço: " + choc.getPreco() + "  || ");
                            System.out.print("Validade: " + choc.getValidade() + "  || ");
                            System.out.print("Tipo: " + choc.getTipo() + "  || ");
                            System.out.println("Marca: " + choc.getMarca());
                        }
                    }
                    if (listade.equals(refri)) {
                        if (aux.getTipoProduto().equals(refri)) {
                            Refrigerante refri = (Refrigerante) aux;
                            System.out.print("ID: " + refri.getId() + "  || ");
                            System.out.print("Nome: " + refri.getNome() + "  || ");
                            System.out.print("Preço: " + refri.getPreco() + "  || ");
                            System.out.print("Validade: " + refri.getValidade() + "  || ");
                            System.out.print("Tipo: " + refri.getAcucar() + "  || ");
                            System.out.println("Marca: " + refri.getMarca());
                        }
                    }
                    if (listade.equals(sande)) {
                        if (aux.getTipoProduto().equals(sande)) {
                            Sandes sande = (Sandes) aux;
                            System.out.print("ID: " + sande.getId() + "  || ");
                            System.out.print("Nome: " + sande.getNome() + "  || ");
                            System.out.print("Preço: " + sande.getPreco() + "  || ");
                            System.out.print("Validade: " + sande.getValidade() + "  || ");
                            System.out.print("Tipo: " + sande.getTipos() + "  || ");
                            System.out.println("Produtor: " + sande.getProdutor());
                        }
                    }
                }
            }
        }
    }


    //PERMITE AO CLIENTE ESCOLHER O PRODUTO QUE QUER COMPRAR
    public void escolherProduto(String listade) {
        boolean encontrou = false;
        int idcompra=0;
        System.out.print("Indique o id do produto que deseja ou -1 para cancelar a compra:");

        while (encontrou == false) {
            idcompra = inputint();
            for (Produto aux : stock) {
                if (idcompra == aux.getId()) {
                    aux.getTipoProduto(); // ADICIONEI À TOAAAAAAAAAAAAAAA PORQUE PORECISAMOS DO TIPO PARA COMPRAR SÓ O QUE VÊ NO DISPLAY

                    if (getSaldo() < aux.getPreco()) {
                        double diferenca = aux.getPreco() - getSaldo();
                        System.out.println("Falta " + diferenca + "€. Insira o dinheiro em falta se faz favor.");


                        int esc1;
                        do {
                            System.out.println("1. Inserir mais saldo.");
                            System.out.println("0. Cancelar compra ");
                            System.out.print("\nEscolha uma das opções: ");
                            esc1 = inputint();

                            switch (esc1) {
                                case 0:
                                    return;

                                case 1:
                                    adicionarSaldo();
                                    esc1 = 0;
                                    break;

                                default:
                                    System.out.println("Introduziu um número inválido. Por favor indique uma das seguintes opções: \n1. Inserir mais saldo. \n0. Cancelar compra .");
                            }
                        } while (esc1 != 0);
                        //Corrigir casas decimais de saldo (e provavelmente dos doubles todos)
//            System.out.println("Saldo atual " + getSaldo());
//            System.out.printf("Preço do produto %,.9f", stock.get(idcompra - 1).getPreco());
                    } else {
                        //HÁ AQUI VÁRIAS MANEIRAS DE FAZER ESTOU A PONDERAR
                        //podemos pôr aqui à campeão, ou fazer aqui outro IF se agora tiver dinheiro, MAS na realidade deviamos
                        // era ter um while lá em cima. A voltar a verificar se o saldo já chegava ou não
                        setSaldo(getSaldo() - aux.getPreco());

                        historico.add(aux);
                        totalvendas += aux.getPreco();
                        stock.remove(aux);
                        System.out.println("Produto adquirido com sucesso. Receba o troco no valor de " + getSaldo() + "€.");

                        guardarObjecto();
                    }

                    encontrou = true;
                    break;
                }
            }
            if (encontrou == false) {
                System.out.print("O ID que introduziu não corresponde a nenhum produto. Por favor indique um ID válido:");
            }
            if(idcompra == -1){
                System.out.println("Compra cancelada, a voltar ao menu");
                return;
            }
        }
    }

        // ------------------------------------------- COLABORADOR ------------------------------------------------//

        // PERMITE CONTAR O NÚMERO DE PRODUTOS DE CADA CATEDORIA (CONTROLO DE STOCK)
        public int contarProduto (String listade){
            int contadorcat = 0;
            if (stock.isEmpty()) {
                System.out.println("Vazio");
            } else {
                for (Produto aux : stock) {

                    if (listade.equals(choc)) {
                        if (aux.getTipoProduto().equals(choc)) {
                            contadorcat++;
                        }
                    }
                    if (listade.equals(refri)) {
                        if (aux.getTipoProduto().equals(refri)) {
                            contadorcat++;
                        }
                    }
                    if (listade.equals(sande)) {
                        if (aux.getTipoProduto().equals(sande)) {
                            contadorcat++;
                        }
                    }
                }
            }
            return contadorcat;
        }


        //PERMITE AO COLABORADOR ADICIONAR UM PRODUTO NO STOCK, DESDE QUE EXISTA ESPAÇO
        public void adicionarProduto () {
            System.out.println("\n**Adicionar novo produto**\n");
            System.out.print("Indique a categoria de produto que pretende adicionar (1.Chocolate; 2.Refrigerante; 3.Sandes; 0.Sair): ");
            int i;

            do {
                i = inputint();
                switch (i) {
                    case 0:
                        return;
                    case 1:
                        if (contarProduto(choc) < maxchocolate) {
                            int auxchoc;
                            String nomechoc;
                            String tipochoc = "";
                            double precochoc;
                            String marcachoc;


                            System.out.print("Nome do Chocolate: ");
                            nomechoc = leitor.nextLine();
                            System.out.print("Tipo de Chocolate | ");
                            System.out.print("1. Negro; 2. Branco; 3. Leite: ");
                            auxchoc = inputint();
                            switch (auxchoc) {
                                case 1:
                                    tipochoc = "Negro";
                                    break;

                                case 2:
                                    tipochoc = "Branco";
                                    break;

                                case 3:
                                    tipochoc = "Leite";
                                    break;

                                default:
                                    System.out.println("Introduziu um número inválido. Por favor indique uma das seguintes opções: \n1. Negro; \n2. Branco; \n3. Leite");
                            }

                            System.out.print("Preço do Chocolate: ");
                            precochoc = inputdouble();
                            System.out.print("Marca do Chocolate: ");
                            marcachoc = leitor.nextLine();

                            stock.add(new Chocolate(stock.size() + 1, nomechoc, precochoc, LocalDate.now().plusDays(15), tipochoc, marcachoc));
                        } else {
                            System.out.println("O Stock de chocolates atingiu o máximo. Remova chocolates do stock antes de adicionar um novo.");
                        }
                        break;

                    case 2:
                        if (contarProduto(refri) < maxrefrigerante) {
                            int auxref;
                            String nomeref;
                            String acucar = "";
                            double precoref;
                            String marcaref = "";

                            System.out.print("Nome do Refrigerante: ");
                            nomeref = leitor.nextLine();
                            System.out.print("Tipo de Refrigerante | ");
                            System.out.print("1. Normal; 2. Sem Açucar: ");
                            auxref = inputint();
                            switch (auxref) {
                                case 1:
                                    acucar = "Normal";
                                    break;

                                case 2:
                                    acucar = "Sem Açucar";
                                    break;

                                default:
                                    System.out.println("Introduziu um número inválido. Por favor indique uma das seguintes opções: \n1. Normal; \n2. Sem Açucar");
                            }
                            System.out.print("Preço do Refrigerante: ");
                            precoref = inputdouble();
                            System.out.print("Marca do Refrigerante: ");
                            System.out.print("1. Pepsi; 2. Sumol; 3.Lipton: ");
                            auxref = inputint();
                            switch (auxref) {
                                case 1:
                                    marcaref = "Pepsi";
                                    break;

                                case 2:
                                    marcaref = "Sumol";
                                    break;

                                case 3:
                                    marcaref = "Lipton";
                                    break;

                                default:
                                    System.out.println("Introduziu um número inválido. Por favor indique uma das seguintes opções: \n1. Pepsi; \n2. Sumol; \n3. Lipton");
                            }

                            stock.add(new Refrigerante(stock.size() + 1, nomeref, precoref, LocalDate.now().plusDays(15), acucar, marcaref));
                        } else {
                            System.out.println("O Stock de refrigerantes atingiu o máximo. Remova refrigerantes do stock antes de adicionar um novo.");
                        }
                        break;
                    case 3:
                        if (contarProduto(sande) < maxsandes) {
                            int auxsan;
                            String nomesan;
                            String tiposan = "";
                            double precosan;
                            String marcasan;

                            System.out.print("Nome da Sandes: ");
                            nomesan = leitor.nextLine();
                            System.out.print("Tipo de Sandes | ");
                            System.out.print("1. Mista; 2. Fiambre; 3. Queijo: ");
                            auxsan = inputint();
                            switch (auxsan) {
                                case 1:
                                    tiposan = "Mista";
                                    break;

                                case 2:
                                    tiposan = "Fiambre";
                                    break;

                                case 3:
                                    tiposan = "Queijo";
                                    break;

                                default:
                                    System.out.println("Introduziu um número inválido. Por favor indique uma das seguintes opções: \n1. Mista; \n2. Fiambre; \n3. Queijo");
                            }
                            System.out.print("Preço da Sandes: ");
                            precosan = inputdouble();
                            System.out.print("Produtor da Sandes: ");
                            marcasan = leitor.nextLine();

                            stock.add(new Sandes(stock.size() + 1, nomesan, precosan, LocalDate.now().plusDays(15), tiposan, marcasan));
                        } else {
                            System.out.println("O Stock de sandes atingiu o máximo. Remova sandes do stock antes de adicionar um novo.");
                        }
                        break;

                    default:
                        System.out.println("Introduziu um número inválido. Por favor indique uma das seguintes opções: \n1. Chocolate; \n2. Refrigerante; \n3. Sandes; \n0. Voltar ao menu.");
                }
                guardarObjecto();

            }while( i !=0 && i!=1 && i!=2 && i!=3);


                int esc1;

                    System.out.println("\n1. Deseja inserir mais produtos.");
                    System.out.println("0. Regressar para menu ");
                    System.out.print("\nEscolha uma das opções: ");
            do {
                    esc1 = inputint();

                    switch (esc1) {
                        case 0:
                            return;

                        case 1:
                            adicionarProduto();
                            esc1 = 0;
                            break;

                        default:
                            System.out.println("Introduziu um número inválido. Por favor indique uma das seguintes opções: \n1.Deseja inserir mais produtos. \n0.Regressar para menu.");
                    }
                } while (esc1 != 0 && esc1 != 1);
        }


        //PERMITE AO COLABORADOR REMOVER UM PRODUTO DO STOCK
        public void removerProduto () {
            if (!stock.isEmpty()) {
                boolean encontrou = false;
                System.out.println("**Remover produto**");
                System.out.print("Indique a categoria de produto que pretende remover (1.Chocolate; 2.Refrigerante; 3.Sandes; 0.Sair): ");
                int i;
                do {
                    i = inputint();
                    switch (i) {
                        case 0:
                            return;
                        case 1:
                            listarProdutos(choc);
                            break;
                        case 2:
                            listarProdutos(refri);
                            break;

                        case 3:
                            listarProdutos(sande);
                            break;
                        default:
                            System.out.println("Introduziu um número inválido. Por favor indique uma das seguintes opções: \n1. Chocolate; \n2. Refrigerante; \n3. Sandes; \n0. Voltar ao menu.");
                    }

                    if(i>=1  && i<=3){
                        int idprod;
                        System.out.print("Indique o ID do produto:");
                        while (encontrou == false) {
                            idprod = inputint();

                            for (Produto aux : stock) {
                                if (idprod == aux.getId()) {
                                    stock.remove(aux);
                                    encontrou = true;
                                    System.out.print("Produto removido com sucesso.");
                                    break;
                                }
                            }
                            if (encontrou == false) {
                                System.out.print("O ID que introduziu não corresponde a nenhum produto. Por favor indique um ID válido:");
                            }
                        }
                    }
                }while(i != 0 && i != 1 && i != 2 && i != 3);

                guardarObjecto();
            }
            else
                System.out.println("Não há produtos a remover.");
        }


        //PERMITE CONSULTAR O HISTÓRICO DE VENDAS
        public void listarHistorico () {
            if (historico.isEmpty()) {
                System.out.println("O histórico de vendas encontra-se vazio");
            } else {
                System.out.println("Histórico de produtos vendidos:");
                for (Produto aux : historico) {
                    System.out.println(aux.getTipoProduto() + " " + aux.getNome() + " " + aux.getPreco() + "€");
                }
            }
        }


        //PERMITE LIMPAR O HISTÓRICO DE VENDAS
        public void limparHistorico() {
            if (historico.isEmpty()) {
                System.out.println("O histórico já se encontra vazio.");
                return;
            } else {
                System.out.println("Tem a certeza que deseja apagar o histórico?\n 1.Sim\n 2.Não");
                int optlh;
                do {
                    optlh = inputint();

                    switch (optlh) {
                        case 1:
                            try {
                                historico.clear();
                                guardarObjecto();
                                System.out.println("Histórico limpo com sucesso!");
                            } catch (Exception e) {
                                System.err.println("Ocorreu um erro ao limpar o histórico !\n" + e.getMessage());
                            }
                            break;

                        case 2:
                            System.out.println("A regressar ao menu ...");
                            return;

                        default:
                            System.out.println("Introduziu um número inválido. Por favor indique uma das seguintes opções: \n1. Sim; \n2. Não;.");
                    }
                } while (optlh != 1 && optlh != 2);
            }
        }
    }
