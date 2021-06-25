package domain.user;

import domain.circle.Circle;
import domain.circle.ICircleFactory;

public class User {

    private final UserId id;
    private FullName name;
    private UserName userName;

    public User(UserId id, FullName fullName, UserName userName) {
        this.id = id;
        this.name = fullName;
        this.userName = userName;
    }

    public UserId getId() {
        return id;
    }

    public FullName getName() {
        return name;
    }

    public UserName getUserName() {
        return userName;
    }

    public void changeName(FullName newName) {
        this.name = newName;
    }

    public void changeUserName(UserName newName) {
        this.userName = newName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;

    }

    public Circle createCircle(ICircleFactory circleFactory, String circleName) {
        return circleFactory.create(this, circleName);
    }
}