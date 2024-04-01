package com.lojaDeRoupas.app.coreClasses.userAutentication;

import com.lojaDeRoupas.app.coreClasses.genericCrudSuperClasses.CrudGenericEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class UserDefaultEntity extends CrudGenericEntity {
    @Column(unique = true, length = 50)
    private String login;
    @Column(nullable = false, length = 30)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Role role;
}
