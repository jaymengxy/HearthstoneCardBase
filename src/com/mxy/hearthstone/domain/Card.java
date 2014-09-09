package com.mxy.hearthstone.domain;

/**
 * 卡牌属性
 * 名字 cardName String
 * 类型 cardType String
 * 品质 quality String
 * 消耗 cost int
 * 所属英雄 heroName String  ---数据库中class列
 * 卡牌效果 cardEffect String
 * 卡牌描述 description String
 * 卡牌图片名 picName String ---数据库中code列
 */

public class Card {
    private String cardName;
    private String cardType;
    private String quality;
    private int cost;
    private String heroName;
    private String cardEffect;
    private String description;
    private String picName;

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getCardEffect() {
        return cardEffect;
    }

    public void setCardEffect(String cardEffect) {
        this.cardEffect = cardEffect;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }
}
