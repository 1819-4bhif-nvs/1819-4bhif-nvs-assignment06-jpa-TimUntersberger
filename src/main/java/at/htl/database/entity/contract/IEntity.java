package at.htl.database.entity.contract;

public interface IEntity<Entity> {
    void update(Entity entity);
    static void merge(IEntity e1, IEntity e2){};
    void setId(Long id);
    Long getId();
}
