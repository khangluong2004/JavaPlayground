package playground;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) {
        try {
            File fp = new File("test.txt");
        
            // CReate new file
            if (!fp.exists()){
                fp.createNewFile();
            }

            // Write file
            FileWriter file_writer = new FileWriter("test.txt");
            file_writer.write("Hello, first file");
            file_writer.close();

            // Read file
            Scanner file_reader = new Scanner(fp);
            while (file_reader.hasNextLine()){
                String a = file_reader.nextLine();
                System.out.println(a);
            }
            file_reader.close();
        } catch (IOException e){
            System.out.println(e);
        }
        

    }
}
