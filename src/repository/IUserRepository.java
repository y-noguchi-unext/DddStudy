package repository;

import java.util.List;
import java.util.Optional;

import domain.User;
import domain.UserId;
import domain.UserName;

public interface IUserRepository {

    public Optional<User> find(UserName userName);

    public Optional<User> find(UserId userId);

    public List<User> findAll();

    public void save(User user);

    public void remove(User user);
}
