package com.example.pengi.pokedex;

/**
 * Created by Pengi on 3/10/2016.
 */
public class Pokemon {
    private int id;
    private double height;
    private double weight;
    private String name;
    private String imageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        if (imageUrl == null)
            this.imageUrl = "http://assets.pokemon.com/assets/cms2/img/pokedex/full/"
                    + getFormattedId(id) + ".png";

        return imageUrl;
    }

    public void setImageUrl(String imageURL) {
        this.imageUrl = imageUrl;
    }

    public static String getFormattedId(int id) {
        String formattedId;

        if (id < 10)
            formattedId = "00" + id;
        else if (id < 100)
            formattedId = "0" + id;
        else
            formattedId = String.valueOf(id);

        return formattedId;
    }
}
