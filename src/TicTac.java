import java.util.Scanner;

public class TicTac {
	Player ticFirst;
	Player ticSecond;
	Player tokenHolder;
	
	static int[][] gameGrid = new int[3][3];
	static String placeHolder = ".";
	static String colDiv = "|";
	TicTac() {}
	public TicTac(Player first, Player second) {
		ticFirst = first;
		ticSecond = second;
		tokenHolder = ticFirst;
		initPopulate(gameGrid);
		System.out.println(showGrid(gameGrid));
		takeInputNDisplay();
	}
	private void takeInputNDisplay() {
		System.out.println(tokenHolder.name + " chip id : " + tokenHolder.token);
		System.out.println("x : ");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		System.out.println("y : ");
		int y = sc.nextInt();
		
		if(x >= gameGrid[0].length || x < 0 || y >= gameGrid[1].length || y < 0) {
			System.out.println("Invalid input coordinates  x: 0 to " + gameGrid[0].length +
					" y: 0 to " + gameGrid[1].length);
			takeInputNDisplay();
		}
		if(gameGrid[x][y] != Player.defaultPopulator) {
			String tempName = "";
			if(ticFirst.moves[x][y] == ticFirst.token) {
				tempName = ticFirst.name;
			}else if(ticSecond.moves[x][y] == ticSecond.token){
				tempName = ticSecond.name;
			}
			if(tokenHolder.name.equals(tempName))
				System.out.println("\nYou have already made move : (" + x + " , " + y + ")");
			else
				System.out.println("move (" + x + " , " + y + ") has already been played by " + tempName);
			System.out.println("Make Another one \n\n");
			takeInputNDisplay();
		}
		ticThat(x, y);
		takeInputNDisplay();
	}
	public boolean gameDraw() {
		if(Player.maxMoves >= 9)
			return true;
		return false;
	}
	public void gameDrawDisplay() {
		System.out.println("Game is Draw !!!");
		System.out.println("Try another game ? y/n ");
		gameReset();
		
	}
	public void gameOverDisplay() {
		System.out.println("\n\n\n\n################################");
		System.out.println(" has Won the Game!");
		System.out.println("Try another game ? y/n \n\n\n");
		gameReset();
	}
	public void gameReset() {
		Scanner sx = new Scanner(System.in);
		
		if(sx.next().equals("y") || sx.next().equals("Y")) {
			System.out.println(ticFirst.name);
			Player.initPopulate(ticFirst.moves);
			Player.initPopulate(ticSecond.moves);
			System.out.println("\n\n\n\n\n\n\n\nNew Game!");
			takeInputNDisplay();
		}
		else 
			System.exit(0);
	}
	public String showGrid(int[][] gameGrid) {
		String s = "\n\n y      0     1     2" + "\n" + "x \n\n";
		for(int i = 0; i < gameGrid[0].length; i++) {
			s += i + "       ";
			for(int j = 0; j < gameGrid[1].length; j++) {
				s += (gameGrid[i][j] == Player.defaultPopulator) ? placeHolder : gameGrid[i][j]; 
				if(j !=2)
					s += "  " + colDiv + "  ";
			}
			s+="\n\n";
		}
		return s;
	}
	private void initPopulate(int[][] gameGrid) {
		for(int i = 0; i < gameGrid[0].length; i++) 
			for(int j = 0; j < gameGrid[1].length; j++)
				gameGrid[i][j] = Player.defaultPopulator;
	}
	public void ticThat(int x, int y) {
		gameGrid[x][y] = tokenHolder.token;
		tokenHolder.moveTo(x, y);
		Player.maxMoves++;
		manageTurns();
		System.out.println(showGrid(gameGrid));
		update();
		if(gameDraw())
			gameDrawDisplay();
	}
	public void manageTurns() {
		if(tokenHolder.equals(ticFirst))
			tokenHolder = ticSecond;
		else if(tokenHolder.equals(ticSecond))
			tokenHolder = ticFirst;
	}
	public Player update() {
		if(ticFirst.win) {
			System.out.println("first player won");
			return ticFirst;
		}
		else if(ticSecond.win) {
			System.out.println("second player won");
			return ticSecond;
		}
		return null;
	}
	public static void main(String[] args) {
		Player Abraham = new Player("Abraham");
		Player Douglas = new Player("Dauglas");
		Player Safwan = new Player("Safwan Abbasi");
		TicTac gameOne = new TicTac(Abraham, Douglas);
	}
}





