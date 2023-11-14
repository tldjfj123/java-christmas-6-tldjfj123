package controller;

import domain.calendar.Date;
import domain.order.OrderList;
import view.OutputBadgeView;
import view.OutputBenefitView;
import view.OutputGiftView;
import view.OutputOrderAmountAfterDiscountView;
import view.OutputOrderAmountBeforeDiscountView;
import view.OutputOrderListView;

public class PreviewController {
    private static final String PREVIEW_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String NEW_LINE = "\n";

    public void run(Date date, OrderList orderList) {
        System.out.printf(PREVIEW_MESSAGE + NEW_LINE, date.getDate());

        OutputOrderListView.printView(orderList);
        OutputOrderAmountBeforeDiscountView.printView(orderList);
        OutputGiftView.printView(orderList);
        OutputBenefitView.printView(date, orderList);
        OutputOrderAmountAfterDiscountView.printView(date, orderList);
        OutputBadgeView.printView(orderList);
    }


}
