package usuario;

import java.sql.*;

public class UsuarioDAO {

    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public Usuario buscarPorNomeSobrenome(Usuario usuario) throws SQLException {
        ResultSet resultSet;
        Usuario usuarioRetornado = null;

        String query = "SELECT * FROM usuario WHERE nome = ? and sobrenome = ?";

        try {
            PreparedStatement pps = connection.prepareStatement(query);
            pps.setString(1, usuario.getNome());
            pps.setString(2, usuario.getSobrenome());

            resultSet = pps.executeQuery();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
        }

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String nome = resultSet.getString(2);
            String sobrenome = resultSet.getString(3);
            usuarioRetornado = new Usuario(nome, sobrenome);
            usuarioRetornado.setId(id);
        }

        return usuarioRetornado;
    }

    public Usuario salvar(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario (nome, sobrenome) VALUES (?, ?)";
        PreparedStatement pps;

        try{
            pps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pps.setString(1, usuario.getNome());
            pps.setString(2, usuario.getSobrenome());

            pps.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
        }

        var usuarioSalvo = new Usuario(usuario.getNome(), usuario.getSobrenome());
        usuarioSalvo.setId(pps.getGeneratedKeys().getInt(1));
        return usuarioSalvo;
    }
}
