package org.example.hobbysplatform;
import java.util.Objects;
public class Event {
    private String name;
    private String location;
    private String date;
    private String category;
    private boolean isPublic;

    public Event() {}

    public Event(String name, String location, String date, String category, boolean isPublic) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.category = category;
        this.isPublic = isPublic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return isPublic == event.isPublic && Objects.equals(name, event.name) && Objects.equals(location, event.location) && Objects.equals(date, event.date) && Objects.equals(category, event.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, date, category, isPublic);
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", isPublic=" + isPublic +
                '}';
    }
}
