package infralayerimpl.inmemory.circle;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import domain.circle.Circle;
import domain.circle.CircleId;
import domain.circle.ICircleRepository;
import domain.user.IUserRepository;
import infralayerimpl.inmemory.user.InMemoryUserRepository;

public class InMemoryCircleRepository implements ICircleRepository {

    private static final IUserRepository userRepository = new InMemoryUserRepository();

    private static final List<Circle> circles = userRepository.findAll().stream().map(user -> {
        return new InMemoryCircleFactory().create(user, "%sのサークル".formatted(user.getUserName().value()));
    }).collect(Collectors.toList());

    @Override
    public void save(Circle circle) {
        circles.add(circle);
    }

    @Override
    public Optional<Circle> find(CircleId id) {
        return circles.stream().filter(circle -> circle.getId().equals(id)).findFirst();
    }
}
