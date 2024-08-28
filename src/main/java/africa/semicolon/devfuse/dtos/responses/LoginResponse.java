package africa.semicolon.devfuse.dtos.responses;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {
    private Long userId;
    private String username;
}
