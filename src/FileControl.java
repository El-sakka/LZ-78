import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileControl {

    protected static void write(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);

    }
}
