package miu.edu.swa.lab10.part2.serviceaapplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAController {

    @Value("${greeting}")
    private String message;

    @RequestMapping("/")
    public String getName(){
        return message;
    }
}
