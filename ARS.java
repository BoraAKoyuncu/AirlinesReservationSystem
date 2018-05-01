package ARS;
import java.util.Scanner;
import java.util.Vector;
import ARS.UserMenu;
import ARS.ARSUI;

/*
Implemented by Burak AKKANAT
*/

public class ARS extends UserMenu {

    static Scanner input = new Scanner(System.in);

    //Creating Planes
    static Plane AirbusA380 = new Plane(1);
    static Plane Boeing747 = new Plane(2);
    
    //Creating Flights
    static Flight flight1 = new Flight("Istanbul", "Izmir", "0001", 300, "2017-06-10 12:00:00", AirbusA380, true);
    static Flight flight2 = new Flight("Ankara", "London", "0002", 1400, "2017-06-10 12:00:00", Boeing747, false);
    
    Seat seat = new Seat();
//    seat.setIsEmpty(true);
    
    Ticket ticket = new Ticket();
    
    //Declaring objects for db insertion
    static DBManager dObj = new DBManager();
    
    public static void main(String[] args) {
        
        
        Reservation(flightsCreated);
       
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPanel().setVisible(true);
            }
        });
        
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ARSUI().setVisible(true);
//                
//            }
//        });
        System.out.print(flight1.toString());
        flightsCreated.add(flight1);
        flightsCreated.add(flight2);
        flightsCreated.get(0).toString();
//        while(true){
//            
//            if(!signInCheck)
//                MainMenu();
//            else
//                SignedInMenu();
//            
//        }
    }
    
    public static void MainMenu(){
        
        System.out.println("Please choose the operation you want to do:\n"
                    + "0.Exit\n"
                    + "1. Register\n"
                    + "2. Sign in");
        
        int i = input.nextInt();
        
        switch(i){
                
            case 0: System.exit(0); break;
            case 1: _user = Register(); break;
            case 2: signIn("burak", "burak"); break;
            //case 3: checkDB(); break;
            
        }
    }
    
    public static int SignedInMenu(){
        
        if(_user.getTickets().isEmpty()){
               
            System.out.println("\nYou do not have any tickets currently.\n"
                        + "Enter -1 to make new reservation.\n"
                        + "Enter 0 to LOG OUT");
           
        }
           
        else {
                
            int j = 0;
            
            System.out.println("\nYour current tickets are as follows:\n"
                   + "Enter ticket number to cancel flight or enter -1 to make new reservation\n"
                   + "Enter 0 to LOG OUT\n");
                
            System.out.printf("Ticket number %d:\n", j+1);
                    
                for(Ticket _ticket: _user.getTickets()){
                        
                    String fly = _ticket.getFlights().get(j).toString();
                    int seat = _user.getTickets().get(j).getSeatsOfFlights().get(j).getSeatNumber();
                        
                    System.out.print(fly + "\nSeat Number:" + seat + "\n");
                    
                    j++;
            }
        }
            
            int choice1 = input.nextInt();
            
            if(choice1 == 0){
                signInCheck = false;
            }
            else if(choice1 == -1){
                Reservation(flightsCreated);
            }
            else{
                _user.getTickets().remove(choice1-1);
                System.out.print("Your ticket with ID" + choice1 + "has cancelled.");
                return 0;
            }
            return 0;
    }
}
