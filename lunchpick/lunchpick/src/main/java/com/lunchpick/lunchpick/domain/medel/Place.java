package com.lunchpick.lunchpick.domain.medel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Place {

    @Id
    @GeneratedValue
    @Column(name = "place_id")
    private Long id;

    private String name;

    private String address;

    private String latitude;

    private String longitude;

    private LocalDateTime update_time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "place")
    private List<Restaurant> restaurants = new ArrayList<>();
}