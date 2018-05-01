package ARS;

/**
 * Created by Ahmet on 4/8/2017.
 */

public class Seat {
    private int seatNumber;
    private boolean isEmpty;
    private boolean isEconomy;


    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean getIsEmpty() {
        return isEmpty;
    }

    public boolean getIsEconomy() {
        return isEconomy;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public void setIsEconomy(boolean isEconomy) {
        this.isEconomy = isEconomy;
    }
}
