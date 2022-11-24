import conta.Conta;
import conta.ContaService;
import operacao.*;

import java.util.Scanner;

public class ByteBankInitializer {

    public static void main(String... x) {
        var byteBankInitializer = new ByteBankInitializer();
        var conta = byteBankInitializer.validarAcesso();
        byteBankInitializer.selecionarOperacao(conta);
    }

    private Conta validarAcesso() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                        Informe o número da conta:
                        """);
        var numeroConta = Integer.parseInt(scanner.next());
        var contaService = new ContaService();
        var conta = contaService.buscar(numeroConta);
        if(conta.isEmpty()) {
            System.out.println("""
                    Conta não existe!!
                    
                    Informe seu nome:
                    """);
            var nome = scanner.next();
            System.out.println("""
                    Informe seu sobrenome:
                    """);
            var sobrenome = scanner.next();
            return contaService.criar(numeroConta, nome, sobrenome);
        } else {
            System.out.println("Seja vem vindo(a)");
        }
        return conta.get();
    }

    private void selecionarOperacao(Conta conta) {
        System.out.print("""
                        Selecione a opção:
                        1 - Sacar
                        2 - Depositar
                        """);

        Scanner scanner = new Scanner(System.in);
        var opcaoSelecionada = Integer.parseInt(scanner.next());
        System.out.println("""
                Insira o valor da operação:
                """);
        var valor = scanner.next();
        var operacaoService = new OperacaoService();
        operacaoService.realizarOperacao(opcaoSelecionada, conta, Integer.parseInt(valor));
    }
}
