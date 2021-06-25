package repository;

import java.util.List;
import java.util.Optional;

import datastore.UserDataStore;
import domain.User;
import domain.UserId;
import domain.UserName;

public class InMemoryUserRepository implements IUserRepository {

    @Override
    public Optional<User> find(UserName userName) {
        return UserDataStore.users.stream().filter(user -> user.getUserName().equals(userName)).findFirst();
    }

    @Override
    public Optional<User> find(UserId userId) {
        return UserDataStore.users.stream().filter(user -> user.getId().equals(userId)).findFirst();
    }

    @Override
    public List<User> findAll() {
        return UserDataStore.users;
    }

    @Override
    public void save(User user) {
        UserDataStore.users.add(user);
    }

    @Override
    public void remove(User user) {
        UserDataStore.users.removeIf(sourceUser -> sourceUser.equals(user));
    }
}
