package model;

public class Product {
    private String name;
    private double perNatural;
    private TypeProduct type;
    private boolean handmade;

    /**
     * Method is Constructor of the class
     * 
     * @param pName, String
     * @param perNatural, double
     * @param pType, String
     * @param pHandmade, boolean
     * */

    public Product(String pName, double perNatural, String pType, boolean pHandmade) {
        this.name = pName;
        this.perNatural = perNatural;
        this.type =TypeProduct.valueOf(pType.toUpperCase());;
        this.handmade = pHandmade;
    }

    /**
     * Method gets the name
     * 
     * @return name, String
     */

    public String getName() {
        return name;
    }

    /**
     * Method gets the type
     * 
     * @return type, TypeProduct
     */

    public TypeProduct getType() {
        return type;
    }

    /**
     * Method gets the percentaje of natural materials
     * 
     * @return perNatural, double
     */

    public double getperNatural() {
        return perNatural;
    }

    /**
     * Method gets the handmade value
     * 
     * @return handmade, boolean
     */

    public boolean getHandmade() {
        return handmade;
    }

    /**
     * Method shows the attributes of product in a string format
     * 
     * @return str, String
     */

    public String toString(){
        return "\nName: " + name + "\nPercentaje of Natural Materials: " + perNatural + "\nType: " + type + "\nHandmade: " + handmade;
    }

    // public void setName(String pName) {
    //     this.name = pName;
    // }

    // public void setType(String pType) {
    //     // can i make a scanner here to put in the type or does it have to be in the ui?
    //     this.type = stringToEnum(pType);
    // }

    // public void setHandmade(boolean pHandmade) {
    //     this.handmade = pHandmade;
    // }

    // public void setPerNatural(double pPerNatural) {
    //     this.perNatural = pPerNatural;
    // }

    // public static TypeProduct stringToEnum(String tipo) {
    //     return TypeProduct.valueOf(tipo.toUpperCase());
    // }

}