package conta;

import db.ConnectionFactory;
import usuario.Usuario;
import usuario.UsuarioService;

import java.sql.Connection;
import java.util.*;

public class ContaService {

    private final Connection connection;

    public ContaService() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public Optional<Conta> buscar(Integer conta) {
        try {
            System.out.println("Conectei");
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return Optional.empty();//listaDeContas().stream().filter(c -> c.getConta().equals(conta)).findFirst();
    }

    public void criar(Integer numeroConta, String nome, String sobrenome) {
        var contaDefault = 12262;
        var usuarioService = new UsuarioService();
        var usuarioValidado = usuarioService.validarUsuario(new Usuario(nome, sobrenome));
        var contaDAO = new ContaDAO(connection);
        contaDAO.salvar(new Conta(contaDefault, numeroConta, usuarioValidado));
        System.out.printf("""
                Conta Criada, %s!!
                Agência: %s
                Conta: %s
                %n""", usuarioValidado.getNome(), contaDefault, numeroConta);
    }
}
