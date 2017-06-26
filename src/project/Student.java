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
import java.util.Date;
public class Student extends Person implements Comparable {

    private double grade;
    private Date valid;

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

    public Date getValid() {
        return valid;
    }

    public void setValid(Date valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return super.toString() + "-" + this.grade;
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student) o;
        if (this.grade > s.getGrade()) {
            return 1;
        } else if (this.grade == s.getGrade()) {
            return 0;
        } else {
            return -1;
        }
    }

    //public boolean isValid(Student s){
        //DateFormat dFormat = new simpleDateFormat("yyyy/MM/dd");
        
}
