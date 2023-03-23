package ntnu.idatt2105.stianlyng.svinn.token;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<Token, Integer> {

    List<Token> findByUserIdAndExpiredFalseAndRevokedFalse(Integer userId);

    Optional<Token> findByToken(String token);
}