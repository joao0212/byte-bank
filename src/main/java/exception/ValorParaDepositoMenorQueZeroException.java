package exception;

public class ValorParaDepositoMenorQueZeroException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Valor para deposito não pode ser menor que zero";
    }
}
