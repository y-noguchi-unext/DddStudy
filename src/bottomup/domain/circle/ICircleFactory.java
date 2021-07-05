package bottomup.domain.circle;

import bottomup.domain.user.User;

public interface ICircleFactory {

    public Circle create(User user, String name);
}
