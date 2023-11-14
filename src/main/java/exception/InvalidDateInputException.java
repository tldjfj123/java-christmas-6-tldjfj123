package exception;

public class InvalidDateInputException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public InvalidDateInputException() {
        super(ERROR_MESSAGE);
    }
}
