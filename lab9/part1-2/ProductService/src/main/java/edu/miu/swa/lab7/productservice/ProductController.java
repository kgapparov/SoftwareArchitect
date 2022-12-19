package edu.miu.swa.lab7.productservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @HystrixCommand(fallbackMethod = "getAmountFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    @RequestMapping("/product/{productId}")
    public Integer getStockNumber(@PathVariable("productId") String productId){
        return stockService.getAmount(productId).getNumberInStock();
    }

    public String getAmountFallback(){
        return "Request fails. it takes too long t ime to response";
    }
    @FeignClient(name = "stockService")
    interface StockService {
        @RequestMapping(method = RequestMethod.GET, value = "/stock/{productId}")
        Product getAmount(@PathVariable("productId") String productId);
    }
}
