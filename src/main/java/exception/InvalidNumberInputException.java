package exception;

public class InvalidNumberInputException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 올바르지 않은 숫자 입력입니다!";

    public InvalidNumberInputException() {
        super(ERROR_MESSAGE);
    }
}
