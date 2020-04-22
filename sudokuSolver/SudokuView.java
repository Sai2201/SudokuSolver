package sudokuSolver;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.stream.IntStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.Highlighter;

/**
 * The Sudoku Puzzle View when the Board Type is selected
 * @author siyengar
 *
 */
public class SudokuView extends JFrame{

	private static final long serialVersionUID = 1L;

	public static final int GRID_SIZE=9;
	
	public static final int SUBGRID_SIZE=3;
	
	private JTable jTable;
	
	private JButton solutionButton;
	
	private JButton resetButton;
	
	private SudokuTableModel model;
	
	private SolverUtil util;
	
	private int[][] board;
	
	
	public SudokuView ( int[][] puzzle, SolverUtil util ) {
		this.setTitle("Sudoku Puzzle Solver");
		this.board = new int[GRID_SIZE][GRID_SIZE];
		this.util = util;
		
		for ( int row=0;row<GRID_SIZE;row++ ) {
			for ( int col=0;col<GRID_SIZE;col++ ) {
				board[row][col] = puzzle[row][col];
			}
		}
		model = new SudokuTableModel(board);
		initializeView();
	}

	private void initializeView() {
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth=2;
		
		jTable = new JTable(model);
		jTable.setTableHeader(null);
		jTable.setRowHeight(40);
		jTable.setGridColor(Color.GRAY);
		jTable.setFont(new Font("Lucida Grande", 0, 18));
		jTable.setRowSelectionAllowed(false);
		jTable.setCellSelectionEnabled(true);
		
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
			
			private static final long serialVersionUID = 1L;
            @Override
            public Component getTableCellRendererComponent(JTable table, Object
                value, boolean isSelected, boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setHorizontalAlignment(SwingConstants.CENTER);
				return this;
            }
		};
		
		IntStream.range(0, 9)
				 .forEach(index -> jTable.getColumnModel().getColumn(index).setCellRenderer(renderer));
		
		jTable.setMinimumSize(new Dimension(360, 360));
		jTable.setBorder(BorderFactory.createLineBorder(Color.black,3));
		panel.add(jTable,constraints);

		
		solutionButton = new JButton("Check Solution");
		solutionButton.setSize(20, 20);
		solutionButton.setVisible(true);
		this.solutionButton.addActionListener(e -> {
			util.solve();
			refreshView();
		});
		
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(10, 10, 5, 5);
		panel.add(solutionButton, constraints);

		constraints.gridx=1;
		resetButton = new JButton("Reset Puzzle");
		solutionButton.setSize(20, 20);
		solutionButton.setVisible(true);
		panel.add(resetButton, constraints);
		
		this.resetButton.addActionListener(e -> {
			model.setTable(this.board);
		});
		
		this.add(panel);
		
		this.setResizable(false);
		this.setSize(450,450);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	private void refreshView() {
		model.setTable(util.getBoard());
	}
}
