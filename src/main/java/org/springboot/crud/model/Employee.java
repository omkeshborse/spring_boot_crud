package org.springboot.crud.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(name = "first_name" , nullable = false , length = 50)
    private String firstName ;
    @Column(name = "last_name" , nullable = false , length = 50)
    private String lastName ;
    @Column(name = "email" , nullable = false , unique = true , updatable = false )
    private String email ;

}
