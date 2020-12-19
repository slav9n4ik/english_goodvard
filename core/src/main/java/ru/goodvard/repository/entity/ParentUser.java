package ru.goodvard.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.goodvard.controller.dto.ParentUserDto;
import ru.goodvard.controller.dto.RegistrationDto;
import ru.goodvard.controller.dto.SendEmailDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;
import static java.util.stream.Collectors.toSet;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.SEQUENCE;
import static ru.goodvard.repository.entity.UserStatus.INTERESTED;
import static ru.goodvard.repository.entity.UserStatus.REGISTRATION;

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
    private Boolean activated;
    private UUID activationCode;

    @Enumerated(STRING)
    private UserStatus status;

    @Column(name = "update_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime updateTime;

    @OneToMany(fetch = EAGER, cascade = ALL)
    private Set<ChildUser> childUser;

    public static ParentUser fromEmailRequestDto(SendEmailDto request) {
        ParentUser parentUser = new ParentUser();
        parentUser.setName(request.getName());
        parentUser.setPhone(request.getPhone());
        parentUser.setEmail(request.getEmail());
        parentUser.setStatus(INTERESTED);
        parentUser.setActivated(false);
        parentUser.setActivationCode(randomUUID());
        parentUser.setUpdateTime(now());
        return parentUser;
    }

    public static ParentUser fromParentDto(ParentUserDto parentDto) {
        ParentUser parentUser = new ParentUser();
        parentUser.setName(parentDto.getName());
        parentUser.setSurname(parentDto.getSurname());
        parentUser.setMiddleName(parentDto.getMiddleName());
        parentUser.setSubscribe(parentDto.getSubscribe());
        parentUser.setPhone(parentDto.getPhone());
        parentUser.setEmail(parentDto.getEmail());
        parentUser.setStatus(REGISTRATION);
        parentUser.setActivated(false);
        parentUser.setActivationCode(randomUUID());
        parentUser.setUpdateTime(now());
        return parentUser;
    }

    public static ParentUser fromRegistrationDto(RegistrationDto registration) {
        ParentUser parentUser = fromParentDto(registration.getParentUserDto());

        var children = registration.getChildrenDto();
        if (children != null && !children.isEmpty()) {
            parentUser.setChildUser(children.stream()
                    .map(ChildUser::fromEntity)
                    .collect(toSet()));
        }

        return parentUser;
    }
}
