package com.jvmoraiscb.but_there_is_coffee_api.domain.entity;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class User {
    private UUID id;
    private String email;
    private List<Group> usergGroups;

    public User(UUID id, String email, String password, List<Group> userGroups) {
        this.id = id;
        this.email = email;
        this.usergGroups = userGroups;
    }

    @Override
    public boolean equals(Object o){
        if (o == null || this.getClass() != o.getClass())
            return false;
        User that = (User) o;
        return Objects.equals(this.id, that.id) && Objects.equals(this.email, that.email) && Objects.equals(this.usergGroups, that.usergGroups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.email);
    }
}
