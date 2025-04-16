package id.co.bsi.hello_spring.dto.response;

import lombok.Data;

@Data
public class ProfileResponse {
    private String status;
    private UserData data;

    @Data
    public static class UserData {
        private String name;
        private String accountType;
        private String profilePictureUrl;
    }
}
