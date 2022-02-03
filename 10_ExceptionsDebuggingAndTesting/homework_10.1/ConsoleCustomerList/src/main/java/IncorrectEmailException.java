public class IncorrectEmailException extends NumberFormatException{
    // принимает в качестве аргумента введённый email

    String email = "Wrong Email format. Correct format: vasily.petrov@gmail.com";
    public String getEmail(){return email;}

    public IncorrectEmailException(String customerEmail) {
       super("Input: " + customerEmail);

    }
}
