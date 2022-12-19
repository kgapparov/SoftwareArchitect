package miu.swa.lab8.stockservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StockController {


    @RequestMapping(method = RequestMethod.GET, value = "/stock/{productId}")
    public Product getAmount(@PathVariable String productId) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Stock stock = new Stock();
        stock.setStockNumber("112-IA-FD");
        stock.addProduct(new Product("1234", 1, "Iphone 14", 998d));
        stock.addProduct(new Product("1235", 2, "Iphone 14", 998d));
        stock.addProduct(new Product("1236", 3, "Iphone 14", 998d));
        stock.addProduct(new Product("1237", 4, "Iphone 14", 998d));
        stock.addProduct(new Product("1239", 5, "Iphone 14", 998d));
        return stock.getProduct(productId);
    }


}