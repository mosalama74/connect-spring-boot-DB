package com.mosalama.student;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "_student")
public class Student {

    @Id
    @GeneratedValue
    private int id;

    private String firstname;

    private String lastname;

    private LocalDate dateOfBirth;

    private String gender;

    @Column(unique=true)
    private String email;

    @Transient
    private int age;

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
