package org.game.models;

public class User {
    private String id;
    private String guildID;
    private int guildPosition;
    private String name;
    private int kron;
    private int shilling;
    private int point;
    private int strength;
    private int agility;
    private int endurance;
    private int accuracy;

    public User(
            String id,
            String guildID,
            int guildPosition,
            String name,
            int kron,
            int shilling,
            int point,
            int strength,
            int agility,
            int endurance,
            int accuracy
    ) {
        this.id = id;
        this.guildID = guildID;
        this.guildPosition = guildPosition;
        this.name = name;
        this.kron = kron;
        this.shilling = shilling;
        this.point = point;
        this.strength = strength;
        this.agility = agility;
        this.endurance = endurance;
        this.accuracy = accuracy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuildID() {
        return guildID;
    }

    public void setGuildID(String guildID) {
        this.guildID = guildID;
    }

    public int getGuildPosition() {
        return guildPosition;
    }

    public void setGuildPosition(int guildPosition) {
        this.guildPosition = guildPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKron() {
        return kron;
    }

    public void setKron(int kron) {
        this.kron = kron;
    }

    public int getShilling() {
        return shilling;
    }

    public void setShilling(int shilling) {
        this.shilling = shilling;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
}