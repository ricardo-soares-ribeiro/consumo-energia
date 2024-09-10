package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class csvReader {
    public void readFile(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
    }
}
