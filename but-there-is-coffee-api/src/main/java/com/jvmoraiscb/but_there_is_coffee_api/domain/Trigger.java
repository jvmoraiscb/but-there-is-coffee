package com.jvmoraiscb.but_there_is_coffee_api.domain;

import java.util.Objects;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Trigger {
    private UUID id;
    private String name;
    private String location;

    public Trigger(UUID id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    @Override
    public boolean equals(Object o){
        if (o == null || this.getClass() != o.getClass())
            return false;
        Trigger that = (Trigger) o;
        return Objects.equals(this.id, that.id) && Objects.equals(this.name, that.name) && Objects.equals(this.location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.location);
    }
}
