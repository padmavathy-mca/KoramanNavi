package com.example.yuzzle.koramannavi;


/**
 * Created by yuzzle on 2018/05/30.
 */

public class Restaurants {

//    @SerializedName("appearance")
    private Integer appearance;
//    @SerializedName("name")
    private String name;
//    @SerializedName("minprice")
    private int minprice;
//    @SerializedName("maxprice")
    private int maxprice;
//    @SerializedName("type")
    private String kind;
//    @SerializedName("meat")
    private Integer meatAvailable;
//    @SerializedName("alcohol")
    private Integer alcoholAvailable;
//    @SerializedName("creditcard")
    private Integer creditAvailable;
    private Integer mapMarkerLink;

    public Restaurants(Integer appearance, String name, String kind, int minprice, int maxprice, Integer meat, Integer alcohol, Integer credit, Integer marker) {
        this.appearance = appearance;
        this.name = name;
        this.kind = kind;
        this.minprice = minprice;
        this.maxprice = maxprice;
        meatAvailable = meat;
        alcoholAvailable = alcohol;
        creditAvailable = credit;
        mapMarkerLink = marker;
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

    public int getMinprice() {
        return minprice;
    }

    public int getMaxprice() {
        return maxprice;
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

    public Integer getMapMarkerLink() {
        return mapMarkerLink;
    }
}
