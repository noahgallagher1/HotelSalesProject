public class UnknownTransactionException extends Exception {
    public UnknownTransactionException(String errorMessage){
        super(errorMessage + "Unknown Transaction Error");
    }
}