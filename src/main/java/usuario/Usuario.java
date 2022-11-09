package usuario;

public class Usuario {

    private final Integer id;
    private final String nome;
    private final String sobrenome;

    public Usuario(Integer id, String nome, String sobrenome) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }
}
