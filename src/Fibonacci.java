import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        System.out.println(Fibonacci(n));


    }

    public static int Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        else
            return Fibonacci(n - 1) + Fibonacci(n - 2);

    }

}
