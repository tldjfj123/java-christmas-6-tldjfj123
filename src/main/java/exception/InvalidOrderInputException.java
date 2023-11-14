package exception;

public class InvalidOrderInputException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public InvalidOrderInputException() {
        super(ERROR_MESSAGE);
    }
}
