import conta.ContaService;
import operacao.*;

import java.util.Scanner;

public class ByteBankInitializer {

    public static void main(String... x) {
        validarAcesso();
        realizarOperacao();
    }

    private static void validarAcesso() {
        System.out.print("""
                        Possui conta?:
                        1 - Sim
                        2 - Não
                """);
        Scanner scanner = new Scanner(System.in);
        var opcaoSelecionada = Integer.parseInt(scanner.next());
        var contaService = new ContaService();
        switch (opcaoSelecionada) {
            case 1 -> contaService.acessar();
            case 2 -> contaService.criar();
        }
    }

    private static void realizarOperacao() {
        System.out.print("""
                        Selecione a opção:
                        1 - Sacar
                        2 - Depositar
                        3 - Transferir
                """);

        Scanner scanner = new Scanner(System.in);
        var operacaoService = new OperacaoService();
        var operacaoSelecionada = operacaoService.buscaPorValor(Integer.parseInt(scanner.next()));
        operacaoService.realizarOperacao(operacaoSelecionada);
    }
}
