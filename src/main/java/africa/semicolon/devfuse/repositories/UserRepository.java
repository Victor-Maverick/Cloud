package africa.semicolon.devfuse.repositories;

import africa.semicolon.devfuse.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByEmail(String email);
}
