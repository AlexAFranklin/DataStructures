import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        String line;
        try(BufferedReader br = new BufferedReader(new FileReader("teams.txt"))) {
            HashMap<String, ArrayList<String>> teams = new HashMap<>();
            while ((line = br.readLine()) != null) {
                String [] lineArr = line.split(":", -2);
                String [] teamArr = lineArr[1].split(",", -2);

                for (String name : teamArr) {
                    if (!teams.containsKey(name)) {
                        new ArrayList<String>();
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




//        HashMap<String, Integer> empIds = new HashMap<>();
//        empIds.put("John", 12345);
//        empIds.put("Carl", 23987);
//        empIds.put("Alex", 2342810);
//        System.out.println(empIds.get("Alex"));
    }

    public static String listToString(ArrayList<String> arrList) {
        StringBuilder result = new StringBuilder(" ");
        for (String s : arrList) {
            result.append(s.toString()).append(" ");
        }
        return result.toString();
    }
}