package domain.circle;

import domain.user.User;

public interface ICircleFactory {

    public Circle create(User user, String name);
}
