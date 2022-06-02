import java.util.ArrayList;
import java.util.Objects;

public class Category {
    ArrayList<Tuple<Integer,String>> Categories = new ArrayList<>();
    Category(){
        Categories.add(new Tuple<>(0,"Pop"));
        Categories.add(new Tuple<>(1,"Science"));
        Categories.add(new Tuple<>(2,"Sports"));
        Categories.add(new Tuple<>(3,"Rock"));
        Categories.add(new Tuple<>(4,"Pop"));
        Categories.add(new Tuple<>(5,"Science"));
        Categories.add(new Tuple<>(6,"Sports"));
        Categories.add(new Tuple<>(7,"Rock"));
        Categories.add(new Tuple<>(8,"Pop"));
        Categories.add(new Tuple<>(9,"Rock"));
        Categories.add(new Tuple<>(10,"Sports"));
        Categories.add(new Tuple<>(11,"Rock"));
    }
    public String currentCategory(int currentPlayerPlace) {
        String Result = null;
        for (Tuple<Integer, String> category : Categories) {
            if (currentPlayerPlace == category.x()) {
                Result = category.y();
                break;
            }
        }
        if (Objects.equals(Result, null)){
            throw new IllegalArgumentException("Not valid place");
        }
        return Result;
    }
    public String[] returnAllCategories(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < Categories.size(); i++) {
            if (!list.contains(Categories.get(i).y())){
                list.add(Categories.get(i).y());
            }
        }
        return list.toArray(new String[list.size()]);
    };
}
