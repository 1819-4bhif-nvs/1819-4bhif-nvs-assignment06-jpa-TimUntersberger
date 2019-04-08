package at.htl.rest.serializer;

import at.htl.database.entity.BaseEntity;

import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

public class EntityReferenceSerializer implements JsonbSerializer<BaseEntity> {
    @Override
    public void serialize(BaseEntity obj, JsonGenerator generator, SerializationContext ctx) {
        if(obj == null)
            generator.writeNull();
        else
            generator.write(obj.getId());
    }
}
