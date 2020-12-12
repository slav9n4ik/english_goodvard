package ru.goodvard.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.goodvard.controller.dto.SendEmailDto;

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
    @SequenceGenerator(name="p-user-seq-gen", sequenceName="user_seq_gen")
    @GeneratedValue(strategy = SEQUENCE, generator="p-user-seq-gen")
    private int id;
    private String name;
    private String surname;
    private String middleName;
    private String email;
    private String phone;
    private String description;
    private Boolean subscribe;

    @Enumerated(STRING)
    private UserStatus status;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "child_id")
    private ChildUser childUser;

    public static ParentUser fromDto(SendEmailDto request, UserStatus status) {
        ParentUser parentUser = new ParentUser();
        parentUser.setName(request.getName());
        parentUser.setPhone(request.getPhone());
        parentUser.setEmail(request.getEmail());
        parentUser.setStatus(status);
        return parentUser;
    }
}
