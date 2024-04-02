package models;

import java.io.BufferedReader;
import java.io.FileReader;

public class CsvReader {
    public static void printCsvFile(String pathname) {
        String line;
        try (BufferedReader br =
                     new BufferedReader(new FileReader(pathname))) {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
