package org.example.entities;

public class Scanner extends Device implements IScanner {

    @Override
    public void processDoc(String doc) {
        System.out.println("Scanner processing: " + doc);
    }

    public String scan() {
        return "Scanned content";
    }
}
