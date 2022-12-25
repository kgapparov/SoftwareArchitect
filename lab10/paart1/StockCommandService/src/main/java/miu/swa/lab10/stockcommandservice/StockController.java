package miu.swa.lab10.stockcommandservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StockController {

    @Autowired
    StockCommandService service;

    @DeleteMapping("/stocks/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping("/stocks")
    public Stock addStock(@RequestBody Stock stock) {
        return service.addStock(stock);
    }

    @PatchMapping("/stocks")
    public Stock updateStock(@RequestBody Stock stock) {
        return service.update(stock);
    }

}
