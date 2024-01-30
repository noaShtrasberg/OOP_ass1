import java.util.ArrayList;

public abstract class ConcretePiece implements Piece{
	protected Player owner;
	protected String type;
    protected String name;
    protected int numSteps;
    protected ArrayList<Position> historyMove;
	
	public ConcretePiece() {

	}
    public ArrayList<Position> getHistory() {
        return this.historyMove;
    }
    public void setHistory(Position p) {
        this.historyMove.add(p);
    }
    @Override
    public Player getOwner() {
        return this.owner;
    }
    public String getName() {
        return this.name;
    }
    @Override
    public String getType() {
    	return type;
    }
    public int getNumSteps() {
        return numSteps;
    }
    public void setNumSteps(int steps) {
        this.numSteps = numSteps + steps;
    }
}
