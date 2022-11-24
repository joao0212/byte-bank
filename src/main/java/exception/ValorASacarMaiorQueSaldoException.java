package exception;

public class ValorASacarMaiorQueSaldoException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Valor a sacar deve ser menor ou igual ao saldo em conta";
    }
}
