package by.savin.comprent.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class UserDto {
    @NotBlank(message = "Enter the username")
    @Email
    private String username;
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 symbols")
    @NotBlank(message = "Enter the password")
    private String password;
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 symbols")
    private String repeatPassword;

    public UserDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
