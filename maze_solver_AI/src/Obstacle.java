import java.util.ArrayList;
import java.util.Random;
public class Obstacle {
    int size;
    int[][] array;
    boolean[][] visitted;
    boolean[][] visitted_way;
    int paths = 0;
    int steps = 0;
    Random random = new Random();
    public Obstacle(int size){
        this.size=size;
    }
    public void generate(){
        if(size%2==0)
            size++;
        array = new int[size + 2][size + 2];
        visitted = new boolean[size + 2][size + 2];
        visitted_way = new boolean[size + 2][size + 2];

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
        array[size][size + 1] = 0;  //Giriş ve çıkış kısımlarına 0 atadık.

        int x_current = 1, y_current = 1;
        Robot current = new Robot(x_current, y_current);
        int visitedCell = 1;
        visitted[x_current][y_current] = true;
        while (visitedCell < paths) {
            steps++;
            Robot next = randNext(current);
            int x_next = next.x;
            int y_next = next.y;

            if (visitted[x_next][y_next] == false) {
                visitted[x_next][y_next] = true;
                visitedCell++;
                creatPath(current, next,array);
            }

            // Update current position
            current.x=next.x;
            current.y=next.y;
        }

        print(array);
    }

    public void print(int array[][]){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    private void creatPath(Robot current, Robot next,int array[][]) {
        int x = (current.x + next.x) / 2;
        int y = (current.y + next.y) / 2;

        array[x][y] = 0;
    }

    private Robot randNext(Robot current) {
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

    public boolean canUp(Robot robot) {
        return robot.x - 2 > 0;
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
}
