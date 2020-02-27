/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordersystemdatabasebuilder.objects;

/**
 *
 * @author Ethan Holmes, Zach Bherensmeyer, Chuck Baxter, Dalton Schilling
 */
public class DatabaseField {
     
    private String table;
    private String field;
    private String dataType;
    private String nullable;
    private String primaryKey;
    private String autoIncrement;
    private String foriegnKey;
    private String unique;
    private String otherConstraint;
    private String references;
    private String description;
    private int orderNumber;

 

 

    /**
     * @return the table
     */
    public String getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(String table) {
        this.table = table;
    }

    /**
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * @param field the field to set
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * @return the dataType
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * @param dataType the dataType to set
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * @return the nullable
     */
    public String getNullable() {
        return nullable;
    }

    /**
     * @param nullable the nullable to set
     */
    public void setNullable(String nullable) {
        this.nullable = nullable;
    }

    /**
     * @return the primaryKey
     */
    public String getPrimaryKey() {
        return primaryKey;
    }

    /**
     * @param primaryKey the primaryKey to set
     */
    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    /**
     * @return the autoIncrement
     */
    public String getAutoIncrement() {
        return autoIncrement;
    }

    /**
     * @param autoIncrement the autoIncrement to set
     */
    public void setAutoIncrement(String autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    /**
     * @return the foriegnKey
     */
    public String getForiegnKey() {
        return foriegnKey;
    }

    /**
     * @param foriegnKey the foriegnKey to set
     */
    public void setForiegnKey(String foriegnKey) {
        this.foriegnKey = foriegnKey;
    }

    /**
     * @return the unique
     */
    public String getUnique() {
        return unique;
    }

    /**
     * @param unique the unique to set
     */
    public void setUnique(String unique) {
        this.unique = unique;
    }

    /**
     * @return the otherConstraint
     */
    public String getOtherConstraint() {
        return otherConstraint;
    }

    /**
     * @param otherConstraint the otherConstraint to set
     */
    public void setOtherConstraint(String otherConstraint) {
        this.otherConstraint = otherConstraint;
    }

    /**
     * @return the references
     */
    public String getReferences() {
        return references;
    }

    /**
     * @param references the references to set
     */
    public void setReferences(String references) {
        this.references = references;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "DatabaseField{" + ", field=" + field + ", dataType=" + dataType + ", nullable=" + nullable + ", primaryKey=" + primaryKey + ", autoIncrement=" + autoIncrement + ", foriegnKey=" + foriegnKey + ", unique=" + unique + ", otherConstraint=" + otherConstraint + ", references=" + references + ", description=" + description + ", orderNumber=" + orderNumber + '}';
    }
 
    
    
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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


    
    public DatabaseField(String table, String field, 
            String dataType, String nullable, String primaryKey, 
            String autoIncrement, String foriegnKey, String unique,
            String otherConstraint, String references, String description, 
            int orderNumber) {

        this.table = table;
        this.field = field;
        this.dataType = dataType;
        this.nullable = nullable;
        this.primaryKey = primaryKey;
        this.autoIncrement = autoIncrement;
        this.foriegnKey = foriegnKey;
        this.unique = unique;
        this.otherConstraint = otherConstraint;
        this.references = references;
        this.description = description;
        this.orderNumber = orderNumber;
    }

   
    
}
