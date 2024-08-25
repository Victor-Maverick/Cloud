package africa.semicolon.devfuse.services.interfaces;

import africa.semicolon.devfuse.dtos.requests.LoginRequest;
import africa.semicolon.devfuse.dtos.requests.RegisterRequest;
import africa.semicolon.devfuse.dtos.responses.RegisterResponse;
import africa.semicolon.devfuse.exceptions.UserExistsException;
import africa.semicolon.devfuse.repositories.UserRepository;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void registerUserTest(){
        RegisterResponse response = registerNewUser();
        System.out.println(response);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).contains("success");
    }

    private RegisterResponse registerNewUser(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Habeeb");
        request.setLastName("Panshak");
        request.setEmail("habeebpanshak@gmail.com");
        request.setPassword("password");
        return userService.register(request);
    }

    @Test
    public void registerNonUniqueUserTest(){
        RegisterResponse response = registerNewUser();
        assertThat(response).isNotNull();
        assertThrows(UserExistsException.class, this::registerNewUser);
    }

    @Test
    public void userCanLoginTest(){
        RegisterResponse response = registerNewUser();
        assertThat(response).isNotNull();

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("habeebpanshak@gmail.com");
        loginRequest.setPassword("password");
       var loginResponse = userService.login(loginRequest);
        assertThat(loginResponse).isNotNull();
        assertThat(response.getMessage()).contains("success");
        MatcherAssert.assertThat(userService.findUserBy("habeebpanshak@gmail.com").isLoggedIn(), is(true));

    }

}