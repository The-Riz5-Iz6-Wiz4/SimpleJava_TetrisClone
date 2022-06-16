import java.util.Random;

public class Shape {
	private Tetromino tetrisPiece;
	private int[][] coords;
	
	//constructs an empty shape 
	public Shape() {
		coords = new int[4][2];
		setShape(Tetromino.NullShape);
	}
	
	//Method to define shape of a tetromino(To be used in the shape randomiser)
	public void setShape(Tetromino shape) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; ++j) {
				coords[i][j] = shape.coords[i][j];
			}
		}
		tetrisPiece = shape; //Sets the tetris piece as the obtained shape
	}
	
	//setters to act as variables to be used later on
	private void setX(int index, int x) {
		coords[index][0] = x;
	}
	
	private void setY(int index, int y) {
		coords[index][1] = y;
	}
	
	public int x(int index) {
		return coords[index][0];
	}
	
	public int y(int index) {
		return coords[index][1];
	}
	
	//returns the tetris piece
	public Tetromino getTetromino() {
		return tetrisPiece;
	}
	
	//Obtaining random numbers which are then pushed into
	//2 Dimensional Array to create random shapes based on the
	//Tetrominoes found in Tetromino 
    public void randomizeShape() {
		Random r = new Random();
		int x = Math.abs(r.nextInt()) % 7 + 1;
		Tetromino[] values = Tetromino.values();
		setShape(values[x]);
	  }
	
	//Methods to be obtain minimum values
	public int minX() {
		int m = coords[0][0];
		
		for(int i = 0; i < 4; i++) {
			m = Math.min(m, coords[i][0]);
		}
		return m;
	}
	
	public int minY() {
		int m = coords[0][1];
		
		for(int i = 0; i < 4; i++) {
			m = Math.min(m, coords[i][1]);
		}
		return m;
	}
	
	//Methods to rotate tetris pieces right and left respectively
	//Shifts the coordinates of the Tetris piece and then returns the new coords
	public Shape rotateRight() {
		if (tetrisPiece == Tetromino.SquareShape) {
			return this;
		}
			Shape result = new Shape();
			result.tetrisPiece = tetrisPiece;
			
			for (int i = 0; i < 4; i++) {
				result.setX(i, -y(i));
				result.setY(i, x(i));
			}
		
		return result;
	}
	
	public Shape rotateLeft() {
		if (tetrisPiece == Tetromino.SquareShape) {
			return this;
		}
			Shape result = new Shape();
			result.tetrisPiece = tetrisPiece;
			
			for (int i = 0; i < 4; i++) {
				result.setX(i, y(i));
				result.setY(i, -x(i));
			}
		
		return result;
	}
}
