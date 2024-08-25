package africa.semicolon.devfuse.services.impls;

import africa.semicolon.devfuse.dtos.requests.RegisterRequest;
import africa.semicolon.devfuse.dtos.responses.RegisterResponse;
import africa.semicolon.devfuse.exceptions.UserExistsException;
import africa.semicolon.devfuse.models.User;
import africa.semicolon.devfuse.repositories.UserRepository;
import africa.semicolon.devfuse.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DevFuseUserService implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public RegisterResponse register(RegisterRequest request) {
        validateEmail(request.getEmail());
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        userRepository.save(user);
        RegisterResponse response = mapper.map(user, RegisterResponse.class);
        response.setMessage("Welcome "+user.getEmail()+", registration successful");
        return response;
    }

    private void validateEmail(String email) {
        boolean existsByEmail = userRepository.existsByEmail(email);
        if(existsByEmail)throw new UserExistsException("User already exists");
    }
}
