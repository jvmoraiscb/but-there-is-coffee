package com.jvmoraiscb.but_there_is_coffee_api.domain.user;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.jvmoraiscb.but_there_is_coffee_api.domain.team.Team;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private UUID id;
    private String email;
    private String password;
    private List<Team> userTeams;

    public User(UUID id, String email) {
        this.id = id;
        this.email = email;
    }

    @Override
    public boolean equals(Object o){
        if (o == null || this.getClass() != o.getClass())
            return false;
        User that = (User) o;
        return Objects.equals(this.id, that.id) && Objects.equals(this.email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.email);
    }
}
