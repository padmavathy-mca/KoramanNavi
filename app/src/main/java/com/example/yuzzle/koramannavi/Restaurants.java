package com.example.yuzzle.koramannavi;

/**
 * Created by yuzzle on 2018/05/30.
 */

public class Restaurants {

    private Integer appearance;
    private String name;
    private String kind;
    private String range;
    private String recommend;
    private Integer meatAvailable;
    private Integer alcoholAvailable;
    private Integer creditAvailable;

    public Restaurants(Integer appearance, String name, String kind, String range, String recommend, Integer meat, Integer alcohol, Integer credit) {
        this.appearance = appearance;
        this.name = name;
        this.kind = kind;
        this.range = range;
        this.recommend = recommend;
        meatAvailable = meat;
        alcoholAvailable = alcohol;
        creditAvailable = credit;
    }

    public Integer getAppearance() {
        return appearance;
    }

    public String getName() {
        return name;
    }

    public String getKind() {
        return kind;
    }

    public String getRange() {
        return range;
    }

    public String getRecommend() {
        return recommend;
    }

    public Integer getMeatAvailable() {
        return meatAvailable;
    }

    public Integer getAlcoholAvailable() {
        return alcoholAvailable;
    }

    public Integer getCreditAvailable() {
        return creditAvailable;
    }
}
