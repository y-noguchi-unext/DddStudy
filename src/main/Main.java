package main;

import domain.UserService;
import domain.application.UserApplicationService;
import domain.application.model.UserModel;
import repository.InMemoryUserRepository;

public class Main {

    public static void main(String[] args) {
        UserApplicationService service =
                new UserApplicationService(new InMemoryUserRepository(), new UserService(new InMemoryUserRepository()));
        System.out.println("--------最初のユーザー--------");
        service.findAllUser().forEach(user -> {
            System.out.println(user);
        });
        System.out.println("--------ユーザーを追加する--------");
        service.registerUser("おだ", "のぶなが", "てんかとりたいひと");

        System.out.println("--------追加したユーザーを表示--------");
        UserModel registeredUser = service.findUser("てんかとりたいひと");
        System.out.println(registeredUser);

        System.out.println("--------名前をかえてみる--------");
        service.changeUserProfile(registeredUser.id, "おだ", "さくのすけ", "てんかとりたいひと");
        System.out.println(service.findUser("てんかとりたいひと"));

        System.out.println("--------削除する--------");
        service.removeUser(registeredUser.id);
        service.findAllUser().forEach(user -> {
            System.out.println(user);
        });
    }
}
