package Tests;

import static models.Cell.State.DEAD;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Cell;
import models.GameOfLife;
import models.golCell;
import models.golCells;


class GameOfLifeTest {


	
	
	@Test
	void setCellsBoard(){

//given 
		
		int row=4;
		int column=5;
		golCell[] cellBoard= new golCell [row*column];
		golCells cells = new golCells(column,row);
		Cell.State[] tabCells= new Cell.State[row*column];
		
		//tablica stanów i Cells
			for (int i=0;i<row;i++) {
				for (int j=0; j<column;j++) {
					if ((i+j)%2==0)
					tabCells[i*column+j]=Cell.State.ALIVE;
					else 
					tabCells[i*column+j]=Cell.State.DEAD;	
		}
			}

			for (int i=0;i<row;i++) {
				for (int j=0; j<column;j++) {
					cellBoard[i*column+j]= new golCell(j*cells.getCellSize(), i*cells.getCellSize(), cells.getCellSize(), DEAD);
					if ((j+i)%2==0)
						cellBoard[i*column+j].setState(Cell.State.ALIVE);
			            }
		}
		cells.setCellsBoard(cellBoard);
			
		////////////////////////////////////////////////////////////////
//when
		GameOfLife game= new GameOfLife(cells);
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
				golCell[] cellBoard= new golCell [row*column];
				golCells cells = new golCells(column,row);
				Cell.State[] tabCells= new Cell.State[row*column];
				
				//tablica stanów i Cells
					for (int i=0;i<row;i++) {
						for (int j=0; j<column;j++) {
							if ((i+j)%2==0)
							tabCells[i*column+j]=Cell.State.ALIVE;
							else 
							tabCells[i*column+j]=Cell.State.DEAD;	
				}
					}

					for (int i=0;i<row;i++) {
						for (int j=0; j<column;j++) {
							cellBoard[i*column+j]= new golCell(j*cells.getCellSize(), i*cells.getCellSize(), cells.getCellSize(), DEAD);
							if ((j+i)%2==0)
								cellBoard[i*column+j].setState(Cell.State.ALIVE);
					            }
				}
				cells.setCellsBoard(cellBoard);
					
				////////////////////////////////////////////////////////////////
		//when
				GameOfLife game= new GameOfLife(cells);
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
		golCell[] cellBoard= new golCell [row*column];
		golCells cells = new golCells(column,row);
		Cell.State[] tabCells= new Cell.State[row*column];

		
			for (int i=0;i<row;i++) {
				for (int j=0; j<column;j++) {
					if ((i+j)%2==0)
					tabCells[i*column+j]=Cell.State.ALIVE;
					else 
					tabCells[i*column+j]=Cell.State.DEAD;	
		}
			}

			for (int i=0;i<row;i++) {
				for (int j=0; j<column;j++) {
					cellBoard[i*column+j]= new golCell(j*cells.getCellSize(), i*cells.getCellSize(), cells.getCellSize(), DEAD);
					if ((j+i)%2==0)
						cellBoard[i*column+j].setState(Cell.State.ALIVE);
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
		GameOfLife game= new GameOfLife(cells);
		game.readStates(intStates);
		game.setCellsBoard(game.getCells().getCellsStates());
		
//then
		
		for (int i=0;i<row;i++) {
			for (int j=0; j<column;j++) {
				assertEquals(game.getCells().getCellsStates()[i*column+j], Cell.State.DEAD);
}}}

	/* NIE WIEM CZEMUNIE £APIE MI chechState()

		void countAliveNextCells(){
//given
			int row=3;
			int column=3;
			golCell[] cellBoard= new golCell [row*column];
			golCells cells = new golCells(column,row);
			Cell.State[] tabCells= new Cell.State[row*column];

			
				for (int i=0;i<row;i++) {
					for (int j=0; j<column;j++) {
						if ((i==1) && j==1)
						tabCells[i*column+j]=Cell.State.ALIVE;
						else 
						tabCells[i*column+j]=Cell.State.DEAD;	
			}
				}

				for (int i=0;i<row;i++) {
					for (int j=0; j<column;j++) {
						cellBoard[i*column+j]= new golCell(j*cells.getCellSize(), i*cells.getCellSize(), cells.getCellSize(), DEAD);
						if ((j+i)%2==0)
							cellBoard[i*column+j].setState(Cell.State.ALIVE);
				            }
			}
			cells.setCellsBoard(cellBoard);
			
//when
			GameOfLife game= new GameOfLife(cells);
			game.setCells(cells);
			game.countAliveNextCells();
			
			for (int i=0;i<row;i++) {
				for (int j=0; j<column;j++) {
					assertEquals(game.getCells().getCellsBoard()[i*column+j].checkState(), DEAD );
			
			
		}

}}
		}
*/

