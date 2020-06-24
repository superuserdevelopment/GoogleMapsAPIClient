package userInterface;

import connection_Scripts.*;
import java.util.Scanner;

public class CommandLine {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Data_Getter_Script getter = new Data_Getter_Script();
        String urlString = "", apiKey = "AIzaSyDXlLjUgUAC6GgdUZD4rfmlHKsZrISplgs";
        String pointA = "", pointB = "";
        System.out.println("Enter Starting Point:");
        pointA = sc.next();
        System.out.println("Enter Ending Point:");
        pointB = sc.next();
        urlString = "https://maps.googleapis.com/maps/api/directions/json?origin="+pointA+"&destination="+pointB+"&key="+apiKey;
        String response = getter.getResponse(urlString);
        // System.out.println(response);
        if(!(response.startsWith("Error"))){
        try{
            Data_Cleaner jsonObj = new Data_Cleaner(response);
	        System.out.println("Distance: " + jsonObj.getDistance()/1000+"km");
		    System.out.println("Time of Travel: " + jsonObj.getDuration());
		    System.out.println("Start Point: " + jsonObj.getStartPoint());
            System.out.println("End Point: " + jsonObj.getEndPoint());
        }
        catch(Exception e){
            System.out.println("Misformatted Inputs");
        }
    }
    }
}