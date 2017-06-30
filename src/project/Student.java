/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Tu Nguyen, NhanTTSE63103
 */

import java.time.LocalDateTime;
import java.util.Calendar;
public class Student extends Person implements Comparable {

    private double grade;
    private SimpleDate valid;
    
    public static final int expireYear = 6;

    {
        // initial block
        grade = 0.0;
        valid = new SimpleDate(0, 0, 0);
    }
    public Student() {
    }

    public Student(String code, String name, String address) {
        super(code, name, address);
    }

    public Student(double grade, SimpleDate valid, String code, String name, String address) {
        super(code, name, address);
        this.grade = grade;
        this.valid = valid;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public SimpleDate getValid() {
        return valid;
    }

    public void setValid(SimpleDate valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + this.grade;
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

    /**
     * Check valid date of student
     * @return Return true if this student has study in no more than 6 year from 'valid' date until now
     */
    public boolean isValid(){
        LocalDateTime now = LocalDateTime.now();
        int studyYear = now.getYear() - this.valid.getDayOfMonth();
        if (studyYear > expireYear) return false;
        if (studyYear < expireYear) return true;
        // studyYear == expireYear, deeper check valid
        if (now.getMonthValue() > this.valid.getMonthValue()) return false;
        if (now.getMonthValue() < this.valid.getMonthValue()) return true;
        // now.month == valid.month, check day of month
        return now.getDayOfMonth() < this.valid.getDayOfMonth();
    }
    
    public boolean parseStudent(String s) throws FormatException {
        if (s==null || s.length()==0) 
            throw new FormatException("Empty student data line");
        String delimiter = "\\s+\\|\\s+"; // \s+: spaces; \|: vertical bar
        String[] spl = s.split(delimiter, 5); // take only 5 tokens, separated by '|'
        if (spl.length < 5) throw new FormatException("Student line has wrong format"); // wrong format string
        
        if (Student.isCodeStandard(spl[0], "ST")) this.setCode(spl[0]); // may throw FormatException here
        this.setName(spl[1]);
        this.setAddress(spl[2]);
        try {
            this.setGrade(Double.parseDouble(spl[3]));
            this.setValid(SimpleDate.parseSDate(spl[4]));
        } catch (Exception e) {
            throw new FormatException("Error reading student data!");
        }
        return true;
    }
}
