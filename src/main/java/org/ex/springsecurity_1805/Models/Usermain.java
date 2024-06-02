package ex.springsecurity_1805.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="UsersInSystem")
public class Usermain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String password;
    private String roles;
}
