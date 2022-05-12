package single_responsibility;

import java.util.ArrayList;

public class Board {
    public ArrayList<String> spots;

    public Board() {
        this.spots = new ArrayList<String>();
        for (int i = 0; i < 9; i++) {
            this.spots.add(String.valueOf(i));
        }
    }

    public ArrayList<String> firstRow() {
    	return getRowbyRowNumber(0);
    }

    public ArrayList<String> secondRow() {
    	return getRowbyRowNumber(1);
    }

    public ArrayList<String> thirdRow() {
        return getRowbyRowNumber(2);
    }
    
    private ArrayList<String> getRowbyRowNumber(int rowNumber) {
    	ArrayList<String> row = new ArrayList<String>();
    	int cellsInROW = 3;
    	for(int i=0; i<cellsInROW; i++)
    		row.add(this.spots.get(i+cellsInROW*rowNumber));
    	return row;
    }

    public void display() {
        String formattedFirstRow = this.spots.get(0) + " | " + this.spots.get(1) + " | " + this.spots.get(2) + "\n" + this.spots.get(3) + " | " + this.spots.get(4) + " | " + this.spots.get(5) + "\n" + this.spots.get(6) + " | " + this.spots.get(7) + " | " + this.spots.get(8);
        System.out.print(formattedFirstRow);
    }
}
