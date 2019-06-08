package Tests;

import static models.Cell.State.DEAD;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Cell;
import models.WireWorld;
import models.WwCell;
import models.WwCells;

class WireWorldTest {

	
	
	@Test
	void setCellsBoard(){

//given 
		
		int row=4;
		int column=5;
		WwCell[] cellBoard= new WwCell [row*column];
		WwCells cells = new WwCells(column,row);
		Cell.State[] tabCells= new Cell.State[row*column];
		
		//tablica stanów i Cells
		
			for (int i=0;i<row;i++) {
				for (int j=0; j<column;j++) {
					if ((i+j)%2==0)
					tabCells[i*column+j]=Cell.State.EMPTY;
					else if ((i+j)%2==1)
					tabCells[i*column+j]=Cell.State.TAIL;
					else if ((i+j)%2==2)
						tabCells[i*column+j]=Cell.State.HEAD;
					else 
						tabCells[i*column+j]=Cell.State.CONDUCTOR;
		}
			}

			for (int i=0;i<row;i++) {
				for (int j=0; j<column;j++) {
					cellBoard[i*column+j]= new WwCell(j*cells.getCellSize(), i*cells.getCellSize(), cells.getCellSize(), Cell.State.EMPTY);
					if ((j+i)%2==0)
						cellBoard[i*column+j].setState(Cell.State.EMPTY);
					else if ((i+j)%2==1)
						cellBoard[i*column+j].setState(Cell.State.TAIL);
					else if ((i+j)%2==2)
						cellBoard[i*column+j].setState(Cell.State.HEAD);
					else 
						cellBoard[i*column+j].setState(Cell.State.CONDUCTOR);
			            }
		}
		cells.setCellsBoard(cellBoard);
			
		////////////////////////////////////////////////////////////////
//when
		WireWorld game= new WireWorld(cells);
		game.setCellsBoard(tabCells);

		
		
//then

			for (int i=0;i<row;i++) {
				for (int j=0; j<column;j++) {
				assertEquals(game.getCells().getCellsBoard(i*column+j).getState(), tabCells[i*column+j]);
				}
}
}
	
	void setCells(){

		//given 
				
				int row=4;
				int column=5;
				WwCell[] cellBoard= new WwCell [row*column];
				WwCells cells = new WwCells(column,row);
				Cell.State[] tabCells= new Cell.State[row*column];
				
				//tablica stanów i Cells
					for (int i=0;i<row;i++) {
						for (int j=0; j<column;j++) {
							if ((i+j)%2==0)
								tabCells[i*column+j]=Cell.State.EMPTY;
								else if ((i+j)%2==1)
								tabCells[i*column+j]=Cell.State.TAIL;
								else if ((i+j)%2==2)
									tabCells[i*column+j]=Cell.State.HEAD;
								else 
									tabCells[i*column+j]=Cell.State.CONDUCTOR;
				}
					}

					for (int i=0;i<row;i++) {
						for (int j=0; j<column;j++) {
							cellBoard[i*column+j]= new WwCell(j*cells.getCellSize(), i*cells.getCellSize(), cells.getCellSize(), Cell.State.HEAD);
							if ((j+i)%2==0)
								cellBoard[i*column+j].setState(Cell.State.EMPTY);
							else if ((i+j)%2==1)
								cellBoard[i*column+j].setState(Cell.State.TAIL);
							else if ((i+j)%2==2)
								cellBoard[i*column+j].setState(Cell.State.HEAD);
							else 
								cellBoard[i*column+j].setState(Cell.State.CONDUCTOR);
						}
					}
				cells.setCellsBoard(cellBoard);
					
				////////////////////////////////////////////////////////////////
		//when
				WireWorld game= new WireWorld(cells);
				game.setCells(cells);
				
				
		//then

					for (int i=0;i<row;i++) {
						for (int j=0; j<column;j++) {
						assertEquals(game.getCells().getCellsBoard(i*column+j).getState(), cells.getCellsBoard(i*column+j).getState());
						}
						}
					}



@Test
	void readStates(){
//given
	int row=4;
	int column=5;
	WwCell[] cellBoard= new WwCell [row*column];
	WwCells cells = new WwCells(column,row);
	Cell.State[] tabCells= new Cell.State[row*column];
	
	//tablica stanów i Cells
		for (int i=0;i<row;i++) {
			for (int j=0; j<column;j++) {
				if ((i+j)%2==0)
					tabCells[i*column+j]=Cell.State.EMPTY;
					else if ((i+j)%2==1)
					tabCells[i*column+j]=Cell.State.TAIL;
					else if ((i+j)%2==2)
						tabCells[i*column+j]=Cell.State.HEAD;
					else 
						tabCells[i*column+j]=Cell.State.CONDUCTOR;
	}
		}

		for (int i=0;i<row;i++) {
			for (int j=0; j<column;j++) {
				cellBoard[i*column+j]= new WwCell(j*cells.getCellSize(), i*cells.getCellSize(), cells.getCellSize(), Cell.State.HEAD);
				if ((j+i)%2==0)
					cellBoard[i*column+j].setState(Cell.State.EMPTY);
				else if ((i+j)%2==1)
					cellBoard[i*column+j].setState(Cell.State.TAIL);
				else if ((i+j)%2==2)
					cellBoard[i*column+j].setState(Cell.State.HEAD);
				else 
					cellBoard[i*column+j].setState(Cell.State.CONDUCTOR);
			}
		}
	cells.setCellsBoard(cellBoard);
		
			
		int[] intStates=new int[row*column];
		
		for (int i=0;i<row;i++) {
			for (int j=0; j<column;j++) {
				intStates[i*column+j]=0;
				}
			}

//when
		WireWorld game= new WireWorld(cells);
		game.readStates(intStates);
		game.setCellsBoard(game.getCells().getCellsStates());
		
//then
		
		for (int i=0;i<row;i++) {
			for (int j=0; j<column;j++) {
				assertEquals(game.getCells().getCellsStates()[i*column+j], Cell.State.EMPTY);
}}}



@Test
public void checkHeadNext() {
	
	
	
	
	
	
}
}

