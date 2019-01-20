package at.htl.rest.endpoint;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class DeveloperEndpointIT {
     static Client client;
     static WebTarget target;

    @BeforeAll
    static void setup(){
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080/mitarbeiterverwaltung/api/");
    }

    @Test
    void T01_create(){
        Response response = target.request("developer").get();
        String body = response.readEntity(String.class);
        System.out.println(body);
    }
}
