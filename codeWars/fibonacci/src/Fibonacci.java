package codeWars.fibonacci.src;


public class Fibonacci {
    private static int contador;

    public Fibonacci(){
    }

    public int getContador(){
        return contador;
    }
    
    public static int fibo(int x){
        contador++;
        if(x==0){
            return 0;
        }else if(x==1){
            return 1;
        }else{
            return fibo(x-1) + fibo(x-2);
        }
    }
}