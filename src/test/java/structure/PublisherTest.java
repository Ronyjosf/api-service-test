package structure;

public class PublisherTest {
    public String publisherId;
    public String time;
    public int[] readings;
    private double median;

    public PublisherTest(){

    }
    public PublisherTest(String publisherId, String time, int[] readings) {
        this.publisherId = publisherId;
        this.time = time;
        this.readings = readings;
    }
}
