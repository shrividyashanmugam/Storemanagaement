package billing;

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    private String fileStr;

    public FileGenerator(String fileStr) {
        this.fileStr = fileStr;
    }

    public void generate(String fileName){
        try{
            FileWriter writer=new FileWriter("billfiles/"+fileName+"generated.txt",false);
            writer.write(this.fileStr);
            writer.close();
            System.out.println("Bill File created successfully");
        } catch(IOException e){
            System.out.println("Error occured in generating the bill file");
        }
    }
}
