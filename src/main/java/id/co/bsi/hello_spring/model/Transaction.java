package id.co.bsi.hello_spring.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Transaction {
    private LocalDateTime datetime;
    private String type;
    private String fromTo;
    private String description;
    private long amount;
}