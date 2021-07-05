package bottomup.infralayerimpl.inmemory.circle;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import bottomup.domain.circle.Circle;
import bottomup.domain.circle.CircleId;
import bottomup.domain.circle.ICircleRepository;
import bottomup.domain.user.IUserRepository;
import bottomup.infralayerimpl.inmemory.user.InMemoryUserRepository;

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
