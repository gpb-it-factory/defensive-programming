package com.example.demo.npe.acl;

/**
 * После использования нашего anti-corruption layer мы уверены
 * в модели, которую получили
 */
public class UserACL {

    public static User transform(ExternalUserDTO externalUser) {
        if (ExternalUserValidator.isValid(externalUser)) {
            return new User(externalUser.getName(), externalUser.getEmail(), externalUser.getAge());
        } else {
            // какая-то обработка, в реальности долнжы быть какие-то детали
            throw new IllegalArgumentException("Не пройдена валидация");
        }
    }
}