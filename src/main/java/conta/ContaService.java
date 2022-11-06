package conta;

import java.util.Scanner;

public class ContaService {

    public void acessar() {
        System.out.print("""
                        Informe o número da agência:
                """);
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        System.out.print("""
                        Informe o número da conta:
                """);
        scanner.next();
        System.out.print("""
                        Voce está logado:
                """);
    }

    public void criar() {
        System.out.print("""
                        Informe o número da agência:
                """);
        Scanner scanner = new Scanner(System.in);
        var agencia = Integer.parseInt(scanner.next());
        System.out.print("""
                        Informe o número da conta:
                """);
        var conta = Integer.parseInt(scanner.next());
        var contaCriada = new Conta(agencia, conta);

        System.out.printf("""
                Conta Criada!!
                Conta: %s
                Agência: %s
                %n""", contaCriada.getConta(), contaCriada.getAgencia());
    }
}
