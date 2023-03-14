import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Grid {
    int size;
    public Grid(){
        size=10;
    }

    public Grid(int size){
        this.size=size;
    }

    public void FileReader() throws IOException {
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

        }
}


