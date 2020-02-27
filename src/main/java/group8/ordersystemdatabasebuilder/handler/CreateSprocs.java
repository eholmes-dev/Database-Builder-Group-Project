/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group8.ordersystemdatabasebuilder.handler;

import java.util.ArrayList;
import ordersystemdatabasebuilder.objects.DataBaseTable;
import ordersystemdatabasebuilder.objects.Database;
import ordersystemdatabasebuilder.objects.DatabaseField;

/**
 * 
 * @author Ethan Holmes, Zach Bherensmeyer, Chuck Baxter, Dalton Schilling
 */
public class CreateSprocs {
    /**
     * takes the database as a parameter to create stored procedures for inserting
     * data into the database.
     * @param database
     * @return 
     */
    public static String createInsertSprocs(Database database) {

        ArrayList<DataBaseTable> tables = database.getTables();
        StringBuilder sb = new StringBuilder();

        for (DataBaseTable databaseTable : tables) {
            boolean isFirst = true;
            boolean visFirst = true;
            boolean isFirst2 = true;
            sb.append("--Sproc to insert into ");
            sb.append(databaseTable.getTableName());
            sb.append("\nDROP PROCEDURE IF EXISTS sp_insert_into_");
            sb.append(databaseTable.getTableName().toLowerCase());

            sb.append(";\n");

            sb.append("Create Procedure sp_insert_into_"
                    + databaseTable.getTableName().toLowerCase());
            sb.append("\n(");

            for (DatabaseField field : databaseTable.getFields()) {
                if (isFirst == true) {
                    sb.append("\n\t");
                    sb.append("@" + field.getField() + "\t");
                    sb.append(field.getDataType());
                    isFirst = false;
                    sb.append("\n");
                } else {
                    sb.append(",\t");
                    sb.append("@" + field.getField() + "\t");
                    sb.append(field.getDataType());
                    sb.append("\n");
                }
            }

            sb.append(")\n");
            sb.append("AS\n");
            sb.append("BEGIN");
            sb.append("\nINSERT INTO " + databaseTable.getTableName());

            for (DatabaseField field : databaseTable.getFields()) {
                if (visFirst == true) {
                    sb.append("\n\t");
                    sb.append(field.getField());
                    visFirst = false;
                    sb.append("\n");
                } else {
                    sb.append(",\t");
                    sb.append(field.getField());
                    sb.append("\n");
                }

            }

            sb.append(")\n");
            sb.append("Values\n(");
            for (DatabaseField field : databaseTable.getFields()) {
                if (isFirst2 == true) {
                    sb.append("\n\t");
                    sb.append("@" + field.getField() + "\t");
                    isFirst2 = false;
                    sb.append("\n");
                } else {
                    sb.append(",\t");
                    sb.append("@" + field.getField() + "\t");
                    sb.append("\n");
                }
            }
            sb.append(")");
            sb.append("\nEND");
            sb.append("\nGO");
            sb.append("\n;\n\n");

        }
        return sb.toString();
    }
    /**
     * Takes database as a parameter and creates stored procedures to select by
     * ID.
     * @param database
     * @return 
     */
    public static String createReadByIDSprocs(Database database) {

        ArrayList<DataBaseTable> tables = database.getTables();
        StringBuilder sb = new StringBuilder();

        for (DataBaseTable databaseTable : tables) {
            boolean isFirst = true;
            boolean visFirst = true;
            boolean wisFirst = true;
            boolean wisFirst2 = true;
            sb.append("--Procedure to get" + databaseTable.getTableName());
            sb.append("records by ID\n");
            sb.append("DROP PROCEDURE IF EXISTS sp_get_");
            sb.append(databaseTable.getTableName().toLowerCase());
            sb.append("record_by_id");
            sb.append(";\n");

            sb.append("CREATE PROCEDURE sp_get_");
            sb.append(databaseTable.getTableName().toLowerCase());
            sb.append("record_by_id");
            sb.append("\n(\n");
            for (DatabaseField field : databaseTable.getFields()) {
                if (isFirst == true) {
                    sb.append("@" + field.getField());
                    sb.append("\t" + field.getDataType());
                    isFirst = false;
                }
            }

            sb.append("\n)\n");
            sb.append("AS\n");
            sb.append("BEGIN\n");
            sb.append("SELECT ");

            for (DatabaseField field : databaseTable.getFields()) {
                if (visFirst == true) {
                    sb.append("\n\t");
                    sb.append(field.getField());
                    visFirst = false;
                    sb.append("\n");
                } else {
                    sb.append(",\t");
                    sb.append(field.getField());
                    sb.append("\n");
                }
            }

            sb.append("FROM " + databaseTable.getTableName());
            sb.append("\nWHERE ");
            for (DatabaseField field : databaseTable.getFields()) {
                if (wisFirst == true) {
                    sb.append(field.getField() + " = ");
                    wisFirst = false;
                }
            }
            for (DatabaseField field : databaseTable.getFields()) {
                if (wisFirst2 == true) {
                    sb.append("@" + field.getField() + "\n");
                    wisFirst2 = false;
                }
            }

            sb.append("GO\n");
            sb.append("END\n;\n\n");
        }
        return sb.toString();
    }
    /**
     * Takes database as a parameter and creates stored procedure to 
     * select all.
     * @param database
     * @return 
     */
    public static String createReadAllSprocs(Database database) {

        ArrayList<DataBaseTable> tables = database.getTables();
        StringBuilder sb = new StringBuilder();

        for (DataBaseTable databaseTable : tables) {
            boolean isFirst = true;
            sb.append("--Sproc to get all " + databaseTable.getTableName());
            sb.append("items\n");
            sb.append("DROP PROCEDURE IF EXISTS sp_get_all_");
            sb.append(databaseTable.getTableName().toLowerCase());
            sb.append("_items;\n");

            sb.append("CREATE PROCEDURE sp_get_all_");
            sb.append(databaseTable.getTableName().toLowerCase());
            sb.append("_items");
            sb.append("\n");
            sb.append("AS\n");
            sb.append("BEGIN\n");
            sb.append("Select ");
            for (DatabaseField field : databaseTable.getFields()) {
                if (isFirst == true) {
                    sb.append("\n\t");
                    sb.append(field.getField());
                    isFirst = false;
                    sb.append("\n");
                } else {
                    sb.append(",\t");
                    sb.append(field.getField());
                    sb.append("\n");
                }
            }
            sb.append("FROM " + databaseTable.getTableName());
            sb.append("\nEND");
            sb.append("\nGO\n;\n\n");
        }
        return sb.toString();
    }
    /**
     * Takes database as a parameter and generates the update stored 
     * procedures.
     * @param database
     * @return 
     */
    public static String createUpdateSprocs(Database database) {

        ArrayList<DataBaseTable> tables = database.getTables();
        StringBuilder sb = new StringBuilder();

        for (DataBaseTable databaseTable : tables) {
            boolean isFirst = true;
            boolean isFirst2 = true;
            boolean isSecond = false;
            String whereClause = "";
            sb.append("--Sproc to update a " + databaseTable.getTableName());
            sb.append(" record\n");
            sb.append("DROP PROCEDURE IF EXISTS sp_update_");
            sb.append(databaseTable.getTableName().toLowerCase());
            sb.append("Items;\n");
            sb.append("CREATE PROCEDURE sp_update_");
            sb.append(databaseTable.getTableName().toLowerCase());
            sb.append("Items");
            sb.append("\n(\n");

            for (DatabaseField field : databaseTable.getFields()) {
                if (isFirst == true) {
                    sb.append("\t");
                    sb.append("@" + field.getField());
                    sb.append("\t" + field.getDataType());
                    sb.append("\n");
                    isFirst = false;
                } else {
                    sb.append(",\t");
                    sb.append("@" + field.getField());
                    sb.append("\t" + field.getDataType());
                    sb.append("\n");
                }
            }

            sb.append("\n)\n");
            sb.append("AS\n");
            sb.append("BEGIN\n");
            sb.append("\tUPDATE " + databaseTable.getTableName() + "\n");
            sb.append("\tSET\n ");
            for (DatabaseField field : databaseTable.getFields()) {
                if (isSecond == true) {
                    sb.append("\t");
                    sb.append(field.getField() + " = @" + field.getField());
                    sb.append(",\n");
                } else if (isFirst2 == true) {
                    whereClause = "WHERE " + field.getField() + " = "
                            + "@" + field.getField();
                    isFirst2 = false;
                    isSecond = true;
                } else {
                    sb.append(",\t");
                    sb.append(field.getField() + " = @" + field.getField());
                    sb.append("\n");
                }

            }
            sb.append(whereClause);
            sb.append("\nEND\n");
            sb.append("GO\n;\n\n");
        }

        return sb.toString();
    }

    public static String createDeleteSprocs(Database database) {

        ArrayList<DataBaseTable> tables = database.getTables();
        StringBuilder sb = new StringBuilder();

        for (DataBaseTable databaseTable : tables) {
            boolean isFirst = true;
            boolean visFirst = true;
            boolean isFirst2 = true;
            sb.append("--Sproc to Delete from " + databaseTable.getTableName());
            sb.append("\nDROP PROCEDURE IF EXISTS sp_delete_from_");
            sb.append(databaseTable.getTableName().toLowerCase());

            sb.append(";\n");

            sb.append("Create Procedure sp_delete_from"
                    + databaseTable.getTableName().toLowerCase());
            sb.append("\n(");

            for (DatabaseField field : databaseTable.getFields()) {
                if (isFirst == true) {
                    sb.append("\n\t");
                    sb.append("@" + field.getField() + "\t");
                    sb.append(field.getDataType());
                    isFirst = false;
                    sb.append("\n");
                }
            }

            sb.append(")\n");
            sb.append("AS\n");
            sb.append("BEGIN");
            sb.append("\nDELETE FROM " + databaseTable.getTableName());
            sb.append("\nWHERE ");
            for (DatabaseField field : databaseTable.getFields()) {
                if (visFirst == true) {
                    sb.append("\t");
                    sb.append(field.getField() + " = @" + field.getField());
                    visFirst = false;
                }
            }
            sb.append("\nEND");
            sb.append("\nGO");
            sb.append("\n;\n");
        }

        return sb.toString();
    }
}
