package connectfour;
import java.util.Random;
import java.util.Scanner;

public class ConnectFour {
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		boolean winner = false;
		int turn = 1; //first turn
		
		//---------2d array---------
		char[][] grid = new char[6][7];
		
		//---------initialise 2d array with empty chars---------
		for (int row = 0; row < grid.length; row++){
			for (int col = 0; col < grid[0].length; col++){
				grid[row][col] = ' ';
			}
		}

		//---------player instructions---------
		System.out.println("-Connect Four-" + "\n" + "Welcome Player!" + "\n" + "Game instructions:" + "\n" +"1. Enter a column to enter your position." + "\n" + "2. Be the first to create any line of 4, horizontal, vertical, or diagonal to win!");
		//---------print empty grid---------
		printGrid(grid);
		
		//---------play---------
		while(winner == false && turn <= 42) {
			
			System.out.println("Enter column (0-6):");
			int playerPos = sc.nextInt();
			
			dropDisc(grid, playerPos, "Player");
			
			Random r = new Random();
			int cPos = r.nextInt(12) + 1;
			dropDisc(grid, cPos, "Computer");

			printGrid(grid);
			
			
		}
		
		//winner = winner(player, grid);
		printGrid(grid);
	}//end of method
	
	public static void printGrid(char[][] grid) {
		System.out.println(" 0 1 2 3 4 5 6");
		System.out.println("---------------");
		for (int row = 0; row < grid.length; row++){
			System.out.print("|");
			for (int col = 0; col < grid[0].length; col++) {
				System.out.print(grid[row][col]);
				System.out.print("|");
			}
			System.out.println();
			System.out.println("+-+-+-+-+-+-+-+");
		}
		System.out.println(" 0 1 2 3 4 5 6");
		System.out.println();
	} // end of method
	
	public static void dropDisc(char[][] grid, int pos, String user) {
		boolean winner = true;
		char character = ' ';
		if (user.equals("Player")) {
			character = 'R';
		}
		else if (user.equals("Computer")) {
			character = 'Y';
		}
		
		while(winner == false) {
				for (int row = grid.length-1; row >= 0; row--) {
				if(grid[row][pos] == ' '){
					grid[row][pos] = character;
					break;
				}
			}
		}
	}// end of method
	
	//method to validate
	public static boolean validate(int col, char[][] grid){
		//valid column?
		if (col < 0 || col > grid[0].length){
			return false;
		}
		
		//full column?
		if (grid[0][col] != ' '){
			return false;
		}
		
		return true;
	}//end of method
	
	//method to confirm winner
	public static boolean winner(char player, char[][] grid){
		//vertical
		for(int row = 0; row < grid.length - 3; row++){
			for(int col = 0; col < grid[0].length; col++){
				if (grid[row][col] == player   && 
					grid[row+1][col] == player &&
					grid[row+2][col] == player &&
					grid[row+3][col] == player){
					return true;
				}
			}
		}
		//horizontal
		for(int row = 0; row<grid.length; row++){
			for (int col = 0;col < grid[0].length - 3;col++){
				if (grid[row][col] == player   && 
					grid[row][col+1] == player &&
					grid[row][col+2] == player &&
					grid[row][col+3] == player){
					return true;
				}
			}			
		}
		//upward diagonal
		for(int row = 3; row < grid.length; row++){
			for(int col = 0; col < grid[0].length - 3; col++){
				if (grid[row][col] == player   && 
					grid[row-1][col+1] == player &&
					grid[row-2][col+2] == player &&
					grid[row-3][col+3] == player){
					return true;
				}
			}
		}
		//downward diagonal
		for(int row = 0; row < grid.length - 3; row++){
			for(int col = 0; col < grid[0].length - 3; col++){
				if (grid[row][col] == player   && 
					grid[row+1][col+1] == player &&
					grid[row+2][col+2] == player &&
					grid[row+3][col+3] == player){
					return true;
				}
			}
		}
		return false;
	}
	
}//end of class

