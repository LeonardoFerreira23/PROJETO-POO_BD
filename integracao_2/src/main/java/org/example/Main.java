package org.example;
import DAO.*;
import Model.*;

import java.math.BigInteger;
import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        Scanner s = new Scanner(System.in);
        int n;
        int p, g;
        String a;
        String b;
        VendedoresDAO vaux = new VendedoresDAO();
        ClienteDAO caux = new ClienteDAO();
        ProdutoDAO paux = new ProdutoDAO();
        OperacaoVendaDAO opaux = new OperacaoVendaDAO();
        OperacaoVenda_ProdutoDAO op2aux = new OperacaoVenda_ProdutoDAO();
        NotasFiscaisDAO notaux = new NotasFiscaisDAO();


        do{
            System.out.println("ESCOLHA A OPERAÇÃO DESEJADA: ");
            System.out.println(" 1 - Insert");
            System.out.println(" 2 - Update");
            System.out.println(" 3 - Select");
            System.out.println(" 4 - Delete");
            n = s.nextInt();
        switch (n) {
            case 1:
                System.out.println("Selecione a tabela: ");
                System.out.println(" 1 - Vendedores");
                System.out.println(" 2 - Clientes");
                System.out.println(" 3 - Produtos");
                System.out.println(" 4 - OperaçõesVenda");
                System.out.println(" OBS.: Para dar insert na tabela de OperaçõesVenda, certifique-se que o produto foi criado, assim como o cliente e vendedor foi registrado");
                int h = s.nextInt();
                switch(h) {
                    case 1:
                        System.out.println("Digite o id do vendedor: ");
                        n = s.nextInt();
                        System.out.println("Digite o nome do vendedor: ");
                        a = s.next();
                        vaux.insertVendedor(new Vendedores(n, a));
                        break;
                    case 2:
                        System.out.println("Digite o CPF do cliente: ");
                        long j = s.nextLong();
                        System.out.println("Digite o nome do cliente: ");
                        a = s.next();
                        System.out.println("Digite o telefone do cliente: ");
                        b = s.next();
                        caux.insertClientes(new Clientes(j, a, b));
                        break;
                    case 3:
                        System.out.println("Digite o id do produto: ");
                        n = s.nextInt();
                        System.out.println("Digite o valor do produto: ");
                        p = s.nextInt();
                        System.out.println("Digite o nome do produto: ");
                        a = s.next();
                        paux.insertProduto(new Produtos(n, p, a));
                        break;
                    case 4:
                        int tot = 0;
                        System.out.println("Digite o numero da operação de venda: ");
                        n = s.nextInt();
                        System.out.println("Digite o id do Vendedor: ");
                        p=s.nextInt();
                        System.out.println("Digite o CPF do cliente: ");
                        j = s.nextLong();
                        opaux.insertOperacao(new OperacaoVenda(n, p, j));
                        System.out.println("Digite a quantidade de produtos da operação de venda: ");
                        p = s.nextInt();
                        System.out.println("Digite o id dos produtos: ");
                        for (int i = 0; i < p ; i++) {
                            g = s.nextInt();
                            op2aux.insertOP_Produto(new OperacaoVenda_Produtos(n,g));
                            tot = tot + paux.selectProdutoValor(g);
                            System.out.println("Digite o id dos produtos: ");
                        }
                        System.out.println("Digite o id da nota fiscal: ");
                        p = s.nextInt();
                        notaux.insertNota(new NotasFiscais(p, n, tot));
                        System.out.println(tot);
                        break;
                }
                break;
            case 2:

                if(n == 2) {
                    System.out.println("Selecione a tabela: ");
                    System.out.println(" 1 - Vendedores");
                    System.out.println(" 2 - Clientes");
                    System.out.println(" 3 - Produtos");
                    System.out.println(" 4 - OperaçõesVenda");

                    h = s.nextInt();
                    if (h == 1) {
                        System.out.println("Digite o id do vendedor: ");
                        int idVendedor = s.nextInt();
                        System.out.println("Digite o novo nome do vendedor: ");
                        String nome = s.next();
                        vaux.updateVendedores(idVendedor, nome);
                        vaux.selectVendedor();
                        break;
                    } else if (h == 2) {
                        System.out.println("Digite o CPF do cliente: ");
                        long cpf = s.nextLong();
                        System.out.println("Digite o novo nome do cliente: ");
                        String nome = s.next();
                        System.out.println("Digite o novo telefone do cliente: ");
                        String telefone = s.next();
                        boolean sucesso = caux.updateClientes(cpf, nome, telefone);
                    } else if (h == 3) {
                        System.out.println("Digite o id do produto: ");
                        int idProduto = s.nextInt();
                        System.out.println("Digite o novo nome do produto: ");
                        String nome = s.next();
                        System.out.println("Digite o novo valor do produto: ");
                        int valor = s.nextInt();
                        boolean sucesso = paux.updateProdutos(idProduto, nome, valor);
                    } else if (h == 4) {
                        System.out.println("Digite o id da operação de venda: ");
                        int idOperacao = s.nextInt();
                        System.out.println("Digite o id do novo vendedor: ");
                        int idOperacao2 = s.nextInt();
                        System.out.println("Digite o CPF do novo cliente: ");
                        Long idOperacao3 = s.nextLong();
                        boolean sucesso = opaux.updateOperacao(idOperacao, idOperacao2, idOperacao3);
                        opaux.selectOperacao();
                    }
                    break;
                }
            case 3:
                System.out.println("Selecione a tabela para exibir os dados: ");
                System.out.println(" 1 - Vendedores");
                System.out.println(" 2 - Clientes");
                System.out.println(" 3 - Produtos");
                System.out.println(" 4 - OperaçõesVenda");
                System.out.println(" 5 - OperacoesVendaProdutos");
                System.out.println(" 6 - NotasFiscais");
                h = s.nextInt();

                if (h == 1) {
                    vaux.selectVendedor();
                } else if (h == 2) {
                    caux.selectCliente();
                }
                else if (h == 3)
                {
                    paux.selectProduto();
                }
                else if (h == 4)
                {
                    opaux.selectOperacao();
                }
                else if (h == 5)
                {
                    op2aux.selectProduto();
                }
                else if (h==6)
                {
                    notaux.selectNotas();
                }
                break;


            case 4:
                System.out.println("Selecione a tabela para deletar os dados: ");
                System.out.println(" 1 - Vendedores");
                System.out.println(" 2 - Clientes");
                System.out.println(" 3 - Produtos");
                System.out.println(" 4 - OperaçõesVenda");
                System.out.println(" 5 - OperacoesVenda_Produtos");
                System.out.println(" 6 - NotasFiscais");
                h = s.nextInt();

                if (h == 1) {
                    vaux.selectVendedor();
                    System.out.println("Digite o id do vendedor: ");
                    int idVendedor = s.nextInt();
                    vaux.deleteVendedores(idVendedor);

                }
                else if (h == 2) {
                    caux.selectCliente();
                    System.out.println("Digite o CPF do cliente: ");
                    long cpf = s.nextLong();
                    caux.deleteClientes(cpf);
                }

                else if (h == 3){
                    paux.selectProduto();
                    System.out.println("Digite o id do produto: ");
                    int id = s.nextInt();
                    paux.deleteProdutos(id);
                }

                else if (h == 4)
                {
                    opaux.selectOperacao();
                    System.out.println("Digite o id da operação: ");
                    int id = s.nextInt();
                    opaux.deleteOperacao(id);
                }

                else if (h==5)
                {
                    op2aux.selectProduto();
                    System.out.println("Digite o id da operação de venda e do produto: ");
                    int id = s.nextInt();
                    int id2 = s.nextInt();
                    op2aux.deleteProdutos(id, id2);
                }

                else if (h==6)
                {
                    notaux.selectNotas();
                    System.out.println("Digite o id da nota fiscal: ");
                    int id = s.nextInt();
                    notaux.deleteNotas(id);
                }
                break;
        }
        } while (n != 0);

    }
}