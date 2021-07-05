package bottomup.service.circle;

import bottomup.domain.circle.Circle;
import bottomup.domain.circle.CircleId;
import bottomup.domain.circle.ICircleFactory;
import bottomup.domain.circle.ICircleRepository;
import bottomup.domain.user.IUserRepository;
import bottomup.domain.user.User;
import bottomup.domain.user.UserId;

public class CircleApplicationService {

    private final ICircleFactory circleFactory;
    private final ICircleRepository circleRepository;
    private final IUserRepository userRepository;

    public CircleApplicationService(ICircleFactory circleFactory, ICircleRepository circleRepository, IUserRepository userRepository) {
        this.circleFactory = circleFactory;
        this.circleRepository = circleRepository;
        this.userRepository = userRepository;
    }

    public void createCircle(long userId, String name) {
        User user = userRepository.find(new UserId(userId)).get();
        Circle circle = user.createCircle(circleFactory, name);
        circleRepository.save(circle);
    }

    public void joinUser(long circleId, long userId) {
        Circle circle = circleRepository.find(new CircleId(circleId)).get();
        User user = userRepository.find(new UserId(userId)).get();
        circle.addUser(user);
        circleRepository.save(circle);
    }
}
