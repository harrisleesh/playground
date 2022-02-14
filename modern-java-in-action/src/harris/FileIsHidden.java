package harris;

import java.io.File;
import java.io.FileFilter;

public class FileIsHidden {
    public static void main(String[] args) {
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
    }
}
