package org.game.dao;

import org.game.database.DatabaseManager;
import org.game.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public void createUser(User user) {
        String sql = "INSERT INTO user (id, name, kron, shilling, point, strength, agility, endurance, accuracy) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setInt(3, user.getKron());
            pstmt.setInt(4, user.getShilling());
            pstmt.setInt(5, user.getPoint());
            pstmt.setInt(6, user.getStrength());
            pstmt.setInt(7, user.getAgility());
            pstmt.setInt(8, user.getEndurance());
            pstmt.setInt(9, user.getAccuracy());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(String id) {
        String sql = "SELECT id, name, kron, shilling, point, strength, agility, endurance, accuracy FROM user WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("kron"),
                        rs.getInt("shilling"),
                        rs.getInt("point"),
                        rs.getInt("strength"),
                        rs.getInt("agility"),
                        rs.getInt("endurance"),
                        rs.getInt("accuracy")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateUser(User user) {
        String sql = "UPDATE user SET name = ?, kron = ?, shilling = ?, point = ?, strength = ?, agility = ?, endurance = ?, accuracy = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setInt(2, user.getKron());
            pstmt.setInt(3, user.getShilling());
            pstmt.setInt(4, user.getPoint());
            pstmt.setInt(5, user.getStrength());
            pstmt.setInt(6, user.getAgility());
            pstmt.setInt(7, user.getEndurance());
            pstmt.setInt(8, user.getAccuracy());

            pstmt.setString(9, user.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String id) {
        String sql = "DELETE FROM user WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}