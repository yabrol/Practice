/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orgchart;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Yukti
 */
public class Employee implements Comparable{
    String name;
    String boss;
    String title;
    int year;
    ArrayList<Employee> children = new ArrayList<Employee>();
    boolean visited = false;
    
    public Employee(String name1, String boss1, String title1, int year1)
    {
        name = name1;
        boss = boss1;
        title = title1;
        year = year1;
    }
    
    public Employee()
    {
        name = "";
        boss = "";
        title = "";
        year = 0;
    }
    
    public void addChildrenEmployee(ArrayList<Employee> child)
    {
        children.addAll(child);
    }
    
       
    //accessor methods
    public String getName(){
        return name;
    }
    public String getBoss(){
        return boss;
    }
    public String getTitle(){
        return title;
    }
    public int getYear(){
        return year;
    }
    public ArrayList<Employee> getChildren(){
        Collections.sort(children);
        return children;
    }
    public boolean getVisited()
    {
        return visited;
    }
    
    //mutator methods
    public void setName(String name1){
        name = name1;
    }
    public void setBoss(String boss1){
        boss = boss1;
    }
    public void setTitle(String title1){
        title = title1;
    }
    public void setYear(int year1){
        year = year1;
    }
    public void setVisted (boolean state){
        visited = state;
    }

    @Override
    public int compareTo(Object o) {
        Employee e = (Employee)o;
        return this.name.compareTo(e.name);
    }
    
}
