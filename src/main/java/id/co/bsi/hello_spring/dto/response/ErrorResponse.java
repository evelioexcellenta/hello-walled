package id.co.bsi.hello_spring.dto.response;

import lombok.Data;

@Data
public class ErrorResponse {
    private String status;
    private String message;
}
