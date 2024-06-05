package ex.springsecurity_1805.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="UsersInSystem")
public class Usermain {


    @Column(unique = true)
    private String name;
    private String password;
    private String roles;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
