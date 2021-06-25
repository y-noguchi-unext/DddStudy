package domain;

import repository.IUserRepository;

public class UserService {

    private final IUserRepository repository;

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    public boolean isDuplicated(User user) {
        return repository.find(user.getUserName()).isPresent();
    }
}
