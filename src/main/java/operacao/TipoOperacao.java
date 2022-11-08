package operacao;

enum TipoOperacao {

    SACAR(1),

    DEPOSITAR(2);

    final Integer tipo;

    TipoOperacao(Integer tipo) {
        this.tipo = tipo;
    }
}
