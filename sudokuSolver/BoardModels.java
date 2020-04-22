package sudokuSolver;

import java.util.Random;

enum BoardType {
	EASY,
	MEDIUM,
	HARD
}

/**
 * The Stub for the different type of Sudoku Board models
 * @author siyengar
 *
 */
public class BoardModels {
	
	private int[][][] easyBoards = new int[3][9][9];
	private int[][][] mediumBoards = new int[3][9][9];
	private int[][][] hardBoards = new int[3][9][9];
	
	private int[][] currentPuzzle = new int[9][9];

	public BoardModels ( BoardType boardType ) {
		
		Random rand = new Random();
		int num = rand.nextInt(3);
		
		switch ( boardType ) {
			case EASY :  initializeEasy(num);
				break;
			case MEDIUM : initializeMedium(num);
				break;
			case HARD : initializeHard(num);
				break;
			default : break;
		}
	}

	private void initializeHard(int num) {
		// TODO Auto-generated method stub
		hardBoards[0] = new int[][] {
			{0, 0, 8, 0, 0, 0, 4, 0, 2},  
            {0, 0, 0, 3, 2, 0, 7, 8, 0},  
            {7, 0, 2, 5, 0, 6, 0, 0, 0},  
            {0, 0, 3, 0, 5, 0, 0, 0, 4},  
            {0, 0, 9, 7, 4, 0, 2, 0, 0},  
            {0, 0, 6, 2, 0, 0, 0, 0, 0},  
            {0, 0, 0, 0, 0, 0, 5, 0, 0},  
            {9, 0, 0, 0, 0, 5, 6, 0, 0},  
            {6, 2, 0, 0, 0, 0, 1, 9, 0}
		};
		
		hardBoards[1] = new int[][] {
			{0, 0, 0, 5, 0, 7, 0, 0, 0},  
            {0, 0, 0, 0, 0, 6, 0, 8, 0},  
            {0, 0, 0, 0, 2, 4, 0, 3, 0},  
            {0, 0, 9, 0, 0, 0, 5, 0, 3},  
            {7, 5, 0, 0, 0, 0, 6, 9, 0},  
            {0, 1, 0, 0, 0, 0, 0, 0, 0},  
            {8, 7, 0, 0, 0, 0, 0, 0, 6},  
            {0, 0, 0, 6, 0, 3, 0, 0, 8},  
            {1, 0, 5, 2, 9, 0, 0, 0, 0}
		};
		
		hardBoards[2] = new int[][] {
			{9, 1, 0, 0, 0, 7, 3, 0, 0},  
            {0, 0, 0, 0, 9, 0, 5, 0, 0},  
            {6, 0, 0, 0, 0, 4, 0, 0, 7},  
            {8, 7, 0, 4, 0, 0, 0, 0, 0},  
            {2, 0, 6, 0, 8, 0, 0, 0, 3},  
            {0, 0, 9, 0, 0, 0, 8, 0, 0},  
            {0, 3, 0, 0, 0, 0, 0, 8, 5},  
            {0, 0, 0, 6, 0, 0, 0, 0, 0},  
            {0, 0, 4, 0, 0, 0, 2, 1, 0}
		};
		this.currentPuzzle = hardBoards[num];
	}

	private void initializeMedium(int num) {
		// TODO Auto-generated method stub
		mediumBoards[0] = new int[][] {
			{7, 0, 0, 5, 0, 0, 2, 0, 0},  
            {5, 9, 0, 0, 6, 2, 7, 0, 4},  
            {0, 0, 0, 0, 7, 0, 0, 8, 0},  
            {0, 2, 0, 9, 1, 0, 0, 6, 8},  
            {9, 1, 0, 0, 0, 7, 0, 0, 0},  
            {0, 0, 0, 0, 0, 0, 0, 0, 0},  
            {8, 0, 0, 0, 0, 5, 0, 2, 0},  
            {3, 0, 9, 0, 2, 0, 0, 0, 0},  
            {2, 5, 0, 0, 9, 1, 0, 0, 3}
		};
		
		this.currentPuzzle = mediumBoards[0];
	}

	private void initializeEasy(int num) {
		// TODO Auto-generated method stub
		easyBoards[0] = new int[][]{
		  {9, 0, 0, 1, 0, 0, 0, 0, 5},
		  {0, 0, 5, 0, 9, 0, 2, 0, 1},
		  {8, 0, 0, 0, 4, 0, 0, 0, 0},
		  {0, 0, 0, 0, 8, 0, 0, 0, 0},
	      {0, 0, 0, 7, 0, 0, 0, 0, 0},
		  {0, 0, 0, 0, 2, 6, 0, 0, 9},
		  {2, 0, 0, 3, 0, 0, 0, 0, 6},
		  {0, 0, 0, 2, 0, 0, 9, 0, 0},
		  {0, 0, 1, 9, 0, 4, 5, 7, 0}
		};

		easyBoards[1] = new int[][]{
		  {3, 0, 6, 5, 0, 8, 4, 0, 0},  
          {5, 2, 0, 0, 0, 0, 0, 0, 0},  
          {0, 8, 7, 0, 0, 0, 0, 3, 1},  
          {0, 0, 3, 0, 1, 0, 0, 8, 0},  
          {9, 0, 0, 8, 6, 3, 0, 0, 5},  
          {0, 5, 0, 0, 9, 0, 6, 0, 0},  
          {1, 3, 0, 0, 0, 0, 2, 5, 0},  
          {0, 0, 0, 0, 0, 0, 0, 7, 4},  
          {0, 0, 5, 2, 0, 6, 3, 0, 0}
		};
	
		easyBoards[2] = new int[][]{
		  {5, 0, 0, 0, 0, 0, 4, 2, 7},  
	      {3, 0, 2, 6, 0, 0, 0, 1, 5},  
	      {1, 0, 0, 2, 0, 0, 6, 8, 0},  
	      {0, 0, 0, 3, 0, 5, 8, 0, 0},  
	      {0, 5, 1, 7, 2, 6, 0, 4, 5},  
	      {0, 7, 3, 8, 9, 0, 6, 0, 0},  
	      {6, 0, 0, 4, 0, 9, 0, 3, 2},  
	      {7, 3, 0, 1, 0, 0, 0, 0, 0},  
	      {2, 1, 9, 0, 0, 0, 7, 0, 0}
		};
		
		this.currentPuzzle = easyBoards[num];
	}
	
	
	public int[][] getCurrentPuzzle() {
		return currentPuzzle;
	}
 
}
