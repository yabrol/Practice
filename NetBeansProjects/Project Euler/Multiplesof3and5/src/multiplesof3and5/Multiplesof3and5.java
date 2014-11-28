/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplesof3and5;

import java.util.Scanner;

/**
 *
 * @author Yukti
 */
public class Multiplesof3and5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("up to what natural number?");
        int max = (new Scanner(System.in)).nextInt();
        int curr = 0;
        for( int i = 0; i < max; i++)
        {
            if( i%3 == 0 || i%5 == 0)
            {
                curr += i;
            }
        }
        System.out.println(curr);
        
        
    }
    
}
