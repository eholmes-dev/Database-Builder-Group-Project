package group8.ordersystemdatabasebuilder.handler;

import java.util.ArrayList;
import ordersystemdatabasebuilder.objects.DataBaseTable;
import ordersystemdatabasebuilder.objects.Database;
import ordersystemdatabasebuilder.objects.DatabaseField;

/**
 *
 * @author Ethan Holmes, Zach Bherensmeyer, Chuck Baxter, Dalton Schilling
 */
public class CreateTables {

    public static String createTable(Database database) {
        ArrayList<DataBaseTable> tables = database.getTables();
        int fkCount = 0;
        int finalFK = 0;
        ArrayList<String> fks = new ArrayList<>();
        ArrayList<String> fkstemp = new ArrayList<>();
        ArrayList<String> fkFields = new ArrayList<>();
        ArrayList<String> fkReferences = new ArrayList<>();
        StringBuilder sb;
        sb = new StringBuilder();

        for (DataBaseTable databaseTable : tables) {
            //These values need reset for each table
            fks.clear();
            fkFields.clear();
            fkReferences.clear();
            finalFK = 0;
            boolean isFirst = true;
            
            //starts writing
            sb.append("--drop table\n");
            sb.append("DROP TABLE IF EXISTS ");
            sb.append(databaseTable.getTableName());
            sb.append(";\n");
            sb.append("--Creating table "); 
            sb.append(databaseTable.getTableName() + "\n");
            sb.append("CREATE TABLE ");
            sb.append(databaseTable.getTableName());
            sb.append("(\n");
            for (DatabaseField field : databaseTable.getFields()) {

                if (isFirst == true) {
                    sb.append("\t");
                    sb.append(field.getField());
                    isFirst = false;
                } else {
                    sb.append(",\t");
                    sb.append(field.getField());
                }
                sb.append("\t");
                sb.append(field.getDataType());
                sb.append("\t");
                sb.append(field.getNullable());
                sb.append("\t");
                sb.append(field.getPrimaryKey());
                sb.append("\t");
                sb.append(field.getAutoIncrement());
                sb.append("\n");

                //If foreign key == y we need to generate coonstraint
                fks.add(field.getForiegnKey());
                fkFields.add(field.getField());
                fkReferences.add(field.getReferences());
                fkstemp = fks;

                //sb.append(field.getForiegnKey());
                //sb.append("\t");
                //sb.append(field.getUnique());
                //sb.append("\t");
                //sb.append(field.getOtherConstraint());
                //sb.append("\t");
                //sb.append(field.getReferences());
                //sb.append("\t");
                // We do not want the description in the table generator
                //sb.append(field.getDescription());                
                //sb.append("\n");
            }

            //Gets count of foreign keys
            for (int i = 0; i < fks.size(); i++) {
                if (fks.get(i).equals("Y")) {
                    fkCount++;
                }
            }
                //used to add constrain
                for (int i = 0; i < fks.size(); i++) {                    
                    if (fks.get(i).equals("Y")) {

                        finalFK++;
                        //last constraint needs no comma
                        if (finalFK == fkCount) {
                            sb.append("\nCONSTRAINT " + databaseTable.getTableName()
                                    + "_fk_" + fkFields.get(i)
                                    + "\nFOREIGN KEY (" + fkFields.get(i) + ")"
                                    + "\nREFERENCES " + fkReferences.get(i) + "\n");
                        // needs comma
                        } else {
                            sb.append("\nCONSTRAINT " + databaseTable.getTableName()
                                    + "_fk_" + fkFields.get(i)
                                    + "\nFOREIGN KEY (" + fkFields.get(i) + ")"
                                    + "\nREFERENCES " + fkReferences.get(i) + "\n"
                                    + ",");
                        }
                    }
                }
                
                //Table comments
                sb.append(") COMMENT '");
                sb.append(databaseTable.getDescription());
                sb.append("'\n;\n\n");
                fkCount = 0;
            }
            //System.out.println(sb.toString());
            return sb.toString();
        }
    }
