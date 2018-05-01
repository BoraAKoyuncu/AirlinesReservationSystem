package ARS;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import ARS.Plane;
import ARS.Flight;
import java.util.Date;

/*
Implemented by Burak AKKANAT
 */

public class UserMenu {

    static Scanner input = new Scanner(System.in);
    static User _user = new User(); //_user changed from userLoggedIn
    static boolean signInCheck = false;
    static DBManager dObj = new DBManager();
    static ArrayList<Flight> flightsCreated = new ArrayList<>();

    public static void main(String[] args)
    {

    }

    public static User Register(){

        System.out.println("Please enter your first name: ");
        String _name = input.next();
        _user.setFirstName(_name);

        System.out.println("Please enter your last name: ");
        String _lastName = input.next();
        _user.setLastName(_lastName);

        System.out.println("Please enter your gender: (M for male, F for Female) ");
        String _gender = input.next();
        _user.setLastName(_gender);

        System.out.println("Please enter your nationality");
        String _nation = input.next();
        _user.setLastName(_nation);

        System.out.println("Please enter your phone number: ");
        String _phoneNumber = input.next();
        _user.setLastName(_phoneNumber);

        System.out.println("Please enter e-mail address: ");
        String _mail = input.next();
        _user.seteMail(_mail);

        System.out.println("Please enter your password: ");
        String _pass1 = input.next();
        _user.setPassword(_pass1);

        System.out.println("You have registered and logged in succesfully.\n");

        _user.setMiles(0);
        _user.setID("12345");
        signInCheck = true;
        dObj.insertUser(_user);
        return _user;

    }

    public static void signIn(String mail, String pswd){

//        System.out.println("Please enter e-mail address: ");
//        String _mail = input.next();
//
//        System.out.println("Please enter your password: ");
//        String _pass = input.next();

        

        if(dObj.findUserByEmail(mail, pswd))
        {
            System.out.println("Password is matched");
            signInCheck = true;
        }
        else{
            System.out.println("Incorrect e mail or password, please try again.\n");
            signInCheck = false;
        }
    }



    public static boolean Payment(){

        System.out.println("Please enter credit card number:\n (ATTENTION: PLEASE DO NOT ENTER A REAL CREDIT CARD NUMBER OR PASSWORD)");

        int i = input.nextInt();

        System.out.println("Please enter password: ");

        int k = input.nextInt();

        input.next();

        return true;

    }

    public static int Reservation(ArrayList<Flight> FlightList){

        System.out.println("Please enter departure city");
        String dep = input.next();

        System.out.println("Please enter arrival city");
        String arr = input.next();

        System.out.println("Please enter O for one-way R for round-trip");
        String type = input.next();

        int i = 1;
        Ticket ticket = new Ticket();
        ArrayList<Flight> AvailableFlights = new ArrayList<>();
        
        for(Flight _flight : FlightList){

            if(_flight.getFrom().equals(dep) && _flight.getTo().equals(arr)){

               
                
                AvailableFlights.add(_flight);

            }
        }
        
        if(!AvailableFlights.isEmpty()){
            
            System.out.println("\nAvailable flights are as follows:\nEnter the number of the flight to make reservation or 0 to LOG OUT:\n");
             
            for(Flight _fly : AvailableFlights){
                    
                if(type.equals("R"))
                        _fly.price *= 2;

                System.out.print("Flight No: " + i + ". ");
                String s = _fly.toString();
                System.out.print(s);
                System.out.println();
                i++;
                
                }
            }
        
        if(AvailableFlights.isEmpty()){
                
                System.out.println("\nNo available flights found.");
                return 0;
                
        }
        
        int flight = input.nextInt();

        if(flight == 0){
            signInCheck = false;
        }

        else{

            System.out.println("\nAvailable seats are as follows. Please enter seat number:\n");

            FlightList.get(flight-1).getPlane().printSeats();

            int seatNo = input.nextInt();

            FlightList.get(flight-1).getPlane().getSeatVector().get(seatNo-1).setIsEmpty(false);

            ticket.flights.add(FlightList.get(flight-1));

            ticket.seatsOfFlights.add(FlightList.get(flight).getPlane().getSeatVector().get(seatNo-1));

            _user.getTickets().add(ticket);

        }
        return 0;
    }
}
