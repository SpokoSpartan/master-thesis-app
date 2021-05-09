package pl.spot.on.quarkus.perftest;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class QuarkusPerftestApplication {

    public static void main(String ... args) {
        Quarkus.run(args);
    }

}
