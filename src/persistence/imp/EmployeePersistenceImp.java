package persistence.imp;

import models.Employee;
import persistence.EmployeePersistence;

import java.util.Hashtable;

public class EmployeePersistenceImp implements EmployeePersistence {

  private Hashtable<String,Employee> employeesByName = new Hashtable<>();
  private Hashtable<String, Employee> employeesById = new Hashtable<>();
  private Hashtable<String, Employee> employeesBySocialSecurityNumber = new Hashtable<>();

  @Override
  public Employee saveEmployee(Employee employee) {
    employeesByName.put(employee.getName(),employee);
    employeesById.put(employee.getId(),employee);
    employeesBySocialSecurityNumber.put(employee.getSocialSecurityNumber(),employee);
    return employee;
  }

  @Override
  public Employee getEmployee(int searchCriteria, String key) throws RuntimeException{
    return getHashTableBySearchCriteria(searchCriteria).get(key);
  }

  private Hashtable<String, Employee> getHashTableBySearchCriteria(int searchCriteria){
    switch (searchCriteria){
      case 1:
        return  employeesByName;
      case 2:
        return employeesById;
      case 3:
        return  employeesBySocialSecurityNumber;
      default:
        throw new RuntimeException("Criterio de busqueda invalido.");
    }
  }
}
