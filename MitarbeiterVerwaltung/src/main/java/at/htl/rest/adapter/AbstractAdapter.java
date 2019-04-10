package at.htl.rest.adapter;

import at.htl.database.entity.BaseEntity;

import javax.json.JsonObject;

public abstract class AbstractAdapter<TEntity extends BaseEntity> {
    public abstract JsonObject marshall(TEntity entity);
    public abstract TEntity unmarshall(JsonObject json);
}
