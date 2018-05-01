package ARS;
import java.util.ArrayList;
import java.util.Vector;
import ARS.Seat;

public class Plane {
    //Private part of the class
    private int planeNumber;
    private ArrayList<Seat> seatVector = new ArrayList<>();

    public Plane(int PlaneNumber) {

        this.planeNumber = PlaneNumber;

        for(int i=0; i<60; i++){

            Seat _seat = new Seat();

            _seat.setSeatNumber(i+1);
            _seat.setIsEmpty(true);
            _seat.setIsEconomy(true);
            seatVector.add(_seat);

        }

    }

    //Public part of the class
    public void setPlaneNumber(int planeNumber)
    {
        this.planeNumber = planeNumber;
    }

    public ArrayList<Seat> getSeatVector() {
        return seatVector;
    }

    public void printSeats() {


        int whenToSeparate = 4;
        int whenToNewLine = 19;
        System.out.println("Empty seats : Seat Number-O");
        System.out.println("Occupied seats : Seat Number-X\n");

        for(int i = 0 ; i < this.seatVector.size() ; i++)
        {

            if(seatVector.get(i).getIsEmpty())
            {
                System.out.printf("%d-O ", i+1);
            }
            else
            {
                System.out.printf("%d-X ", i+1);
            }

            if(i == whenToSeparate)
            {
                whenToSeparate+=5;
                System.out.printf("  ");
            }

            if(i == whenToNewLine)
            {
                whenToNewLine+=20;
                System.out.printf("\n\n");
            }
        }


    }

    public int getPlaneNumber()
    {
        return planeNumber;
    }
}

