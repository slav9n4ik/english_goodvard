package ru.goodvard.repository;

import ru.goodvard.repository.entity.ParentUser;

public interface EntityResolver {
    long getUsersCount();
    void saveParentUserIfNotExists(ParentUser user);
}
