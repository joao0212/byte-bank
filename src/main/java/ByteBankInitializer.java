import conta.ContaService;
import operacao.*;

import java.util.Scanner;

public class ByteBankInitializer {

    public static void main(String... x) {
        validarAcesso();
        selecionarOperacao();
    }

    private static void validarAcesso() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                        Informe o número da agência:
                        """);
        scanner.next();
        System.out.print("""
                        Informe o número da conta:
                        """);
        var numeroConta = Integer.parseInt(scanner.next());
        var contaService = new ContaService();
        var conta = contaService.buscar(numeroConta);
        if(conta.isEmpty()) {
            System.out.println("""
                    Conta não existe!!""");
            contaService.criar(numeroConta);
        } else {
            System.out.println("Seja vem vindo(a)");
        }
    }

    private static void selecionarOperacao() {
        System.out.print("""
                        Selecione a opção:
                        1 - Sacar
                        2 - Depositar
                        """);

        Scanner scanner = new Scanner(System.in);
        var opcaoSelecionada = Integer.parseInt(scanner.next());
        new OperacaoService().realizarOperacao(opcaoSelecionada);
    }
}
