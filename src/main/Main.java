package main;

import domain.user.UserService;
import infralayerimpl.inmemory.user.InMemoryUserFactory;
import infralayerimpl.inmemory.user.InMemoryUserRepository;
import service.user.UserApplicationService;
import service.user.model.UserModel;

public class Main {

    public static void main(String[] args) {
        UserApplicationService userService = new UserApplicationService( //
                new InMemoryUserRepository(), //
                new UserService(new InMemoryUserRepository()), //
                new InMemoryUserFactory());

        System.out.println("--------最初のユーザー--------");
        userService.findAllUser().forEach(user -> {
            System.out.println(user);
        });
        System.out.println("--------ユーザーを追加する--------");
        userService.registerUser("おだ", "のぶなが", "てんかとりたいひと");

        System.out.println("--------追加したユーザーを表示--------");
        UserModel registeredUser = userService.findUser("てんかとりたいひと");
        System.out.println(registeredUser);

        System.out.println("--------名前をかえてみる--------");
        userService.changeUserProfile(registeredUser.id, "おだ", "さくのすけ", "てんかとりたいひと");
        System.out.println(userService.findUser("てんかとりたいひと"));

        System.out.println("--------削除する--------");
        userService.removeUser(registeredUser.id);
        userService.findAllUser().forEach(user -> {
            System.out.println(user);
        });
    }
}
