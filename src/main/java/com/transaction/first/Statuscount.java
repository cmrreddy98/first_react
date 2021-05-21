package com.transaction.first;

public class Statuscount {
    String type;
    int count;

    public Statuscount(String type, int count) {
        this.type = type;
        this.count = count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
