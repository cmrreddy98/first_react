package com.transaction.first;

public class Merchant {
    private int success;
    private int failure;
    private int pending;
    private String name;

    public Merchant(int success, int failure, int pending, String name) {
        this.success = success;
        this.failure = failure;
        this.pending = pending;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getFailure() {
        return failure;
    }

    public void setFailure(int failure) {
        this.failure = failure;
    }

    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }
}
