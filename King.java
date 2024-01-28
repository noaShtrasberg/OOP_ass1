import java.util.ArrayList;

public class King extends ConcretePiece{
	private String type;
	private ConcretePlayer owner;
	private String name;
	private int numSteps;
	private ArrayList<Position> historyMove;

	public King(Player player){
		super.owner = player;
		this.type = "\u2654";
		name = "D7";
		numSteps = 0;
		historyMove = new ArrayList<Position>();
	}

	public String getType() {
		return this.type;
	}
	public ArrayList<Position> getHistory() {
		return this.historyMove;
	}
	public void setHistory(Position p) {
		this.historyMove.add(p);
	}
	public String getName() {
		return name;
	}
	public void setNameKing(String n) {
		this.name = n;
	}
	public int getNumSteps() {
		return numSteps;
	}
	public void setNumSteps(int steps) {
		this.numSteps = numSteps + steps;
	}

}
