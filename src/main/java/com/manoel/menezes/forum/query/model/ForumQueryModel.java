package com.manoel.menezes.forum.query.model;

public final class ForumQueryModel {

    private final String name;

    private final String category;

    private final int threads;

    public ForumQueryModel(String name, String category, int threads) {
        this.name = name;
        this.category = category;
        this.threads = threads;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getThreads() {
        return threads;
    }


}