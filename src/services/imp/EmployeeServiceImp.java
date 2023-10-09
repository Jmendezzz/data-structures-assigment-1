package services.imp;

import models.Employee;
import persistence.EmployeePersistence;
import persistence.imp.EmployeePersistenceImp;
import services.EmployeeService;

import java.util.Optional;

public class EmployeeServiceImp implements EmployeeService {
  EmployeePersistence employeePersistence;
  public EmployeeServiceImp(){
    employeePersistence = new EmployeePersistenceImp();
  }

  @Override
  public Employee createEmployee(Employee employee) {
    return employeePersistence.saveEmployee(employee);
  }

  @Override
  public Optional<Employee> getEmployeeByKey(int searchCriteria, String key) {
    try{
      Employee employee = employeePersistence.getEmployee(searchCriteria,key);
      return Optional.ofNullable(employee);

    }catch (RuntimeException ex){
      System.out.println(ex.getMessage());
      return Optional.empty();
    }
  }
}
