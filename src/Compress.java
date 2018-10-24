
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Compress {
    String word;
    List<Tag> tags = new ArrayList<>();
    HashMap<Integer,String> dic = new HashMap<Integer, String>();

    public Compress(String word) {
        this.word = word;
    }

    public void compress(){
        // to avoid starting in index 1
        dic.put(0,"null");

        // string concate
        String con="";
        String match = "";
        boolean found = false;
        Integer keyMap = 1;
        int tagIndex = 0;

        for(int i=0;i<word.length();i++){
            con += word.charAt(i);
            /*System.out.println(con);
            System.out.println(dic.size());*/
            // means dic has values
            if(dic.size()>0){
                for(int k=1;k<dic.size();k++){
                    match = dic.get(k);
                    // found in dic
                    if(match.equals(con)){
                        found = true;
                        tagIndex = k;
                        continue;
                    }
                }
                // not found
                if(!found){
                    dic.put(keyMap,con);
                    keyMap++;
                    tags.add(new Tag(tagIndex,word.charAt(i)));
                    con="";
                    tagIndex = 0;
                }else{
                    found = false;
                    if(i==word.length()-1){
                        tags.add(new Tag(tagIndex,'/'));
                    }
                }
            }
        }
    }

    public void PrintTags(){
        for(int i=0;i<tags.size();i++){
            System.out.println(tags.get(i));
        }
    }
    public void PrintDic(){
        for(int i=1;i<dic.size();i++){
            System.out.println(i+" "+dic.get(i));
        }
    }

    public List<Tag> getTags() {
        return tags;
    }
}
