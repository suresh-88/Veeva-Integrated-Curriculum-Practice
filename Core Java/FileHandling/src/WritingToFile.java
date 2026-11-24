import java.io.*;

public class WritingToFile {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Example.txt",true))) {
            writer.write("Good Bye");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}