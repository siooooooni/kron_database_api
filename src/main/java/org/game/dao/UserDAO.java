package org.game.dao;

import org.game.database.DatabaseManager;
import org.game.models.User;

import java.sql.*;

public class UserDAO {
    //region 가져오기 함수들
    // - 기본
    public String getUserGuildID(String userID) {
        String result = null;

        String sql = "SELECT guild_id FROM user WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getString("guild_id");
            }
            else{
                result = null;
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = null;
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = null;
        }

        return result;
    }

    public int getUserGuildPosition(String userID) {
        int result = -1;

        String sql = "SELECT guild_position FROM user WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("guild_position");
            }
            else{
                result = 1;
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public String getUserName(String userID) {
        String result = null;

        String sql = "SELECT name FROM user WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getString("name");
            }
            else{
                result = null;
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = null;
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = null;
        }

        return result;
    }

    public int getUserKron(String userID) {
        int result = -1;

        String sql = "SELECT kron FROM user WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("kron");
            }
            else{
                result = 1;
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public int getUserShilling(String userID) {
        int result = -1;

        String sql = "SELECT shilling FROM user WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("shilling");
            }
            else{
                result = 1;
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public int getUserPoint(String userID) {
        int result = -1;

        String sql = "SELECT point FROM user WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("point");
            }
            else{
                result = 1;
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public int getUserStrength(String userID) {
        int result = -1;

        String sql = "SELECT strength FROM user WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("strength");
            }
            else{
                result = 1;
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public int getUserAgility(String userID) {
        int result = -1;

        String sql = "SELECT agility FROM user WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("agility");
            }
            else{
                result = 1;
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public int getUserEndurance(String userID) {
        int result = -1;

        String sql = "SELECT endurance FROM user WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("endurance");
            }
            else{
                result = 1;
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public int getUserAccuracy(String userID) {
        int result = -1;

        String sql = "SELECT accuracy FROM user WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("accuracy");
            }
            else{
                result = 1;
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public User getUser(String userID) {
        User result = null;

        String sql = "SELECT id, guild_id, guild_position, name, kron, shilling, point, strength, agility, endurance, accuracy FROM user WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = new User(
                        rs.getString("id"),
                        rs.getString("guild_id"),
                        rs.getInt("guild_position"),
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
            else{
                result = null;
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = null;
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = null;
        }

        return result;
    }
    //endregion

    //region 수정하기 함수들
    // - 기본
    public int updateUserGuildID(String userID, String guildID) {
        int result = -1;

        String sql = "UPDATE user SET guild_id = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guildID);
            pstmt.setString(2, userID);

            pstmt.executeUpdate();

            result = 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public int updateUserGuildPosition(String userID, int guildPosition) {
        int result = -1;

        String sql = "UPDATE user SET guild_position = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, guildPosition);
            pstmt.setString(2, userID);

            pstmt.executeUpdate();

            result = 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public int updateUserKron(String userID, int kron) {
        int result = -1;

        String sql = "UPDATE user SET kron = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, kron);
            pstmt.setString(2, userID);

            pstmt.executeUpdate();

            result = 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public int updateUserShilling(String userID, int shilling) {
        int result = -1;

        String sql = "UPDATE user SET shilling = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, shilling);
            pstmt.setString(2, userID);

            pstmt.executeUpdate();

            result = 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public int updateUserPoint(String userID, int point) {
        int result = -1;

        String sql = "UPDATE user SET point = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, point);
            pstmt.setString(2, userID);

            pstmt.executeUpdate();

            result = 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public int updateUserStrength(String userID, int strength) {
        int result = -1;

        String sql = "UPDATE user SET strength = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, strength);
            pstmt.setString(2, userID);

            pstmt.executeUpdate();

            result = 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public int updateUserAgility(String userID, int agility) {
        int result = -1;

        String sql = "UPDATE user SET agility = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, agility);
            pstmt.setString(2, userID);

            pstmt.executeUpdate();

            result = 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public int updateUserEndurance(String userID, int endurance) {
        int result = -1;

        String sql = "UPDATE user SET endurance = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, endurance);
            pstmt.setString(2, userID);

            pstmt.executeUpdate();

            result = 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public int updateUserAccuracy(String userID, int accuracy) {
        int result = -1;

        String sql = "UPDATE user SET accuracy = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, accuracy);
            pstmt.setString(2, userID);

            pstmt.executeUpdate();

            result = 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public int updateUser(User user) {
        int result = -1;

        String sql = "UPDATE user SET guild_id = ?, guild_position = ?, name = ?, kron = ?, shilling = ?, point = ?, strength = ?, agility = ?, endurance = ?, accuracy = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getGuildID());
            pstmt.setInt(2, user.getGuildPosition());
            pstmt.setString(3, user.getName());
            pstmt.setInt(4, user.getKron());
            pstmt.setInt(5, user.getShilling());
            pstmt.setInt(6, user.getPoint());
            pstmt.setInt(7, user.getStrength());
            pstmt.setInt(8, user.getAgility());
            pstmt.setInt(9, user.getEndurance());
            pstmt.setInt(10, user.getAccuracy());
            pstmt.setString(11, user.getId());

            pstmt.executeUpdate();

            result = 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }
    //endregion

    //region 생성 및 소멸하는 함수들
    // - 기본

    public int createUser(User user) {
        int result = -1;

        String sql = "INSERT INTO user (id, guild_id, guild_position, name, kron, shilling, point, strength, agility, endurance, accuracy) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getId());
            pstmt.setString(2, null);
            pstmt.setInt(3, 0);
            pstmt.setString(4, user.getName());
            pstmt.setInt(5, user.getKron());
            pstmt.setInt(6, user.getShilling());
            pstmt.setInt(7, user.getPoint());
            pstmt.setInt(8, user.getStrength());
            pstmt.setInt(9, user.getAgility());
            pstmt.setInt(10, user.getEndurance());
            pstmt.setInt(11, user.getAccuracy());

            pstmt.executeUpdate();

            result = 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }

    public int deleteUser(String userID) {
        int result = -1;

        String sql = "DELETE FROM user WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userID);

            pstmt.executeUpdate();

            result = 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = e.getErrorCode();
        }

        return result;
    }
    //endregion
}