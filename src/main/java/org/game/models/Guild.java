package org.game.models;

public class Guild {
    private String id;
    private String kingId;
    private String description;
    private String empireId;

    public Guild(String id, String kingId, String description, String empireId) {
        this.id = id;
        this.kingId = kingId;
        this.description = description;
        this.empireId = empireId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKingId() {
        return kingId;
    }

    public void setKingId(String kingId) {
        this.kingId = kingId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmpireId() {
        return empireId;
    }

    public void setEmpireId(String empireId) {
        this.empireId = empireId;
    }
}