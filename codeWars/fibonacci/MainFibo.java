package codeWars.fibonacci;
import java.util.Scanner;

import codeWars.fibonacci.src.Fibonacci;


public class MainFibo {
    public static void main(String[] args) {
        Fibonacci obj = new Fibonacci();
        System.out.println(Fibonacci.fibo(10));
        System.out.println(obj.getContador());
        
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(Fibonacci.fibo(number));
        System.out.println(obj.getContador());
        sc.close();
    }
}
