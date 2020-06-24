package connection_Scripts;

public class Data_Cleaner {
    String jsonString;
    //Initializes the JSON String to the object
    public Data_Cleaner(String response){
        jsonString = removeSpaces(response);
    }

    //Returns Distance between the two points in meters
    public double getDistance(){
		String s = jsonString;
		s = s.substring(s.indexOf("distance"), s.indexOf("duration"));
		// System.out.println(s.substring(s.indexOf(":\"")+2, s.indexOf(",")-1));
		// System.out.println(s.substring(s.indexOf("value")+7, s.indexOf("}"))+"m");
		return Double.parseDouble(s.substring(s.indexOf("value")+7, s.indexOf("}")));
    }
    
    //Returns the driving time between the two points
    public String getDuration(){
		String s = jsonString;
		s = s.substring(s.indexOf("duration"), s.indexOf("end_address"));
		return (s.substring(s.indexOf("text")+7, s.indexOf(",")-1));
    }
    
    //Returns the start point
    public String getStartPoint(){
		String s = jsonString;
		s = s.substring(s.indexOf("start_address")+16, s.indexOf("steps"));
		return s.substring(0, s.indexOf("\","));
    }
    
    //Returns the end point
    public String getEndPoint(){
		String s = jsonString;
		s = s.substring(s.indexOf("end_address")+14, s.indexOf("start_address"));
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