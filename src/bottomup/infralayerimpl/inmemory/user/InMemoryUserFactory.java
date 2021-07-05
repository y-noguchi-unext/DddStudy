package bottomup.infralayerimpl.inmemory.user;

import bottomup.domain.user.FullName;
import bottomup.domain.user.IUserFactory;
import bottomup.domain.user.User;
import bottomup.domain.user.UserId;
import bottomup.domain.user.UserName;

public class InMemoryUserFactory implements IUserFactory {

    private static long currentId;

    @Override
    public User createUser(UserName userName, FullName name) {
        currentId++;
        return new User(new UserId(currentId), name, userName);
    }
}
