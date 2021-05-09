package pl.spot.on.quarkus.perftest.gc;

import lombok.RequiredArgsConstructor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
@Path("/api/test")
@RequiredArgsConstructor
public class MaxRequestController {

    @GET
    @Path("/{elementsSize}")
    public int countRandomSumGet(@PathParam("elementsSize")  int elementsSize) {
        RandomSumGenerator generator = new RandomSumGenerator(elementsSize);
        return generator.sum();
    }

    @POST
    @Path("/{elementsSize}")
    public int countRandomSumPost(@PathParam("elementsSize") int elementsSize) {
        RandomSumGenerator generator = new RandomSumGenerator(elementsSize);
        return generator.sum();
    }

}
