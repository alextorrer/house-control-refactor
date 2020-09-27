package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileReader {

    private String path;
   
    public FileReader(String path){
        this.path = path;
    }

    /**
     *
     * @return the parsed file in a single string
     * @throws FileNotFoundException to be handled by the caller
     */
    public String getContentFile() throws FileNotFoundException{
        Scanner file = new Scanner(new File(this.path));
        String content = "";
        while (file.hasNextLine()) {
            content += file.nextLine()+"\n";
        }
        file.close();

        return content;
    }

}
