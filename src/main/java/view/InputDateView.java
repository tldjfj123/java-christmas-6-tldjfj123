package view;

import camp.nextstep.edu.missionutils.Console;
import exception.InvalidDateInputException;

public class InputDateView {
    private static final String INTEGER_REGEX = "[1-9][0-9]*";
    private static final String HEAD_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 31;

    public int getValue() {
        System.out.println(HEAD_MESSAGE);
        while (true) {
            try {
                String inputValue = Console.readLine();
                validate(inputValue);
                return Integer.parseInt(inputValue);
            } catch (InvalidDateInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validate(String inputValue) {
        validateNoWhiteSpace(inputValue);
        validateNumeric(inputValue);
        validateDateRange(inputValue);
    }

    private void validateNoWhiteSpace(String inputValue) {
        if (inputValue.contains(" ")) {
            throw new InvalidDateInputException();
        }
    }

    private void validateNumeric(String inputValue) {
        if (!inputValue.matches(INTEGER_REGEX)) {
            throw new InvalidDateInputException();
        }
    }

    private void validateDateRange(String inputValue) {
        int date = Integer.parseInt(inputValue);
        if (!(MIN_RANGE <= date && date <= MAX_RANGE)) {
            throw new InvalidDateInputException();
        }

    }
}
