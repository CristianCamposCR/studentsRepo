package com.example.estudents.contorllers.student;

import com.example.estudents.models.student.Student;
import com.example.estudents.models.student.StudentRepository;
import com.example.estudents.services.student.StudentService;
import com.example.estudents.utils.CustomReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-examen/student")
@CrossOrigin(origins = {"*"})
public class StudentController {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private StudentService service;
    @GetMapping("/")
    public ResponseEntity<CustomReponse<Object>> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomReponse<Object>> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<CustomReponse<Object>> insert(@RequestBody Student student){
        student.setMatricula("20213tn0");
        return new ResponseEntity<>(this.service.insert(student), HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<CustomReponse<Object>> update(@RequestBody Student student){
        return new ResponseEntity<>(this.service.update(student), HttpStatus.CREATED);
    }
    @PatchMapping("/")
    public ResponseEntity<CustomReponse<Integer>> enableOrDisable(@RequestBody Student student){
        return new ResponseEntity<>(this.service.changeStatus(student), HttpStatus.OK);
    }
}
