package usuario;

import db.ConnectionFactory;

import java.sql.Connection;

public class UsuarioService {

    public UsuarioDAO usuarioDAO;

    public UsuarioService() {
        Connection connection =  new ConnectionFactory().getConnection();
        this.usuarioDAO = new UsuarioDAO(connection);
    }

    public Usuario validarUsuario(Usuario usuario) {
        Usuario usuarioRetornado = usuarioDAO.buscarPorNomeSobrenome(usuario);
        if (usuarioRetornado != null) {
            return usuarioRetornado;
        }
        return criarUsuario(usuario);
    }

    private Usuario criarUsuario(Usuario usuario) {
        return usuarioDAO.salvar(usuario);
    }
}
