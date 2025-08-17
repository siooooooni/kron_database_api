package org.game.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static HikariDataSource dataSource;

    // 플러그인 시작 시 연결 풀을 초기화하는 메서드
    public static void initialize() {
        if (dataSource != null) {
            return;
        }

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/mydb"); // 데이터베이스 URL
        config.setUsername("root"); // 데이터베이스 사용자명
        config.setPassword("sioning#0611"); // 데이터베이스 비밀번호

        // 연결 풀 설정 (최적의 설정은 환경에 따라 다름)
        config.setMaximumPoolSize(10); // 최대 연결 수
        config.setMinimumIdle(5); // 최소 유휴(idle) 연결 수
        config.setConnectionTimeout(30000); // 연결 타임아웃 (30초)
        config.setIdleTimeout(600000); // 유휴 연결 타임아웃 (10분)
        config.setMaxLifetime(1800000); // 연결 최대 수명 (30분)

        dataSource = new HikariDataSource(config);
    }

    // 연결 풀에서 연결을 빌려오는 메서드
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // 플러그인 종료 시 연결 풀을 닫는 메서드
    public static void shutdown() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}