package com.dalenys.snail;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Application {
    public static void main(String[] args) throws IOException {
        final Snail snail = new Snail();
        final String result = snail.compute(2);

        // display the result in the console
        System.out.println(result);

        // write the result in the file to display in chrome
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("snail.html"))) {
            writer.write(result);
        }
    }
}
