package com.tekup.mp.web.model.requests;

import com.tekup.mp.jpa.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;
import java.util.Collection;

@Getter
@Setter
public class UserForm {

    private Long idUser;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private Collection<RoleEnum> roles;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Collection<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RoleEnum> roles) {
        this.roles = roles;
    }
}
