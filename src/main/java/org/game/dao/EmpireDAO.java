package org.game.dao;

import org.game.database.DatabaseManager;
import org.game.models.Empire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpireDAO {
    public void createEmpire(Empire empire) {
        String sql = "INSERT INTO empire (id, imperial_guild_id, description) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empire.getId());
            pstmt.setString(2, empire.getImperialGuildId());
            pstmt.setString(3, empire.getDescription());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Empire getEmpireById(String id) {
        String sql = "SELECT id, imperial_guild_id, description FROM empire WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Empire(
                        rs.getString("id"),
                        rs.getString("imperial_guild_id"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateEmpire(Empire empire) {
        String sql = "UPDATE empire SET imperial_guild_id = ?, description = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empire.getImperialGuildId());
            pstmt.setString(2, empire.getDescription());
            pstmt.setString(3, empire.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmpire(String id) {
        String sql = "DELETE FROM empire WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}