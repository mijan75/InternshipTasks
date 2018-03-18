package models;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student extends Model {
    @Id @Constraints.Required
    public String id;
    @Constraints.Required
    public String name;
    @Constraints.Required
    public String address;
    @Constraints.Required
    public String phone;
    @Constraints.Required
    @Constraints.Email
    public String email;

    public static Finder<String, Student> find = new Finder<>(Student.class);
}
