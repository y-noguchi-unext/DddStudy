package bottomup.domain.user;

public interface IUserFactory {

    public User createUser(UserName userName, FullName name);
}
