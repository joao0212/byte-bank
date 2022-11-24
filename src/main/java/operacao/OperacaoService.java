package operacao;

import conta.Conta;

import java.util.Arrays;

public class OperacaoService {

    private Operacao operacao;

    public void realizarOperacao(Integer opcao, Conta conta, Integer valor) {
        switch (buscarTipoPorValor(opcao)) {
            case SACAR -> operacao = new Saca();
            case DEPOSITAR -> operacao = new Deposita();
        }
        operacao.realizar(conta, valor);
    }

    private TipoOperacao buscarTipoPorValor(Integer opcao) {
        return Arrays.stream(TipoOperacao.values())
                .filter(tipoOperacao -> tipoOperacao.tipo.equals(opcao))
                .findFirst()
                .orElseThrow();
    }
}
