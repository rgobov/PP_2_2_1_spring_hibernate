package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        Car mersedes = new Car("mersedes", 1234);
        Car bmw = new Car("bmw", 1235);
        Car audi = new Car("audi", 1236);
        Car kia = new Car("kia", 1237);


        userService.add(new User("User1", "Lastname1", "user1@mail.ru", mersedes));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", bmw));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", audi));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", kia));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar().getModel());
            System.out.println();
        }
        User user = userService.getUserByCar("kia", 1237);
        System.out.println(user.toString());

        context.close();
    }
}
