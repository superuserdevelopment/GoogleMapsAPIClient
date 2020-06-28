package connection_Scripts;

public class Data_Cleaner {
    String jsonString;
    //Initializes the JSON String to the object
    public Data_Cleaner(String response){
        jsonString = removeSpaces(response);
    }

    //Returns Distance between the two points in meters
    public String getDistance(){
		String s = jsonString;
		s = s.substring(s.indexOf("Distance"));
		// System.out.println(s.substring(s.indexOf(":\"")+2, s.indexOf(",")-1));
		// System.out.println(s.substring(s.indexOf("value")+7, s.indexOf("}"))+"m");
		return s.substring(11, s.indexOf("}")-1);
		
    }
    
    //Returns the driving time between the two points
    public String getDuration(){
		String s = jsonString;
		s = s.substring(s.indexOf("Duration"), s.indexOf("EndingLocation"));
		return (s.substring(11, s.indexOf(",")-1));
    }
    
    //Returns the start point
    public String getStartPoint(){
		String s = jsonString;
		s = s.substring(s.indexOf("StartingLocation")+19, s.indexOf("Duration"));
		return s.substring(0, s.indexOf("\","));
    }
    
    //Returns the end point
    public String getEndPoint(){
		String s = jsonString;
		s = s.substring(s.indexOf("EndingLocation")+17, s.indexOf("Distance"));
		return s.substring(0, s.indexOf("\","));
    }
    
    //Internal Function to remove extra spaces in the JSON String
    private String removeSpaces(String input){
		int i;
		String output = "";
		for(i=0;i<input.length();i++){
			if(!(input.charAt(i)==' ')){
				output = output + input.charAt(i);
			}
		}
		return output;
	}
}