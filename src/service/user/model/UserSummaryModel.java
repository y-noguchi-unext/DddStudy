package service.user.model;

import domain.user.User;

public class UserSummaryModel {

    public long id;
    public String userName;

    public UserSummaryModel(User user) {
        this.id = user.getId().value();
        this.userName = user.getUserName().value();
    }

    @Override
    public String toString() {
        return "id: %s, userName: %s".formatted(id, userName);
    }
}
