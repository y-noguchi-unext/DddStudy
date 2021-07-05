package bottomup.domain.user;

import java.util.Objects;

public class UserName {

    private final String name;

    public UserName(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException();
        }
        if (name.length() > 50) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public String value() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserName other = (UserName) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
