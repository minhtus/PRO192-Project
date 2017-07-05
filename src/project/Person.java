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
public class Person {
    protected String code;
    protected String name;
    protected String address;
    
    protected static double TAX=0.1;

    public Person() {
    }
    
    public Person(String code, String name, String address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }

    public static double getTAX() {
        return TAX;
    }

    public static void setTAX(double TAX) {
        Person.TAX = TAX;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }    
    
    @Override
    public String toString(){
        return this.code + " | " + this.name + " | " + this.address;
    }
    
    /**
     * Check if the string code is in format
     * @param c String code to be checked
     * @param start Prefix of string code, PR or ST
     * @return Return true if string code is in format
     * @throws FormatException if string code is in wrong format
     */
    public static boolean isCodeStandard(String c, String start) throws FormatException {
        FormatException exception = new FormatException();
        if (start.equals("PR")) exception.setMessage("Wrong professor code format.\nRight format: PRxxx, where xxx is 3-digit number in [000, 999]");
        if (start.equals("ST")) exception.setMessage("Wrong student code format.\nRight format: STxxx, where xxx is 3-digit number in [000, 999]");
        if (c==null) throw exception;
        String patt = "(?i)" + start + "(\\d{3})"; // (?i) for incase-sensitve, (\\d{3}) for 3 digits
        if (c.matches(patt)) { // has the right format
            int num = Integer.parseInt(c.replaceAll(patt, "$1")); // get the number after 'start'
            if (num > 999) throw exception; // exceed 999
        } else throw exception;
        return true;
    }
    
    /**
     * Beautify Person name
     * @param name Name to trim
     * @return trimmed name
     */
    public static String trimName(String name) {
        name = name.trim(); // remove first and last spaces
        String delimiter = "\\s+";
        String[] tokens = name.split(delimiter);
        name = ""; // construct name in format
        for (int i=0; i<tokens.length-1; ++i) name = name + tokens[i] + " ";
        name = name + tokens[tokens.length-1];
        return name;
    }
}
