package bottomup.domain.circle;

import java.util.Optional;

public interface ICircleRepository {

    public void save(Circle circle);

    public Optional<Circle> find(CircleId id);
}
