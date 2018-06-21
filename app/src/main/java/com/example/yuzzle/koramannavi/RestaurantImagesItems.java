package com.example.yuzzle.koramannavi;

/**
 * Created by yuzzle on 2018/06/15.
 */

public class RestaurantImagesItems {
    private Integer restauranImage;
    private String imageName;

    public RestaurantImagesItems(Integer restauranImage, String imageName) {
        this.restauranImage = restauranImage;
        this.imageName = imageName;
    }

    public Integer getRestauranImage() {
        return restauranImage;
    }

    public String getImageName() {
        return imageName;
    }
}
