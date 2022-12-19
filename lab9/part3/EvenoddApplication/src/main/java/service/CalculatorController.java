package service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public String isNumberPrime(@RequestParam("value1") Integer number1, @RequestParam("value2") Integer number2) {
        return String.valueOf(number1 + number2);
    }
}
