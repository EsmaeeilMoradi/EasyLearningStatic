package com.esmaeeil_moradi.easy_learning_static;

public class Pasta {
    private String name;
    private int imageResourceId;
    public static final Pasta[] pastas = {
            new Pasta("Spaghetti Bolognese", R.drawable.spaghetti_bolognese),
            new Pasta("Lasagne", R.drawable.lasagne)
    };

    public Pasta(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
