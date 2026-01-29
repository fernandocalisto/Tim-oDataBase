package calistofernando.repository;

import calistofernando.factory.ConnectionFactory;
import calistofernando.model.Player;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO_MySQL implements PlayerDAO{
    @Override
    public void savePlayer(Player p) {

        String command = "INSERT INTO corinthians (name, birth_date, position) VALUES (?,?,?)";


        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement stmt = c.prepareStatement(command)) {


            stmt.setString(1, p.getName());
            stmt.setDate(2, Date.valueOf(p.getBirth_date()));
            stmt.setString(3, p.getPosition());

            stmt.executeUpdate();

            System.out.println("New player added!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar Player!", e);
        }
    }

    @Override
    public void deletePlayer(int id) {

        String command = "DELETE FROM corinthians WHERE ID = ?";

        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement stmt = c.prepareStatement(command)){

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Player Deleted!");

        }catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar Player!", e);
        }

    }

    @Override
    public Player getPlayer(int id){

        String command = "SELECT name, birth_date, position FROM corinthians WHERE id = ?";

        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement stmt = c.prepareStatement(command)){

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Player ans = new Player();

                    ans.setName(rs.getString("name"));
                    ans.setBirth_date(rs.getObject("birth_date", LocalDate.class));
                    ans.setPosition(rs.getString("position"));

                    return ans;
                }
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao Consultar Player!", e);
        }
    }

    @Override
    public List<Player> getAllPlayers() {

        String command = "SELECT name, birth_date, position FROM corinthians";

        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement stmt = c.prepareStatement(command);
             ResultSet rs = stmt.executeQuery()) {

                List<Player> ans = new ArrayList<>();

                while (rs.next()) {
                    Player p = new Player();
                    p.setName(rs.getString("name"));
                    p.setBirth_date(rs.getObject("birth_date", LocalDate.class));
                    p.setPosition(rs.getString("position"));

                    ans.add(p);
                }
                return ans;


        } catch (SQLException e) {
            throw new RuntimeException("Erro ao acessar o DB!", e);
        }

    }
}
