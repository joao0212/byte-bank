package conta;

import java.util.*;

public class ContaService {

    public Optional<Conta> buscar(Integer conta) {
        return listaDeContas().stream().filter(c -> c.getConta().equals(conta)).findFirst();
    }

    public void criar(Integer numeroConta) {
        var contaCriada = new Conta(1226, numeroConta);
        adicionar(contaCriada);
        System.out.printf("""
                Conta Criada!!
                Agência: %s
                Conta: %s
                %n""", contaCriada.getAgencia(), contaCriada.getConta());
    }

    private void adicionar(Conta conta) {
        listaDeContas().add(conta);
    }

    private List<Conta> listaDeContas() {
        var contas = new ArrayList<Conta>();
        contas.add(new Conta(12, 48));
        contas.add(new Conta(12, 56));
        contas.add(new Conta(12, 88));
        contas.add(new Conta(12, 90));
        contas.add(new Conta(12, 101));
        contas.add(new Conta(12, 2));
        return contas;
    }
}
