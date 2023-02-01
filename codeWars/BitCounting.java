package codeWars;
import java.util.ArrayList;
public class BitCounting {

	/**
	 * @param n entero positivo
	 * @return el número de bits=1 en binario de n
     * Hago un ArrayList porque no sé qué tamaño tendrá, 
     * aunque luego pienso es más sencillo ir contando 1s,
     * así que no reordeno el ArrayList para sacar el n en binario.
	 */
	public static int countBits(int n){
		// Show me the code!
    ArrayList<int> binarios = new ArrayList<int>();
    int contador = 1;
    if(n==0){   
      return 0;      
      }else if(n==1){
            binarios.add(1);
            return 1;
          }else{
              while(n>1){
                if (binarios%2==1){
                  contador++;
                }
                  binarios.add(n%2);
                  n = n/2;
                  if(n==1){
                    binarios.add(1);
                    return contador;
                  }
              }
          }
    }
	
}