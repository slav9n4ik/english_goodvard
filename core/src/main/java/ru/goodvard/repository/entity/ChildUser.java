package ru.goodvard.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.goodvard.controller.dto.ChildUserDto;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "child_user")
@NoArgsConstructor
public class ChildUser {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator="user-seq-gen")
    @SequenceGenerator(name="user-seq-gen", sequenceName="user_seq_gen")
    private int id;
    private String name;
    private double experience;
    private double experienceInCurrentSchool;
    private int ages;

    @ManyToOne(fetch = EAGER, cascade = ALL)
    @JoinColumn(name = "parent_id")
    private ParentUser parentUser;

    @Column(name = "update_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime updateTime;

    public static ChildUser fromEntity(ChildUserDto dto) {
        ChildUser child = new ChildUser();
        child.setAges(dto.getAges());
        child.setName(dto.getName());
        child.setExperience(dto.getExperience());
        child.setExperienceInCurrentSchool(dto.getExperienceInCurrentSchool());
        child.setUpdateTime(now());
        return child;
    }
}
