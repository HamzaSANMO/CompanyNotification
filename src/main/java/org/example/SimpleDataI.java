package org.example;

import java.io.IOException;
import java.util.List;

public interface SimpleDataI<T> {
    void saveFile(List<T> objects) throws IOException;
    List<T> loadFile();


}
