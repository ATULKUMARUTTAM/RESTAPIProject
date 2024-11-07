package com.example.RESTAPIProject.EmpController;




import com.example.RESTAPIProject.Model.Employee;
import com.example.RESTAPIProject.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService es;

    @PostMapping("/save")
    public ResponseEntity<String> createEmp(@RequestBody  Employee e)
    {
            es.saveEmp(e);
            return  new ResponseEntity<>("Saved!!!!", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public    ResponseEntity<List<Employee>> getalllEMP()
    {
                 List<Employee> students=  es.getAll();
                 return new ResponseEntity<>(students, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmpp(@PathVariable Long id)
    {
       String s=  es.deleteEmp(id);
        return  new ResponseEntity<>(s, HttpStatus.ACCEPTED);
    }


    @GetMapping("/find/{id}")
  public  ResponseEntity<Employee> findbyid( @PathVariable  Long id){

        Optional<Employee>e =  es.findEmp(id);
        if (e.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            else
        return new ResponseEntity<Employee>(e.get(), HttpStatus.FOUND);
  }
        @PutMapping("/update/{id}")
        public ResponseEntity<String> updateEmployee(@PathVariable Long id,@RequestBody Employee e)
        {
                String s =  es.updateEmp(id,e);
         return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
        }















}
