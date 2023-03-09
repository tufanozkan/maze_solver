import java.util.ArrayList;
import java.util.Random;

public class Obstacle {
    public int size;
    public Random random;
    public int[][] array;
    public boolean[][] visitted;
    public boolean[][] visitted_way;
    public int paths = 0;
    public int steps = 0;

    public Obstacle(int size) {
        if (size % 2 == 0) size++;
        this.size = size;
        random = new Random();
        array = new int[size + 2][size + 2];
        visitted = new boolean[size + 2][size + 2];
        visitted_way = new boolean[size + 2][size + 2];
    }

    public void generate() {
        // First settup
        for (int i = 0; i < size + 2; i++) {
            array[0][i] = 1;
            array[size + 1][i] = 1;
            array[i][0] = 1;
            array[i][size + 1] = 1;
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (i % 2 == 1 && j % 2 == 1) {
                    array[i][j] = 0;
                    visitted[i][j] = false;
                    paths++;
                    visitted_way[i][j] = false;
                } else {
                    array[i][j] = 1;
                }
            }
        }

        array[1][0] = 0;
        array[size][size + 1] = 0;

        // Draw matrix
        int x_current = 1, y_current = 1;
        Position current = new Position(x_current, y_current);
        int visitedCell = 1;
        visitted[x_current][y_current] = true;
        while (visitedCell < paths) {
            steps++;
            Position next = randNext(current);
            int x_next = next.getX();
            int y_next = next.getY();

            if (visitted[x_next][y_next] == false) {
                visitted[x_next][y_next] = true;
                visitedCell++;
                creatPath(current, next);
            }

            // Update current position
            current.setX(next.getX());
            current.setY(next.getY());
        }
    }

    public void creatPath(Position current, Position next) {
        int x = (current.getX() + next.getX()) / 2;
        int y = (current.getY() + next.getY()) / 2;

        array[x][y] = 0;

    }
    public Position randNext(Position current) {
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

                return new Position(current.getX() - 2, current.getY());
            }
            case 1: {
                return new Position(current.getX(), current.getY() + 2);
            }
            case 2: {

                return new Position(current.getX() + 2, current.getY());
            }
            case 3: {
                return new Position(current.getX(), current.getY() - 2);
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + value);
        }
    }
    private boolean canUp(Position position) {
        return position.getX() - 2 > 0;
    }
    private boolean canRight(Position position) {
        return position.getY() + 2 <= size;
    }

    private boolean canDown(Position position) {
        return position.getX() + 2 <= size;
    }

    private boolean canLeft(Position position) {
        return position.getY() - 2 > 0;
    }

    public void print(int[][] array){
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}