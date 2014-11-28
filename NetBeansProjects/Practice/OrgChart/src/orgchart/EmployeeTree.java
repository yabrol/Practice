/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orgchart;

import java.util.ArrayList;

/**
 *
 * @author Yukti
 */
public class EmployeeTree {
    Employee head;
    String out = "";
    
    EmployeeTree(Employee firstEmployee){
        head = firstEmployee;
    }
    
    public static Employee findBoss (ArrayList<Employee> list){
        Employee x = new Employee();
        for(Employee p : list){
            if(p.getBoss().equalsIgnoreCase("null"))
                x = p;
        }
        return x;
    }
    
    public static ArrayList<Employee> findChildren (ArrayList<Employee> list, Employee boss){
        ArrayList<Employee> kids = new ArrayList<>();
        for (Employee x : list){
            if(x.getBoss().equalsIgnoreCase(boss.name))
                kids.add(x);
        }
        return kids;
    }
    
    public String printTree()
    {
        dfs(head, 0);
        
        return out;
    }
    
    public void dfs(Employee boss, int y){
        if(boss == null)
            return;
        String spaces = "";
        for(int q = 0; q < y; q++)
        {
            spaces += "-";
        }
        out += spaces + boss.name + " (" + boss.title + ") " + String.valueOf(boss.year) + "\n";
        boss.setVisted(true);
        y++;
        for( Employee x : boss.getChildren()){
            if (x.getVisited() == false)
            {
                dfs(x, y);
            }
        }   
    }
    
    public static void addAllChildren(ArrayList<Employee> list, Employee boss)
    {
        if(boss == null)
            return;
        ArrayList<Employee> kids = EmployeeTree.findChildren(list, boss);
        boss.addChildrenEmployee(kids);
        for (Employee x: kids)
        {
            addAllChildren(list, x);
        }
    }
    
}
