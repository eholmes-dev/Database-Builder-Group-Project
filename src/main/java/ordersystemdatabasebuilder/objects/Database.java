/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordersystemdatabasebuilder.objects;

import java.util.ArrayList;

/**
 *
 * @author Ethan Holmes, Zach Bherensmeyer, Chuck Baxter, Dalton Schilling
 */
public class Database {

    
    private String DBName;
    private ArrayList<DataBaseTable> tables;
    
    public void addTable(DataBaseTable currentTable) {
        tables.add(currentTable);
    }

    //Full constructor
    public Database(String DBName, ArrayList<DataBaseTable> tables) {
        this.DBName = DBName;
        this.tables = tables;
    }

    public Database() {
        tables = new ArrayList<>();
    }

    /**
     * @return the DBName
     */
    public String getDBName() {
        return DBName;
    }

    /**
     * @param DBName the DBName to set
     */
    public void setDBName(String DBName) {
        this.DBName = DBName;
    }

    /**
     * @return the tables
     */
    public ArrayList<DataBaseTable> getTables() {
        return tables;
    }

    /**
     * @param tables the tables to set
     */
    public void setTables(ArrayList<DataBaseTable> tables) {
        this.tables = tables;
    }

    
    
}
