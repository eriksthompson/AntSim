package com.example.demo;

public class Water {
    private int x;
    private int y;
    private int typeOfAnt;
    private int age;
    String loc;
    private long startTime;
    private long reproduceTime;
    public Water(int x, int y){
        this.x = x;
        this.y = y;
        startTime = System.nanoTime();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public long getStartTime() {
        return startTime;
    }
}
