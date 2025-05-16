/*
package com.jvmoraiscb.but_there_is_coffee_api.domain;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Admin {
    private UUID id;
    private String email;
    private String password;
    private List<Group> adminGroups;
    private Boolean isSuperAdmin;

    public Admin(UUID id, String email, String password, List<Group> adminGroups, Boolean isSuperAdmin){
        this.id = id;
        this.email = email;
        this.password = password;
        this.adminGroups = adminGroups;
        this.isSuperAdmin = isSuperAdmin;
    }

    @Override
    public boolean equals(Object o){
        if (o == null || this.getClass() != o.getClass())
            return false;
        Admin that = (Admin) o;
        return Objects.equals(this.id, that.id) && Objects.equals(this.email, that.email) && Objects.equals(this.password, that.password) && Objects.equals(this.adminGroups, that.adminGroups) && Objects.equals(this.isSuperAdmin, that.isSuperAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.id, this.email, this.password, this.adminGroups, this.isSuperAdmin);
    }
}
    */
