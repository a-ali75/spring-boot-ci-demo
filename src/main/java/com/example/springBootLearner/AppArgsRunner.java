package com.example.springBootLearner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AppArgsRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Options :: " + args.getOptionNames()
                + " Non Options :: " + args.getNonOptionArgs()
                + " Option Values :: "
                + (Optional.ofNullable(
                        args.getOptionValues("one")).isPresent()
                ? args.getOptionValues("one").isEmpty() : "Null Option"));
    }
}
