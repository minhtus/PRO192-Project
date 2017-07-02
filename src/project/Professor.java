/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tu Nguyen, NhanTTSE63103
 */
public class Professor extends Person {

    private int experience;
    private int basicSalary = 1000;
    private PositionEnum pos;
    private EducationLevel edu;
    private ArrayList<Person> arr;
    private int count;
    private static int STEP = 3;
    private static double COF = 0.3;

    {
        // inital block
        experience = 0;
        pos = PositionEnum.PROFESSOR;
        edu = EducationLevel.BACHELOR;
        arr = new ArrayList<>();
        count = 0;
    }

    public Professor() {
    }

    public Professor(String code, String name, String address) {
        super(code, name, address);
    }

    public Professor(int experience, int basicSalary, PositionEnum pos, EducationLevel edu, ArrayList<Person> arr, int count, String code, String name, String address) {
        super(code, name, address);
        this.experience = experience;
        this.basicSalary = basicSalary;
        this.pos = pos;
        this.edu = edu;
        this.arr = arr;
        this.count = count;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
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

    public ArrayList<Person> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Person> arr) {
        this.arr = arr;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + this.experience + " | " + getRealSalary(this);
    }

    // Class Method
    /**
     * Professor method, calculate real Salary of a professor
     *
     * @param p A professor object wanted to know it's real salary
     * @return Real salary of professor p
     */
    public static double getRealSalary(Professor p) {
        return p.basicSalary * (p.experience / STEP) * (1 + COF) * (1 + p.getPos().getSUPPOS()) * (1 + p.getEdu().getSUPLEV());
    }

    /**
     * Professor method, calculate annual income of a professor
     *
     * @param p A professor object wanted to know it's annual income
     * @return Annual income of professor p
     */
    public static double getAnnualIncome(Professor p) {
        return Professor.getRealSalary(p) * 12 * (1 - Professor.getTAX());
    }

    // Manage Student Methods
    /**
     * Additional Professor method #1 Parse a line of professor data to this
     * professor's fields
     *
     * @param s Data string to parse to professor's fields
     * @return True if parsing successful
     * @throws project.FormatException
     */
    public boolean parseProfessor(String s) throws FormatException {
        if (s == null || s.length() == 0) {
            throw new FormatException("Empty professor data line");
        }
        String delimiter = "\\s+\\|\\s+"; // \s+: spaces; \|: vertical bar
        String[] spl = s.split(delimiter, 8); // take only 8 tokens, separated by '|'
        if (spl.length < 8) {
            throw new FormatException("Professor line has wrong format"); // wrong format string
        }
        if (Professor.isCodeStandard(spl[0], "PR")) {
            this.setCode(spl[0]); // may throw FormatException here
        }
        this.setName(spl[1]);
        this.setAddress(spl[2]);
        try {
            this.setExperience(Integer.parseInt(spl[3]));
            this.setBasicSalary(Integer.parseInt(spl[4]));
            this.setPos(PositionEnum.valueOf(spl[5]));
            this.setEdu(EducationLevel.valueOf(spl[6]));
            this.setCount(Integer.parseInt(spl[7])); // count is number of student in file, not in arr
        } catch (Exception e) {
            throw new FormatException("Error reading professor data!");
        }
        return true;
    }

    /**
     * Add a new student to Student List
     *
     * @param s New student to add to Student List
     * @return Return true if adding successful
     */
    public boolean addStudent(Student s) {
        if (s == null) {
            System.out.println("Error: Wrong data of student!");
            System.out.println("Add new student fail!");
            return false;
        } // not a student
        /////////////////////////////////////////////////////// check s.code must be unique
        if (!this.arr.add(s)) {
            return false; // add method of ArrayList returns a boolean value
        }
        System.out.println("New student has been added!");
        return true;
    }

    /**
     * Access input data file and load all data to professor object
     *
     * @param f Data file store data to be loaded
     * @return Return true if loading successful
     */
    public boolean addAllStudent(File f) {
        ArrayList<Person> tmp = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String pLine = br.readLine(); // read first line of file: information of professor
            this.parseProfessor(pLine); // parse pLine to this professor, may throw FormatException here 
            for (int i = 0; i < this.count; ++i) { // start reading student lines
                String sLine = br.readLine(); // read student lines
                Student student = new Student();
                student.parseStudent(sLine); // parse String sLine to Stduent student, may throw exception
                if (!tmp.add(student)) {
                    return false; // adding error
                }
            }
        } catch (FileNotFoundException ex) { // catch file not found, compile exception
            System.out.println("File not found!");
            return false;
        } catch (IOException ex) { // catch br.readLine() error, compile exception
            System.out.println("Error reading file!");
            return false;
        } catch (FormatException ex) {
            System.out.println(ex.getMessage()); // error format of file, runtime exception
            return false;
        }

        this.arr.addAll(tmp);
        System.out.println("All students from " + f.getName() + " have been added successful!");
        return true;
    }

    /**
     * Remove a specific student by given code
     *
     * @param code Code of student to delete
     * @return true if remove successful
     */
    public void removeStudent(String code) {
        Student st = findStudent(code); //find student to remove
        if (st == null) {
            System.out.println("No student " + code + "found!");
        }
        else {
            System.out.println("Do you want to remove student " + code + " (Y/N)?");//confirm
            Scanner sc = new Scanner(System.in);
            char cf;
            cf = sc.next().charAt(0);
            switch (cf) {
                case 'Y':
                case 'y':
                    this.arr.remove(st);//remove student
                    System.out.println("Student " + code + " successfully remove!");
                    break;
                case 'N':
                case 'n':
                    System.out.println("Cancel, student " + code + " still in list ");//remove cancel by user
                    break;
                default:
                    System.out.println("Invalid choice! ");
                    break;
            }
            sc.close();

        }
    }
    /**Remove Invalid Student in list
     * 
     */
    public void removeInvalid(){
        int count = 0;
        System.out.println("Do you want to remove all invalid date Student in list (Y/N)?");
        char c;
        Scanner sc = new Scanner(System.in);
        c = sc.next().charAt(0);
        if ( c == 'Y' || c == 'y'){
        for (int i=0; i<arr.size(); ++i){
            if ( ((Student)arr.get(i)).isValid() ){
                System.out.println("Student " + ((Student)arr.get(i)).name + " is not valid: " + ((Student)arr.get(i)).getValid());
                arr.remove(arr.get(i));
                count++;
            }
        }
            System.out.println("Remove " + count + " invalid datestudent in list successful");
        }
        else if ( c == 'N' || c == 'n'){
            System.out.println("Cancel, all student still in list");
        }
        else
            System.out.println("Invalid choice!");
    }

    /**
     * Find a specific student by given code
     *
     * @param code Code of student to find
     * @return Found student or null
     */
    public Student findStudent(String code) {
        for (int i = 0; i < this.arr.size(); ++i) {
            if (arr.get(i).code.equals(code)) {
                return (Student) arr.get(i);
            }
        }
        return null;
    }

    /**
     * Update a student with given code
     *
     * @param code Code of student to update
     */
    public void updateStudent(String code) {
        Student st = findStudent(code); // student to be updated
        if (st == null) {
            System.out.println("No student " + code + " found!");
            return;
        }
        Student clone = new Student(); // clone student st, in case update fail
        clone.setCode(st.getCode());
        if (Student.updateStudent(clone)) {
            st = clone; // update successful, change reference of st to clone, leave old st to Java Gargabe Collection
            System.out.println("Update student " + st.getCode() + " successful!");
        } else {
            System.out.println("Update student " + st.getCode() + " fail!");
        }
    }

    /**
     * Display the student list
     */
    public void displayAllStudents() {
        System.out.println("*** All students in the list of professor " + this.name + " ***");
        for (int i = 0; i < arr.size(); ++i) {
            System.out.println("No." + i + " || " + arr.get(i).toString());
        }
        System.out.println("*** End of list");
    }
}
