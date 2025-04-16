package id.co.bsi.hello_spring.dto.request;


import lombok.Data;

@Data
public class TopupRequest {
    private String from;
    private int amount;
    private String notes;
}
