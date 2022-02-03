public class IncorrectPhoneNumberException extends NumberFormatException{
    // принимает в качестве аргумента введённый номер

    String numberExample = "Wrong phone number format. Correct format: +79215637722";
    public String getNumberExample(){return numberExample;}

    public IncorrectPhoneNumberException(String customerNumber) {
        super("Input: " + customerNumber);

    }
}
