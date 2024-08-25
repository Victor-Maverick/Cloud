package africa.semicolon.devfuse.services.interfaces;

import africa.semicolon.devfuse.dtos.requests.LoginRequest;
import africa.semicolon.devfuse.dtos.requests.RegisterRequest;
import africa.semicolon.devfuse.dtos.responses.LoginResponse;
import africa.semicolon.devfuse.dtos.responses.RegisterResponse;
import africa.semicolon.devfuse.models.User;

public interface UserService {

    RegisterResponse register(RegisterRequest request);
    LoginResponse login(LoginRequest request);

    User findUserBy(String email);
}
