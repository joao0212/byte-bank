package conta;

class Conta {

    private final Integer agencia;
    private final Integer conta;

    Conta(Integer agencia, Integer conta) {
        this.agencia = agencia;
        this.conta = conta;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Integer getConta() {
        return conta;
    }
}
