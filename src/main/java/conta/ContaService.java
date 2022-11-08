package conta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ContaService {

    public void validar(Integer opcao) {
        switch (opcao) {
            case 1 -> this.acessar();
            case 2 -> this.criar();
        }
    }

    private void acessar() {
        System.out.print("""
                        Informe o número da agência:
                """);
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        System.out.print("""
                        Informe o número da conta:
                """);
        var conta = pegarConta(Integer.parseInt(scanner.next()));
        System.out.printf("""
                        Voce está logado na conta %s
                """, conta.getConta());
    }

    private void criar() {
        var contaCriada = new Conta(1226, new Random().nextInt(0, 200));
        adicionarConta(contaCriada);
        System.out.printf("""
                Conta Criada!!
                Agência: %s
                Conta: %s
                %n""", contaCriada.getAgencia(), contaCriada.getConta());
    }

    private Conta pegarConta(Integer conta) {
        return listaDeContas().stream().filter(c -> c.getConta().equals(conta)).findFirst().orElseThrow();
    }

    private void adicionarConta(Conta conta) {
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
