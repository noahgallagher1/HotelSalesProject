public class UnknownTransactionException extends Exception {
    public UnknownTransactionException(){
    }
    public UnknownTransactionException(String errorMessage){
        super(errorMessage);
    }
}
