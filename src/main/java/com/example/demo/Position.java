package com.example.demo;

public class Position {
	public static final int mapXsize = 20;
	public static final int mapYsize = 30;
	
	
    int x,y;
    //xc - x coordinate yc - y coordinate
    public Position(int xc, int yc){
    	//Out of bounds check
    	if(xc < 0 ) {
    		xc = 0;
    	}
    	if(xc > mapXsize -1) {
    		xc = mapXsize - 1;
    	}
    	if(yc < 0 ) {
    		yc = 0;
    	}
    	if(yc > mapYsize -1 ) {
    		yc = mapYsize-1;
    	}
    	
        this.x = xc;
        this.y = yc;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    /**
     * @param xc x coordinate
     * @return true if value is in map boundaries for x coordinates
     */
    public boolean xInBounds(int xc) {
    	return xc >= 0 && xc < mapXsize;
    }
    
    /** @require caller check for null -> no spots available
     * @param yc y coordinate
     * @return true if value is in map boundaries for y coordinates
     */
    public boolean yInBounds(int yc) {
    	return yc >= 0 && yc < mapYsize;
    }
    
    // Positions for adjacent squares
    /**
     * Does not go out of bound of map
     * @return Position object with coordinates of empty spot around.
     */
    public Position getEmptyAroundMe() {
    	for(int i = this.x - 1; i < this.x + 1; i++ ) {
    		for (int j = this.y - 1; j < this.y + 1; j++) {
    			if(xInBounds(i) && yInBounds(j) && Controller.gameGrid[i][j] == 0 ) {
    				// i,j in bounds and empty
    				return new Position(i,j);
    			}
    		}
    	}
    	//Null means no spots available. Caller must check for null
    	return null;
	}
    /*
		 * public Position left() { return new Position(x-1, y); } public Position
		 * right() { return new Position(x+1, y); } public Position up() { return new
		 * Position(x, y-1); } public Position down() { return new Position(x, y+1); }
		 * public Position leftTop() { return new Position(x-1, y-1); } public Position
		 * rightTop() { return new Position(x+1, y-1); } public Position leftBottom() {
		 * return new Position(x-1, y+1); } public Position rightBottom() { return new
		 * Position(x+1, y+1); }
		 */
}
