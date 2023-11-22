package com.example.umc.domain;

import com.example.umc.domain.common.BaseEntity;
import com.example.umc.domain.mapping.Review;
import com.example.umc.domain.mapping.StoreType;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @Column(nullable = false,length = 45)
    private String name;

    @Column(nullable = false)
    private String address;

    private int reviews;

    @Column(columnDefinition = "decimal(2,1) default 5.0")
    private Double rating;

    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<StoreType> storeTypeList = new ArrayList<>();

}
