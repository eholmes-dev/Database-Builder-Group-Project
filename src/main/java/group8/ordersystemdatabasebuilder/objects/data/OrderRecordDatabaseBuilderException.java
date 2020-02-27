package group8.ordersystemdatabasebuilder.objects.data;

/**
 *
 * @author Ethan Holmes, Zach Bherensmeyer, Chuck Baxter, Dalton Schilling
 */
public class OrderRecordDatabaseBuilderException extends Exception{

    public OrderRecordDatabaseBuilderException() {
    }

    public OrderRecordDatabaseBuilderException(String message) {
        super(message);
    }

    public OrderRecordDatabaseBuilderException(String message, Throwable 
            cause) {
        super(message, cause);
    }

    public OrderRecordDatabaseBuilderException(Throwable cause) {
        super(cause);
    }

    public OrderRecordDatabaseBuilderException(String message, Throwable cause, 
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
