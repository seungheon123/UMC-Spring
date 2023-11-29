package com.example.umc.domain;

import com.example.umc.domain.common.BaseEntity;
import com.example.umc.domain.mapping.MemberMission;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")
    private Long id;

    @Column(nullable = false,length = 45)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int point;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission",cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
