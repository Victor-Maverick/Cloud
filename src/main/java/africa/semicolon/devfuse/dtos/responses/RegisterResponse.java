package africa.semicolon.devfuse.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RegisterResponse {
    private String id;
    private String message;
}
