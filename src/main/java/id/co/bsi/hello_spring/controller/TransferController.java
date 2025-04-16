package id.co.bsi.hello_spring.controller;

import id.co.bsi.hello_spring.dto.request.TransferRequest;
import id.co.bsi.hello_spring.dto.response.TransferResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @PostMapping("/api/transfer")
    public ResponseEntity<TransferResponse> Transfer(@RequestBody TransferRequest transferRequest) {
        TransferResponse transferResponse = new TransferResponse();

        // set variable
        transferResponse.setStatus("success");
        transferResponse.setMessage("Transfer to: " + transferRequest.getToAccount() + "Success");

        // return (setiap post mapping punya return)
        return ResponseEntity.ok(transferResponse);
    }
}
