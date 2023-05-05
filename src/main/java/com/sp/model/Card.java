package com.sp.model;

import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;
@Builder(toBuilder = true, setterPrefix = "with")
@Entity
public class Card implements OwnerUUID{

    public static final Card NULL_CARD = Card
            .builder()
            .withUuid(UUID.fromString("00000000-0000-0000-0000-000000000000"))
            .withName("404")
            .withDescription("404")
            .withImageUrl("https://ih1.redbubble.net/image.1198305180.8026/papergc,500x,w,f8f8f8-pad,750x1000,f8f8f8.jpg")
            .withFamily("404")
            .withAffinity("404")
            .withHp(0)
            .withAttack(0)
            .withDefense(0)
            .withEnergy(0)
            .build();

    @Id
    @GeneratedValue
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

    public Card(UUID uuid, String name, String description, String imageUrl, String family, String affinity, int hp, int attack, int defense, int energy) {
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
