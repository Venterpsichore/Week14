package projects.exception;
// Extends unchecked RuntimeException 
public class DbException extends RuntimeException{

// Writes error message
public DbException(String message) {
	super(message);
}
// Takes thrown cause
public DbException(Throwable cause) {
	super(cause);
}
// Combines the message and cause
public DbException(String message, Throwable cause) {
	super(message, cause);
}


}