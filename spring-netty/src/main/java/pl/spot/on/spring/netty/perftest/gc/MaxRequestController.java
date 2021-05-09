package pl.spot.on.spring.netty.perftest.gc;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test/")
@RequiredArgsConstructor
public class MaxRequestController {


    @GetMapping("/{elementsSize}")
    public int countRandomSumGet(@PathVariable int elementsSize) {
        RandomSumGenerator generator = new RandomSumGenerator(elementsSize);
        return generator.sum();
    }

    @PostMapping("/{elementsSize}")
    public int countRandomSumPost(@PathVariable int elementsSize) {
        RandomSumGenerator generator = new RandomSumGenerator(elementsSize);
        return generator.sum();
    }

}
