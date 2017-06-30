/*
Class SimpleDate provides a simple way to represent a date object
A date object contains fields: dayOfMonth, monthValue, year
*/
package project;

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
     * @throws Exception if parsing number error
     */
    public static SimpleDate parseSDate(String s) throws Exception {
        SimpleDate sd = new SimpleDate();
        String delimiter = "/";
        String[] spl = s.split(delimiter);
        sd.setDayOfMonth(Integer.parseInt(spl[0]));
        sd.setMonthValue(Integer.parseInt(spl[1]));
        sd.setYear(Integer.parseInt(spl[2]));
        return sd;
    }
}
