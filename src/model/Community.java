package model;

import model.Representative;
import model.Product;
import java.util.ArrayList;

public class Community {
    private String name;
    private TypeCom type;
    private int population;
    private Representative rep;
    private String problems;
    private Product[] products = new Product[20];
    private TypeProblem problem;

    // public Communities(String pName, String pType, int pPopulation,
    // Representative pRep, String problems, Products[] pProducts, ){
    // this.name = pName;
    // this.type = stringToEnum(pType);
    // this.population = pPopulation;
    // this.rep = pRep;
    // this.products = pProducts;

    // }

    /**
     * Method is Constructor of the class
     * 
     * @param pName,       String
     * @param pType,       String
     * @param pPopulation, int
     * @param nameRep,     String
     * @param pPopulation, int
     * @param cellphone,   String
     * @param problem,     String
     */

    public Community(String pName, String pType, int pPopulation, String nameRep, String cellphone, String problem) {
        this.name = pName;
        this.type = TypeCom.valueOf(pType);
        this.population = pPopulation;
        this.rep = new Representative(nameRep, cellphone);
        this.problem = TypeProblem.valueOf(problem.toUpperCase());
    }

    /**
     * Method shows the attributes of community in a string format
     * 
     * @return str, String
     */

    public String toString() {
        return "Name: " + name + "\nType: " + type.name() + "\nPopulation: " + population + "\nName Representative: "
                + rep.getName() + "\nCellphone Representative: " + rep.getCellphone() + "\nProblematic: "
                + problem.name();
    }

    /**
     * Method gets the Representative from th attributes
     * 
     * @return rep, type Representative
     */

    public Representative getRepresentative() {
        return rep;
    }

    // public TypeProblem stringToEnumProblem(String problem){
    // return TypeProblem.valueOf(problem.toUpperCase());
    // }

    // public String enumToStringProblem(TypeProblem problem){
    // return problem.name().replace("_", " ");
    // }

    /**
     * Method gets the problem from the attributes
     * 
     * @return problem, String
     */

    public String getProblem() {
        return problem.name().replace("_", " ");
    }

    /**
     * Method shows the attributes of community in a string format
     * 
     * @return str, String
     */

    // public void setProblem(TypeProblem problem) {
    // this.problem = problem;
    // }

    /**
     * Method adds products to the product array
     * 
     * @param pName,      String
     * @param perNatural, double
     * @param pType,      String
     * @param pHandmade,  boolean
     */

    public void addProduct(String pName, double perNatural, String pType, boolean pHandmade) {
        for (int i = 0; i < 20; i++) {
            if (products[i] == null) {
                products[i] = new Product(pName, perNatural, pType, pHandmade);
                i = 21;
            }
        }
    }

    /**
     * Method modifies products from the product array
     * 
     * @param indicator,  int
     * @param pName,      String
     * @param perNatural, double
     * @param pType,      String
     * @param handmade,   boolean
     */

    public void modifyProduct(int indicator, int index, double perNatural, String pType, boolean handmade) {
        for (int z = 0; z < 20; z++) {
            Product originalProduct = products[index];
            String pName = originalProduct.getName();
            if (perNatural == -1) {
                perNatural = originalProduct.getperNatural();
            }
            if (pType == null) {
                pType = originalProduct.getType().name();
            }
            if (indicator == 1) {
                handmade = originalProduct.getHandmade();
            }
            Product product = new Product(pName, perNatural, pType, handmade);
            index = z;
            z = 21;
            products[index] = new Product(pName, perNatural, pType, handmade);
        }
    }

    /**
     * Method
     * 
     * @param indicator,  int
     * @param pName,      String
     * @param perNatural, double
     * @param pType,      String
     * @param handmade,   boolean
     */

    // public String[] getProductNames(){
    // String [] producName = new String[20];
    // for(int i =0; i<20;i++){
    // if(products[i] != null){
    // producName[i] = products[i].getName();
    // } else{
    // i = 100;
    // }
    // }
    // return producName;
    // }

    /**
     * Method gets name
     * 
     * @return name, String
     */

    public String getName() {
        return name;
    }

    /**
     * Method gets type
     * 
     * @return type, TypeCom
     */

    public TypeCom getType() {
        return type;
    }

    /**
     * Method gets population
     * 
     * @return population, int
     */

    public int getPopulation() {
        return population;
    }

    // public String getProblems(){
    // return problems;
    // }

    /**
     * Method checks to see if products is not empty
     * 
     * @return value, boolean
     */

    public boolean hasProducts() {
        boolean value = false;
        if (products[0] != null) {
            value = true;
        }
        return value;
    }

    /**
     * Method checks to see if products has an empty space
     * 
     * @return value, boolean
     */

    public boolean canAddProducts() {
        return products[14] == null ? false : true;

    }

    // public Product[] getProducts(){
    // return products;
    // }

    // public void setName(String pName){
    // this.name = pName;
    // }

    // public void setType(TypeCom pType){
    // this.type = pType;
    // }

    // public void setPopulation(int pNumber){
    // this.population = pNumber;
    // }

    // public void setProblems(String pProblems){
    // this.problems = pProblems;
    // }

    // public void setProducts(Product[] pProducts){
    // this.products = pProducts;
    // }

    // private static String enumToString(TypeCom tipo){
    // return tipo.name();
    // }

    // private static TypeCom stringToEnum(String tipo){
    // return TypeCom.valueOf(tipo.toUpperCase());
    // }

    /**
     * Method deletes a product from products
     * @return value, boolean
     */

    public void deleteProduct(int index) {
        products[index] = null;
        Product[] newProducts = new Product[20];
        for (int i = 0, j = 0; i < products.length; i++) {
            if (i != index) {
                newProducts[j++] = products[i];
            }
        }
        this.products = newProducts;
    }

    /**
     * Method make an enumerated string of the products names
     * @return str, string
     */

    public String getProductNames() {
        String str = "";
        for (int i = 0; i < products.length; i++) {
            str = str + "(" + (i + 1) + ") " + products[i].getName() + "\n";
        }
        return str;
    }

}