import java.util.ArrayList;

public class GameLogic implements PlayableLogic {

	private final int BOARD_SIZE = 11;
	ConcretePiece[][] board = new ConcretePiece[BOARD_SIZE][BOARD_SIZE];
	private ArrayList<ConcretePiece> boardState;
	ArrayList<Position> pos = new ArrayList<Position>();
	Position[][] positions;
	ConcretePlayer attacker = new ConcretePlayer(false);
	ConcretePlayer defender = new ConcretePlayer(true);
	private boolean firstPlayerTurn;
	int deadAttacker;
	int deadDefender;
	int xKing;
	int yKing;
	int kills;
	boolean gameFinish = false;
	boolean winner; //true == defender, false == attacker


	public GameLogic() {
		reset();
	}

	/*
	reset the board, the kills, the positions and all the pieces
 	*/
	@Override
	public void reset() {
		deadAttacker = 0;
		deadDefender = 0;
		boardState = new ArrayList<ConcretePiece>();
		positions = new Position[11][11];
		gameFinish = false;
		initPosition();

		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = null;
			}
		}

		xKing = 5;
		yKing = 5;

		//attacker
		board[3][0] = new Pawn(this.attacker);
		boardState.add(board[3][0]);
		((Pawn) board[3][0]).setNamePawn("A1");
		positions[3][0].setPiecesAtPosition(board[3][0]);

		board[4][0] = new Pawn(this.attacker);
		boardState.add(board[4][0]);
		((Pawn) board[4][0]).setNamePawn("A2");
		positions[4][0].setPiecesAtPosition(board[4][0]);

		board[5][0] = new Pawn(this.attacker);
		boardState.add(board[5][0]);
		((Pawn) board[5][0]).setNamePawn("A3");
		positions[5][0].setPiecesAtPosition(board[5][0]);

		board[6][0] = new Pawn(this.attacker);
		boardState.add(board[6][0]);
		((Pawn) board[6][0]).setNamePawn("A4");
		positions[6][0].setPiecesAtPosition(board[6][0]);

		board[7][0] = new Pawn(this.attacker);
		boardState.add(board[7][0]);
		((Pawn) board[7][0]).setNamePawn("A5");
		positions[7][0].setPiecesAtPosition(board[7][0]);

		board[5][1] = new Pawn(this.attacker);
		boardState.add(board[5][1]);
		((Pawn) board[5][1]).setNamePawn("A6");
		positions[5][1].setPiecesAtPosition(board[5][1]);

		board[0][3] = new Pawn(this.attacker);
		boardState.add(board[0][3]);
		((Pawn) board[0][3]).setNamePawn("A7");
		positions[0][3].setPiecesAtPosition(board[0][3]);

		board[10][3] = new Pawn(this.attacker);
		boardState.add(board[10][3]);
		((Pawn) board[10][3]).setNamePawn("A8");
		positions[10][3].setPiecesAtPosition(board[10][3]);

		board[0][4] = new Pawn(this.attacker);
		boardState.add(board[0][4]);
		((Pawn) board[0][4]).setNamePawn("A9");
		positions[0][4].setPiecesAtPosition(board[0][4]);

		board[10][4] = new Pawn(this.attacker);
		boardState.add(board[10][4]);
		((Pawn) board[10][4]).setNamePawn("A10");
		positions[10][4].setPiecesAtPosition(board[10][4]);

		board[0][5] = new Pawn(this.attacker);
		boardState.add(board[0][5]);
		((Pawn) board[0][5]).setNamePawn("A11");
		positions[0][5].setPiecesAtPosition(board[0][5]);

		board[1][5] = new Pawn(this.attacker);
		boardState.add(board[1][5]);
		((Pawn) board[1][5]).setNamePawn("A12");
		positions[1][5].setPiecesAtPosition(board[1][5]);

		board[9][5] = new Pawn(this.attacker);
		boardState.add(board[9][5]);
		((Pawn) board[9][5]).setNamePawn("A13");
		positions[9][5].setPiecesAtPosition(board[9][5]);

		board[10][5] = new Pawn(this.attacker);
		boardState.add(board[10][5]);
		((Pawn) board[10][5]).setNamePawn("A14");
		positions[10][5].setPiecesAtPosition(board[10][5]);

		board[0][6] = new Pawn(this.attacker);
		boardState.add(board[0][6]);
		((Pawn) board[0][6]).setNamePawn("A15");
		positions[0][6].setPiecesAtPosition(board[0][6]);

		board[10][6] = new Pawn(this.attacker);
		boardState.add(board[10][6]);
		((Pawn) board[10][6]).setNamePawn("A16");
		positions[10][6].setPiecesAtPosition(board[10][6]);

		board[0][7] = new Pawn(this.attacker);
		boardState.add(board[0][7]);
		((Pawn) board[0][7]).setNamePawn("A17");
		positions[0][7].setPiecesAtPosition(board[0][7]);

		board[10][7] = new Pawn(this.attacker);
		boardState.add(board[10][7]);
		((Pawn) board[10][7]).setNamePawn("A18");
		positions[10][7].setPiecesAtPosition(board[10][7]);

		board[5][9] = new Pawn(this.attacker);
		boardState.add(board[5][9]);
		((Pawn) board[5][9]).setNamePawn("A19");
		positions[5][9].setPiecesAtPosition(board[5][9]);

		board[3][10] = new Pawn(this.attacker);
		boardState.add(board[3][10]);
		((Pawn) board[3][10]).setNamePawn("A20");
		positions[3][10].setPiecesAtPosition(board[3][10]);

		board[4][10] = new Pawn(this.attacker);
		boardState.add(board[4][10]);
		((Pawn) board[4][10]).setNamePawn("A21");
		positions[4][10].setPiecesAtPosition(board[4][10]);

		board[5][10] = new Pawn(this.attacker);
		boardState.add(board[5][10]);
		((Pawn) board[5][10]).setNamePawn("A22");
		positions[5][10].setPiecesAtPosition(board[5][10]);

		board[6][10] = new Pawn(this.attacker);
		boardState.add(board[6][10]);
		((Pawn) board[6][10]).setNamePawn("A23");
		positions[6][10].setPiecesAtPosition(board[6][10]);

		board[7][10] = new Pawn(this.attacker);
		boardState.add(board[7][10]);
		((Pawn) board[7][10]).setNamePawn("A24");
		positions[7][10].setPiecesAtPosition(board[7][10]);

		//defender
		board[5][3] = new Pawn(this.defender);
		boardState.add(board[5][3]);
		((Pawn) board[5][3]).setNamePawn("D1");
		positions[5][3].setPiecesAtPosition(board[5][3]);

		board[4][4] = new Pawn(this.defender);
		boardState.add(board[4][4]);
		((Pawn) board[4][4]).setNamePawn("D2");
		positions[4][4].setPiecesAtPosition(board[4][4]);

		board[5][4] = new Pawn(this.defender);
		boardState.add(board[5][4]);
		((Pawn) board[5][4]).setNamePawn("D3");
		positions[5][4].setPiecesAtPosition(board[5][4]);

		board[6][4] = new Pawn(this.defender);
		boardState.add(board[6][4]);
		((Pawn) board[6][4]).setNamePawn("D4");
		positions[6][4].setPiecesAtPosition(board[6][4]);

		board[3][5] = new Pawn(this.defender);
		boardState.add(board[3][5]);
		((Pawn) board[3][5]).setNamePawn("D5");
		positions[3][5].setPiecesAtPosition(board[3][5]);

		board[4][5] = new Pawn(this.defender);
		boardState.add(board[4][5]);
		((Pawn) board[4][5]).setNamePawn("D6");
		positions[4][5].setPiecesAtPosition(board[4][5]);

		board[5][5] = new King(this.defender);
		boardState.add(board[5][5]);
		((King) board[5][5]).setNameKing("K7");
		positions[5][5].setPiecesAtPosition(board[5][5]);

		board[6][5] = new Pawn(this.defender);
		boardState.add(board[6][5]);
		((Pawn) board[6][5]).setNamePawn("D8");
		positions[6][5].setPiecesAtPosition(board[6][5]);

		board[7][5] = new Pawn(this.defender);
		boardState.add(board[7][5]);
		((Pawn) board[7][5]).setNamePawn("D9");
		positions[7][5].setPiecesAtPosition(board[7][5]);

		board[4][6] = new Pawn(this.defender);
		boardState.add(board[4][6]);
		((Pawn) board[4][6]).setNamePawn("D10");
		positions[4][6].setPiecesAtPosition(board[4][6]);

		board[5][6] = new Pawn(this.defender);
		boardState.add(board[5][6]);
		((Pawn) board[5][6]).setNamePawn("D11");
		positions[5][6].setPiecesAtPosition(board[5][6]);

		board[6][6] = new Pawn(this.defender);
		boardState.add(board[6][6]);
		((Pawn) board[6][6]).setNamePawn("D12");
		positions[6][6].setPiecesAtPosition(board[6][6]);

		board[5][7] = new Pawn(this.defender);
		boardState.add(board[5][7]);
		((Pawn) board[5][7]).setNamePawn("D13");
		positions[5][7].setPiecesAtPosition(board[5][7]);

		this.firstPlayerTurn = false;

	}

	/*
	restart the array of the positions
	 */
	public void initPosition() {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				positions[i][j] = new Position(i, j);
			}
		}
	}

	/*
	Convert the 2D array to a regular array so we can sort it
	*/
	public void arrToArray(Position[][] arr) {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				pos.add(positions[i][j]);
			}
		}
	}

	/*
	get src position and dst position.
	return true if the move is legal, else - false.
	 */
	@Override
	public boolean move(Position a, Position b) {
		/*
		at start - if it's diagonal / move to the corner for a pawn / not the
		player turn - return false.
		 */
		if (a.isDiagonal(b)) {
			return false;
		}
		if (isCorner(b.get_x(), b.get_y()) && board[a.get_x()][a.get_y()] instanceof Pawn)
			return false;
		if (board[a.get_x()][a.get_y()].getOwner().isPlayerOne() && !firstPlayerTurn)
			return false;
		if (!board[a.get_x()][a.get_y()].getOwner().isPlayerOne() && firstPlayerTurn)
			return false;
		else {
			//if there is a piece in the wanted path - return false.
			if (a.get_x() == b.get_x()) {
				if (a.get_y() > b.get_y()) {
					for (int i = b.get_y(); i < a.get_y(); i++) {
						if (board[a.get_x()][i] != null)
							return false;
					}
				} else {
					for (int i = a.get_y() + 1; i <= b.get_y(); i++) {
						if (board[a.get_x()][i] != null)
							return false;
					}
				}
			}
			if (a.get_y() == b.get_y()) {
				if (a.get_x() > b.get_x()) {
					for (int i = b.get_x(); i < a.get_x(); i++) {
						if (board[i][a.get_y()] != null)
							return false;
					}
				} else {
					for (int i = a.get_x() + 1; i <= b.get_x(); i++) {
						if (board[i][a.get_y()] != null)
							return false;
					}
				}
			}
		}
		firstPlayerTurn = !firstPlayerTurn;
		//make the move and sum up the amount of kills.
		doMove(a, b);
		kills = isKill(b);
		if (isSecondPlayerTurn()) { //defender kills the attacker
			deadAttacker = deadAttacker + kills;
		} else {//attacker kills the defender
			deadDefender = deadDefender + kills;
		}

		//kills for specific pawn.
		if (getPieceAtPosition(b) instanceof Pawn)
			((Pawn) board[b.get_x()][b.get_y()]).setNumKills(kills);

		//make all the sorts and the updates if the is finish.
		if (isGameFinished()) {
			if (winner) {
				defender.setWins();
				sortByPawnHistory(defender);
				for (int i = 0; i < boardState.size(); i++) {
					if (boardState.get(i) instanceof King)
						boardState.remove(i);
				}
				sortByNumKills(defender);
				boardState.add(board[xKing][yKing]);
				countSteps();
				sortBySteps(defender);
				arrToArray(positions);
				sortByPosition();
			}
			if (!winner) {
				attacker.setWins();
				sortByPawnHistory(attacker);
				for (int i = 0; i < boardState.size(); i++) {
					if (boardState.get(i) instanceof King)
						boardState.remove(i);
				}
				sortByNumKills(attacker);
				boardState.add(board[xKing][yKing]);
				countSteps();
				sortBySteps(attacker);
				arrToArray(positions);
				sortByPosition();
			}
			gameFinish = true;
		}
		return true;
	}

	/*
	make the step and update in the relevant places (positions and history).
	 */
	public void doMove (Position a, Position b){
			if (board[a.get_x()][a.get_y()].getHistory().isEmpty()) {
				board[a.get_x()][a.get_y()].setHistory(a);
			}

			ConcretePiece temp = board[a.get_x()][a.get_y()];
			board[b.get_x()][b.get_y()] = temp;
			board[a.get_x()][a.get_y()] = null;

			if (!pieceIsContains(positions[b.get_x()][b.get_y()].getPiecesAtPosition(), board[b.get_x()][b.get_y()])) {
				positions[b.get_x()][b.get_y()].setPiecesAtPosition(board[b.get_x()][b.get_y()]);
			}

			if (temp instanceof King) {
				xKing = b.get_x();
				yKing = b.get_y();
				((King) board[b.get_x()][b.get_y()]).setHistory(b);
			} else
				((Pawn) board[b.get_x()][b.get_y()]).setHistory(b);

		}
	/*
	check if a specifec piece is already at the array.
	 */
	public boolean pieceIsContains (ArrayList < ConcretePiece > arr, ConcretePiece p){
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).getName().equals(p.getName()))
					return true;
			}
			return false;
		}
	/*
	get the dst position.
	return the amount of kills - sum the directions for several kills at the same step.
	uses the functions: regularKill - redPawn,bluePawn,redPawn.
	                    edgeKill - bluePawn, redPawn, end of the board.
	 */
	public int isKill (Position b){
			int x = b.get_x();
			int y = b.get_y();
			int numKills = 0;
			if ((board[x][y] instanceof Pawn)) { //the king can't eat
				//leftKill
				if (x - 2 >= 0) {
					numKills = numKills + regularKill(x, y, x - 1, y, x - 2, y);
				} else if (x - 2 == -1) {
					numKills = numKills + edgeKill(x, y, x - 1, y);
				}
				//rightKill
				if (x + 2 <= BOARD_SIZE - 1) {
					numKills = numKills + regularKill(x, y, x + 1, y, x + 2, y);
				} else if (x + 2 == BOARD_SIZE) {
					numKills = numKills + edgeKill(x, y, x + 1, y);
				}
				//upKill
				if (y - 2 >= 0) {
					numKills = numKills + regularKill(x, y, x, y - 1, x, y - 2);
				} else if (y - 2 == -1) {
					numKills = numKills + edgeKill(x, y, x, y - 1);
				}
				//downKill
				if (y + 2 <= BOARD_SIZE - 1) {
					numKills = numKills + regularKill(x, y, x, y + 1, x, y + 2);
				} else if (y + 2 == BOARD_SIZE) {
					numKills = numKills + edgeKill(x, y, x, y + 1);
				}
			}
			return numKills;
		}
	public int regularKill (int xKiller, int yKiller, int xEaten, int yEaten, int xSide2, int ySide2){
			if (board[xEaten][yEaten] != null && board[xSide2][ySide2] != null) {
				boolean killer = board[xKiller][yKiller].getOwner().isPlayerOne();
				boolean eaten = board[xEaten][yEaten].getOwner().isPlayerOne();
				boolean side2 = board[xSide2][ySide2].getOwner().isPlayerOne();
				if (killer == side2 && killer != eaten && (board[xEaten][yEaten] instanceof Pawn)) {
					board[xEaten][yEaten] = null;
					return 1;
				}
			}
			if (isCorner(xSide2, ySide2) && board[xEaten][yEaten] != null) {
				boolean killer = board[xKiller][yKiller].getOwner().isPlayerOne();
				boolean eaten = board[xEaten][yEaten].getOwner().isPlayerOne();
				if (killer != eaten && (board[xEaten][yEaten] instanceof Pawn)) {
					board[xEaten][yEaten] = null;
					return 1;
				}
			}
			return 0;
		}
	public int edgeKill (int xKiller, int yKiller, int xEaten, int yEaten){
			if (board[xEaten][yEaten] != null) {
				boolean killer = board[xKiller][yKiller].getOwner().isPlayerOne();
				boolean eaten = board[xEaten][yEaten].getOwner().isPlayerOne();
				if (killer != eaten && (board[xEaten][yEaten] instanceof Pawn)) {
					board[xEaten][yEaten] = null;
					return 1;
				}
			}
			return 0;
		}
	/*
	get x and y on the board
	return true if it is a corner.
	 */
	public boolean isCorner (int x, int y){
			if ((x == 0 && y == 0) || (x == 0 && y == BOARD_SIZE - 1) ||
					(x == BOARD_SIZE - 1 && y == 0) || (x == BOARD_SIZE - 1 && y == BOARD_SIZE - 1))
				return true;
			return false;
		}
	/*
	get a position.
	return the piece on it.
	 */
	@Override
	public Piece getPieceAtPosition (Position position){
			ConcretePiece atPosition = board[position.get_x()][position.get_y()];
			return atPosition;
		}
	@Override
	public Player getFirstPlayer () {
			return this.defender;
		}
	@Override
	public Player getSecondPlayer () {
			return this.attacker;
		}
	/*
	count the num of steps that the piece do on one move.
	 */
	public void countSteps () {
			for (int i=0 ; i<boardState.size() ; i++) {
				ConcretePiece c = boardState.get(i);
				if (c.getHistory().size() > 1) {
					for (int j = 0; j < c.getHistory().size() - 1; j++) {
						Position a = (Position) c.getHistory().get(j);
						Position b = (Position) c.getHistory().get(j + 1);
						if (a.get_x() > b.get_x()) c.setNumSteps(a.get_x() - b.get_x());
						else c.setNumSteps(b.get_x() - a.get_x());
						if (a.get_y() > b.get_y()) c.setNumSteps(a.get_y() - b.get_y());
						else c.setNumSteps(b.get_y() - a.get_y());
					}
				}
			}
		}
	/*
	the next two functions check if there was a king's kill.
	the two options - 4 pawns surround the king, or three with the edge.
	 */
	public boolean killKing4sides () {
			if (xKing > 0 && xKing < BOARD_SIZE - 1 && yKing > 0 && yKing < BOARD_SIZE - 1) {
				boolean left = board[xKing - 1][yKing] != null && !board[xKing - 1][yKing].getOwner().isPlayerOne();
				boolean right = board[xKing + 1][yKing] != null && !board[xKing + 1][yKing].getOwner().isPlayerOne();
				boolean up = board[xKing][yKing - 1] != null && !board[xKing][yKing - 1].getOwner().isPlayerOne();
				boolean down = board[xKing][yKing + 1] != null && !board[xKing][yKing + 1].getOwner().isPlayerOne();
				if (left && right && up && down) {
					return true;
				}
			}
			return false;
		}
	public boolean killKing3sides () {
			if (xKing == 0) {
				boolean right = board[xKing + 1][yKing] != null && !board[xKing + 1][yKing].getOwner().isPlayerOne();
				boolean up = board[xKing][yKing - 1] != null && !board[xKing][yKing - 1].getOwner().isPlayerOne();
				boolean down = board[xKing][yKing + 1] != null && !board[xKing][yKing + 1].getOwner().isPlayerOne();
				if (right && up && down) {
					return true;
				}
			}
			if (xKing == BOARD_SIZE - 1) {
				boolean left = board[xKing - 1][yKing] != null && !board[xKing - 1][yKing].getOwner().isPlayerOne();
				boolean up = board[xKing][yKing - 1] != null && !board[xKing][yKing - 1].getOwner().isPlayerOne();
				boolean down = board[xKing][yKing + 1] != null && !board[xKing][yKing + 1].getOwner().isPlayerOne();
				if (left && up && down) {
					return true;
				}
			}
			if (yKing == 0) {
				boolean left = board[xKing - 1][yKing] != null && !board[xKing - 1][yKing].getOwner().isPlayerOne();
				boolean right = board[xKing + 1][yKing] != null && !board[xKing + 1][yKing].getOwner().isPlayerOne();
				boolean down = board[xKing][yKing + 1] != null && !board[xKing][yKing + 1].getOwner().isPlayerOne();
				if (left && right && down) {
					return true;
				}
			}
			if (yKing == BOARD_SIZE - 1) {
				boolean left = board[xKing - 1][yKing] != null && !board[xKing - 1][yKing].getOwner().isPlayerOne();
				boolean right = board[xKing + 1][yKing] != null && !board[xKing + 1][yKing].getOwner().isPlayerOne();
				boolean up = board[xKing][yKing - 1] != null && !board[xKing][yKing - 1].getOwner().isPlayerOne();
				if (left && right && up) {
					return true;
				}
			}
			return false;
		}
	@Override
	public boolean isSecondPlayerTurn () {
		return !firstPlayerTurn;
	}
	/*
    sort the pawns by the num of kills the pawn did and print.
     */
	public void sortByNumKills (ConcretePlayer winner){ //sort and print
			boardState.sort(new ComparePiecesWithKills(winner));
			Pawn p;
			for (int i = boardState.size() - 1; i >= 0; i--) {
				if (boardState.get(i) != null) {
					p = ((Pawn) boardState.get(i));
					if (p.getNumKills() > 0)
						System.out.println(p.getName() + ": " + p.getNumKills() + " kills");
				}
			}
			System.out.println("***************************************************************************");
		}
	/*
	sort the pieces by the num of the positions the pawn passed and print.
	 */
	public void sortByPawnHistory (ConcretePlayer winner){
			boardState.sort(new ComarePieceWithHistorMove(winner));
			for (int i = 0; i < boardState.size(); i++) {
				if (boardState.get(i) != null) {
					if (boardState.get(i).getHistory().size() > 1) {
						ConcretePiece c = boardState.get(i);
						System.out.print(c.getName() + ": " + "[");
						for (int j = 0; j < c.getHistory().size(); j++) {
							if (j == c.getHistory().size() - 1)
								System.out.print(c.getHistory().get(j).toString());
							else System.out.print(c.getHistory().get(j).toString() + ", ");
						}
						System.out.println("]");
					}
				}
			}
			System.out.println("***************************************************************************");
		}
	/*
    sort the pieces by the num of steps the pawn did and print.
     */
	public void sortBySteps (ConcretePlayer winner){
			boardState.sort(new CompareSteps(winner));
			for (int i = 0; i < boardState.size(); i++) {
				ConcretePiece c = boardState.get(i);
				if (c.getNumSteps() > 0) {
					System.out.println(c.getName() + ": " + c.getNumSteps() + " squares");
				}
			}
			System.out.println("***************************************************************************");
		}
	/*
    sort the positions by the num of different pieces that step on it and print.
     */
	public void sortByPosition () {
			pos.sort(new ComparePositions());
			for (int i = 0; i < pos.size(); i++) {
				Position p = pos.get(i);
				if (p.getPiecesAtPosition().size() > 1) {
					System.out.println(p.toString() + p.getPiecesAtPosition().size() + " pieces");
				}
			}
			System.out.println("***************************************************************************");
		}
	@Override
	public void undoLastMove () {

	}
	@Override
	public boolean isGameFinished () {
			//The defender wins
			//the king is in a corner or all the attacker's pawn dead
			if (isCorner(xKing, yKing) || deadAttacker == 24) {
				winner = true;
				return true;
			}
		    //The attacker wins
		    //the king is dead
			if (killKing4sides() || killKing3sides()) {
				winner = false;
				return true;
			}
			return false;
		}
	@Override
	public int getBoardSize () {
		return BOARD_SIZE;
	}
}
