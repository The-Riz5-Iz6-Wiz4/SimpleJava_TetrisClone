

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TetrisMain extends JFrame {
	private JLabel statusBar;
	
	//Constructor method that initializes the UI
	public TetrisMain() {
		
		statusBar = new JLabel (" 0");
		add(statusBar, BorderLayout.SOUTH);
		
		GameBoard board = new GameBoard(this);
		add(board);
		board.start();
		setSize(200, 400);
		setTitle("Tetris Clone");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
        
	//creates a status bar to display game score and game state(paused or game over)
	JLabel getStatusBar() {
		return statusBar;
	}
	
	//Calling main to start the game
	public static void main(String[] args) {
		
		TetrisMain myTetris = new TetrisMain();
		myTetris.setLocationRelativeTo(null);
		myTetris.setVisible(true);
	}
}
