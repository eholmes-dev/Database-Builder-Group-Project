package group8.ordersystemdatabasebuilder.handler;

import group8.ordersystemdatabasebuilder.objects.data.OrderRecordDatabaseBuilderException;
import java.io.IOException;
import ordersystemdatabasebuilder.objects.Database;

/**
 *
 * @author Ethan Holmes, Zach Bherensmeyer, Chuck Baxter, Dalton Schilling
 */
public interface IBuildSqlScript {

    void generateScript(Database database) throws 
            OrderRecordDatabaseBuilderException, IOException;
        
    

    
}
