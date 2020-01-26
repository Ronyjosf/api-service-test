//package structure;
//
//public class PostPubisher {
//    // call /api/loadProviders with json in body
//
//    public void loadPublisher(String jsonString){
//
//        Unirest.setTimeouts(0, 0);
//        HttpResponse<String> response = Unirest.post("http://localhost:4567/api/loadProviders")
//                .header("Content-Type", "application/json;charset=UTF-8")
//                .body("{\n    \"publisherId\": \"200\",\n    \"time\": \"2015-11-03 15:03:30.352\",\n    \"readings\": [ 1, 13, 192, 7, 8, 99, 1014, 4]\n}")
//                .asString();
//
//    }
//}
