package org.game.dao;

import org.game.database.DatabaseManager;
import org.game.models.Guild;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuildDAO {
    public void createGuild(Guild guild) {
        String sql = "INSERT INTO guild (id, king_id, description, empire_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guild.getId());
            pstmt.setString(2, guild.getKingId());
            pstmt.setString(3, guild.getDescription());
            pstmt.setString(4, guild.getEmpireId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Guild getGuildById(String id) {
        String sql = "SELECT id, king_id, description, empire_id FROM guild WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Guild(
                        rs.getString("id"),
                        rs.getString("king_id"),
                        rs.getString("description"),
                        rs.getString("empire_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateGuild(Guild guild) {
        String sql = "UPDATE guild SET king_id = ?, description = ?, empire_id = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guild.getKingId());
            pstmt.setString(2, guild.getDescription());
            pstmt.setString(3, guild.getEmpireId());
            pstmt.setString(4, guild.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGuild(String id) {
        String sql = "DELETE FROM guild WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}