package at.htl.rest.dto.converter;

import at.htl.database.dao.AbstractCrudDao;
import at.htl.database.entity.contract.IEntity;

public abstract class AbstractDtoConverter<
        Entity extends EntityContract,
        EntityDto extends EntityContract,
        EntityContract extends IEntity<EntityContract>
        > {
    protected abstract AbstractCrudDao<Entity> getDao();
    protected abstract Class<Entity> getEntityClass();
    protected abstract Class<EntityDto> getEntityDtoClass();
    protected abstract void updateEntity(EntityContract e1, EntityContract e2);

    public Entity toEntity(EntityDto dto){
       if(dto == null)
            return null;

        Entity entity = null;

        if(dto.getId() != null)
            entity = getDao().findById(dto.getId());
        else {
            try {
                entity = getEntityClass().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        updateEntity(entity, dto);

        return entity;
    }

    public EntityDto toDto(Entity entity){
        if(entity == null)
            return null;

        EntityDto entityDto = null;


        try {
            entityDto = getEntityDtoClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        entityDto.setId(entity.getId());

        updateEntity(entityDto, entity);

        return entityDto;
    }
}
