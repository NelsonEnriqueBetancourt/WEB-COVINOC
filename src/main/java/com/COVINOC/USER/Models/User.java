package com.COVINOC.USER.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Name_User",length = 20)
    private String Name;
    @Column(name = "lastName_User",length = 20)
    private String lastName;
    @Column(name = "Email_User",length = 50)
    private String Email;
    @Column(name = "Telephone_User",length = 15)
    private int Telephone;
    @Column(name = "Identification_User",length = 15)
    private int Identification;


}
