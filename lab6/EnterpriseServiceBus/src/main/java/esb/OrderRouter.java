package esb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderRouter {
    Logger log = LoggerFactory.getLogger(OrderRouter.class);
    public String route(Order order) {
        if (order.getAmount() > 175) {
            log.info("NextDayShipping was performed");
            return "nextDayShipping";
        } else {
            log.info(("Normal shipping was performed"));
            return "normalShipping";
        }
    }
}
