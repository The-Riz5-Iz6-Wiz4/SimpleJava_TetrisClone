

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TetrisMain extends JFrame {
	private JLabel statusBar;
	
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

	JLabel getStatusBar() {
		return statusBar;
	}
	
	public static void main(String[] args) {
		
		TetrisMain myTetris = new TetrisMain();
		myTetris.setLocationRelativeTo(null);
		myTetris.setVisible(true);
	}
}
