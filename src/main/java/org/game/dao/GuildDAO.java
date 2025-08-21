package org.game.dao;

import org.game.database.DatabaseManager;
import org.game.models.Guild;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuildDAO {
    //region 가져오기 함수들
    // - 기본
    public String getGuildEmpireID(String guildID) {
        String result = null;

        String sql = "SELECT empire_id FROM guild WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guildID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("empire_id");
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

    public int getGuildEmpirePosition(String guildID) {
        int result = -1;

        String sql = "SELECT empire_position FROM user WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guildID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("empire_position");
            }
            else{
                result = -2;
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        }

        return result;
    }

    public String getGuildName(String guildID) {
        String result = null;

        String sql = "SELECT name FROM guild WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guildID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("name");
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

    public String getGuildDescription(String guildID) {
        String result = null;

        String sql = "SELECT description FROM guild WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guildID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("description");
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

    public Guild getGuild(String guildID) {
        Guild result = null;

        String sql = "SELECT id, empire_id, empire_position, name, description FROM guild WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guildID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Guild(
                        rs.getString("id"),
                        rs.getString("empire_id"),
                        rs.getInt("empire_position"),
                        rs.getString("name"),
                        rs.getString("description")
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

    // - 특수

    public List<String> getAllUserID(String guildID) {
        List<String> result = new ArrayList<>();

        String sql = "SELECT u.id FROM user AS u INNER JOIN guild AS g ON u.guild_id = g.id WHERE g.id = ? ORDER BY u.guild_position ASC";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guildID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.add(
                        rs.getString("id")
                );
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

        }

        return result;
    }

    public List<List<String>> getAllUserIDNNameNPosition(String guildID) {
        List<List<String>> result = new ArrayList<>();

        String sql = "SELECT u.id, u.name, u.guild_position FROM user AS u INNER JOIN guild AS g ON u.guild_id = g.id WHERE g.id = ? ORDER BY u.guild_position ASC";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guildID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.add(
                        List.of(
                                rs.getString("id"),
                                rs.getString("name"),
                                Integer.toString(rs.getInt("guild_position"))
                        )
                );
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();
        }

        return result;
    }

    public String getKingID(String guildID) {
        String result = null;

        String sql = "SELECT u.id FROM user AS u WHERE u.guild_id = ? AND u.guild_position = 1;";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guildID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("id");
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

    public List<List<String>> getAllManagerIDNName(String guildID) {
        List<List<String>> result = new ArrayList<>();

        String sql = "SELECT u.id, u.name FROM user AS u WHERE u.guild_id = ? AND u.guild_position = 2;";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guildID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.add(
                        List.of(
                                rs.getString("id"),
                                rs.getString("name")
                        )
                );
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();
        }

        return result;
    }

    public List<List<String>> getAllNobleIDNName(String guildID) {
        List<List<String>> result = new ArrayList<>();

        String sql = "SELECT u.id, u.name FROM user AS u WHERE u.guild_id = ? AND u.guild_position = 3;";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guildID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.add(
                        List.of(
                                rs.getString("id"),
                                rs.getString("name")
                        )
                );
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();
        }

        return result;
    }

    public List<String> getAllGuildID() {
        List<String> result = new ArrayList<>();

        String sql = "SELECT id FROM guild;";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.add(
                        rs.getString("id")
                );
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();
        }

        return result;
    }

    public int getGuildMemberCount(String guildID) {
        int result = -1;

        String sql = "SELECT COUNT(u.id) AS user_count FROM user AS u INNER JOIN guild AS g ON u.guild_id = g.id WHERE g.id = ?;";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guildID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("user_count");
            }
            else{
                result = -2;
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        }

        return result;
    }

    public String getGuildIDByName(String guildName) {
        String result = null;

        String sql = "SELECT id FROM guild WHERE name = ?;";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guildName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getString("id");
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

    public int isSameGuildName(String guildName) {
        int result = -1;

        String sql = "SELECT COUNT(*) AS same_guild_count FROM guild WHERE name = ?;";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guildName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("same_guild_count");
            }
            else{
                result = -2;
            }
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        }

        return result;
    }
    //endregion

    //region 수정하기 함수들
    // - 기본
    public int updateGuildEmpireID(String guildID, String empireID) {
        int result = -1;

        String sql = "UPDATE guild SET empire_id = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empireID);
            pstmt.setString(2, guildID);

            pstmt.executeUpdate();

            return 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        }

        return result;
    }

    public int updateGuildEmpirePosition(String guildID, String empirePosition) {
        int result = -1;

        String sql = "UPDATE guild SET empire_position = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empirePosition);
            pstmt.setString(2, guildID);

            pstmt.executeUpdate();

            return 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        }

        return result;
    }

    public int updateGuildName(String guildID, String name) {
        int result = -1;

        String sql = "UPDATE guild SET name = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, guildID);

            pstmt.executeUpdate();

            return 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        }

        return result;
    }

    public int updateGuildDescription(String guildID, String description) {
        int result = -1;

        String sql = "UPDATE guild SET description = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, description);
            pstmt.setString(2, guildID);

            pstmt.executeUpdate();

            return 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        }

        return result;
    }

    public int updateGuild(Guild guild) {
        int result = -1;

        String sql = "UPDATE guild SET empire_id = ?, empire_position = ?, name = ?, description = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guild.getEmpireId());
            pstmt.setInt(2, guild.getEmpirePosition());
            pstmt.setString(3, guild.getName());
            pstmt.setString(4, guild.getDescription());
            pstmt.setString(5, guild.getId());

            pstmt.executeUpdate();

            return 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        }

        return result;
    }

    // - 특수


    //endregion

    //region 생성 및 소멸 함수들
    // - 기본
    public int createGuild(Guild guild) {
        int result = -1;

        String sql = "INSERT INTO guild (id, empire_id, empire_position, name, description) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guild.getId());
            pstmt.setString(2, guild.getEmpireId());
            pstmt.setInt(3, guild.getEmpirePosition());
            pstmt.setString(4, guild.getName());
            pstmt.setString(5, guild.getDescription());

            pstmt.executeUpdate();

            return 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        }

        return result;
    }

    public int deleteGuild(String guildID) {
        int result = -1;

        String sql = "UPDATE user SET guild_id = NULL, guild_position = 0 WHERE guild_id = ?;DELETE FROM guild WHERE id = ?;";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guildID);
            pstmt.setString(2, guildID);

            pstmt.executeUpdate();

            return 0;
        } catch (SQLSyntaxErrorException e) {
            System.err.println("SQL 쿼리 문법이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        } catch (SQLException e) {
            System.err.println("데이터베이스 오류가 발생했습니다.");
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Code: " + e.getErrorCode());
            e.printStackTrace();

            result = -1*e.getErrorCode();
        }

        return result;
    }
    //endregion
}