package operacao;

import java.util.Arrays;

public class OperacaoService {

    private Operacao operacao;

    public void realizarOperacao(Integer opcao) {
        switch (buscarTipoPorValor(opcao)) {
            case SACAR -> operacao = new Saca();
            case DEPOSITAR -> operacao = new Deposita();
        }
        operacao.realizar();
    }

    private TipoOperacao buscarTipoPorValor(Integer opcao) {
        return Arrays.stream(TipoOperacao.values())
                .filter(tipoOperacao -> tipoOperacao.tipo.equals(opcao))
                .findFirst()
                .orElseThrow();
    }
}
