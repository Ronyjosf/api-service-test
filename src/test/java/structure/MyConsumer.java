package structure;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class MyConsumer {
    Logger logger = getLogger("MyConsumer");
    // call /api/loadProviders with json in body
    String url = "http://localhost:4567/api/";

    public void loadPublisher(String jsonString) throws Exception {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post(url+"loadProviders")
                .header("Content-Type", "application/json;charset=UTF-8")
//                .body("{\n    \"publisherId\": \"200\",\n    \"time\": \"2015-11-03 15:03:30.352\",\n    \"readings\": [ 1, 13, 192, 7, 8, 99, 1014, 4]\n}")
                .body(jsonString)
                .asString();
        logger.info ("response status = "+response.getStatus());
        logger.info(response.getBody());
        if (response.getStatus() !=200){
            throw new Exception();
        }
    }


    public void loadPublishers(String[] jsonStringArr) throws Exception {
        for (String jsonString: jsonStringArr){
            loadPublisher(jsonString);
        }
    }

    public String getOutlierById(String id) throws Exception {
        HttpResponse<String> response = Unirest.get(url+"getOutlierById?id="+id)
                .header("Content-Type", "application/json;charset=UTF-8")
//                .routeParam("id", id)
//                .body(id)
                .asString();
        logger.info ("response status = "+response.getStatus());
        logger.info(response.getBody());
        if (response.getStatus() !=200){
            return null;
        }
        return response.getBody();
    }

    public String getOutlierById(String id, int last_n_readings) throws Exception {
        HttpResponse<String> response = Unirest.get(url+"getOutlierById?id="+id+"&last-n-readings="+last_n_readings)
                .header("Content-Type", "application/json;charset=UTF-8")
//                .routeParam("id", id)
//                .body(id)
                .asString();
        logger.info ("response status = "+response.getStatus());
        logger.info(response.getBody());
        if (response.getStatus() !=200){
            throw new Exception();
        }
        return response.getBody();
    }

    public int getApiStatus() throws UnirestException {
        HttpResponse<String> response = Unirest.get(url+"status")
                .header("Content-Type", "application/json;charset=UTF-8")
//                .routeParam("id", id)
//                .body(id)
                .asString();
        logger.info ("response status = "+response.getStatus());
        return response.getStatus();
    }
}
