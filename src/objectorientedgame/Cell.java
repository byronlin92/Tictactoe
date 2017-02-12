package objectorientedgame;


/*
* The cell class models the individual cells in a game board
*/
public class Cell {
	//package access
	Seed content;  //content of this cell of type Seed
				   //take value of Seed.EMPTY, Seed.Cross, or Seed.Naught
	
	int row, col; //row and column of a cell, not used in this program
	
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		clear();
	}
	
	/*Set cell to Seed.EMPTY*/
	public void clear() {
		content = Seed.EMPTY;
	}
	
	//print each cell depending if it is empty, X or O
	public void paint() {
		switch (content) {
			case CROSS: System.out.print(" X "); break;
			case NOUGHT: System.out.print(" O "); break;
			case EMPTY: System.out.print("  "); break;
		}
	}
	
}
