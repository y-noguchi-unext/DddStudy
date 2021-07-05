package bottomup.infralayerimpl.inmemory.circle;

import bottomup.domain.circle.Circle;
import bottomup.domain.circle.CircleId;
import bottomup.domain.circle.ICircleFactory;
import bottomup.domain.user.User;

public class InMemoryCircleFactory implements ICircleFactory {

    private static long currentId;

    @Override
    public Circle create(User user, String name) {
        currentId++;
        return new Circle(new CircleId(currentId), name, user);
    }
}
