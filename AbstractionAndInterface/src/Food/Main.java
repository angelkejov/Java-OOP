package Food;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Buyer> buyerMap = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String idOrGroup = tokens[2];
            Buyer buyer = null;
            if(tokens.length == 4){
                String birthDate = tokens[3];
                buyer = new Citizen(name,age,idOrGroup,birthDate);
            } else{
                buyer = new Rebel(name,age,idOrGroup);
            }
            buyerMap.put(name,buyer);
        }
        String line = scanner.nextLine();
        int total = 0;
        while(!line.equals("End")){
            if(buyerMap.containsKey(line)){
                buyerMap.get(line).buyFood();
                String type = buyerMap.get(line).getClass().getSimpleName();
                if(type.equals("Rebel")){
                    total += 5;
                } else{
                    total +=10;
                }
            }
            line = scanner.nextLine();
        }
        System.out.println(total);
    }
}
