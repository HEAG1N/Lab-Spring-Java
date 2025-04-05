package org.example.hobbysplatform;
import java.util.Objects;
public class Group {
    private String title;
    private String description;
    private int membersCount;
    private boolean openGroup;
    private String hobbyTag;

    public Group() {}

    public Group(String title, String description, int membersCount, boolean openGroup, String hobbyTag) {
        this.title = title;
        this.description = description;
        this.membersCount = membersCount;
        this.openGroup = openGroup;
        this.hobbyTag = hobbyTag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMembersCount() {
        return membersCount;
    }

    public void setMembersCount(int membersCount) {
        this.membersCount = membersCount;
    }

    public boolean isOpenGroup() {
        return openGroup;
    }

    public void setOpenGroup(boolean openGroup) {
        this.openGroup = openGroup;
    }

    public String getHobbyTag() {
        return hobbyTag;
    }

    public void setHobbyTag(String hobbyTag) {
        this.hobbyTag = hobbyTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return membersCount == group.membersCount && openGroup == group.openGroup && Objects.equals(title, group.title) && Objects.equals(description, group.description) && Objects.equals(hobbyTag, group.hobbyTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, membersCount, openGroup, hobbyTag);
    }

    @Override
    public String toString() {
        return "Group{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", membersCount=" + membersCount +
                ", openGroup=" + openGroup +
                ", hobbyTag='" + hobbyTag + '\'' +
                '}';
    }
}

