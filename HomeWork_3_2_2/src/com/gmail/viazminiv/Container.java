package com.gmail.viazminiv;

import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "d:\\file.txt")
    public class Container {
        String text = "Hello World";
        @Saver
        public void save(String path) throws IOException {
            FileWriter fw = new FileWriter(path);
            try {
                fw.write(text);
            }finally {
                fw.close();
            
        }
    }
}

