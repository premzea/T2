package model;


public class Products{
    private String name;
    private double perNatural;
    private TypeProduct type;
    private boolean handmade;


    public Products(String pName, double perNatural, String pType, boolean pHandmade){
        this.name = pName;
        this.perNatural = perNatural;
        this.type = stringToEnum(pType);
        this.handmade = pHandmade;
    }

    public String getName(){
        return name;
    }

    
    public TypeProduct getType(){
        return type;
    }

    public double getperNatural(){
        return perNatural;
    }



    public boolean getHandmade(){
        return handmade;
    }

    public void setName(String pName){
        this.name = pName;
    }

    public void setType(String pType){
        // can i make a scanner here to put in the type or does it have to be in the ui?
        this.type = stringToEnum(pType);
    }



    public void setHandmade(boolean pHandmade){
        this.handmade = pHandmade;
    }

    public void setPerNatural(double pPerNatural){
        this.perNatural = pPerNatural;
    }

    public static TypeProduct stringToEnum(String tipo){
        return TypeProduct.valueOf(tipo.toUpperCase());
    }

}