package DAO;
import Model.Clientes;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    //INSERT
    public boolean insertClientes(Clientes cliente) {
        connectToDB();
        String sql = "INSERT INTO Cliente (CPF, Nome, Telefone) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setLong(1, cliente.getCPF());
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getTelefone());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
    //UPDATE
    public boolean updateClientes(long cpf, String nome, String telefone) {
        connectToDB();
        String sql = "UPDATE Cliente SET Nome = ?, Telefone = ? WHERE CPF = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, telefone);
            pst.setLong(3, cpf);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
    //DELETE
    public boolean deleteClientes(long cpf) {
        connectToDB();
        String sql = "DELETE FROM Cliente where cpf=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setLong(1, cpf);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = O cliente está sendo referenciado em alguma tabela");
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
    //SELECT
    public ArrayList<Clientes> selectCliente() {
        ArrayList<Clientes> clientes = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Cliente";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Cliente: ");
            while (rs.next()) {
                Clientes clienteAux = new Clientes(rs.getLong("CPF"),rs.getString("Nome"), rs.getString("Telefone"));
                System.out.println("cpf = " + clienteAux.getCPF());
                System.out.println("nome = " + clienteAux.getNome());
                System.out.println("telefone = " + clienteAux.getTelefone());
                System.out.println("--------------------------------");
                clientes.add(clienteAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return clientes;
    }

}
