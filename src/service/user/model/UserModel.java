package service.user.model;

import domain.user.FullName;
import domain.user.User;

public class UserModel {

    public long id;
    public String userName;
    public FullNameModel fullName;

    public UserModel(User user) {
        this.id = user.getId().value();
        this.userName = user.getUserName().value();
        this.fullName = new FullNameModel(user.getName());
    }

    public static class FullNameModel {

        public String familyName;
        public String lastName;

        public FullNameModel(FullName fullName) {
            this.familyName = fullName.getFamilyName();
            this.lastName = fullName.getLastName();
        }
    }

    @Override
    public String toString() {
        return "id: %s, userName: %s, familyName: %s, lastName: %s".formatted(id, userName, fullName.familyName, fullName.lastName);
    }
}
