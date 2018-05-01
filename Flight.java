package ARS;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Flight {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String from;
    private String to;
    private String flightNo;
    public static String date; /*= "2017-06-10 12:00:00"*/
    public float price;
    private Plane plane;
    private static float distance;
    private static boolean isTransit;

    @Override
    public String toString() {
        return "From=" + from + " To=" + to + ", FlightNo=" + flightNo + ", Date=" + date + ", isTransit=" + isTransit + ", Price=" + price;
    }
    
    public Flight()
    {
        
    }

    public Flight(String from, String to, String flightNo, float Distance, String Date, Plane plane, boolean Transit) {
        this.from = from;
        this.to = to;
        this.flightNo = flightNo;
        this.distance = Distance;
        this.date = Date;
        this.plane = plane;
        this.isTransit = Transit;
        this.price = calculatePrice();
    }

    public static void setDateFormat(SimpleDateFormat dateFormat) {
        Flight.dateFormat = dateFormat;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public float getPrice() {
        return price;
    }

    public Plane getPlane() {
        return plane;
    }

    public static boolean isIsTransit() {
        return isTransit;
    }

    public static SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public static void setDate(String date) {
        Flight.date = date;
    }

    public static String getDate() {
        return date;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public static float getDistance() {
        return distance;
    }

    public boolean getIsTransit() {
        return isTransit;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public void setIsTransit(boolean isTransit) {
        this.isTransit = isTransit;
    }

    static float calculatePrice(){

        float _price;
        _price = getDistance() * 3 / 4;

        try{
            Date date1 = dateFormat.parse(date);
            Date date2 = new Date();
            long diff = date2.getTime() - date1.getTime();
            if( TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) < -28 )
                _price = _price * 90 / 100;
            if (isTransit == false)
                _price = _price * 95 / 100;
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        return _price;

    }

}
