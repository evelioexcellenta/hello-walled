package id.co.bsi.hello_spring.controller;

import id.co.bsi.hello_spring.dto.request.LoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @PostMapping("/api/login");
    public RestController<> login(@RequestBody LoginRequest loginRequest){
        LoginRequest loginRequest1 = new LoginRequest();


    }
}
