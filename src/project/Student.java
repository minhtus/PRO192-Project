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
import java.util.Comparator;
import java.util.Scanner;

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
        // compare Student by grade, but cannot use in Collections<Person>
        // this compareTo can just use in Collections<Student>
        Student s = (Student) o;
        if (this.grade > s.getGrade()) {
            return 1;
        } else if (this.grade == s.getGrade()) {
            return 0;
        } else {
            return -1;
        }
    }

    //add another comparator, compare Student by Code
    public static Comparator compareCode = (Comparator) (Object s1, Object s2) -> {
        Student st1 = (Student) s1;
        Student st2 = (Student) s2;
        return st1.code.compareTo(st2.code);
    };

    //add another comparator, compare Student by name
    public static Comparator compareName = (Comparator) (Object s1, Object s2) -> {
        Student st1 = (Student) s1;
        Student st2 = (Student) s2;
        return st1.name.compareTo(st2.name);
    };
    
    //add another comparator, compare Student by grade
    public static Comparator compareGrade = (Comparator) (Object s1, Object s2) -> {
        Student st1 = (Student) s1;
        Student st2 = (Student) s2;
        if (st1.grade < st2.grade) return 1;
        else if (st1.grade > st2.grade) return -1;
        return 0;
    };

    /**
     * Check valid date of student
     *
     * @return Return true if this student has study in no more than 6 year from 'valid' date until now
     */
    public boolean isValid() {
        LocalDateTime now = LocalDateTime.now();
        int studyYear = now.getYear() - this.valid.getYear(); 
        if (studyYear > expireYear) {
            return false;
        }
        if (studyYear < expireYear) {
            return true;
        }
        // studyYear == expireYear, deeper check valid
        if (now.getMonthValue() > this.valid.getMonthValue()) {
            return false;
        }
        if (now.getMonthValue() < this.valid.getMonthValue()) {
            return true;
        }
        // now.month == valid.month, check day of month
        return now.getDayOfMonth() < this.valid.getDayOfMonth();
    }

    /**
     * Parse a string to a student object
     * @param s String contains data to parse
     * @return True if parsing successful
     * @throws FormatException Error parsing data
     */
    public boolean parseStudent(String s) throws FormatException {
        if (s == null || s.length() == 0) {
            throw new FormatException("Empty student data line");
        }
        String delimiter = "\\s+\\|\\s+"; // \s+: spaces; \|: vertical bar
        String[] spl = s.split(delimiter, 5); // take only 5 tokens, separated by '|'
        if (spl.length < 5) {
            throw new FormatException("Student line has wrong format"); // wrong format string
        }
        if (Student.isCodeStandard(spl[0], "ST")) {
            this.setCode(spl[0]); // may throw FormatException here
        }
        this.setName(spl[1]);
        this.setAddress(spl[2]);
        try {
            this.setGrade(Double.parseDouble(spl[3]));
            Student.validGrade(this.getGrade());
            this.setValid(SimpleDate.parseSDate(spl[4]));
        } catch (NumberFormatException | FormatException e) {
            throw new FormatException("Error reading student data!");
        }
        return true;
    }

    /**
     * Update name, address, grade, valid of student st
     * from 'original' student
     * @param st Student to be updated
     * @param original Original student object
     * @return True if update successful
     */
    public static boolean updateStudent(Student st, Student original) {
        Scanner sc = new Scanner(System.in);
        if (original != null) System.out.println("NOTE: type 'skip' to skip updating that information!");
        try {
            System.out.print("Enter student name: ");
            String name = sc.nextLine(); 
            name = Person.trimName(name);
            if (!name.equalsIgnoreCase("skip")) st.name = name;
            else if (original != null) st.name = original.name;
            System.out.print("Enter student address: ");
            String address = sc.nextLine();
            if (!address.equalsIgnoreCase("skip")) st.address = address;
            else if (original != null) st.address = original.address;
            System.out.print("Enter student grade (double): ");
            String grade = sc.nextLine();
            if (!grade.equalsIgnoreCase("skip")) {
                st.grade = Double.parseDouble(grade);
                Student.validGrade(st.grade);
            }
            else if (original != null) st.grade = original.grade;
            System.out.println("Enter student enrolled date (day/month/year):");
            System.out.print("Enter day: ");
            String sDay = sc.nextLine();
            int day = 0, month = 0, year = 0;
            if (!sDay.equalsIgnoreCase("skip")) day = Integer.parseInt(sDay);
            else if (original != null) day = original.getValid().getDayOfMonth();
            System.out.print("Enter month: ");
            String sMonth = sc.nextLine();
            if (!sMonth.equalsIgnoreCase("skip")) month = Integer.parseInt(sMonth);
            else if (original != null) month = original.getValid().getMonthValue();
            System.out.print("Enter year: ");
            String sYear = sc.nextLine();
            if (!sYear.equalsIgnoreCase("skip")) year = Integer.parseInt(sYear);
            else if (original != null) year = original.getValid().getYear();
            st.valid = new SimpleDate(day, month, year);
            SimpleDate.isValidDate(st.valid); // check valid date
        } catch (NumberFormatException | FormatException ex) {
            st = null;
            System.out.println(ex);
            return false;
        } 
        return true;
    }

    /**
     * Create a new student with data retrieve from keyboard
     *
     * @return a new student
     */
    public static Student newStudent() {
        Scanner sc = new Scanner(System.in);
        Student st = new Student();
        try {
            System.out.print("Enter student code (STxxx): ");
            String code = sc.nextLine();
            if (Person.isCodeStandard(code, "ST")) {
                st.code = code;
            }
            if (!Student.updateStudent(st, null)) {
                st = null;
            }
        } catch (FormatException ex) {
            st = null;
            System.out.println(ex.getMessage());
        }   
        return st;
    }
    
    /**
     * Move all data from t to this student
     * @param t Source student to get data
     */
    public void update(Student t) {
       this.code = t.code;
       this.name = t.name;
       this.address = t.address;
       this.grade = t.grade;
       this.valid = t.valid;
    }
    
    /**
     * Check grade must be in range [0, 10]
     * @param g Grade to be checked
     * @throws FormatException 
     */
    public static void validGrade(Double g) throws FormatException {
        if (g < 0 || g > 10) throw new FormatException("Error: Grade must be in range: [0..10]!");
    }
}
