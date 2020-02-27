package group8.ordersystemdatabasebuilder.data.csv;

import group8.ordersystemdatabasebuilder.handler.CSVHandler;
import group8.ordersystemdatabasebuilder.objects.data.OrderRecordDatabaseBuilderException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import ordersystemdatabasebuilder.objects.DataBaseTable;
import ordersystemdatabasebuilder.objects.Database;
import ordersystemdatabasebuilder.objects.DatabaseField;

/**
 * CSVDataBuilderDAO
 *
 * @author Ethan Holmes, Zach Bherensmeyer, Chuck Baxter, Dalton Schilling
 */
public class CSVDataBuilderDAO {
    
    // Commented out to test the fullPath 
    //private static final String FILE_NAME = "OrderSystemDataDictionary.csv";

    public Database LoadDataBase() throws FileNotFoundException, IOException,
            OrderRecordDatabaseBuilderException {

        Database database = new Database();
        
        //create an instance of csvHandler
        CSVHandler csvHandler = new CSVHandler();
        
        //declaration statements
        String currentTableName = "";
        DataBaseTable currentTable = null;
        //call to csvHandler.getUserFileName to build fullPath
        String fullPath = csvHandler.getUserFileName();

        String line;

        String[] loadingFields;

        DataBaseTable table;

        String tableName;

        int orderNumber;

        String description;

        int lineCount = 0;
        // create a scanner on the specified path (fullPath)
        // build the database from the csv file provided.
        try {
            Scanner in = new Scanner(new File(fullPath));
            while (in.hasNextLine()) {
                lineCount++;
                line = in.nextLine();
                loadingFields = line.split(",");

                //First Field is Table Name
                if (!currentTableName.equals(loadingFields[0])) {
                    //Means it is a new table
                    currentTable = new DataBaseTable(loadingFields[0]);
                    currentTableName = loadingFields[0];
                    database.addTable(currentTable);
                    currentTable.setDescription(loadingFields[10]);
                } else {
//                    // new field
//                    String f0 = loadingFields[0];
//                    String f1 = loadingFields[1];
//                    String f2 = loadingFields[2];
//                    String f3 = loadingFields[3];
//                    String f4 = loadingFields[4];
//                    String f5 = loadingFields[5];
//                    String f6 = loadingFields[6];
//                    String f7 = loadingFields[7];
//                    String f8 = loadingFields[8];
//                    String f9 = loadingFields[9];
//                    String f10 = loadingFields[10];
                    
                    DatabaseField currentDatabaseField = new DatabaseField(
                            loadingFields[0],
                            loadingFields[1],
                            loadingFields[2],
                            loadingFields[3],
                            loadingFields[4],
                            loadingFields[5],
                            loadingFields[6],
                            loadingFields[7],
                            loadingFields[8],
                            loadingFields[9],
                            loadingFields[10],
                            /*loadingFields[11],*/ lineCount);
                    currentTable.addField(currentDatabaseField);
                }

            }

        } catch (FileNotFoundException e) {
            throw new OrderRecordDatabaseBuilderException(e);
        }
        return database;

    }

}
