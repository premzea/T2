package model;


public class Products{
    private String name;
    private double perNatural;
    private String type;
    private boolean handmade;


    public Products(String pName, double perNatural, String pType, boolean pHandmade){
        this.name = pName;
        this.perNatural = perNatural;
        this.type = pType;
        this.handmade = pHandmade;
    }

    public String getName(){
        return name;
    }

    
    public String getType(){
        return type;
    }

    public double getperNatural(){
        return perNatural;
    }



    public String getHandmade(){
        String ret = "no";
        if (handmade == true){
            ret = "yes";
        } 
        return ret;
    }

    public void setName(String pName){
        this.name = pName;
    }

    public void setType(String pType){
        // can i make a scanner here to put in the type or does it have to be in the ui?
        this.type = pType;
    }



    public void setHandmade(boolean pHandmade){
        this.handmade = pHandmade;
    }

    public void setPerNatural(double pPerNatural){
        this.perNatural = pPerNatural;
    }

}