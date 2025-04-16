package id.co.bsi.hello_spring.controller;

import id.co.bsi.hello_spring.dto.response.BalanceResponse;
import id.co.bsi.hello_spring.dto.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @GetMapping("/api/balances")
    public ResponseEntity<?> getBalance(@RequestParam("token") String token) {
        if (!"absdsadsfbgdfdas".equals(token)) {
            return new ResponseEntity<>(
                    new ErrorResponse("failed", "Unable Fetch Balance"),
                    HttpStatus.UNAUTHORIZED
            );
        }
//        public ResponseEntity<BalanceResponse> getBalance(){
        BalanceResponse response = new BalanceResponse();
        response.setStatus("success");
        response.setBalance(100000);

        return ResponseEntity.ok(response);
    }
}
