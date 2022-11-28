package io.miu.swa.lab5.componentapplication.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Supplier {
    private Long supplierNumber;
    private String name;
    private String phone;
}
