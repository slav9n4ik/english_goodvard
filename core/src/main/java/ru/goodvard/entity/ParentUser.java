package ru.goodvard.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "parent_user")
@NoArgsConstructor
public class ParentUser {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private int id;
    private String name;
    private String surname;
    private String middleName;
    private String email;
    private String phone;
    private String description;

    @Enumerated(STRING)
    private UserStatus userStatus;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "child_id")
    private ChildUser childUser;
}
