package id.co.bsi.hello_spring.dto.response;

import lombok.Data;

@Data
public class BalanceResponse {
    private Integer balance;
    private String message;
}
