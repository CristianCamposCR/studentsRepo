package com.example.estudents.models.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String lastname;
    @Column
    private String curp;
    @Column
    private String birthday;
    @Column
    private String matricula;
    @Column
    private Boolean status;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", curp='" + curp + '\'' +
                ", birthday='" + birthday + '\'' +
                ", matricula='" + matricula + '\'' +
                ", status=" + status +
                '}';
    }
}
