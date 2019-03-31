package org.springframework.samples.petclinic.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class TestController {

    @GetMapping("/test")
    public String hello(){return "hello";}
}
