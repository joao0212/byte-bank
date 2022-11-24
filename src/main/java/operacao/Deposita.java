package operacao;

import conta.Conta;
import conta.ContaService;
import exception.ValorParaDepositoMenorQueZeroException;

class Deposita implements Operacao {

    @Override
    public void realizar(Conta conta, Integer valor) {
        if (valor > 0) {
            ContaService contaService = new ContaService();
            contaService.update(conta, valor);
        } else {
            throw new ValorParaDepositoMenorQueZeroException();
        }
    }
}
