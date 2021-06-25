package infralayerimpl.inmemory.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import domain.user.FullName;
import domain.user.IUserRepository;
import domain.user.User;
import domain.user.UserId;
import domain.user.UserName;

public class InMemoryUserRepository implements IUserRepository {

    private static final List<User> users = new ArrayList<>(List.of( //
            new InMemoryUserFactory().createUser(new UserName("のぐちゃん"), new FullName("のぐち", "ゆうき")), //
            new InMemoryUserFactory().createUser(new UserName("のぐちゃん"), new FullName("さかもと", "りょうま")), //
            new InMemoryUserFactory().createUser(new UserName("ぱーぷる"), new FullName("むらさき", "しきぶ"))));

    @Override
    public Optional<User> find(UserName userName) {
        return users.stream().filter(user -> user.getUserName().equals(userName)).findFirst();
    }

    @Override
    public Optional<User> find(UserId userId) {
        return users.stream().filter(user -> user.getId().equals(userId)).findFirst();
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void remove(User user) {
        users.removeIf(sourceUser -> sourceUser.equals(user));
    }
}
