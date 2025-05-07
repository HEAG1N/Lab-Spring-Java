package org.example.hobbysplatform;

import org.example.hobbysplatform.model.Event;
import org.example.hobbysplatform.model.User;
import org.example.hobbysplatform.model.Group;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HobbysPlatformApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HobbysPlatformApplication.class, args);
        // Obținerea bean-urilor din context folosind context.getBean()
        Event event = context.getBean(Event.class);
        Group group = context.getBean(Group.class);

        // Afișarea informațiilor despre bean-uri pentru verificare
        System.out.println("Event bean: " + event);
        System.out.println("Group bean: " + group);

        // Obținerea user-ului cu injecție prin constructor
        User userConstructor = context.getBean("userWithConstructorInjection", User.class);
        System.out.println("User with constructor injection: " + userConstructor);

        // Obținerea user-ului cu injecție prin setter
        User userSetter = context.getBean("userWithSetterInjection", User.class);
        System.out.println("User with setter injection: " + userSetter);
    }

    // Bean creat prin constructor - injecție prin constructor
    @Bean
    public User userWithConstructorInjection(Event event, Group group) {
        return new User("username1", "email1@example.com", 25, "Reading", true, event, group);
    }

    // Bean creat cu setter injection
    @Bean
    public User userWithSetterInjection(Event event, Group group) {
        User user = new User();
        user.setUsername("username2");
        user.setEmail("email2@example.com");
        user.setAge(30);
        user.setHobby("Gaming");
        user.setActive(true);
        // Folosim setteri explicit în loc să ne bazăm pe @Autowired
        user.setEvent(event);
        user.setGroup(group);
        return user;
    }
}
