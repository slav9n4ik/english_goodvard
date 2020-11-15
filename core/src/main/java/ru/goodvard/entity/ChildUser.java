package ru.goodvard.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.sql.Timestamp;

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
    private Timestamp updateTime;
}
