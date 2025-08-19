package org.game;

import org.bukkit.plugin.java.JavaPlugin;
import org.game.database.DatabaseManager;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        DatabaseManager.initialize();

        getLogger().info("KronDatabaseAPI 플러그인이 활성화되었습니다!");
    }

    @Override
    public void onDisable() {
        DatabaseManager.shutdown();

        getLogger().info("KronDatabaseAPI 플러그인이 비활성화되었습니다.");
    }
}