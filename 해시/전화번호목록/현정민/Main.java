import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        //System.out.print("t =>");
        int t = Integer.parseInt(br.readLine());
        //System.out.print("n =>");
        


        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            //System.out.print("phoneNumber =>");
            //Map<String, Integer> check= new HashMap<>();
            String[] phoneNumbers = new String[n];
            for(int j = 0; j < n; j++) {
                phoneNumbers[j] = br.readLine();
            }

            boolean flag = true;
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(j == k)
                        continue;
                    if(phoneNumbers[j].startsWith(phoneNumbers[k])){
                        flag = false;
                        break;
                    }
                }
                if(!flag) break;
            }
            System.out.println(flag?"YES":"NO");

        }

    }

}
