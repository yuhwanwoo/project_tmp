package com.lunchpick.lunchpick.domain.medel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;

    private int age;

    private String address_home;

    private String address_company;

    private String email;

    private String phone;

    @OneToMany(mappedBy = "user")
    private List<Place> places = new ArrayList<>();
}
