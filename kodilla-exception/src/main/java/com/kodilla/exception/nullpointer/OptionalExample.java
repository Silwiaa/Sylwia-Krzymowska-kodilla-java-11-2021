import com.kodilla.exception.nullpointer.User;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        User user = new User("Name");
        User user2 = new User("");

        Optional<User> optionalUser = Optional.ofNullable(user);
        Optional<User> optionalUser2 = Optional.ofNullable(user2);

        String username = optionalUser.orElse(new User("")).getName();
        System.out.println(username);

        optionalUser2.ifPresent(u -> System.out.println(u.getName()));
    }
}