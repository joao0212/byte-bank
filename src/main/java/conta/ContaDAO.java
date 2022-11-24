package conta;

import java.sql.*;
import java.util.Optional;

class ContaDAO {

    private final Connection connection;

    public ContaDAO(Connection connection) {
        this.connection = connection;
    }

    public Optional<Conta> buscarPorConta(Integer conta) {
        Conta contaRetornada = null;

        String query = "SELECT * FROM conta WHERE conta = ?";

        try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, conta);

            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                while (resultSet.next()) {
                    Integer agencia = resultSet.getInt(1);
                    Integer contaCorrente = resultSet.getInt(2);
                    Integer valor = resultSet.getInt(4);
                    contaRetornada = new Conta(agencia, contaCorrente, valor);
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }

        if (contaRetornada != null) {
            return Optional.of(contaRetornada);
        } return Optional.empty();
    }

    public Conta salvar(Conta conta) {
        Conta novaConta;

        String query = "INSERT INTO conta (agencia, conta, usuario_id, valor) VALUES (?, ?, ?, ?)";

        try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {

            prepareStatement.setInt(1, conta.getAgencia());
            prepareStatement.setInt(2, conta.getConta());
            prepareStatement.setInt(3, conta.getUsuario().getId());
            prepareStatement.setInt(4, conta.getValor());

            prepareStatement.execute();

            novaConta = new Conta(conta.getAgencia(), conta.getConta(), conta.getValor());
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        return novaConta;
    }

    public void update(Conta conta, Integer valor) {
        String query = "UPDATE conta SET valor = valor + ? where conta = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, valor);
            preparedStatement.setInt(2, conta.getConta());

            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
        }
    }
}
