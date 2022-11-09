package conta;

import usuario.Usuario;

class Conta {

    private final Integer agencia;
    private final Integer conta;
    private final Usuario usuario;

    Conta(Integer agencia, Integer conta, Usuario usuario) {
        this.agencia = agencia;
        this.conta = conta;
        this.usuario = usuario;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Integer getConta() {
        return conta;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
