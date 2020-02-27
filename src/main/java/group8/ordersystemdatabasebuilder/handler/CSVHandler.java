package group8.ordersystemdatabasebuilder.handler;

import group8.ordersystemdatabasebuilder.ui.UIHelper;

/**
 * CSVHandler
 * @author Ethan Holmes, Zach Bherensmeyer, Chuck Baxter, Dalton Schilling
 */
public class CSVHandler {
    
    /**
     * getUserFileName() will retrieve the fullPath for the csv
     * User input: filePath and fileName.
     * @return fullPath
     */
    public String getUserFileName(){
        // Setting the file path to a variable
        String filePath = UIHelper.getUserString("What is the file path? "  
                , "Invalid file path please try again.");
        
        //Setting the file name to a variable
        String fileName = UIHelper.getUserString("What is the name of the "
                + "file? ", "Invalid file please try again.");

        String fullPath = filePath + "/" + fileName;
        return fullPath;
    }
    
    /**
     * getDBName() retrieves the Database name from user.
     * @return DBName
     */
    public String getDBName(){
       //Setting the database name to a variable
       String DBName = UIHelper.getUserString("What is the name of the "
                + "database? ", "Error in database name."); 
       
       //return the DBName
       return DBName;
    }
    
}
