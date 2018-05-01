package ARS;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/*
Implemented by Bora Armagan KOYUNCU

Version 1.02 Updates:
new variables and their getter&setters. (Ahmet)
*/

public class User {

    Scanner input = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private String gender; //TODO: Update that on UI
    private String nation;
    private long phoneNumber;
    private String eMail;
    private String ID;
    private String password;
    private float miles;
    public ArrayList <Ticket> tickets = new ArrayList<>();

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public void setNation(String nation)
    {
        this.nation = nation;
    }

    public void setPhoneNumber(long phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMiles(float miles) {
        this.miles = miles;
    }

    public Scanner getInput() {
        return input;
    }

    public String geteMail() {
        return eMail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender()
    {
        return gender;
    }

    public String getNation()
    {
        return nation;
    }

    public long getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public float getMiles() {
        return miles;
    }

    public void changePassword(){

        System.out.println("\nPlease enter new password:");
        String pass = input.next();
        setPassword(pass);
    }
    
    public void eraseFlight(int i){
        
        //this.tickets.elementAt(i) = null;
    }
}