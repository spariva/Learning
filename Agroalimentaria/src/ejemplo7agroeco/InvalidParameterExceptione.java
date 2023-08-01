package ejemplo7agroeco;
//exceptione porque InvalidParameterException ya existe
public class InvalidParameterExceptione extends Exception{
    public InvalidParameterExceptione(String exceptionMessage){
        super(exceptionMessage);
    }
}