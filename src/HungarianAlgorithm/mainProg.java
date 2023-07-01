package HungarianAlgorithm;
import java.util.Scanner;

public class mainProg extends methods {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Masukkan jumlah worker dan jumlah assignment: ");
        int n = scanner.nextInt();
        int [][] array = new int[n][n];

        System.out.println("Masukkan cost matrix secara berurutan: (enter untuk value baris selanjutnya)");
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                array[i][j] = scanner.nextInt();
            }
        }
        
        methods hg = new methods();

        int finalOptimumRes = hg.findResult(array, n); //Optimum result
        System.out.printf("Hasil optimal: %d\n", finalOptimumRes);

        System.out.println("Rinciannya yaitu sebagai berikut: ");
        for(int i = 0; i < hg.xy.length; i++){
            System.out.printf("Baris ke-%d adalah nilai kolom ke-%d dengan nilai %d\n", i+1, hg.xy[i] + 1, array[i][hg.xy[i]]);
        }
    }
}
