package infralayerimpl.inmemory.user;

import domain.user.FullName;
import domain.user.IUserFactory;
import domain.user.User;
import domain.user.UserId;
import domain.user.UserName;

public class InMemoryUserFactory implements IUserFactory {

    private static long currentId;

    @Override
    public User createUser(UserName userName, FullName name) {
        currentId++;
        return new User(new UserId(currentId), name, userName);
    }
}
