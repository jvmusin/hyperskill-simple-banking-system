package banking;

import java.sql.*;
import java.util.Optional;

public class CardRepository {
    private final String connectionString;

    public CardRepository(String connectionString) {
        this.connectionString = connectionString;
        createTables();
    }

    public void createTables() {
        String sql = "" +
                "CREATE TABLE IF NOT EXISTS card (" +
                "  id INTEGER PRIMARY KEY," +
                "  number TEXT," +
                "  pin TEXT," +
                "  balance INTEGER DEFAULT 0" +
                ")";
        try (Connection connection = DriverManager.getConnection(connectionString);
             Statement s = connection.createStatement()) {
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Card saveCard(Card card) {
        String sql = "INSERT INTO card (number, pin) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, card.getNumber());
            ps.setString(2, card.getPin());
            ps.execute();
            return loadCard(card.getNumber()).orElseThrow();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Card> loadCard(String number) {
        String sql = "SELECT id, number, pin, balance FROM card WHERE number=?";
        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, number);
            ResultSet rs = ps.executeQuery();
            return rs.next()
                    ? Optional.of(new Card(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)))
                    : Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBalance(String number, int delta) {
        String sql = "UPDATE card SET balance=?+balance WHERE number=?";
        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, delta);
            ps.setString(2, number);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCard(String number) {
        String sql = "DELETE FROM card WHERE number=?";
        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, number);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
