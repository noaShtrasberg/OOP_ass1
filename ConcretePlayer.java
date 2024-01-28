public class ConcretePlayer implements Player{
	
	private boolean numPlayer;
	private int wins;
	
	public ConcretePlayer(boolean player) {
        //false = attacker, true = defender
        this.numPlayer = player;
		this.wins = 0;	
	}

    //player1 - defender, player2 - attacker
    @Override
    public boolean isPlayerOne() {
        return numPlayer;
    }

    public void setWins() {
    	this.wins=this.wins+1;
    }

    @Override
    public int getWins() {
        return this.wins;
    }

}
