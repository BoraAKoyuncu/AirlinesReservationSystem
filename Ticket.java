package ARS;
import java.util.ArrayList;
import java.util.Vector;

/*
Implemented by Bora Armağan KOYUNCU
*/

public class Ticket {
    
    private float price;
    private boolean isRound;
    public ArrayList<Flight> flights = new ArrayList<>();
    public ArrayList<Seat> seatsOfFlights = new ArrayList<>();

    public void setPrice(Flight _flight) {
        this.price = _flight.calculatePrice();
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public void setSeatsOfFlights(ArrayList<Seat> seatsOfFlights) {
        this.seatsOfFlights = seatsOfFlights;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public ArrayList<Seat> getSeatsOfFlights() {
        return seatsOfFlights;
    }

    public void setIsRound(boolean isRound) {
        this.isRound = isRound;
    }

    public float getPrice() {
        return price;
    }

    public boolean isIsRound() {
        return isRound;
    }
}
