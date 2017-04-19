/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;
import java.util.*;

/**
 *
 * @author yabrol
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        Fib f = new Fib();
        System.out.println(f.fibonacci(n));
    }
    
}

class Fib {
    public ArrayList<Integer> fib; 
    
    public Fib(){
        fib = new ArrayList();
        fib.add(0, 0);
        fib.add(1, 1);
    }

    public int fibonacci(int n) {
        // Complete the function.
        if (n > fib.size()-1)
            fib.add(n, fibonacci(n-1) + fibonacci(n-2)); 
        return (fib.get(n));
    }
}
