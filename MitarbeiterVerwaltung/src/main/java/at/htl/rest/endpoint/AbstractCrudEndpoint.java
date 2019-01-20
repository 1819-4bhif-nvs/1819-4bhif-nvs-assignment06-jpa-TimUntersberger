package at.htl.rest.endpoint;


import at.htl.database.dao.ICrudDao;
import at.htl.database.entity.BaseEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Produces(MediaType.APPLICATION_JSON)
public abstract class AbstractCrudEndpoint<TEntity extends BaseEntity> {
    protected abstract ICrudDao<TEntity> getDao();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(TEntity entity){
        ICrudDao<TEntity> dao = getDao();
        dao.create(entity);
        return Response
                .status(Response.Status.CREATED)
                .entity(entity.getId())
                .build();
    }

    @GET
    public List<TEntity> read(){
        return getDao()
            .findAll()
            .stream()
            .collect(Collectors.toList());

    }

    @GET
    @Path("{id}")
    public TEntity readById(@PathParam("id") Long id){
        return getDao().findById(id);
    }

    @PATCH
    @Path("{id}")
    public Response update(@PathParam("id") Long id, TEntity entity){
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
