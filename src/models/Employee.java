package models;

public class Employee {
  private String id;
  private String name;
  private String socialSecurityNumber;

  public Employee(String id, String name, String socialSecurityNumber) {
    this.id = id;
    this.name = name;
    this.socialSecurityNumber = socialSecurityNumber;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  public void setSocialSecurityNumber(String socialSecurityNumber) {
    this.socialSecurityNumber = socialSecurityNumber;
  }

  @Override
  public String toString() {
    return
            "Numero='" + id + '\'' +
            ", Nombre='" + name + '\'' +
            ", No. Seguridad Social='" + socialSecurityNumber + '\'';
  }
}