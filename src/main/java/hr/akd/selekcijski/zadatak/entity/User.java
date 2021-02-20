package hr.akd.selekcijski.zadatak.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 40)
    private String firstName;

    @Size(max = 40)
    private String lastName;

    @PastOrPresent
    private Date birthDate;

    public User() {
    }

    public User(@Size(max = 40) String firstName, @Size(max = 40) String lastName, @PastOrPresent Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(!(obj instanceof User))return false;

        return id != null && id.equals(((User) obj).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
