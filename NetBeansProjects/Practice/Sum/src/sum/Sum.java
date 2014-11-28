/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Abrol
 */
public class Sum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFileChooser chooser = new JFileChooser();
        //FileNameExtensionFilter filter = new FileNameExtensionFilter("Text "
        //        + "Files", "txt");
        //chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(chooser);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            FileReader fr = null;
            FileWriter fw = null;
            try {
                System.out.println("You chose to open this file: "
                        + chooser.getSelectedFile().getName());
                String path = chooser.getSelectedFile().getPath();
                fr = new FileReader(path);
                BufferedReader bf = new BufferedReader(fr);
                
                String line = null;
                ArrayList<String> text = new ArrayList<String>();
                
                String[] nums = new String[2];
                int x, y, z;
                int count = 0;
                
                String outPath = chooser.getSelectedFile().getPath();
                outPath = outPath.replaceFirst(".in", ".out");
                System.out.println("output file: " + outPath);
                
                File file = new File(outPath);
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
                fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);               
                
                while ((line = bf.readLine()) != null) {
                    if (count > 0) {
                        //do something to the lines
                        System.out.println(line);
                        text.add(line);
                        nums = line.split(" ");
                        x = Integer.parseInt(nums[0]);
                        y = Integer.parseInt(nums[1]);
                        z = x + y;
                        System.out.println(z);
                        bw.write("Case #" + count + "\n");
                        bw.write(String.valueOf(z));
                        bw.newLine();
                    }
                    count++;
                }
                bw.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Sum.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Sum.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fr.close();
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Sum.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}
