/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Tu Nguyen
 */
public class Project {
    public static void loadFile(Professor pr) {
        Scanner sc = new Scanner(System.in);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // test add all student OK - just need to check duplicate student code
        
        Menu menu = new Menu();
        menu.add("1. Add student");
        menu.add("2. Remove student");
        menu.add("3. Update student");
        menu.add("4. Find student");
        menu.add("5. Display students");
        menu.add("6. Display statistic");
        menu.add("7. Export student list to file");
        menu.add("8. About professor");
        menu.add("9. Quit");
        menu.addSubMenu(1, "1. Add a new student");
        menu.addSubMenu(1, "2. Import student list from file");
        menu.addSubMenu(2, "1. Remove a student");
        menu.addSubMenu(2, "2. Remove invalid students");
        menu.addSubMenu(5, "1. Display students sorted by student code");
        menu.addSubMenu(5, "2. Display students sorted by student name");
        menu.addSubMenu(5, "3. Display students sorted by student grade");
        menu.addSubMenu(5, "4. Display high grade students");
        menu.addSubMenu(5, "5. Display low grade students");
        menu.addSubMenu(6, "1. Display average grade");
        menu.addSubMenu(6, "2. Display distribution of grade");
        menu.addSubMenu(6, "3. Display distinct grade");
        menu.addSubMenu(6, "4. Display duplicate student names");
        menu.addSubMenu(6, "5. Display unique student names");
        menu.addSubMenu(8, "1. Update informantion of professor");
        menu.addSubMenu(8, "2. Display informantion of professor");
        
        Scanner sc = new Scanner(System.in);
        
        Professor pr  = new Professor(); 
        
        Project.loadFile(pr); // load initial data to run program
        System.out.println("\n============ Manage Student Program ============");
        
        do {
            menu.displayMenu();
            switch (menu.getChoice()) {
                case 1: System.out.println("\n=== Add student ===");
                        menu.displaySubMenu(1);
                        switch (menu.getChoice()) {
                            case 1: System.out.println("\n--> Add new student from keyboard"); 
                                    pr.addStudent(Student.newStudent());
                                    break;
                            case 2: System.out.println("\n--> Import students from file");
                                    System.out.print("Enter file name to import: ");
                                    File f = new File(sc.nextLine());
                                    if (!pr.addAllStudent(f)) System.out.println("Import students fail!");
                                    break;
                            default: System.out.println("\nNo option found");
                        } break;
                case 2: System.out.println("\n=== Remove student ===");
                        menu.displaySubMenu(2);
                        switch (menu.getChoice()) {
                            case 1: System.out.println("\n--> Remove a student by student code");
                            String code = sc.nextLine();
                            pr.removeStudent(code);
                            break;
                            case 2: System.out.println("\n--> Remove invalid students"); break;
                            default: System.out.println("\nNo option found");
                        } break;
                case 3: System.out.println("\n=== Update a student ==="); break;
                case 4: System.out.println("\n=== Find a student ==="); break;
                case 5: System.out.println("\n=== Display students ===");
                        menu.displaySubMenu(5);
                        switch (menu.getChoice()) {
                            case 1: System.out.println("\n--> Display students sorted by student code"); // ascending
                                    //pr.sort student list ascending by code
                                    pr.displayAllStudents();
                                    break; 
                            case 2: System.out.println("\n--> Display students sorted by student name"); // ascending
                                    //pr.sort student list ascending by name
                                    pr.displayAllStudents();
                                    break;
                            case 3: System.out.println("\n--> Display students sorted by student grade"); // descending
                                    //pr.sort student list descending by grade
                                    pr.displayAllStudents();
                                    break; 
                            case 4: System.out.println("\n--> Display highest grade students"); break;
                            case 5: System.out.println("\n--> Display lowest grade students"); break;
                            default: System.out.println("\nNo option found");
                        } break;
                case 6: System.out.println("\n=== Display statistic ===");
                        menu.displaySubMenu(6);
                        switch (menu.getChoice()) {
                            case 1: System.out.println("\n--> Display averaga grade"); break;
                            case 2: System.out.println("\n--> Display distribution of grade"); break;
                            case 3: System.out.println("\n--> Display distinct grade"); break;
                            case 4: System.out.println("\n--> Display duplicate student names"); break;
                            case 5: System.out.println("\n--> Display unique student names"); break;
                            default: System.out.println("\nNo option found");
                        } break;
                case 7: System.out.println("\n=== Export student list to file ==="); break;
                case 8: System.out.println("\n=== About professor ===");
                        menu.displaySubMenu(8);
                        switch (menu.getChoice()) {
                            case 1: System.out.println("\n--> Update information of professor"); break;
                            case 2: System.out.println("\n--> Display information of professor"); break;
                        } break;
                case 9: System.out.println("\n============ Good Bye ============"); return;
                default: System.out.println("\nNo option found");
            }
        } while (true);
    }
    
}
