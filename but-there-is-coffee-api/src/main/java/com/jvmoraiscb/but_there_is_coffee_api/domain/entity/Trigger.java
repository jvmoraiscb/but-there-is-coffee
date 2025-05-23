package com.jvmoraiscb.but_there_is_coffee_api.domain.entity;

import java.util.Objects;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Trigger {
    private UUID id;
    private String name;
    private String location;
    private String locationUrl;
    private Group group;

    public Trigger(UUID id, String name, Group group, String location, String locationUrl) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.locationUrl = locationUrl;
        this.group = group;
    }

    @Override
    public boolean equals(Object o){
        if (o == null || this.getClass() != o.getClass())
            return false;
        Trigger that = (Trigger) o;
        return Objects.equals(this.id, that.id) && Objects.equals(this.name, that.name) && Objects.equals(this.location, that.location) && Objects.equals(this.locationUrl, that.locationUrl) && Objects.equals(this.group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.location, this.locationUrl, this.group);
    }
}
