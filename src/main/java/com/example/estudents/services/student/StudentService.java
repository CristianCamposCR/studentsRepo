package com.example.estudents.services.student;

import com.example.estudents.models.student.Student;
import com.example.estudents.models.student.StudentRepository;
import com.example.estudents.utils.CustomReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLDataException;

@Service
@Transactional

public class StudentService {
    @Autowired
    private StudentRepository repository;
    @Transactional(readOnly = true)
    public CustomReponse<Object> getAll(){
        return new CustomReponse<>(this.repository.findAll(), false, 200, "ok");
    }
    @Transactional(readOnly = true)
    public CustomReponse<Object> getlast(){
        return new CustomReponse<>(this.repository.getlast(), false, 200, "ok");
    }
    @Transactional(readOnly = true)
    public CustomReponse<Object> getOne(Long id){
        return new CustomReponse<>(this.repository.findById(id), false, 200, "ok");
    }

    @Transactional(rollbackFor = {SQLDataException.class})
    public CustomReponse<Object> insert(Student student){
        System.out.println(student.toString());

        if (this.repository.existsByCurp(student.getCurp())){
            return new CustomReponse<>(null, true, 400, "El alumno ya existe");}
        return new CustomReponse<>(this.repository.saveAndFlush(student), false, 200, "Alumno registrado correcatamente");
    }
    @Transactional(rollbackFor = {SQLDataException.class})
    public CustomReponse<Object> update(Student student){
        if (!this.repository.existsByCurp(student.getCurp()))
            return new CustomReponse<>(null, true, 400, "El alumno no existe");
        return new CustomReponse<>(this.repository.saveAndFlush(student), false, 200, "Alumno registrado correcatamente");

    }
    @Transactional(rollbackFor = {SQLDataException.class})
    public CustomReponse<Integer> changeStatus(Student student){
        if (!this.repository.existsById(student.getId()))
            return new CustomReponse<>(null, true, 400, "El alumno no existe");
        return new CustomReponse<>(this.repository.updateStatusById(student.getStatus(), student.getId()), false, 200, "Alumno registrado correcatamente");

    }
}
