package structure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestData {
    private static TestData testData = null;
    private List<PublisherTest> publisherTests = new ArrayList<>();

    static public TestData getTestDataInstance(){
        if (testData ==null){
            return new TestData();
        }
        return testData;
    }


    static String[] testDataArr = {"{\n" +
        "    \"publisherId\": \"100\",\n" +
        "    \"time\": \"2015-11-03 15:03:30.352\",\n" +
        "    \"readings\": [ 1, 13, 192, 7, 8, 99, 1014, 4]\n" +
        "}", "{\n" +
        "    \"publisherId\": \"200\",\n" +
        "    \"time\": \"2015-11-03 15:03:30.352\",\n" +
        "    \"readings\": [ 1, 13, 192, 7, 8, 99, 1014, 4]\n" +
        "}"};

    public String[] loadTestData() throws JsonProcessingException {
        setTestDataObj();
        return testDataArr;
    }
    private void setTestDataObj() throws JsonProcessingException {
        PublisherTest jsonPublisherTest = null;
        for (String testData: testDataArr){
            ObjectMapper mapper = new ObjectMapper();
            try{
                 jsonPublisherTest = mapper.readValue(testData, PublisherTest.class);
            }catch (Exception e){
                System.out.println("can't map");
                return;
            }

            PublisherTest publisherTest = new PublisherTest(jsonPublisherTest.publisherId, jsonPublisherTest.time, jsonPublisherTest.readings);
            publisherTests.add(jsonPublisherTest);


        }
    }

    public PublisherTest getPublisherTest(int index) {
        if (index <publisherTests.size()) {
            return publisherTests.get(index);
        }
        return null;
    }

    public double getMedian(int[] values) {
        // sort array
        Arrays.sort(values);
        double median;
        // get count of scores
        int totalElements = values.length;
        // check if total number of scores is even
        if (totalElements % 2 == 0) {
            int sumOfMiddleElements = values[totalElements / 2] +
                    values[totalElements / 2 - 1];
            // calculate average of middle elements
            median = ((double) sumOfMiddleElements) / 2;
        } else {
            // get the middle element
            median = (double) values[values.length / 2];
        }
        return median;
    }

    public int getLargestNum(int[] arr){
        if (arr.length ==0){
            return -1;
        }
        int max = arr[0];
        for (int temp: arr){
            if (temp > max) {max = temp;}
        }
        return max;
    }


}
