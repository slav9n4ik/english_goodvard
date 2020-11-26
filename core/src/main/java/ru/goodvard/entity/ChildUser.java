package ru.goodvard.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "child_user")
@NoArgsConstructor
public class ChildUser {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private int id;
    private String name;
    private double experience;
    private double experienceInCurrentSchool;
    private int ages;

    @Column(name = "update_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime updateTime;
}
