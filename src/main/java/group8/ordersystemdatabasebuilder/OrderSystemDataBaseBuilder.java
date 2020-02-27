package group8.ordersystemdatabasebuilder;

import group8.ordersystemdatabasebuilder.data.csv.CSVDataBuilderDAO;
import group8.ordersystemdatabasebuilder.handler.BuildSqlScript;
import group8.ordersystemdatabasebuilder.handler.CSVHandler;
import group8.ordersystemdatabasebuilder.objects.data.OrderRecordDatabaseBuilderException;
import group8.ordersystemdatabasebuilder.ui.UIHelper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import ordersystemdatabasebuilder.objects.Database;

/**
 * Main method for program. Builds the database, loads the database, and
 * builds the database script.
 * @author Ethan Holmes, Zach Bherensmeyer, Chuck Baxter, Dalton Schilling
 */
public class OrderSystemDataBaseBuilder {

    public static void main(String[] args) throws IOException, 
            FileNotFoundException, OrderRecordDatabaseBuilderException {
        System.out.println("Program Starting...");        
        
        // calls the CSVDataBuilderDAO() to create and return the database
        CSVDataBuilderDAO builder = new CSVDataBuilderDAO();
        
        Database database = builder.LoadDataBase();
        
        //creates an instance of BuildSqlScript
        BuildSqlScript script = new BuildSqlScript();
        
        //generates the script
        script.generateScript(database);               
        
        System.out.println("Program complete.");
    }
}
    