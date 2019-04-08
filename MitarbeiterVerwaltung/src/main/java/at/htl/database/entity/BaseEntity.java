package at.htl.database.entity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    public BaseEntity() {
    }

    public Long getId() {
        return id;
    }

    protected <T> void setIfPresent(Consumer<T> set, Supplier<T> get){
        Optional.of(get.get()).ifPresent(set::accept);
    }

    public void update(BaseEntity changeset) {
    }

    public JsonObjectBuilder toJsonObjectBuilder(){
        return Json.createObjectBuilder()
                .add("id", id);
    }

    public JsonObject toJsonObject(){
        return toJsonObjectBuilder().build();
    }
}
