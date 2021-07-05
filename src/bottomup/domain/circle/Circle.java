package bottomup.domain.circle;

import java.util.ArrayList;
import java.util.List;

import bottomup.domain.user.User;

public class Circle {

    private final CircleId id;
    private String name;
    private List<User> users = new ArrayList<>();

    public Circle(CircleId id, String name, User user) {
        this.id = id;
        this.name = name;
        this.users.add(user);
    }

    public CircleId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}
