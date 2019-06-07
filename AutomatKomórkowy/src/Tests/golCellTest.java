package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Cell;
import models.golCell;
import models.Cell.State;

class golCellTest {


    @Test
    public void setX() {
        //given
    	golCell cell= new golCell(3, 4, 10, Cell.State.ALIVE);
    	double expVal=5;
    	
        //when
    	cell.setX(5);
    	
        //then
        assertEquals(expVal, cell.getX(),0);
    }
    
    
    
    @Test
    public void setY() {
        //given
    	golCell cell= new golCell(3, 4, 10, Cell.State.ALIVE);
    	double expVal=5;
    	
        //when
    	cell.setY(5);
    	

        //then
        assertEquals(expVal, cell.getY(),0);
    }
    
 
   
    
    @Test
    public void setSize() { 
    	//given
    	double size =20;
    	golCell cell= new golCell(3, 4, 10, Cell.State.ALIVE);

    	
        //when
    	cell.setSize(size);
    	

        //then
        assertEquals(cell.getSize(), size,0);

    }
    

    
    @Test
    public void setState() { 
    	//given
    	State state= Cell.State.ALIVE;
    	golCell cell= new golCell(3, 4, 10, Cell.State.ALIVE);

    	
    	//when
    	cell.setState(state);
    	
    	//then
    	assertEquals(cell.getState(),state);
    	
}

}
