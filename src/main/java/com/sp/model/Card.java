package com.sp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class Card implements OwnerUUID{

    private UUID uuid;
    @Getter
    private String name;
    @Getter
    private String description;
    @Getter
    @Setter
    private String imageUrl;
    @Getter
    @Setter
    private String family;
    @Getter
    @Setter
    private String affinity;
    @Getter
    @Setter
    private int hp;
    @Getter
    @Setter
    private int attack;
    @Getter
    @Setter
    private int defense;
    @Getter
    @Setter
    private int energy;
    public Card(){

    }

    public Card(String name, String description, String imageUrl, String family, String affinity, int hp, int attack, int defense, int energy) {
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

    @Override
    public String toString() {
        return "Card{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", family='" + family + '\'' +
                ", affinity='" + affinity + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", energy=" + energy +
                '}';
    }

    @Override
    public UUID getUUID() {
        return this.uuid;
    }

    @Override
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }
}
