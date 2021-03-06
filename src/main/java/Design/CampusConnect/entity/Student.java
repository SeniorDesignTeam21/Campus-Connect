package Design.CampusConnect.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Student {
    public Student() {
    }

    public Student(String firstName, String lastName, String password, String email, boolean confirmed) {
        this.username = "";
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
//        this.groups = new ArrayList<>();
        this.groups = new HashSet<>();
        this.confirmed = confirmed;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    private boolean confirmed;

    @ElementCollection(fetch = FetchType.EAGER, targetClass=Integer.class)
    private Set<Integer> groups = new HashSet<>();


    public Set<Integer> getGroups() {
        return groups;
    }

    public void setGroups(Set<Integer> groups) {
        this.groups = groups;
    }


    public Integer getId() {
        return id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", groups='" + groups + '\'' +
                ", confirmed='" + confirmed + '\'' +
                '}';
    }
}
