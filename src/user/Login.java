package user;

import java.util.*;
import java.io.*;

import java.nio.*;

public class Login {
    

    
    private static String path = "C:\\Users\\fatma\\OneDrive\\Masaüstü\\Users.txt";
	
	private static File file = new File(path);

	
	
	public static boolean registrationSucces(String userName, String password) {
    	
        try(Scanner scanner = new Scanner(file)) {
    		
            if (scanner.hasNextLine()) {
            	boolean existance = false;
            	while(scanner.hasNextLine()) {
	
            		String[] line = scanner.nextLine().split(" "); 
        
            		if(line[0].equals(userName)){
            			if(line [1].equals(password)) {
                    		existance = true;
                    		return true; 
            			}else {
            				return false;
            			}
            		}
            	}
            	if (!existance) {      		
            		return false;
            	}
            }
            else {return false;}        
        }  
        catch (Exception e) {}
		return false;
    }
	
	
	
    
    public static void addUserToFile(String path, String userName, String password, String name, int ID) {
    	try (FileWriter writer = new FileWriter(path, true)){
    		writer.write(userName+" "+password +" "+name+" "+ID +"\n");   
    	}    
        catch (Exception e) {} 
    	}
    
    
    
    public static boolean existenceInFile(String username) {
    		
    	try(Scanner scanner = new Scanner(file)) {
    		
    		boolean defvalue = true;
    		if (scanner.hasNextLine()) {
            	while(scanner.hasNextLine()) {
            		String[] line = scanner.nextLine().split(" "); 
            		if(line[0].equals(username)){
            			defvalue = false;}
            			}
            		}
            	
            return defvalue;
    	}catch(Exception e){
    	return false;}
    	}
    
    
    
    
 
	
    public static File getFile() {
		return file;
	}

	public static void setFile(File file) {
		Login.file = file;
	}
    	
}
    
