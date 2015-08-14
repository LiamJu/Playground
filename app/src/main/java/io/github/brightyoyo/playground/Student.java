package io.github.brightyoyo.playground;

import javax.inject.Inject;

/**
 * @author bri
 * @date 15-8-8.
 */
public class Student {

    private String name = "droideep";

    @Inject
    public Student() {
    }

    public String getName() {
        return name;
    }
}
