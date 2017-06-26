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
public class Professor extends Person{
    private int experience;
    private int basicsalary = 1000;
    private PositionEnum pos;
    private EducationLevel edu;
    private String[] Student;
    private int count;
    private static int basicSalary;

    public Professor(String code, String name, String address) {
        super(code, name, address);
    }

    public Professor(int experience, PositionEnum pos, EducationLevel edu, String[] Student, int count, String code, String name, String address) {
        super(code, name, address);
        this.experience = experience;
        this.pos = pos;
        this.edu = edu;
        this.Student = Student;
        this.count = count;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(int basicsalary) {
        this.basicsalary = basicsalary;
    }

    public PositionEnum getPos() {
        return pos;
    }

    public void setPos(PositionEnum pos) {
        this.pos = pos;
    }

    public EducationLevel getEdu() {
        return edu;
    }

    public void setEdu(EducationLevel edu) {
        this.edu = edu;
    }

    public String[] getStudent() {
        return Student;
    }

    public void setStudent(String[] Student) {
        this.Student = Student;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public static double realSalary(Professor p){
        
        //double realSalary = basicSalary * (experience/STEP) * COF * SUPPOS * SUPLEV;
        return realSalary;
    }
    
    
    
}
