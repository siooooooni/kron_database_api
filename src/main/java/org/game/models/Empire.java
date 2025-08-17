package org.game.models;

public class Empire {
    private String id;
    private String imperialGuildId;
    private String description;

    public Empire(String id, String imperialGuildId, String description) {
        this.id = id;
        this.imperialGuildId = imperialGuildId;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImperialGuildId() {
        return imperialGuildId;
    }

    public void setImperialGuildId(String imperialGuildId) {
        this.imperialGuildId = imperialGuildId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}