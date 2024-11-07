package com.example.RESTAPIProject.Service;

import com.example.RESTAPIProject.Model.Employee;
import com.example.RESTAPIProject.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo er;

    public Employee saveEmp(Employee e){
        return er.save(e);
    }

    public Optional<Employee> findEmp(Long id){
        return er.findById(id);
    }

    public String deleteEmp(Long id){
      Optional<Employee> e =   findEmp(id);
      if(e.isEmpty())
          return "Empployee Not Exist";
      else
        {
            er.deleteById(id);
        return "deleted emplyee";
        }

    }

    public List<Employee> getAll()
    {
        return er.findAll();
    }

    public String updateEmp(Long id, Employee e)
    {
           Optional<Employee> emp =   findEmp(id);
           if(emp.isEmpty())
               return  "Employee Not Exist!!!";
           else {
               emp.get().setName(e.getName());
               emp.get().setSalary(e.getSalary());
                saveEmp(emp.get());
                return "Employee Updated!!!!";
           }
    }
}
