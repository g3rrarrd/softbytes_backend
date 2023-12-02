package hn.softbytes.softbytes_backend.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class softBytesController {
    
    @GetMapping("/date")
    public String demo(){
        return "hello world";
    }

}
