package com.sp.model;

public class AbstractCard{

    private String name;
    private String description;
    private String imageUrl;
    private String family;
    private String affinity;
    private int hp;
    private int attack;
    private int defense;
    private int energy;
    public AbstractCard(){

    }

    public AbstractCard(String name, String description, String imageUrl, String family, String affinity, int hp, int attack, int defense, int energy) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.family = family;
        this.affinity = affinity;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.energy = energy;
    }

    public String toString() {
        return "AbstractCard{name='" + this.name + '\'' + ", description='" + this.description + '\'' + ", imageUrl='" + this.imageUrl + '\'' + ", family='" + this.family + '\'' + ", affinity='" + this.affinity + '\'' + ", hp=" + this.hp + ", attack=" + this.attack + ", defense=" + this.defense + ", energy=" + this.energy + '}';
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFamily() {
        return this.family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getAffinity() {
        return this.affinity;
    }

    public void setAffinity(String affinity) {
        this.affinity = affinity;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getEnergy() {
        return this.energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
