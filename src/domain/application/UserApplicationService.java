package domain.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import domain.FullName;
import domain.User;
import domain.UserId;
import domain.UserName;
import domain.UserService;
import domain.application.model.UserModel;
import domain.application.model.UserSummaryModel;
import repository.IUserRepository;

public class UserApplicationService {

    private final IUserRepository repository;
    private final UserService userService;

    public UserApplicationService(IUserRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public void registerUser(String familyName, String lastName, String userName) {
        User user = new User(new FullName(familyName, lastName), //
                new UserName(userName));

        if (userService.isDuplicated(user)) {
            throw new RuntimeException("重複しちゃってるよ〜ん");
        }

        repository.save(user);
    }

    public void changeUserProfile(long id, String familyName, String lastName, String userName) {
        UserId userId = new UserId(id);
        Optional<User> optUser = repository.find(userId);
        optUser.ifPresentOrElse(user -> {
            user.changeName(new FullName(familyName, lastName));
            user.changeUserName(new UserName(userName));
            repository.save(user);
        }, () -> {
            throw new RuntimeException("いなんご・・・");
        });
    }

    public void removeUser(long id) {
        UserId userId = new UserId(id);
        Optional<User> optUser = repository.find(userId);
        optUser.ifPresentOrElse(user -> {
            repository.remove(user);
        }, () -> {
            throw new RuntimeException("いなんご・・・");
        });
    }

    public UserModel findUser(long id) {
        return repository.find(new UserId(id)).map(UserModel::new).orElseThrow();
    }

    public UserModel findUser(String userName) {
        return repository.find(new UserName(userName)).map(UserModel::new).orElseThrow();
    }

    public List<UserSummaryModel> findAllUser() {
        return repository.findAll().stream().map(UserSummaryModel::new).collect(Collectors.toList());
    }
}
