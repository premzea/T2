package model;

public class Representative{
    private String name;
    private String cellphone;

    /**
    * Method is the Construcor
    *@param pName, type String
    *@param pCellphone, type String
    */

    public Representative(String pName, String pCellphone){
        this.name = pName;
        this.cellphone = pCellphone;
    }

     /**
    * Method gets name from atrributes
    *@return name, type String
    */

    public String getName(){
        return name;
    }

     /**
    * Method gets cellphone from atrributes
    *@return cellphone, type String
    */
    
    public String getCellphone(){
        return cellphone;
    }
}
