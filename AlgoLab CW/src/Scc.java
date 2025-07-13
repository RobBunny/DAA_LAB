import java.util.Scanner;

public class Scc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        int mat[][] = new int[r][c];
        for(int i=0; i<r; i++) {
            String input = sc.nextLine();
            String[] values = input.split(",");
            for(int j=0; j<c; j++) {
                mat[i][j] = Integer.parseInt(values[j]);
            }
        }
        int perimeter = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(mat[i][j] == 1) {
                    perimeter += 4;
                    if(i>0 && mat[i-1][j] == 1) perimeter -= 2;
                    if(j>0 && mat[i][j-1] == 1) perimeter -= 2;
                }
            }
        }
        System.out.println(perimeter);
        sc.close();
    }
}