package codeWars;
import java.util.Scanner;

class Fibonacci {
    public static void main(String[] args) {
        int contador = 0;
        System.out.println(fibo(10));
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(fibo(number));
        sc.close();
    }

    public static int fibo(int x){
        if(x==0){
            return 0;
        }else if(x==1){
            return 1;
        }else{
            return fibo(x-1) + fibo(x-2);
        }
    }
}