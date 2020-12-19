package ru.goodvard.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.goodvard.exceptions.SaveDbException;
import ru.goodvard.repository.entity.ParentUser;

@Slf4j
@Component
@AllArgsConstructor
public class EntityResolverImpl implements EntityResolver {

    private final ParentRepository parentRepository;

    @Override
    public void saveParentUserIfNotExists(ParentUser user) {
        log.info("Save user {} {} if not exist", user.getSurname(), user.getName());
        var parentsByPhone = parentRepository.findAllByPhone(user.getPhone());
        if (parentsByPhone.isEmpty()) saveParentUser(user);
    }

    private void saveParentUser(ParentUser user) {
        try {
            parentRepository.save(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SaveDbException(e.getMessage());
        }
    }
}
