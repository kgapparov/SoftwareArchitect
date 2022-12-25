package miu.swa.lab10.stockcommandservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = false)
@Data
public class Stock {
    @Id
    private String id;
    private String productNumber;
    private Integer quantity;
}
