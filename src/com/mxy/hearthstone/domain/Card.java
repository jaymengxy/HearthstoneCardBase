package com.mxy.hearthstone.domain;

/**
 * 卡牌属性
 * 名字 name String
 * 类型 type String
 * 品质 quality String
 * 消耗 costs int
 * 所属英雄 heroName String
 *
 */

public class Card {
    private String name;
    private String type;
    private String quality;
    private int costs;
    private String heroName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getCosts() {
        return costs;
    }

    public void setCosts(int costs) {
        this.costs = costs;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }
}
