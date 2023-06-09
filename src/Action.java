/**
 * This class represents an action that can be performed in the game. It contains information about the tile to be
 * moved, the direction of the movement, and the new indexes of the tile after the action is committed.
 */
public class Action {
    int i;
    int j;
    Tile tile;
    PossibleDirection direction;
    public Action(int i, int j, Tile tile, PossibleDirection direction) {
        this.i = i;
        this.j = j;
        this.tile = tile;
        this.direction = direction;
    }

    /**
     * This method does not get any parameter as an input and returns string in the form of "Move 7 down"
     *
     * @return String
     */
    public String toString() {
        return "Move " + tile.get() + " " + direction.toString().toLowerCase();
    }

    /**
     * This method returns the (new) indexes of the tile after the action is committed.
     * @return State
     */
    public int[] actionAsNewIndexes() {
        switch (direction) {
            case UP:
                return new int[]{i + 1, j};
            case DOWN:
                return new int[]{i - 1, j};
            case RIGHT:
                return new int[]{i, j + 1};
            case LEFT:
                return new int[]{i, j - 1};
        }
        return null;
    }

    /**
     * This method convert between the indexes of the empty tile and the tile need to be moved (based on an input
     * direction).
     * @return State
     */
    public static int[] convertEmptyToTarget(int[] emptyIndexes, PossibleDirection direction) {
        switch (direction) {
            case UP:
                return new int[]{emptyIndexes[0] + 1, emptyIndexes[1]};
            case DOWN:
                return new int[]{emptyIndexes[0] - 1, emptyIndexes[1]};
            case RIGHT:
                return new int[]{emptyIndexes[0], emptyIndexes[1] - 1};
            case LEFT:
                return new int[]{emptyIndexes[0], emptyIndexes[1] + 1};
        }
        return null;
    }
}
