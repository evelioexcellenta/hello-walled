package id.co.bsi.hello_spring.controller;

import id.co.bsi.hello_spring.dto.response.ProfileResponse;
import id.co.bsi.hello_spring.dto.response.ProfileResponse.UserData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @GetMapping("/api/profile")
    public ResponseEntity<ProfileResponse> getProfile() {
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
