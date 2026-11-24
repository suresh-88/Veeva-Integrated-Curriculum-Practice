import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreatingFile {
    public static void main(String[] args) throws IOException {
        File file = new File("Example.txt");
        file.createNewFile();
        System.out.println("file exists = " + file.exists());
        System.out.println("file is file = " + file.isFile());
        System.out.println("file is directory = " + file.isDirectory());
        System.out.println("file can read = " + file.canRead());
        System.out.println("file can write = " + file.canWrite());
        System.out.println("file can execute = " + file.canExecute());
        System.out.println("file path = " + file.getAbsolutePath());
        System.out.println("file length = "+file.length());
    }
}
