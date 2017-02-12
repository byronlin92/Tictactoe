import java.util.Scanner;

public class Game {
	
	static Scanner scan;
	static Scanner scan2;
	static String[][] board;
	static int gameStatus = 0; //0 = playing, 1 = draw, 2 = player1 won, 3 = player2 won
	static int currentPlayer = 0; //0 = player1 , 1 = player2
	static String playerOneName;
	static String playerTwoName;
	static boolean playAgain = false;  // true= yes
	public static void initalizeBoard() {
		int k = 1;
		board = new String[3][3];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
					board[i][j]= Integer.toString(k);
					k++;
			}
		}
	}
	
	public static void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j ++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void playerMove(int currentPlayer) {
		boolean validInput = false;
		String seed; 
		
		if (currentPlayer==0) {
			seed = "X";
			System.out.print("Player one please pick a spot: ");
		} else {
			seed = "O";
			System.out.print("Player two please pick a spot: ");
		}
		
		do {
			int input = scan.nextInt();
			if (input >= 1 && input <=9) {
				if (input == 1  && board[0][0] != "X" && board[0][0] != "O") {
					board[0][0] = seed;
					validInput = true;
				} else if (input == 2  && board[0][1] != "X" && board[0][1] != "O") {
					board[0][1] = seed;
					validInput = true;
				} else if (input == 3  && board[0][2] != "X" && board[0][2] != "O") {
					board[0][2] = seed;
					validInput = true;
				} else if (input == 4  && board[1][0] != "X" && board[1][0] != "O") {
					board[1][0] = seed;
					validInput = true;
				} else if (input == 5  && board[1][1] != "X" && board[1][1] != "O") {
					board[1][1] = seed;
					validInput = true;
				} else if (input == 6  && board[1][2] != "X" && board[1][2] != "O") {
					board[1][2] = seed;
					validInput = true;
				} else if (input == 7  && board[2][0] != "X" && board[2][0] != "O") {
					board[2][0] = seed;
					validInput = true;
				} else if (input == 8  && board[2][1] != "X" && board[2][1] != "O") {
					board[2][1] = seed;
					validInput = true;
				} else if (input == 9  && board[2][2] != "X" && board[2][2] != "O") {
					board[2][2] = seed;
					validInput = true;
				}
				else {
					validInput = false;
					System.out.println("This move is invalid, please try again: ");
				}
			} else {
				validInput = false;
				System.out.println("This move is invalid, please try again: ");
			}
		} while (!validInput);
	}
	
	public static void checkBoard(int currentPlayer) {
		String seed;
		int playerWon;
		if (currentPlayer==0) {
			seed = "X";
			playerWon = 2;
		} else {
			seed = "O";
			playerWon = 3;
		}
		
		//check vertical
		if (board[0][0]==seed && board[0][1]==seed && board[0][2]==seed) {
			gameStatus=playerWon;
		} else if (board[1][0]==seed && board[1][1]==seed && board[1][2]==seed) {
			gameStatus=playerWon;
		} else if (board[2][0]==seed && board[2][1]==seed && board[2][2]==seed) {
			gameStatus=playerWon;
		//check horizontal 
		} else if (board[0][0]==seed && board[1][0]==seed && board[2][0]==seed) {
			gameStatus=playerWon;
		} else if (board[0][1]==seed && board[1][1]==seed && board[2][1]==seed) {
			gameStatus=playerWon;
		} else if (board[0][2]==seed && board[1][2]==seed && board[2][2]==seed) {
			gameStatus=playerWon;
		//check diagonal
		} else if (board[0][0]==seed && board[1][1]==seed && board[2][2]==seed) {
			gameStatus=playerWon;
		} else if (board[2][0]==seed && board[1][1]==seed && board[0][2]==seed) {
			gameStatus=playerWon;
		} 
	}

		
	public static boolean isDraw() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j ++) {
				if (board[i][j]!="X" && board[i][j]!="O") {
					return false;
				}
			}
		}
		gameStatus=1;
		return true;  // no empty cell, return true
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		scan2 = new Scanner(System.in);
		
		do {
			initalizeBoard();
			printBoard();
			do {
				playerMove(currentPlayer);
				checkBoard(currentPlayer);
				printBoard();
				
				
				//check board
				if (gameStatus==2) {
					System.out.println("Player 1 won!");
				} else if (gameStatus==1) {
					System.out.println("Player 2 won!");
				} else if (isDraw()) {
						System.out.println("Game is a draw!");
				}
				
				//Switch player
				if (currentPlayer == 0) { 
					currentPlayer = 1;
				} else {
					currentPlayer = 0;
				}
			} while (gameStatus==0);
			
			System.out.print("Play again? (y/n):");
			String ans = scan2.nextLine();
			if (!ans.equals("Y") && !ans.equals("y")) {
				playAgain = false;
				System.out.println("Good bye!");
				System.exit(0);  //terminate program
			} else {
				playAgain = true;
				gameStatus=0;
			}
			
			
		} while(playAgain);
	}
	
	
}
