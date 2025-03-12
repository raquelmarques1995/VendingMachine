package TrabalhoJavaversao2510;

import java.util.Scanner;

public class TrabalhoFinalJava {


    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Maquina venda = new Maquina("Venda");

        venda.importarObjecto();

        int ex1;

            System.out.println("\n ** Menu **\n ");
            System.out.println("1.Cliente ");
            System.out.println("2.Colaborador ");
            System.out.println("0.Sair ");
            System.out.print("\nEscolha uma das opções: ");
        do {
            //aqui vai precisar de um if
            ex1 = venda.inputint();

            if (!venda.verificarStock() && ex1== 1) {
                    System.out.println("Não existem produtos na máquina. Volte sempre.");
                    return;
            } else {
            switch (ex1) {
                case 0:
                    System.out.println("Elaborado por José Vaz e Raquel Marques");
                    System.out.println("Volte sempre!");
                    break;

                case 1:
                    int esc1;
                    do {
                        System.out.println("\n ** Menu do Cliente: **\n ");
                        System.out.println("1. Ver lista de produtos antecipadamente.");
                        System.out.println("2. Fazer compra.");
                        System.out.println("0. Sair ");
                        System.out.print("\nEscolha uma das opções: ");
                        esc1 = venda.inputint();

                        switch (esc1) {
                            case 0:
                                System.out.println("Até breve!");
                                return;

                            case 1:
                                venda.listarcategoria();
                                venda.adicionarSaldo();
                                venda.listarcategoria();
                                venda.escolherProduto();
                                break;

                            case 2:
                                venda.adicionarSaldo();
                                venda.listarcategoria();
                                venda.escolherProduto();
                                break;

                            default:
                                System.out.println("Introduziu um número inválido. Por favor indique uma das seguintes opções: \n1. Ver lista de produtos antecipadamente; \n2. Fazer compra; \n0. Para voltar ao menu.\n");
                        }
                    } while (esc1 != 0);

                    break;

                case 2:
                    int esc2;
                    do {
                        System.out.println("\n ** Menu do Colaborador: **\n ");
                        System.out.println("1. Adicionar novo Produto.");
                        System.out.println("2. Remover Produto do Stock.");
                        System.out.println("3. Listar produto por categoria.");
                        System.out.println("4. Consultar o total de Vendas.");
                        System.out.println("5. Consultar Histório de Vendas");
                        System.out.println("6. Limpar histórico.");
                        System.out.println("0. Sair ");
                        System.out.print("\nEscolha uma das opções: ");

                        esc2 = venda.inputint();

                        switch (esc2) {
                            case 0:
                                System.out.println("Até breve!");
                                return;

                            case 1:
                                venda.adicionarProduto();
                                break;
                            case 2:
                                venda.removerProduto();
                                break;
                            case 3:
                                venda.listarProdutoscat();
                                break;

                            case 4:
                                System.out.println("O total de vendas até ao momento é de " + venda.getTotalvendas() + "€");

                                break;

                            case 5:
                                venda.listarHistorico();

                                break;

                            case 6:
                                venda.limparHistorico();
                                break;

                            default:
                                System.out.println("Introduziu um número inválido. Por favor indique uma das seguintes opções: \n1. Adicionar novo Produto; \n2. Remover Produto do Stock; \n3. Listar produto por categoria; \n4. Consultar o total de Vendas. \n5. Consultar Histório de Vendas;\n6. Limpar histórico;\n0. para voltar ao menu.");
                        }
                    } while (esc2 != 0);

                    break;

                default:
                    System.out.println("Introduziu um número inválido. Por favor indique uma das seguintes opções:\n1. Cliente; \n2. Colaborador;\n0. Sair.");
            }
            }
        }while(ex1!=0);


        venda.guardarObjecto();
        leitor.close();

    }
}
