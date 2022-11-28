package edu.miu.swa.lab7.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    StockService stockService;

    @RequestMapping("/product/{productId}")
    public Integer getStockNumber(@PathVariable("productId") String productId){
        return stockService.getAmount(productId).getNumberInStock();
    }

    @FeignClient(name = "stock-service")
    interface StockService {
        @RequestMapping(method = RequestMethod.GET, value = "/stock/{productId}")
        Product getAmount(@PathVariable("productId") String productId);
    }
}
