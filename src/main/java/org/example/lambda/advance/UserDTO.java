package org.example.lambda.advance;

public class UserDTO {

    private String email;

    private String username;

    public UserDTO(User user){
        this.email = user.getEmail();
        this.username = user.getUsername();
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }



}
