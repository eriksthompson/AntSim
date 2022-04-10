
package com.example.demo;

import java.util.ArrayList;



	

    public class Ant{
    	public static final int maxAnts = 12;
    	
    	// life span in nanoseconds
    	public static final long lifeSpan = (long) 15000000000.0;
    	
        private int x;
        private int y;
        private int typeOfAnt;
        private int age;
        String loc;
        
        // base
        public static Position antHill = new Position(0,0);
        
        private long startTime;
        private long reproduceTime;
        private long deathTime;
        public Ant(int x,int y){
            this.x = x;
            this.y = y;
            startTime = System.nanoTime();
            reproduceTime = System.nanoTime();
            // Death time = now + 15 seconds
            deathTime = System.nanoTime() + lifeSpan;


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
                if (tempx >= 0 && tempy >= 0 && tempx < 20 && tempy < 30) {
                    if (gameGrid[tempx][tempy] == 0 && gameGrid[tempx][tempy] != 2) {
                        //check = true;
                        gameGrid[tempx][tempy] = 8;
                        gameGrid[x][y] = 0;
                        x = tempx;
                        y = tempy;
                    }
                }
            //}

//          System.out.println("x: " + x);

        }
        
        public void moveToEnemyBase(int[][] gameGrid) {
        	// find nearest enemy
        	Position nearestEnemyB = findNearestEnemyB(gameGrid);
        	
        	//move towards enemyB
        	int tempx = x;
            int tempy = y;
            
            //direction to enemyB
            if(nearestEnemyB.x > tempx) {
            	tempx++;
            }
            else if(nearestEnemyB.y > tempy) {
            	tempy++;
            }
            else if(nearestEnemyB.x < tempx) {
            	tempx--;
            }
            else if(nearestEnemyB.y < tempy) {
            	tempy--;
            }
            
        	if (tempx >= 0 && tempy >= 0 && tempx < Position.mapXsize && tempy < Position.mapYsize) {
                if (gameGrid[tempx][tempy] == 0 ) {
                    //check = true;
                    gameGrid[tempx][tempy] = 8;
                    gameGrid[x][y] = 0;
                    x = tempx;
                    y = tempy;
                }else {
                	
                	changeLoc(gameGrid);
                }
            }
        }
        
        /**
         * 
         * @param gameGrid
         * @return Position vector of nearest enemy ant
         * 
         */
        public Position findNearestEnemyB(int[][]gameGrid) {
        	ArrayList<Position> enemyBases = new ArrayList<>();
        	enemyBases.add(Country2.antHill);
        	enemyBases.add(Country3.antHill);
        	enemyBases.add(Country4.antHill);
        	
        	double minDistance = 30;
        	Position base = enemyBases.get(0);
        	
        	//minimum distance
        	for(int i =0; i < enemyBases.size(); i++) {
        		// calculate distance 
        		double distance = Math.sqrt(Math.pow(Math.abs(enemyBases.get(i).x - this.x), 2) + Math.pow(Math.abs(enemyBases.get(i).y - this.y), 2));
        		
        		if((double) distance < minDistance) {
        			minDistance = distance;
        			base = enemyBases.get(i);
        		}
        	}
        	
        	return base;
        
        }
        
        //this code can also be inside of the controller class if necessary.
        public boolean checkNeighbor(ArrayList<Ant> tempAnt,int tempGrid[][]){

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
        public long getDeathTime(){
            return deathTime;
        }
        public void resetDeathTime(){
            deathTime = System.nanoTime();
        }
        public int getY() {
            return this.y;
        }
}