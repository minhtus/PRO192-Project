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
        if (start.equals("PR")) exception.setMessage("Wrong professor code format.\nRight format: PRxxx, where xxx is number in [0, 999]");
        if (start.equals("ST")) exception.setMessage("Wrong student code format.\nRight format: STxxx, where xxx is number in [0, 999]");
        if (c==null) throw exception;
        if (c.length()==0) throw exception;
        if (!c.startsWith(start)) throw exception;
        String suffix = c.substring(2); // get the number after 'start': PR or ST
        if (suffix.length()==0) throw exception;
        try {
            if (Integer.parseInt(suffix) > 999) throw exception; // exceed 999
        } catch (NumberFormatException e) { // runtime exception
            throw exception;
        }
        return true;    // code c in right format
    }
    
    // trim person name
}
