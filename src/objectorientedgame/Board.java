package objectorientedgame;

public class Board {
	public static final int COLS = 3;
	public static final int ROWS  = 3;
	
	//package access
	Cell[][] cells;  //array of cell objects
	int currentRow, currentCol;  //current seed's row and column
	
	
	//initalize gameboard
	public Board() {
		cells = new Cell[ROWS][COLS];
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				cells[row][col] = new Cell(row, col);  //instantiate each cell in board
			}
		}
	}
	
	//initalize contents of board to empty
	public void init() { 
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				cells[row][col].clear();
			}
		}
	}
	
	public boolean isDraw() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				if (cells[row][col].content == Seed.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}
	
/*	
 * Return true if player with "theSeed" has won after placing at currentRow, currentCol
*/	
	public boolean hasWon(Seed theSeed) {
		return (cells[currentRow][0].content == theSeed   //3 in a row
				&& cells[currentRow][1].content == theSeed 
				&& cells[currentRow][2].content == theSeed 
			|| cells[0][currentCol].content == theSeed  //3 in a column
				&& cells[1][currentCol].content == theSeed
				&& cells[2][currentCol].content == theSeed
			|| cells[0][0].content == theSeed 					//diagonal
				&& cells[1][1].content == theSeed
				&& cells[2][2].content == theSeed
			|| cells[0][2].content == theSeed
			    && cells[1][1].content == theSeed
			    && cells[2][0].content == theSeed); 
	}
	
	public void paint() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				cells[row][col].paint();
				if (col < COLS) { System.out.print("|");
				}
			}
			System.out.println();
			if (row < ROWS) { System.out.println("-----------");
			}
		}
	}
		
		
	
}
