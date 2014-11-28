/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largestprimefactor;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Yukti
 */
public class LargestPrimeFactor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BigInteger max = new BigInteger("600851475143");
        BigInteger i = new BigInteger("3");
        ArrayList<BigInteger> list = new ArrayList();
        while (max.compareTo(i.multiply(i)) != -1) {
            if (max.mod(i)) {

            }
        }
    }

    

}
