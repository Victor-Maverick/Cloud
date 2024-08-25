package africa.semicolon.devfuse.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Users")
@Setter
@Getter
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
