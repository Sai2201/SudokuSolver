package sudokuSolver;

/**
 * Utility class solving the sudoku puzzle using backtracking
 * 
 * @author siyengar
 */
public class SolverUtil {

	private final static int EMPTY = 0;
	
	private final static int SIZE = 9;
	
	private int[][] board;
	
	public SolverUtil ( int[][] puzzle ) {
		this.board = puzzle;
	}
	

	/**
	 * Sudoku puzzle solver function
	 */
	public boolean solve() {
		for ( int row = 0;row < SIZE; row++ ) {
			for (int col = 0;col < SIZE; col++ ) {
				// if square already has values
				if ( board[row][col] != EMPTY )
					continue;
				
				// iterate over all possibilities and check
				for (int number = 1; number <= 9; number++) {
					// check if safe to keep on square
					if (isSafe(row, col, number)) {
						board[row][col] = number;
						// try to recurse and backtrack the solution
						if (solve()) {
							return true;
						}
						board[row][col] = EMPTY;
					}
				}
				// if all possibilities fail, solution doesn't exist
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Check if number is safe to place in board[row][col]
	 */
	private boolean isSafe(int row, int col, int number) {
		return ((isRowSafe(row,number) && isColSafe(col,number) && isCubeSafe(row,col,number)));
	}

	
	/**
	 * Check if number exists in 3x3 cube
	 */
	private boolean isCubeSafe(int row, int col, int number) {
		row = row - (row % 3 );
		col = col - (col % 3 );
		
		for ( int index = row;index<row+3;index++ ) {
			for ( int jIndex = col; jIndex<col+3;jIndex++ ) {
				if ( board[index][jIndex] == number )
					return false;
			}
		}
		return true;
	}

	
	/**
	 * Check if number exists in the column
	 */
	private boolean isColSafe(int col, int number) {
		for ( int index = 0;index<SIZE;index++) {
			if (board[index][col] == number )
				return false;
		}
		return true;
	}


	/**
	 * Check if number exists in the row
	 */
	private boolean isRowSafe(int row, int number) {
		for ( int index = 0;index<SIZE;index++) {
			if (board[row][index] == number )
				return false;
		}
		return true;
	}
	
	
	public int[][] getBoard () {
		return board;
	}
}
