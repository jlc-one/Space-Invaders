package Assets;

public class Bunker {

    private int x;
    private int y;

    private BunkerSegment[][] bunkerSegments = new BunkerSegment[6][5];

    public Bunker(int xPos, int yPos) {
        this.x = xPos;
        this.y = yPos;
        bunkerInit();
    }

    private void bunkerInit() {
        for (int i = 0; i < bunkerSegments.length; ++i) {
            for (int j = 0; j < bunkerSegments[0].length; ++j) {
                bunkerSegments[i][j] = new BunkerSegment(x + (i * 10), y + (j * 10));
            }
        }


    }

    public BunkerSegment[][] getBunkerSegments() {
        return bunkerSegments;
    }

    
}

