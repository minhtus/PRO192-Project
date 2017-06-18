/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Tu Nguyen
 */
public class Student extends Person {
    private double grade;

    public Student(String code, String name, String address) {
        super(code, name, address);
    }
    
    

    public Student(double grade, String code, String name, String address) {
        super(code, name, address);
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
    
    @Override
    public String toString(){
        return super.toString() + "-" + this.grade;
    }
    
    //public int compareTo(Student s)
    //public boolean isValid(Student s)
            
}
    
