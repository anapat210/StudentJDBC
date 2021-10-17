/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabase;

/**
 *
 * @author asus
 */
public class Student {
    private int id;
    private String name;
    private double gpa;
    public Student(){}
    
    public Student(int id, String name, double gpa){
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }
    
    
    
}
