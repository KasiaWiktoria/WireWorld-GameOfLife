package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Cell;
import models.golCell;
import models.golCells;

class golCellsTest {

	@Test 
	void setRows() {
		//given 
		int row = 10;
		golCells cells = new golCells(3,4);
		
		//when
		cells.setRows(row);
		
		//then
	    assertEquals(row, cells.getRows(),0);
		
	}
	
	@Test 
	void setColumns() {
		//given 
		int column = 25;
		golCells cells = new golCells(3,4);
		
		//when
		cells.setColumns(column);
		
		//then
	    assertEquals(column, cells.getColumns(),0);
	    }
	
	
	@Test 
	void setCellSize() {
		//given 
		double size = 24;
		golCells cells = new golCells(3,4);
		
		//when
		cells.setCellSize(size);
		
		//then
	    assertEquals(size, cells.getCellSize(),0);
	    }
	
	
	@Test 
	void setCellsStates() {
		//given 
		int row=4,column=5;
		int num =column*row;
		golCells cells = new golCells(row,column);
		Cell.State tab[]= new Cell.State[num];
		
		for (int i=0;i<row;i++) {
			for (int j=0; j<column;j++)
				if ((i+j)%2==0)
				tab[i*column+j]=Cell.State.ALIVE;
		}
		
	
		//whenX
		cells.setCellsStates(tab);
		
		//thenX
	    for(int i=0;i<row;i++) {
			for (int j=0; j<column;j++)
				assertEquals(tab[i*column+j], cells.getCellsStates()[i*column+j]);
	    }    
	}
	
	
	
	@Test 
	void setNumberOfCells() {
		//given 
		int num =10;
		golCells cells = new golCells(3,4);
		
		//when
		cells.setNumberOfCells(num);
		
		//then
	    assertEquals(cells.getNumberOfCells(),num,0);
	    }
	
	
	@Test 
	void setCellsBoard() {
		//given 
		int row=4,column=5;
		int num =column*row;
		golCells cells = new golCells(row,column);
		golCell tab[]= new golCell[num];
		Cell.State state=Cell.State.ALIVE;
		
		for (int i=0;i<row;i++) {
			for (int j=0; j<column;j++) {
				if ((i+j)%2==0) 
					state=Cell.State.ALIVE;
					else
						state=Cell.State.DEAD;
				tab[i*column+j]=new golCell (column,row,cells.getCellSize(),state);}
		}
			
		
		//when
		cells.setCellsBoard(tab);
		
		//then

	    for(int i=0;i<row;i++) {
			for (int j=0; j<column;j++)
				assertEquals(tab[i*column+j], cells.getCellsBoard(i*column+j));
	    }    
	    }
	
	
}


