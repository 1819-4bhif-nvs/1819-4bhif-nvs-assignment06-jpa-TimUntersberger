package at.htl.database.dao;

import java.util.List;

public interface ICrudDao<Entity> {
    void create(Entity entity);
    List<Entity> findAll();
    Entity findById(Long id);
    void update(Long id, Entity changeset);
    void delete(Long id);
}
