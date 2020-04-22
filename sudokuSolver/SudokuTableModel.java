package sudokuSolver;

import javax.swing.table.AbstractTableModel;

/**
 * The Table Model for the Sudoku Puzzle Solver View
 * @author siyengar
 *
 */
public class SudokuTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 20200418002L;
	
	private static final int SIZE = 9; 

	private int[][] board;
	
	private boolean[][] isEditableMatrix;
	
	public SudokuTableModel(int[][] board) {
		this.board = board;
		this.isEditableMatrix = new boolean[SIZE][SIZE];
		for ( int index =0; index<SIZE; index++ ) {
			for ( int jIndex =0 ;jIndex<SIZE;jIndex++ ) {
				if ( board[index][jIndex] == 0 )
					isEditableMatrix[index][jIndex] = true;
			}
		}
	}

	
	@Override
	public int getRowCount() {
		return SIZE;
	}

	
	@Override
	public int getColumnCount() {
		return SIZE;
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if ( board[rowIndex][columnIndex] == 0 )
			return "";
		return board[rowIndex][columnIndex];
	}
	
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		try {
			if ( aValue.equals("") || !isValid(aValue) ) {
				board[rowIndex][columnIndex] = 0;
			} else {
				int val = Integer.parseInt((String)aValue);
				board[rowIndex][columnIndex] = val;
			}
			fireTableCellUpdated(rowIndex, columnIndex);
		} catch ( NumberFormatException ex ) {
			System.out.println(ex.getMessage());
		}
	}

	
	private boolean isValid(Object aValue) {
		int val = Integer.parseInt((String)aValue);
		return (val > 0 && val < 10);
	}

	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return isEditableMatrix[rowIndex][columnIndex];
	}

	
	public void setTable(int[][] board2) {
		this.board = board2;
		fireTableDataChanged();
	}
	
}
