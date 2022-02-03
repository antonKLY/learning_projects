public class IllegalCommandException extends IllegalArgumentException{
    //принимает в качестве аргументов конструктора имя команды.

    String errorInfo = "Wrong command! Available command examples:" +
            "\n\tadd Василий Петров vasily.petrov@gmail.com +79215637722" +
            "\n\tlist\n\tremove\n\tcount\n\thelp";

    public String getErrorInfo() {
        return errorInfo;
    }

    public IllegalCommandException (String commandName){
        super("Command: " + commandName);

    }
}
