package org.game.models;

public class Guild {
    private String id;
    private String empireId;
    private int empirePosition;
    private String name;
    private String description;

    public Guild(
            String id,
            String empireId,
            int empirePosition,
            String name,
            String description) {
        this.id = id;
        this.empireId = empireId;
        this.empirePosition = empirePosition;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpireId() {
        return empireId;
    }

    public void setEmpireId(String empireId) {
        this.empireId = empireId;
    }

    public int getEmpirePosition() {
        return empirePosition;
    }

    public void setEmpirePosition(int empirePosition) {
        this.empirePosition = empirePosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}