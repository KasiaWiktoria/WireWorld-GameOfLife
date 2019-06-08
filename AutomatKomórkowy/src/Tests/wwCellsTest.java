package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Cell;
import models.WwCell;
import models.WwCells;

class wwCellsTest {

	@Test 
	void setRows() {
		//given 
		int row = 10;
		WwCells cells = new WwCells(3,4);
		
		//when
		cells.setRows(row);
		
		//then
	    assertEquals(row, cells.getRows(),0);
		
	}
	
	@Test 
	void setColumns() {
		//given 
		int column = 25;
		WwCells cells = new WwCells(3,4);
		
		//when
		cells.setColumns(column);
		
		//then
	    assertEquals(column, cells.getColumns(),0);
	    }
	
	
	@Test 
	void setCellSize() {
		//given 
		double size = 24;
		WwCells cells = new WwCells(3,4);
		
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
		WwCells cells = new WwCells(row,column);
		Cell.State tab[]= new Cell.State[num];
		
		for (int i=0;i<row;i++) {
			for (int j=0; j<column;j++)
				if ((i+j)%2==0)
				tab[i*column+j]=Cell.State.HEAD;
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
		WwCells cells = new WwCells(3,4);
		
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
		WwCells cells = new WwCells(row,column);
		WwCell tab[]= new WwCell[num];
		Cell.State state=Cell.State.EMPTY;
		
		for (int i=0;i<row;i++) {
			for (int j=0; j<column;j++) {
				if ((i+j)%4==0) 
					state=Cell.State.EMPTY;
				else if ((i+j)%4==1) 
					state=Cell.State.HEAD;
				else if ((i+j)%4==0) 
					state=Cell.State.TAIL;
					else
						state=Cell.State.CONDUCTOR;
				tab[i*column+j]=new WwCell (column,row,cells.getCellSize(),state);}
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
