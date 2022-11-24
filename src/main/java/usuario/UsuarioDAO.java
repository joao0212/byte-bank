package usuario;

import java.sql.*;

class UsuarioDAO {

    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public Usuario buscarPorNomeSobrenome(Usuario usuario) {
        Usuario usuarioRetornado = null;

        String query = "SELECT * FROM usuario WHERE nome = ? and sobrenome = ?";

        try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setString(1, usuario.getNome());
            prepareStatement.setString(2, usuario.getSobrenome());

            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                while (resultSet.next()) {
                    String nome = resultSet.getString(2);
                    String sobrenome = resultSet.getString(3);
                    usuarioRetornado = new Usuario(nome, sobrenome);
                    usuarioRetornado.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        return usuarioRetornado;
    }

    public Usuario salvar(Usuario usuario) {
        Usuario novoUsuario;

        String query = "INSERT INTO usuario (nome, sobrenome) VALUES (?, ?)";

        try (PreparedStatement prepareStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1, usuario.getNome());
            prepareStatement.setString(2, usuario.getSobrenome());

            prepareStatement.execute();

            novoUsuario = new Usuario(usuario.getNome(), usuario.getSobrenome());
            try (ResultSet keys = prepareStatement.getGeneratedKeys()) {
                keys.next();
                novoUsuario.setId(keys.getInt(1));
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        return novoUsuario;
    }
}
