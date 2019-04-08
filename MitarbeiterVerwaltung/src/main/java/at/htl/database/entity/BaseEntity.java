package at.htl.database.entity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import java.time.LocalDate;
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

    protected <T> void setNonNull(Consumer<T> set, Supplier<T> get){
        T value = get.get();
        if(value != null){
            set.accept(value);
        }
    }

    public void update(BaseEntity changeset) {
    }

    public JsonObject serialize(){
        return Json.createObjectBuilder()
                .add("id", id)
                .build();
    }
}
