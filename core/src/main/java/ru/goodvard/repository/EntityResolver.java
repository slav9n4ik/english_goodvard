package ru.goodvard.repository;

import ru.goodvard.repository.entity.ParentUser;

public interface EntityResolver {
    void saveParentUserIfNotExists(ParentUser user);
}
