import conta.ContaService;
import operacao.*;

import java.util.Scanner;

public class ByteBankInitializer {

    public static void main(String... x) {
        validarAcesso();
        selecionarOperacao();
    }

    private static void validarAcesso() {
        System.out.print("""
                        Possui conta?:
                        1 - Sim
                        2 - Não
                """);
        Scanner scanner = new Scanner(System.in);
        var opcaoSelecionada = Integer.parseInt(scanner.next());
        new ContaService().validar(opcaoSelecionada);
    }

    private static void selecionarOperacao() {
        System.out.print("""
                        Selecione a opção:
                        1 - Sacar
                        2 - Depositar
                        3 - Transferir
                """);

        Scanner scanner = new Scanner(System.in);
        var operacaoService = new OperacaoService();
        operacaoService.realizarOperacao(Integer.parseInt(scanner.next()));
    }
}
