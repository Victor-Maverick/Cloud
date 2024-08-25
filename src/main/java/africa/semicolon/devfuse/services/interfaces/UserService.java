package africa.semicolon.devfuse.services.interfaces;

import africa.semicolon.devfuse.dtos.requests.RegisterRequest;
import africa.semicolon.devfuse.dtos.responses.RegisterResponse;

public interface UserService {

    RegisterResponse register(RegisterRequest request);
}
