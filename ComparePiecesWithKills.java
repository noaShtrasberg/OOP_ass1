import java.util.Comparator;

public class ComparePiecesWithKills implements Comparator<ConcretePiece> {
    private ConcretePlayer winner;
    public ComparePiecesWithKills(ConcretePlayer winner) {
        super();
        this.winner = winner;
    }

    @Override
    public int compare(ConcretePiece o1, ConcretePiece o2) {
        Pawn p1 = ((Pawn)o1);
        Pawn p2 = ((Pawn)o2);
        String n1 = p1.getName();
        n1 = n1.substring(1);
        int numP1 = Integer.parseInt(n1);
        String n2 = p2.getName();
        n2 = n2.substring(1);
        int numP2 = Integer.parseInt(n2);

        if (p1.getNumKills() == p2.getNumKills()) {
            if (numP1 == numP2) {
                if (p1.getOwner() == winner) {
                    return 1;
                }
                return -1;
            }
            else {
                if (numP1 < numP2)
                    return 1;
                return -1;
            }
        }
        else {
                if (p1.getNumKills() > p2.getNumKills())
                    return 1;
                return -1;
        }
    }
}
