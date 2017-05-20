package com.manoel.menezes.forum.query.model;

public final class ForumQueryModel {

    private final String name;

    private final String category;

    private final int threads;

    private final int messages;

    private final int views;

    public ForumQueryModel(String name, String category, int threads, int messages, int views) {
        this.name = name;
        this.category = category;
        this.threads = threads;
        this.messages = messages;
        this.views = views;
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

    public int getMessages() {
        return messages;
    }

    public int getViews() {
        return views;
    }
}