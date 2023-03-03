import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input: ");
        String text = scanner.nextLine();
        String[] words = text.split(" ");
        TreeSet<String> ts = new TreeSet<>();
        ArrayList<String> wordlist = new ArrayList<>();
        for (String word:words) {
            word.toLowerCase();
            wordlist.add(word);
            ts.add(word);
        }
        System.out.println("В тексте "+ ts.size()+ " слов");
        System.out.println("Топ 10: ");
        wordlist.stream().collect(Collectors.toMap(key->key,val->1,Integer::sum))
                .entrySet().stream().sorted((e1, e2) ->{
                    int val = e1.getValue().compareTo(e2.getValue()) * -1;
                    if (val == 0) {
                        val = e1.getKey().compareTo(e2.getKey());
                    }
                    return val;
                }).limit(10).forEach(e ->System.out.println(e.getValue()+" - " + e.getKey()));

    }
}