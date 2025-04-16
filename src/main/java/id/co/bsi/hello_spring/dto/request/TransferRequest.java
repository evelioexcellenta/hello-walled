package id.co.bsi.hello_spring.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransferRequest {
    private Integer toAccount;
    private Integer amount;
    private String notes;
    private String type;
    private LocalDateTime dateTime;
}
