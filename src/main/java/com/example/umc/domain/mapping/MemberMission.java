package com.example.umc.domain.mapping;

import com.example.umc.domain.Member;
import com.example.umc.domain.Mission;
import com.example.umc.domain.common.BaseEntity;
import com.example.umc.domain.enums.MissionStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "member_mission")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_mission_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus missionStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
}
