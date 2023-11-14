package view;

import camp.nextstep.edu.missionutils.Console;
import domain.menu.Drink;
import domain.order.Order;
import domain.order.OrderList;
import exception.InvalidOrderInputException;
import java.util.ArrayList;
import java.util.List;

public class InputOrderView {
    private static final String HEAD_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String MENU_SPLIT_STANDARD = ",";
    private static final String SPLIT_STANDARD = "-";
    private static final String INTEGER_REGEX = "[1-9][0-9]*";
    private static final int SPLIT_LENGTH = 2;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int MAX_ORDER = 20;

    public OrderList getValue() {
        System.out.println(HEAD_MESSAGE);
        while (true) {
            try {
                String[] inputValue = Console.readLine().split(MENU_SPLIT_STANDARD);

                for (String input : inputValue) {
                    validate(input);
                }

                return createOrderListWithInput(inputValue);


            } catch (InvalidOrderInputException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private void validate(String inputValue) {
        validateNoWhiteSpace(inputValue);
        validateRightFormat(inputValue);
    }

    private void validateRightFormat(String inputValue) {
        String[] parts = inputValue.split(SPLIT_STANDARD);
        if (parts.length != SPLIT_LENGTH) {
            throw new InvalidOrderInputException();
        }

        if (!parts[1].matches(INTEGER_REGEX)) {
            throw new InvalidOrderInputException();
        }
    }

    private void validateNoWhiteSpace(String inputValue) {
        if (inputValue.contains(" ")) {
            throw new InvalidOrderInputException();
        }

    }

    private OrderList createOrderListWithInput(String[] inputValue) {
        List<Order> orderList = new ArrayList<>();
        Drink drink = new Drink();

        int drinkQuantity = ZERO;
        int totalQuantity = ZERO;

        for (String s : inputValue) {
            String menuName = s.split(SPLIT_STANDARD)[ZERO];
            int quantity = Integer.parseInt(s.split(SPLIT_STANDARD)[ONE]);

            orderList.add(new Order(menuName, quantity));
            totalQuantity += quantity;

            if (drink.isDrink(menuName)) {
                drinkQuantity += quantity;
            }
        }

        if (totalQuantity > MAX_ORDER) {
            throw new InvalidOrderInputException();
        }

        if (totalQuantity == drinkQuantity) {
            throw new InvalidOrderInputException();
        }

        return new OrderList(orderList);
    }
}
