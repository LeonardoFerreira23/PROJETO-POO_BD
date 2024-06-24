package Model;

public class NotasFiscais {

    private int idNotasFiscais;

    private int OperacaoVenda_idOperacaoVenda;

    private int total;

    public NotasFiscais(int idNotasFiscais, int operacaoVenda_idOperacaoVenda, int total) {
        this.idNotasFiscais = idNotasFiscais;
        OperacaoVenda_idOperacaoVenda = operacaoVenda_idOperacaoVenda;
        this.total = total;
    }

    public int getIdNotasFiscais() {
        return idNotasFiscais;
    }

    public int getOperacaoVenda_idOperacaoVenda() {
        return OperacaoVenda_idOperacaoVenda;
    }

    public int getTotal() {
        return total;
    }
}
