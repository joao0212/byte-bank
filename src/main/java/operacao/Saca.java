package operacao;

import conta.Conta;
import conta.ContaService;
import exception.ValorASacarMaiorQueSaldoException;

class Saca implements Operacao {

    @Override
    public void realizar(Conta conta, Integer valor) {
        ContaService contaService = new ContaService();
        var contaRetornada = contaService.buscar(conta.getConta());
        if (contaRetornada.isPresent() && valor > contaRetornada.get().getValor()) {
            throw new ValorASacarMaiorQueSaldoException();
        } else {
            contaService.update(conta, (valor * -1));
        }
    }
}
