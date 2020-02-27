package group8.ordersystemdatabasebuilder.handler;

import group8.ordersystemdatabasebuilder.objects.data.OrderRecordDatabaseBuilderException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import ordersystemdatabasebuilder.objects.Database;

/**
 *
 * @author Ethan Holmes, Zach Bherensmeyer, Chuck Baxter, Dalton Schilling
 */
public class BuildSqlScript implements IBuildSqlScript {

    String writeFileName = "OrderSystemScript.sql";
    
    /**
     * Takes database as a parameter and generates the script
     * to create the database.
     * @param database
     * @throws OrderRecordDatabaseBuilderException
     * @throws IOException
     */
    @Override
    public void generateScript(Database database) throws 
            OrderRecordDatabaseBuilderException, IOException {
       FileWriter fw;
       
       // create instance of CSVHandler
       CSVHandler csvHandler = new CSVHandler();
       
       //Call to get the database name
       String dbName = csvHandler.getDBName();
       
            fw = new FileWriter(writeFileName);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("-- Create the db");            
            pw.println("DROP DATABASE IF EXISTS " + dbName + ";" );            
            pw.println("CREATE DATABASE " + dbName + ";\n");
            pw.println("-- Use the correct datbase");
            pw.println("Use " + dbName + ";\n" );
            pw.println("--Create the Tables\n");
            pw.print(CreateTables.createTable(database));
            pw.print(CreateSprocs.createInsertSprocs(database));
            pw.print(CreateSprocs.createReadByIDSprocs(database));
            pw.print(CreateSprocs.createReadAllSprocs(database));
            //Hard a hard time with this method, brain couldn't comprehend what
            //Bob wanted.
            pw.print(CreateSprocs.createUpdateSprocs(database));
            pw.print(CreateSprocs.createDeleteSprocs(database));
           
            pw.println();
            pw.close();
        
            
            
        }
       
    }
    
    
    
    

