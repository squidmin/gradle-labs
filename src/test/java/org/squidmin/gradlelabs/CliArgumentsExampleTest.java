package org.squidmin.gradlelabs;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class CliArgumentsExampleTest {

    @Test
    public void basicExample() {
        String arg_1 = System.getProperty("arg_1");
        log.info("arg_1: {}", arg_1);
    }

}
