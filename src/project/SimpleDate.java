/*
Class SimpleDate provides a simple way to represent a date object
A date object contains fields: dayOfMonth, monthValue, year
*/
package project;

import java.time.LocalDateTime;

/**
 *
 * @author NhanTTSE63103 - Tran Thanh Nhan
 */
public class SimpleDate {
    private int dayOfMonth, monthValue, year;

    public SimpleDate() {
    }

    public SimpleDate(int dayOfMonth, int monthValue, int year) {
        this.dayOfMonth = dayOfMonth;
        this.monthValue = monthValue;
        this.year = year;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getMonthValue() {
        return monthValue;
    }

    public void setMonthValue(int monthValue) {
        this.monthValue = monthValue;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    /**
     * 
     * @return Date in format: "dd/mm/yyyy"
     */
    public String toString() {
        return dayOfMonth + "/" + monthValue + "/" + year;
    }
    
    /**
     * Parse a string to a SimpleDate object
     * @param s String to parse
     * @return A SimpleDate object
<<<<<<< HEAD
     * @throws NumberFormatException if parsing number error
=======
     * @throws Exception if parsing number error
>>>>>>> TNhan
     */
    public static SimpleDate parseSDate(String s) throws NumberFormatException {
        SimpleDate sd = new SimpleDate();
        String delimiter = "/";
        String[] spl = s.split(delimiter);
        sd.setDayOfMonth(Integer.parseInt(spl[0]));
        sd.setMonthValue(Integer.parseInt(spl[1]));
        sd.setYear(Integer.parseInt(spl[2]));
        return sd;
    }
    
    public static void isValidDate(SimpleDate sd) throws FormatException {
        FormatException ex = new FormatException("Error: Invalid date!");
        int day = sd.getDayOfMonth();
        int month = sd.getMonthValue();
        int year = sd.getYear();
        LocalDateTime now = LocalDateTime.now();
        if (year < 0 || year > now.getYear()) throw ex;
        if (month < 0 || month > 12) throw ex;
        int maxD = 31;
        if (month==4 || month==6 || month==9 || month==11) maxD = 30;
        if (month==2) {
            maxD = 28;
            if (year%400 == 0) maxD = 29;
            if (year%100 != 0 && year%4==0) maxD = 29;
        }
        if (day < 0 || day > maxD) throw ex;
    }
}
