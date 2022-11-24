package conta;

import db.ConnectionFactory;
import usuario.Usuario;
import usuario.UsuarioService;

import java.sql.Connection;
import java.util.*;

public class ContaService {

    private final ContaDAO contaDAO;

    public ContaService() {
        Connection connection = new ConnectionFactory().getConnection();
        this.contaDAO = new ContaDAO(connection);
    }

    public Optional<Conta> buscar(Integer conta) {
        return contaDAO.buscarPorConta(conta);
    }

    public Conta criar(Integer numeroConta, String nome, String sobrenome) {
        var agenciaDefault = 12262;
        var usuarioService = new UsuarioService();
        var usuarioValidado = usuarioService.validarUsuario(new Usuario(nome, sobrenome));
        var novaConta = new Conta(agenciaDefault, numeroConta, 0);
        novaConta.setUsuario(usuarioValidado);
        System.out.printf("""
                Conta Criada, %s!!
                Agência: %s
                Conta: %s
                %n""", usuarioValidado.getNome(), agenciaDefault, numeroConta);
        return contaDAO.salvar(novaConta);
    }

    public void update(Conta conta, Integer valor) {
        contaDAO.update(conta, valor);
    }
}
