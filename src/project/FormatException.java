
package project;

/**
 * A custom runtime exception 
 * @author NhanTTSE63103 - Tran Thanh Nhan
 */
public class FormatException extends Exception {
    private String message;
    
    public FormatException() {
    }

    public FormatException(String string) {
        super(string);
        this.message = string;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
