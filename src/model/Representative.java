package model;

public class Representative{
    private String name;
    private String cellphone;

    public Representative(String pName, String pCellphone){
        this.name = pName;
        this.cellphone = pCellphone;
    }

    public void setName(String pName){
        this.name = pName;
    }

    public void setCellphone(String pCellphone){
        this.cellphone= pCellphone;
    }

    public String getName(){
        return name;
    }

    
    public String getCellphone(){
        return cellphone;
    }
}
