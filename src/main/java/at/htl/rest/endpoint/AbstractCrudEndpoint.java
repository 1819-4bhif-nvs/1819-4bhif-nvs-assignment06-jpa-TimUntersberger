package at.htl.rest.endpoint;


import at.htl.database.dao.ICrudDao;
import at.htl.database.entity.contract.IEntity;
import at.htl.rest.dto.converter.AbstractDtoConverter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Produces(MediaType.APPLICATION_JSON)
public abstract class AbstractCrudEndpoint<
        Entity extends EntityDtoContract,
        Dto extends EntityDtoContract,
        EntityDtoContract extends IEntity<EntityDtoContract>,
        EntityDtoConverter extends AbstractDtoConverter<Entity, Dto, EntityDtoContract>
> {
    protected abstract ICrudDao<Entity> getDao();
    protected abstract EntityDtoConverter getDtoConverter();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Dto dto){
        ICrudDao<Entity> dao = getDao();
        Entity entity = getDtoConverter().toEntity(dto);

        dao.create(entity);

        return Response
                .status(Response.Status.CREATED)
                .entity(entity.getId())
                .build();
    }

    @GET
    public List<Dto> read(){
        return getDao()
            .findAll()
            .stream()
            .map(getDtoConverter()::toDto)
            .collect(Collectors.toList());

    }

    @GET
    @Path("{id}")
    public Dto readById(@PathParam("id") Long id){
        return getDtoConverter().toDto(getDao().findById(id));
    }

    @PATCH
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Dto dto){
        Entity entity = getDtoConverter().toEntity(dto);

        getDao().update(id, entity);

        return Response
                .ok()
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        getDao().delete(id);
        return Response
                .ok()
                .build();
    }
}
