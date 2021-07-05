package bottomup.domain.user;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    public Optional<User> find(UserName userName);

    public Optional<User> find(UserId userId);

    public List<User> findAll();

    public void save(User user);

    public void remove(User user);
}
