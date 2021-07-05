package am.mentorcliq.pojo;

import com.opencsv.bean.CsvBindByPosition;
import java.util.Objects;

public class User {

  @CsvBindByPosition(position = 0)
  private String name;
  @CsvBindByPosition(position = 1)
  private String email;
  @CsvBindByPosition(position = 2)
  private String division;
  @CsvBindByPosition(position = 3)
  private int age;
  @CsvBindByPosition(position = 4)
  private String timezone;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDivision() {
    return division;
  }

  public void setDivision(String division) {
    this.division = division;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getTimezone() {
    return timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", division='" + division + '\'' +
        ", age='" + age + '\'' +
        ", timezone='" + timezone + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(name, user.name) &&
        Objects.equals(email, user.email) &&
        Objects.equals(division, user.division) &&
        Objects.equals(age, user.age) &&
        Objects.equals(timezone, user.timezone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, division, age, timezone);
  }
}
