package ordersystemdatabasebuilder.objects;

import java.util.ArrayList;

/**
 *
 * @author Ethan Holmes, Zach Bherensmeyer, Chuck Baxter, Dalton Schilling
 */
public class DataBaseTable {
    private String tableName;
    private ArrayList<DatabaseField> fields;
    private int orderNumber;
    private String description;
    
    public void addField(DatabaseField currentField) {
        fields.add(currentField);
    }

    public DataBaseTable(String tableName, ArrayList<DatabaseField> fields, 
        int orderNumber, String description) {
        this.tableName = tableName;
        this.fields = fields;
        this.orderNumber = orderNumber;
        this.description = description;
    }

    public DataBaseTable(String loadingField) {
        this.tableName = loadingField;
        this.fields = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "DataBaseTable{" + "tableName=" + tableName + ", fields=" 
                + fields + ", orderNumber=" + orderNumber + ", description=" 
                + description + '}';
    }

    /**
     * @return the tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * @param tableName the tableName to set
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * @return the fields
     */
    public ArrayList<DatabaseField> getFields() {
        return fields;
    }

    /**
     * @param fields the fields to set
     */
    public void setFields(ArrayList<DatabaseField> fields) {
        this.fields = fields;
    }

    /**
     * @return the orderNumber
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber the orderNumber to set
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    

   
}
