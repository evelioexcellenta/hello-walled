package id.co.bsi.hello_spring.controller;

import id.co.bsi.hello_spring.dto.response.BalanceResponse;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping("/api/balance")
    public ResponseEntity<BalanceResponse> getBalance(
    ){
        BalanceResponse balanceResponse = new BalanceResponse();
        balanceResponse.setBalance(1000000);
        balanceResponse.setMessage("Your balance is 1.000.000");

        return ResponseEntity.ok(balanceResponse);
    }
}
