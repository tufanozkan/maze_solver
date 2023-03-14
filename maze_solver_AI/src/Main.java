import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Robot robot= new Robot(11);
        Scanner input = new Scanner (new File("C:\\Users\\cagan\\OneDrive\\Masaüstü\\url2.txt"));
        // pre-read in the number of rows/columns
        int rows = 0;
        int columns = 0;
        while(input.hasNextLine())
        {
            ++rows;
            Scanner colReader = new Scanner(input.nextLine());
            while(colReader.hasNextInt())
            {
                ++columns;
            }
        }
        int[][] a = new int[rows][columns];

        input.close();

// read in the data
        input = new Scanner(new File("C:\\Users\\cagan\\OneDrive\\Masaüstü\\url2.txt"));
        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < columns; ++j)
            {
                if(input.hasNextInt())
                {
                    a[i][j] = input.nextInt();
                }
            }
        }

        System.out.println(a);
    }
}