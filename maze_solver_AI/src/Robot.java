import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Robot {

    public int size;
    public Random random;
    public int x;
    public int y;
    public int[][] array;

    public Robot(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Robot() {
        this.x = 1;
        this.y = 0;
    }

    public boolean equals(Object obj) {
        Robot other = (Robot) obj;
        return x == other.x && y == other.y;
    }

    public void creatPath(Robot current, Robot next) {
        int x = (current.x + next.x) / 2;
        int y = (current.y + next.y) / 2;

        array[x][y] = 0;
    }


    public boolean canUp(Robot position) {
        return position.x - 2 > 0;
    }
    public boolean canRight(Robot position) {
        return position.y + 2 <= size;
    }
    public boolean canDown(Robot position) {
        return position.x + 2 <= size;
    }
    public boolean canLeft(Robot position) {
        return position.y - 2 > 0;
    }

    public Robot randNext(Robot current) {
        ArrayList<Integer> nexts = new ArrayList<Integer>();
        if (canUp(current))
            nexts.add(0);
        if (canRight(current))
            nexts.add(1);
        if (canDown(current))
            nexts.add(2);
        if (canLeft(current))
            nexts.add(3);

        int value = nexts.get(random.nextInt(nexts.size()));
        switch (value) {
            case 0: {

                return new Robot(current.x - 2, current.y);
            }
            case 1: {
                return new Robot(current.x, current.y + 2);
            }
            case 2: {

                return new Robot(current.x + 2, current.y);
            }
            case 3: {
                return new Robot(current.x, current.y - 2);
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + value);
        }
    }

    public boolean canMoveUp(Robot position) {
        return position.x - 1 > 0 && array[position.x - 1][position.y] == 0;
    }
    public boolean canMoveRight(Robot position) {
        return position.y + 1 <= size + 1 && array[position.x][position.y + 1] == 0;
    }
    public boolean canMoveDown(Robot position) {
        return position.x + 1 <= size && array[position.x + 1][position.y] == 0;
    }
    public boolean canMoveLeft(Robot position) {
        return position.y - 1 > 0 && array[position.x][position.y - 1] == 0;
    }

    public boolean canMove(Robot current, Robot next) {
        ArrayList<Robot> nexts = new ArrayList<Robot>();
        if (canMoveUp(current))
            nexts.add(new Robot(current.x - 1, current.y));
        if (canMoveRight(current))
            nexts.add(new Robot(current.x, current.y + 1));
        if (canMoveDown(current))
            nexts.add(new Robot(current.x + 1, current.y));
        if (canMoveLeft(current))
            nexts.add(new Robot(current.x, current.y - 1));
        return nexts.contains(next);
    }
}