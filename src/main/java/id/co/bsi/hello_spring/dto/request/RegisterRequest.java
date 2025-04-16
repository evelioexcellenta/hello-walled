package id.co.bsi.hello_spring.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Integer phone;
}
