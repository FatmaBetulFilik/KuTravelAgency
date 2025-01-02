package user;

import java.util.*;
import java.io.*;

import java.nio.*;

public class Login {
    	
	
	private static String path = "src/user/usersFile.txt";
	

	private static File file = new File(path);

	
	/**
	 * registrationSucces(String userName, String password) method verifies if a user exists in the file 
	 * specified by the static path and checks if the given username and password match.
	 * 
	 * @param userName : The username provided for login.
	 * @param password : The password provided for login.
	 * @return true if the username and password match a record in the file, false otherwise.
	 */
	
	public static boolean registrationSucces(String userName, String password) {
    	
        try(Scanner scanner = new Scanner(file)) {
    		
            if (scanner.hasNextLine()) {
            	boolean existance = false;
            	while(scanner.hasNextLine()) {
	
            		String[] line = scanner.nextLine().split(","); 
        
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
	
	
	/**
	 * addUserToFile(String path, String userName, String password, String name, int ID) method adds a new user 
	 * to the file specified by the given path. It appends the user information to the file.
	 * 
	 * @param path : The file path where the user data should be written.
	 * @param userName : The username of the new user.
	 * @param password : The password of the new user.
	 * @param name : The name of the new user.
	 * @param ID : The ID of the new user.
	 */
    
    public static void addUserToFile(String path, String userName, String password, String name, int ID) {
    	try (FileWriter writer = new FileWriter(path, true)){
    		writer.write(userName+","+password +","+name+","+ID +"\n");   
    	}    
        catch (Exception e) {} 
    	}
    
    
    /**
     * existenceInFile(String username) method checks whether a given username exists in the file 
     * specified by the static path.
     * 
     * @param username : The username to check for existence.
     * @return true if the username does not exist in the file, false if it does exist.
     */
    public static boolean existenceInFile(String username) {
    		
    	try(Scanner scanner = new Scanner(file)) {
    		
    		boolean defvalue = true;
    		if (scanner.hasNextLine()) {
            	while(scanner.hasNextLine()) {
            		String[] line = scanner.nextLine().split(","); 
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
    
	public static String getPath() {
		return path;
	}




	public static void setPath(String path) {
		Login.path = path;
	}

}
    
