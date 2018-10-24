import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeCompress {
    List<Tag> tags = new ArrayList<>();
    HashMap<Integer,String> dic = new HashMap<>();
    String word = "";
    public DeCompress(List<Tag> tags) {
        this.tags = tags;
    }

    public void deCompress(){
        //add none value to dic
        dic.put(0,"null");
        int keyMap = 1;
        String con = "";
        //boolean found  = false;

        for(Tag tag :tags){
            if(tag.getIndex() == 0){
                dic.put(keyMap,tag.getSymbol()+"");
                word+=tag.getSymbol();
                keyMap++;
            }
            else{
                // reach to final symbol
                if(tag.getSymbol() == '/'){
                    word += dic.get(tag.getIndex());
                }else{
                    // search in dic
                    con = dic.get(tag.getIndex()) + tag.getSymbol();
                    dic.put(keyMap,con);
                    word+=con;
                    con="";
                    keyMap++;
                }

            }
        }
    }

    public String getWord(){
        return word;
    }
    public void printDic(){
        for(int i=1;i<dic.size();i++){
            System.out.println(i+" "+ dic.get(i));
        }
    }


}
