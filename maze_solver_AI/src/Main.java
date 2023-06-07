import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            File dosya = new File("/Users/tufan/Downloads/text/url2.txt");
            Scanner scanner = new Scanner(dosya);

            int satir = scanner.nextInt();
            int sutun = scanner.nextInt();

            int[][] matris = new int[satir][sutun];

            for (int i = 0; i < satir; i++) {
                for (int j = 0; j < sutun; j++) {
                    matris[i][j] = scanner.nextInt();
                }
            }

            scanner.close();

            // Matrisi ekrana yazdırma örneği
            for (int i = 0; i < satir; i++) {
                for (int j = 0; j < sutun; j++) {
                    System.out.print(matris[i][j] + " ");
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı!");
            e.printStackTrace();
        }

    }

}

