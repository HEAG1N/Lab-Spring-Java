package org.example.hobbysplatform;
import java.util.Objects;
public class User {
    private String username;
    private String email;
    private int age;
    private String hobby;
    private boolean active;

    public User() {}

    public User(String username, String email, int age, String hobby, boolean active) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.hobby = hobby;
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && active == user.active && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(hobby, user.hobby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, age, hobby, active);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                ", active=" + active +
                '}';
    }
}

