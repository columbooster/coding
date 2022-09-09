import java.util.Scanner;

public class Split {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        String[] arr = str.split("");

        sc.close();



        for(int i = 0; i < str.length(); i++) {
            System.out.print(arr[i]);
            if( i % 10 == 9) {
                System.out.println();
            }
        }
    }

}