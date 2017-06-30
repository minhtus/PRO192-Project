/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.File;

/**
 *
 * @author Tu Nguyen
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f = new File("in_students.txt");
        // f = new File("empty.txt");
        Professor pr = new Professor();
        boolean ok = pr.addAllStudent(f);
        Student s = new Student(10, new SimpleDate(20, 10, 2000), "ST000", "name", "address");
        pr.addStudent(s);
        
        pr.displayAllStudents();
        System.out.println(((Student) pr.getArr().get(pr.getArr().size()-1)).toString());
    }
    
}
