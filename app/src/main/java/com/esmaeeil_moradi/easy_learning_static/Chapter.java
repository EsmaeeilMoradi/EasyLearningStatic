package com.esmaeeil_moradi.easy_learning_static;

public class Chapter {
    private String name;
    private int imageResourceId;

    public static final Chapter[] chapters = {
            new Chapter("contents", R.drawable.contents),
            new Chapter("chapter1", R.drawable.chapter1),
            new Chapter("chapter2", R.drawable.chapter2),
            new Chapter("chapter3", R.drawable.chapter3),
            new Chapter("chapter4", R.drawable.chapter4),
            new Chapter("chapter5", R.drawable.chapter5),
            new Chapter("chapter6", R.drawable.chapter6),
            new Chapter("chapter7", R.drawable.chapter7),
            new Chapter("chapter8", R.drawable.chapter8),
            new Chapter("chapter9", R.drawable.chapter9),
            new Chapter("chapter10", R.drawable.chapter10)
    };

    public Chapter(String name, int imageResourceId) {
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
