package com.K204110582.models;

public class ChatModel {
    private int id;
    private String message;
    private boolean isMe;

    public ChatModel() {
        this.id = id;
        this.message = message;
        this.isMe = isMe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isMe() {
        return isMe;
    }

    public void setMe(boolean me) {
        isMe = me;
    }
}
