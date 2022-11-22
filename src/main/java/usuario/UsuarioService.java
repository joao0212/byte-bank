package usuario;

import db.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class UsuarioService {

    public Connection connection;
    public UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.connection = new ConnectionFactory().getConnection();
        this.usuarioDAO = new UsuarioDAO(connection);
    }

    public Usuario validarUsuario(Usuario usuario) {
        Usuario novoUsuario;
        try {
            Usuario usuarioRetornado = usuarioDAO.buscarPorNomeSobrenome(usuario);
            if (usuarioRetornado != null) {
                return usuarioRetornado;
            }
            novoUsuario = usuarioDAO.salvar(usuario);
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return novoUsuario;
    }
}
