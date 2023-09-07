import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
// TODO: add validation
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader("teams.txt"))) {
            HashMap<String, ArrayList<String>> teams = new HashMap<>();
            while ((line = br.readLine()) != null) {
                String [] lineArr = line.split(":");
                String [] teamArr = lineArr[1].split(",");

                for (String name : teamArr) {
                    if (!teams.containsKey(name)) {
                        teams.put(name, new ArrayList<String>());
                    }
                    ArrayList<String> teamNames = teams.get(name);
                    teamNames.add(lineArr[0]);
                }
            }
            teams.forEach((k, v) -> {
               System.out.println(k + " plays in:" + listToString(v));
            });
        } catch (IOException e) {
           // e.printStackTrace();
            System.out.println("IOException in try block =>" + e.getMessage());
        }

    }

    public static String listToString(ArrayList<String> arrList) {
        StringBuilder result = new StringBuilder(" ");
        for (String s : arrList) {
            result.append(s.toString()).append(" ");
        }
        return result.toString();
    }
}