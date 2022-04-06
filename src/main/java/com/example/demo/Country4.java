package com.example.demo;

import java.util.ArrayList;


public class Country4{
    private int x;
    private int y;
    private int typeOfAnt;
    private int age;
    String loc;
    private long startTime;
    private long reproduceTime;
    private long deathTime;
    private ArrayList<Country4> temp = new ArrayList<>();
    public Country4(int x,int y){
        this.x = x;
        this.y = y;
        startTime = System.nanoTime();
        reproduceTime = System.nanoTime();
        deathTime = System.nanoTime();


    }
    public void changeLoc(int[][] gameGrid){

        //boolean check = false;
        //while(!check){
            int tempx = x;
            int tempy = y;
            if(Math.random()>.5){
                tempx++;
            }else {
                tempx--;
            }
            if(Math.random()>.5){
                tempy++;
            }else {
                tempy--;
            }
            if (tempx >= 0 && tempy >= 0 && tempx < Position.mapXsize && tempy < Position.mapYsize) {
                if (gameGrid[tempx][tempy] == 0 && gameGrid[tempx][tempy] != 2) {
                    //check = true;
                    gameGrid[tempx][tempy] = 5;
                    gameGrid[x][y] = 0;
                    x = tempx;
                    y = tempy;
                }
            }
        //}

//          System.out.println("x: " + x);

    }

    //this code can also be inside of the controller class if necessary.
    public boolean checkNeighbor(ArrayList<Country4> tempAnt,int tempGrid[][]){

        for (int i = 0;i<tempAnt.size();i++){
//                System.out.println(tempAnt.get(i).getX());
            if(tempAnt.get(i).getX() >=x-1 && tempAnt.get(i).getX()<=x+1 &&
                    tempAnt.get(i).getY() >=y-1 && tempAnt.get(i).getY()<=y+1 &&
                    tempAnt.get(i).getX()!=x && tempAnt.get(i).getY()!=y){
//                tempAnt.add(new Ant(7,8));
//                tempGrid[tempAnt.get(tempAnt.size()-1).getX()][tempAnt.get(tempAnt.size()-1).getY()]=1;
                return true;
            }
        }

        return false;
    }
    public boolean checkNeighborWater(ArrayList<Water> tempAnt,int tempGrid[][]){
//        System.out.println("hi");
        for (int i = 0;i<tempAnt.size();i++){
//                System.out.println(tempAnt.get(i).getX());
            if(tempAnt.get(i).getX() >=x-1 && tempAnt.get(i).getX()<=x+1 &&
                    tempAnt.get(i).getY() >=y-1 && tempAnt.get(i).getY()<=y+1 &&
                    tempAnt.get(i).getX()!=x && tempAnt.get(i).getY()!=y){
                return true;
            }
        }

        return false;
    }

    public int getX(){
        return this.x;
    }
    public void resetStartTime(){
        startTime = System.nanoTime();
    }
    public long getStartTime(){
        return startTime;
    }
    public long getReproduceTime() {
        return reproduceTime;
    }
    public void resetReproduceTime(){
        reproduceTime = System.nanoTime();
    }
    public int getY() {
        return this.y;
    }
    public long getDeathTime(){
        return deathTime;
    }
    public void resetDeathTime(){
        deathTime = System.nanoTime();
    }

	/*
	 * public void changeLoc(int[][] gameGrid) { }
	 */
}
