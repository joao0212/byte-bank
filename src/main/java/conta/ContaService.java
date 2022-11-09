package conta;

import db.ConnectionFactory;
import usuario.Usuario;

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

        return listaDeContas().stream().filter(c -> c.getConta().equals(conta)).findFirst();
    }

    public void criar(Integer numeroConta, String nome, String sobrenome) {
        var usuario = new Usuario(new Random().nextInt(), nome, sobrenome);
        var contaCriada = new Conta(1226, numeroConta, usuario);
        adicionar(contaCriada);
        System.out.printf("""
                Conta Criada, %s!!
                Agência: %s
                Conta: %s
                %n""", contaCriada.getUsuario().getNome(), contaCriada.getAgencia(), contaCriada.getConta());
    }

    private void adicionar(Conta conta) {
        listaDeContas().add(conta);
    }

    private List<Conta> listaDeContas() {
        var contas = new ArrayList<Conta>();
        contas.add(new Conta(12, 48, new Usuario(new Random().nextInt(), "João", "Martins")));
        contas.add(new Conta(12, 56, new Usuario(new Random().nextInt(), "Paulo", "Silveira")));
        contas.add(new Conta(12, 88, new Usuario(new Random().nextInt(), "Mag", "Moura")));
        contas.add(new Conta(12, 90, new Usuario(new Random().nextInt(), "Alexandre", "Aquiles")));
        contas.add(new Conta(12, 101, new Usuario(new Random().nextInt(), "Claudia", "Martins")));
        contas.add(new Conta(12, 2, new Usuario(new Random().nextInt(), "Giovane", "Carvalho")));
        return contas;
    }
}
