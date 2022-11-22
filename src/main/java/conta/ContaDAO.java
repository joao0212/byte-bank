package conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ContaDAO {

    private final Connection connection;

    public ContaDAO(Connection connection) {
        this.connection = connection;
    }


    public void salvar(Conta conta) {
        String query = "INSERT INTO conta (agencia, conta, usuario_id) VALUES (?, ?, ?)";
        PreparedStatement pps;

        try {
            pps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pps.setInt(1, conta.getAgencia());
            pps.setInt(2, conta.getConta());
            pps.setInt(3, conta.getUsuario().getId());

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
    }
}
