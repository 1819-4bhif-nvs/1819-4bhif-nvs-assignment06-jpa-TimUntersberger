package at.htl.rest.endpoint;

import at.htl.database.dao.AbstractDao;
import at.htl.database.entity.BaseEntity;
import at.htl.rest.adapter.AbstractAdapter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
public abstract class AbstractCrudEndpoint<TEntity extends BaseEntity> {
    protected abstract AbstractDao<TEntity> getDao();
    protected abstract AbstractAdapter<TEntity> getAdapter();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(JsonObject json){
        AbstractDao<TEntity> dao = getDao();
        TEntity entity = getAdapter().unmarshall(json);
        dao.create(entity);
        return Response
                .status(Response.Status.CREATED)
                .entity(entity.getId())
                .build();
    }

    @GET
    public JsonArray read(){
        return getDao()
                .findAll()
                .stream()
                .map(getAdapter()::marshall)
                .collect(Json::createArrayBuilder, JsonArrayBuilder::add, JsonArrayBuilder::add)
                .build();
    }

    @GET
    @Path("{id}")
    public JsonObject readById(@PathParam("id") Long id){
        return getDao().findById(id).toJsonObject();
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
