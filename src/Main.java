import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String word = "";
        List<Tag> tags = new ArrayList<>();

        FileReader fileReader = new FileReader("words.txt");
        int c = 0;
        while((c = fileReader.read() )!= -1){
            word += (char) c ;
        }

        Compress compress = new Compress(word);
        compress.compress();
        compress.PrintTags();
        compress.PrintDic();
        tags = compress.getTags();

        FileWriter fileWriter = new FileWriter("tags.txt");
        for(int i=0;i<tags.size();i++){
            fileWriter.write(String.valueOf(tags.get(i))+"\n");
        }
        fileWriter.flush();
        fileWriter.close();

     /*   FileReader fileReader1 = new FileReader("tags.txt");
        int x = 0;
        while((x = fileReader1.read()) != -1){

        }
*/
        DeCompress deCompress = new DeCompress(tags);
        deCompress.deCompress();
        deCompress.printDic();

        if(deCompress.getWord().equals(word))
            System.out.println("matched");

    }
}
