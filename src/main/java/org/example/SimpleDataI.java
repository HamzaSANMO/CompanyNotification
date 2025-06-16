package org.example;

import org.example.centity.Admin;

import java.io.IOException;
import java.util.List;

public interface SimpleDataI<M> {
    void saveFile(List<M> objects) throws IOException;
    List<M> loadFile();


}
