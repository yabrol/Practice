/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evenfibonaccinumbers;

/**
 *
 * @author Yukti
 */
public class EvenFibonacciNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int max = 4000000;
        int curr = 2;
        int fib1 = 1;
        int fib2 = 2;
        int fibonacci = 3;
        while( fibonacci < max){
            if( fibonacci %2 == 0)
            {
               curr += fibonacci; 
            }
            
            fib1 = fib2;
            fib2 = fibonacci;
            fibonacci = fib1 + fib2;
        }
        System.out.println(curr);
    }
    
}
