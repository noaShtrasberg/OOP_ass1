import java.util.ArrayList;

public class Pawn extends ConcretePiece{
	//private String type;
	private int numKills;

	public Pawn (Player player){
		super.owner = player;
		this.setType("\u2659");
		numKills = 0;
		numSteps = 0;
		historyMove = new ArrayList<Position>();
	}

	public String getType() { return this.type;	}
	public ArrayList<Position> getHistory() {
		return this.historyMove;
	}
	public void setHistory(Position p) {
		this.historyMove.add(p);
	}
	public void setType(String t) {
		this.type = t;
	}
	public int getNumKills() {
		return this.numKills;
	}
	public String getName() {
		return this.name;
	}
	public int getNumSteps() {
		return numSteps;
	}
	public void setNumSteps(int steps) {
		this.numSteps = numSteps + steps;
	}
	public void setNamePawn(String n) {
		this.name = n;
	}
	public void setNumKills(int num) {
		this.numKills = numKills + num;
	}

}
