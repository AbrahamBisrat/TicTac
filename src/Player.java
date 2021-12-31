
public class Player {
	TicTac temp = new TicTac();
	
	String name = "";
	static int defaultPopulator = 8;
	static int maxMoves = 0;
	boolean win = false;
	int[][] moves = new int[3][3];
	int token;
	static boolean tokenBoolean = true;
	
	Player(String name) {
		for(int i = 0; i < moves[0].length; i++) {
			for(int j = 0; j < moves[1].length; j++) {
				moves[i][j] = 3;
			}
		}
		this.name = name;
		if(tokenBoolean) {
			token = 1;
			tokenBoolean = false;
		}else
			token = 0;
		initPopulate(moves);
	}
	public static void initPopulate(int[][] gameGrid) {
		for(int i = 0; i < gameGrid[0].length; i++) 
			for(int j = 0; j < gameGrid[1].length; j++)
				gameGrid[i][j] = Player.defaultPopulator;
	}
	public void winner() {
//		System.out.println(showMoves());
		for(int i = 0; i < moves[0].length; i++) {
			if(moves[i][0] == token && moves[i][1] == token && moves[i][2] == token)
				win = true; // check horizontal rows
			if(moves[0][i] == token && moves[1][i] == token && moves[2][i] == token)
				win = true; // check vertical rows
		}
		if(moves[0][1] == token && moves[1][1] == token && moves[2][1] == token)
				win = true; // middle vertical
		if(moves[0][0] == token && moves[1][1] == token && moves[2][2] == token)
			win = true; // 0,0 1,1 and 2,2 // diagonal
		if(moves[0][2] == token && moves[1][1] == token && moves[2][0] == token)
			win = true; // 0,2 1,1 and 2,0 // diagonal
		if(win) {
			showMoves();
			System.out.println(name + " won");
			temp.gameOverDisplay();
		}
		win = false;
	}
	public void moveTo(int x, int y) {
		moves[x][y] = token;
		winner(); // update the win boolean
	}
	public String showMoves() {
		String s = "      y   0      1      2" + "\n";
		for(int i = 0; i < moves[0].length; i++) {
			s += "x >>  " + i + "   ";
			for(int j = 0; j < moves[1].length; j++) {
				s += (moves[i][j] == 8) ? "_" : moves[i][j];
				s += "  |  ";
			}
			s+="\n";
		}
		return s;
	}
	public void reset() {
		
	}
}





