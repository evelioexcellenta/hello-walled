package id.co.bsi.hello_spring.controller;


import id.co.bsi.hello_spring.dto.request.TopupRequest;
import id.co.bsi.hello_spring.dto.response.TopupResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopupController {

    @PostMapping("/api/topup")
    public ResponseEntity<TopupResponse> Topup(@RequestBody TopupRequest TopupRequest) {
        TopupResponse topupResponse = new TopupResponse();
        topupResponse.setStatus("Success");
        topupResponse.setMessage("Top up from Credit Card");

        return ResponseEntity.ok(topupResponse);
    }

}
