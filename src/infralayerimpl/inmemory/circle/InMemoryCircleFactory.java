package infralayerimpl.inmemory.circle;

import domain.circle.Circle;
import domain.circle.CircleId;
import domain.circle.ICircleFactory;
import domain.user.User;

public class InMemoryCircleFactory implements ICircleFactory {

    private static long currentId;

    @Override
    public Circle create(User user, String name) {
        currentId++;
        return new Circle(new CircleId(currentId), name, user);
    }
}
