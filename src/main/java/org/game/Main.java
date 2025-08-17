package org.game;

import org.bukkit.plugin.java.JavaPlugin;
import org.game.database.DatabaseManager;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        DatabaseManager.initialize();
    }

    @Override
    public void onDisable() {
        DatabaseManager.shutdown();
    }
}