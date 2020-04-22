package sudokuSolver;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


/**
 * The Main Driver Class for the Sudoku Solver 
 * @author siyengar
 *
 */
public class SudokuSolver {
	
	static BoardModels models;
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Sudoku Puzzle" );

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx=0;
		constraints.gridy=0;	
		constraints.gridheight=2;
		constraints.anchor = GridBagConstraints.PAGE_START;
		JButton easyButton = new JButton("EASY");
		easyButton.setFont(new Font("Lucida Grande", 0, 18));
		easyButton.setVisible(true);
		easyButton.setBackground(Color.DARK_GRAY);	
		panel.add(easyButton, constraints);

		easyButton.addActionListener(e -> {
			loadBoard(frame, BoardType.EASY);
		});
		
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.anchor = GridBagConstraints.CENTER;
		JButton mediumButton = new JButton("MEDIUM");
		mediumButton.setFont(new Font("Lucida Grande", 0, 18));
		mediumButton.setVisible(true);
		mediumButton.setBackground(Color.DARK_GRAY);	
		panel.add(mediumButton, constraints);
		
		mediumButton.addActionListener(e -> {
			loadBoard(frame, BoardType.MEDIUM);
		});
		
		constraints.gridx=0;
		constraints.gridy=4;
		constraints.anchor = GridBagConstraints.PAGE_END;
		JButton hardButton = new JButton("HARD");
		hardButton.setFont(new Font("Lucida Grande", 0, 18));
		hardButton.setVisible(true);
		hardButton.setBackground(Color.DARK_GRAY);
		panel.add(hardButton, constraints);
		
		hardButton.addActionListener(e -> {
			 loadBoard (frame, BoardType.HARD);
		});
		
		frame.add(panel);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setSize(200,200);
		frame.setVisible(true);
	}

	
	/**
	 * Function to load the puzzle with the desired board type difficulty
	 */
	private static void loadBoard(JFrame frame, BoardType type) {
		models = new BoardModels(type);
		int[][] puzzle = models.getCurrentPuzzle();
		SolverUtil util = new SolverUtil(puzzle);
		SudokuView view = new SudokuView(puzzle, util);
		view.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(false);
		frame.dispose();
	}

}
