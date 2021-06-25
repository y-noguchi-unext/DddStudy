package datastore;

import java.util.ArrayList;
import java.util.List;

import domain.FullName;
import domain.User;
import domain.UserName;

public class UserDataStore {

    public static List<User> users = new ArrayList<>(List.of( //
            new User(new FullName("のぐち", "ゆうき"), new UserName("のぐちゃん")), //
            new User(new FullName("さかもと", "りょうま"), new UserName("りょうちゃん")), //
            new User(new FullName("むらさき", "しきぶ"), new UserName("ぱーぷる")) //
    ));
}
