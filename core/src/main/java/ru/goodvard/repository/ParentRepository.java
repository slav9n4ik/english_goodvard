package ru.goodvard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.goodvard.entity.ParentUser;

import java.util.List;

public interface ParentRepository extends JpaRepository<ParentUser, Integer> {
    List<ParentUser> findAllByPhone(String phone);
}
