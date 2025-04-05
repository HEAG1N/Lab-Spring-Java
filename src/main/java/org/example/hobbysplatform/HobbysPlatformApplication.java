package org.example.hobbysplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HobbysPlatformApplication {

    public static void main(String[] args) {
        User user = new User("alex123", "alex@email.com", 28, "drumeții", true);
        System.out.println("Utilizator: " + user);
        System.out.println("Hobby inițial: " + user.getHobby());
        user.setHobby("cățărat");
        System.out.println("Hobby actualizat: " + user.getHobby());
        Event event = new Event("Ieșire în Munții Bucegi", "Sinaia", "2025-06-01", "Drumeții", true);
        System.out.println("Eveniment: " + event);
        event.setLocation("Busteni");
        System.out.println("Locație nouă: " + event.getLocation());
        Group group = new Group("Aventurieri", "Grup de drumeții și explorări", 12, true, "drumeții");
        System.out.println("Grup: " + group);
    }

}
