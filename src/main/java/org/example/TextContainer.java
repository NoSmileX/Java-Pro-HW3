package org.example;

import org.example.annotations.*;

import java.io.IOException;
import java.io.PrintWriter;

@SaveTo(path = "c://new.txt")
public class TextContainer {
    private String someText;

    public TextContainer(String someText) {
        this.someText = someText;
    }

    public String getSomeText() {
        return someText;
    }
    @Saver
    public void save(String path){
        try (PrintWriter pw = new PrintWriter(path)){
            pw.println(someText);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
