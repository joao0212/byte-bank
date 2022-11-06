package operacao;

import java.util.Arrays;

public class OperacaoService {

    private Operacao operacao;

    public void realizarOperacao(TipoOperacao operacaoSelecionada) {
        switch (operacaoSelecionada) {
            case SACAR -> operacao = new Saca();
            case DEPOSITAR -> operacao = new Deposita();
            case TRANSFERIR -> operacao = new Transfere();
        }
        operacao.realizar();
    }

    public TipoOperacao buscaPorValor(Integer tipo) {
        return Arrays.stream(TipoOperacao.values())
                .filter(tipoOperacao -> tipoOperacao.tipo.equals(tipo))
                .findFirst()
                .orElseThrow();
    }
}
