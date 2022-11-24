package conta;

import usuario.Usuario;

public class Conta {

    private final Integer agencia;
    private final Integer conta;
    private Usuario usuario;
    private final Integer valor;

    Conta(Integer agencia, Integer conta, Integer valor) {
        this.agencia = agencia;
        this.conta = conta;
        this.valor = valor;
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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getValor() { return valor; }
}
