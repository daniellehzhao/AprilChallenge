package ai.aprillabs.listingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListingApplication {
    
    public static void main(String[] args) {
        /*
        Haven't figured out whether these functions should be in main, within a different file, or in 
        different classes
        */

        //Get a list of all the listings in JSON format
        ArrayList<Listing> array = new ArrayList<Listing>();
        for(int i = 0 ; i < 100; i++){
            array.add(new Listing(i+"", i+"", i+"", i+""));
        }

        JSONArray jsonArray = new JSONArray();
        for (int i = 0;i < array.size() ; i++) {
            JSONObject obj = new JSONObject();
            JSONObject objItem =  new JSONObject();
            objItem.put("id", array.get(i).getId());
            objItem.put("address",  array.get(i).getAddress());
            objItem.put("beds",  array.get(i).getBeds());
            objItem.put("baths",  array.get(i).getBaths());
            objItem.put("time created",  array.get(i).getCreatedAt());
            obj.put("listing", objItem);
            jsonArray.put(obj);
        }

        try (FileWriter file = new FileWriter("listing path")) {
            file.write(jsonArray.toString());
        } catch(Exception e){
            System.out.println(e);

        }
        //Get the details of a specific listing in JSON format
        //Get the details of a specific listing in JSON format
        //Get the details of a specific listing in JSON format
        //Get discount rate for a user
        SpringApplication.run(ListingApplication.class, args);
    }
}

    