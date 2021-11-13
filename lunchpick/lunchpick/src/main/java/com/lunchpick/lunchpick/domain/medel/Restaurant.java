package com.lunchpick.lunchpick.domain.medel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Restaurant {

    @Id
    @GeneratedValue
    @Column(name = "restaurant_id")
    private Long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "restaurant")
    private List<Food> foods = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

}
