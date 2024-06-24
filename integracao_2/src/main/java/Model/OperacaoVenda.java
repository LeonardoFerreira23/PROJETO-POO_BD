package Model;


public class OperacaoVenda {

    private int idOperacaoVenda;

    private int Vendedores_idVendedores;

    private long Cliente_CPF;

    public OperacaoVenda(int idOperacaoVenda, int vendedores_idVendedores, long cliente_CPF) {
        this.idOperacaoVenda = idOperacaoVenda;
        Vendedores_idVendedores = vendedores_idVendedores;
        Cliente_CPF = cliente_CPF;
    }

    public int getIdOperacaoVenda() {
        return idOperacaoVenda;
    }

    public int getVendedores_idVendedores() {
        return Vendedores_idVendedores;
    }

    public long getCliente_CPF() {
        return Cliente_CPF;
    }



}
