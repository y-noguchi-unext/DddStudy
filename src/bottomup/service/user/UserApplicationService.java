package bottomup.service.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import bottomup.domain.user.FullName;
import bottomup.domain.user.IUserFactory;
import bottomup.domain.user.IUserRepository;
import bottomup.domain.user.User;
import bottomup.domain.user.UserId;
import bottomup.domain.user.UserName;
import bottomup.domain.user.UserService;
import bottomup.service.user.model.UserModel;
import bottomup.service.user.model.UserSummaryModel;

public class UserApplicationService {

    private final IUserRepository repository;
    private final UserService userService;
    private final IUserFactory factory;

    public UserApplicationService(IUserRepository repository, UserService userService, IUserFactory factory) {
        this.repository = repository;
        this.userService = userService;
        this.factory = factory;
    }

    public void registerUser(String familyName, String lastName, String userName) {
        User user = factory.createUser(new UserName(userName), new FullName(familyName, lastName));

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
