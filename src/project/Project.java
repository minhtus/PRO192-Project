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
        
        Student s = new Student(10, new SimpleDate(20, 10, 2000), "ST000", "name", "address");
        pr.addStudent(s);
        
        //boolean ok = pr.addAllStudent(f);
        
        pr.displayAllStudents();
        //System.out.println(((Student) pr.getArr().get(pr.getArr().size()-1)).toString());
        
        // test newStudent
        System.out.println("Add a new student");
        pr.addStudent(Student.newStudent());
        System.out.println();
        pr.displayAllStudents();
        // test updateStudent
        System.out.println("Update student");
        pr.updateStudent("ST999");
        pr.displayAllStudents();
        
        
        Menu menu = new Menu();
        menu.add("1. Add student");
        menu.add("2. Remove student");
        menu.add("3. Update student");
        menu.add("4. Find student");
        menu.add("5. Display students");
        menu.add("6. Display statistic");
        menu.add("7. Export student list to file");
        menu.add("8. Quit");
        menu.addSubMenu(1, "1. Add a new student");
        menu.addSubMenu(1, "2. Import student list from file");
        menu.addSubMenu(2, "1. Remove a student");
        menu.addSubMenu(2, "2. Remove invalid students");
        menu.addSubMenu(5, "1. Display high grade students");
        menu.addSubMenu(5, "2. Display low grade students");
        menu.addSubMenu(6, "1. Display average grade");
        menu.addSubMenu(6, "2. Display distribution of grade");
        menu.addSubMenu(6, "3. Display distinct grade");
        menu.addSubMenu(6, "4. Display duplicate student names");
        menu.addSubMenu(6, "5. Display unique student names");
        
        do {
            menu.displayMenu();
            switch (menu.getChoice()) {
                case 1: System.out.println("\n=== Add student ===");
                        menu.displaySubMenu(1);
                        switch (menu.getChoice()) {
                            case 1: System.out.println("--> Add new student from keyboard"); break;
                            case 2: System.out.println("--> Import student from file"); break;
                            default: System.out.println("No option found");
                        } break;
                case 2: System.out.println("\n=== Remove student ===");
                        menu.displaySubMenu(2);
                        switch (menu.getChoice()) {
                            case 1: System.out.println("--> Remove a student by student code"); break;
                            case 2: System.out.println("--> Remove invalid students"); break;
                            default: System.out.println("No option found");
                        } break;
                case 3: System.out.println("\n=== Update a student ==="); break;
                case 4: System.out.println("\n=== Find a student ==="); break;
                case 5: System.out.println("\n=== Display students ===");
                        menu.displaySubMenu(5);
                        switch (menu.getChoice()) {
                            case 1: System.out.println("--> Display high grade students"); break;
                            case 2: System.out.println("--> Displya low grade students"); break;
                            default: System.out.println("No option found");
                        } break;
                case 6: System.out.println("\n=== Display statistic ===");
                        menu.displaySubMenu(6);
                        switch (menu.getChoice()) {
                            case 1: System.out.println("--> Display averaga grade"); break;
                            case 2: System.out.println("--> Display distribution of grade"); break;
                            case 3: System.out.println("--> Display distinct grade"); break;
                            case 4: System.out.println("--> Display duplicate student names"); break;
                            case 5: System.out.println("--> Display unique student names"); break;
                            default: System.out.println("No option found");
                        } break;
                case 7: System.out.println("\n=== Export student list to file ==="); break;
                case 8: System.out.println("\n=== Good Bye ==="); return;
                default: System.out.println("\nNo option found");
            }
        } while (true);
    }
    
}
