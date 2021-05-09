package pl.spot.on.micronaut.perftest.gc;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import lombok.RequiredArgsConstructor;

@Controller("/api/test")
@RequiredArgsConstructor
public class MaxRequestController {

    @Get("/{elementsSize}")
    public int countRandomSumGet(int elementsSize) {
        RandomSumGenerator generator = new RandomSumGenerator(elementsSize);
        return generator.sum();
    }

    @Post("/{elementsSize}")
    public int countRandomSumPost(int elementsSize) {
        RandomSumGenerator generator = new RandomSumGenerator(elementsSize);
        return generator.sum();
    }

}
