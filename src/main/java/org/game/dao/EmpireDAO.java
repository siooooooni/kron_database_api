package org.game.dao;

import org.game.database.DatabaseManager;
import org.game.models.Empire;

import java.sql.*;
import java.util.List;

public class EmpireDAO {
    //region 가져오기 함수들
    // - 기본
    public String getEmpireName(String empireID) {
        String result = null;

        String sql = "SELECT name FROM empire WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empireID);
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

    public String getEmpireDescription(String empireID) {
        String result = null;

        String sql = "SELECT description FROM empire WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empireID);
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

    public String getHoldingGuildID(String guildID) {
        String result = null;

        String sql = "SELECT g.id FROM guild AS g WHERE g.empire_id = ? AND g.empire_position = 1;";
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

    public List<String> getVassalGuildIDs(String guildID) {
        List<String> result = null;

        String sql = "SELECT g.id FROM guild AS g WHERE g.empire_id = ? AND g.empire_position = 2;";
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
    //endregion

    //region 수정하기 함수들
    // - 수정

    public int updateEmpireName(String empireID, String name) {
        int result = -1;

        String sql = "UPDATE empire SET name = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, empireID);

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

    public int updateEmpireDescription(String empireID, String description) {
        int result = -1;

        String sql = "UPDATE empire SET description = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, description);
            pstmt.setString(2, empireID);

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

    public int updateEmpire(Empire empire) {
        int result = -1;

        String sql = "UPDATE empire SET name = ?, description = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empire.getName());
            pstmt.setString(2, empire.getDescription());
            pstmt.setString(3, empire.getId());

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

    //region 생성 및 소멸 함수들
    // - 기본
    public int createEmpire(Empire empire) {
        int result = -1;

        String sql = "INSERT INTO empire (id, name, description) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empire.getId());
            pstmt.setString(2, empire.getName());
            pstmt.setString(3, empire.getDescription());

            pstmt.executeUpdate();

            return 0;
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

    public int deleteEmpire(String id) {
        int result = -1;

        String sql = "DELETE FROM empire WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);

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