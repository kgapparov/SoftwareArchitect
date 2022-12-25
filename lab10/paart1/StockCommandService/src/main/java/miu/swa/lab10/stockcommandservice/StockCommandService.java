package miu.swa.lab10.stockcommandservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StockCommandService {
    @Autowired
    StockRepository repository;

    @Autowired
    KafkaTemplate<String, Stock> kafkaTemplate;

    public Stock addStock(Stock stock) {
        Stock stock1 =  repository.insert(stock);
        kafkaTemplate.send("addStockEvent", stock1);
        return stock1;
    }

    public Stock update(Stock stock) {
        Stock stock1 =  repository.save(stock);
        kafkaTemplate.send("updateStockEvent", stock1);
        return stock1;
    }

    public void delete (String id) {
        repository.deleteById(id);
        kafkaTemplate.send("deleteStockEvent", repository.findById(id).orElse(null));
    }
}
