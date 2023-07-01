package HungarianAlgorithm;
import java.util.Scanner;

public class mainProg extends methods {
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private static final String ANSI_RESET = "\u001B[0m";

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] array = new int[0][0];
        System.out.println("=======[HUNGARIAN ALGORITHM]========");
        System.out.println("Main Menu:");
        System.out.println("1. Test menggunakan angka random");
        System.out.println("2. Input cost matriks");
        System.out.println("3. Cancel");
        System.out.print("Pilihan Anda: ");
        int choice = scanner.nextInt();
        if(choice <= 0 || choice > 3) System.out.println("ERROR: Invalid input!");
        else if(choice == 1) array = calculateByRandomMatrix();
        else if(choice == 2) array = calculateByUserInput();
        else if(choice == 3) System.exit(0);

        if(!(array.length == 0)){
            methods hg = new methods();
            
            int finalOptimumRes = hg.findResult(array, array.length); //Optimum result
            System.out.printf("Hasil optimal: %d\n", finalOptimumRes);
    
            System.out.println("Rinciannya yaitu sebagai berikut: ");
            for(int i = 0; i < hg.xy.length; i++){
                System.out.printf("Baris ke-%d adalah nilai kolom ke-%d dengan nilai %d\n", i+1, hg.xy[i] + 1, array[i][hg.xy[i]]);
            }
            System.out.println("\nMapping optimal assignment pada matriks original: \n(angka yang di-highlight adalah optimal assignment setiap baris)");
            for(int i = 0; i < array.length; i++){
                for(int j = 0; j < array[i].length; j++){
                    if(hg.xy[i] == j) System.out.printf("%s%d%s\t", ANSI_CYAN_BACKGROUND, array[i][j], ANSI_RESET);
                    else System.out.printf("%d\t", array[i][j]);
                }
                System.out.println();
            }
        }
    }
    public static int[][] calculateByRandomMatrix(){ 
        int[][] array = new int[0][0];

        System.out.println("Pilih ukuran matriks yang diinginkan: ");
        for(int i = 1; i <= 9; i++){
            System.out.printf("%d. %dx%d\n", i, i+1, i+1);
        }
        System.out.println("10. Cancel");
        System.out.print("Masukkan pilihan Anda: ");
        int choice = scanner.nextInt();
        if(choice > 10 || choice <= 0) System.out.println("ERROR: Invalid input");
        else if(choice == 10) main(null);
        else {
            array = new int[choice+1][choice+1];

            for(int i = 0; i < array.length; i++){
                for(int j = 0; j < array[i].length; j++){
                    array[i][j] = (int)(Math.random() * 98) + 1;
                }
            }

            System.out.println("USERINFO: Successfully generated random matriks");
            for(int i = 0; i < array.length; i++){
                for(int j = 0; j < array[i].length; j++){
                    System.out.printf("%d\t", array[i][j]);
                }
                System.out.println();
            }
        }
        return array;
    }
    public static int[][] calculateByUserInput(){
        System.out.print("Masukkan jumlah worker dan jumlah assignment: ");
        int n = scanner.nextInt();
        int[][] array = new int[n][n];

        System.out.println("Masukkan cost matrix secara berurutan: (enter untuk value baris selanjutnya)");
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                array[i][j] = scanner.nextInt();
            }
        }

        return array;
    }
}
