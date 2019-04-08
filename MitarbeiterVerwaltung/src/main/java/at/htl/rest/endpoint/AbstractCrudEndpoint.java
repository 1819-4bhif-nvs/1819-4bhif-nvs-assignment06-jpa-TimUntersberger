package at.htl.rest.endpoint;


import at.htl.database.dao.ICrudDao;
import at.htl.database.entity.BaseEntity;

import javax.annotation.PreDestroy;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.bind.serializer.JsonbSerializer;
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
    public JsonArray read(){
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

        getDao()
                .findAll()
                .stream()
                .map(TEntity::serialize)
                .forEach(jsonArrayBuilder::add);

        return jsonArrayBuilder.build();
    }

    @GET
    @Path("{id}")
    public TEntity readById(@PathParam("id") Long id){
        TEntity entity = getDao().findById(id);
        return entity;
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
