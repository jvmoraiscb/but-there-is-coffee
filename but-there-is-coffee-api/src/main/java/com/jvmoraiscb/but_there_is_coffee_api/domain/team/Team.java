package com.jvmoraiscb.but_there_is_coffee_api.domain.team;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.jvmoraiscb.but_there_is_coffee_api.domain.user.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Team {
    private UUID id;
    private String name;
    private String description;
    private List<User> users;

    public Team(UUID id, String name, String description, List<User> users){
        this.id = id;
        this.name = name;
        this.description = description;
        this.users = users;
    }
    
    @Override
    public boolean equals(Object o){
        if (o == null || this.getClass() != o.getClass())
            return false;
        Team that = (Team) o;
        return Objects.equals(this.id, that.id) && Objects.equals(this.name, that.name) && Objects.equals(this.description, that.description) && Objects.equals(this.users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.description, this.users);
    }


}
