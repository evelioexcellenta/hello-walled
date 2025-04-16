package id.co.bsi.hello_spring.controller;

import id.co.bsi.hello_spring.dto.response.ProfileResponse;
import id.co.bsi.hello_spring.dto.response.ProfileResponse.UserData;
import id.co.bsi.hello_spring.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

    @GetMapping("/api/profile")
    public ResponseEntity<?> getProfile(@RequestParam("token") String token) {
        if (!"absdsadsfbgdfdas".equals(token)) {
            return new ResponseEntity<>(
                    new ErrorResponse("failed", "Unauthorized access"),
                    HttpStatus.UNAUTHORIZED
            );
        }

        UserData userData = new UserData();
        userData.setName("Chelsea Immanuela");
        userData.setAccountType("Personal Account");
        userData.setProfilePictureUrl("https://google.com/avatar/chelsea.jpg");

        ProfileResponse profileResponse = new ProfileResponse();
        profileResponse.setStatus("success");
        profileResponse.setData(userData);

        return ResponseEntity.ok(profileResponse);
    }
}
