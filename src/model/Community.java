package model;
import model.Representative;
import model.Product;
import java.util.ArrayList;

public class Community{
    private String name;
    private TypeCom type;
    private int population;
    private Representative rep;
    private String problems;
    private Product[] products = new Product[20];
    private TypeProblem problem; 
    

    // public Communities(String pName, String pType, int pPopulation, Representative pRep, String problems, Products[] pProducts, ){
    //     this.name = pName;
    //     this.type = stringToEnum(pType);
    //     this.population = pPopulation;
    //     this.rep = pRep;
    //     this.products = pProducts; 
        
    
    // }

    /**
     * Method is Constructor of the class
     * @param pName, String
     * @param pType, String
     * @param pPopulation, int
     *@param nameRep, String
     *@param pPopulation, int
     *@param cellphone, String
     *@param problem, String
     */

    public Community(String pName, String pType, int pPopulation, String nameRep, String cellphone, String problem){
        this.name = pName;
        this.type = stringToEnum(pType);
        this.population = pPopulation;
        this.rep = new Representative(nameRep, cellphone);
        this.problem = TypeProblem.valueOf(problem.toUpperCase());
    }

    /**
     * Method shows the attributes of community in a string format
     *@return str, String
     */

    public String toString(){
        return "Name: " + name + "\nType: " + type.name() + "\nPopulation: " + population + "\nName Representative: " + rep.getName() + "\nCellphone Representative: " + rep.getCellphone() + "\nProblematic: " + problem.name();
    }

    /**
     * Method gets the Representative from th attributes
     *@return rep, type Representative
     */

    public Representative getRepresentative(){
        return rep;
    }

    // public TypeProblem stringToEnumProblem(String problem){
    //     return TypeProblem.valueOf(problem.toUpperCase());
    // }

    // public String enumToStringProblem(TypeProblem problem){
    //     return problem.name().replace("_", " ");
    // }

    /**
     * Method gets the problem from the attributes
     *@return problem, String 
     */

    public String getProblem() {
        return problem.name().replace("_", " ");
    }

    /**
     * Method shows the attributes of community in a string format
     *@return str, String
     */

    // public void setProblem(TypeProblem problem) {
    //     this.problem = problem;
    // }

    /**
     * Method adds products to the product array
     *@param pName, String
     *@param perNatural, double
     *@param pType, String
     *@param pHandmade, boolean
     */

    public void addProduct(String pName, double perNatural, String pType, boolean pHandmade){
        for (int i = 0; i< 20; i++){
            if (products[i] == null){
                products[i] = new Product(pName, perNatural, pType, pHandmade);
                i = 21;
            }
        }
    }

    public void modifyProduct(int indicator, String pName, double perNatural,String pType,boolean handmade){
        int index = 0;
        for (int z = 0; z < 20; z++) {
            if (products[z].getName().equals(pName)) {
                Product originalProduct = products[z];
                if(perNatural == -1){
                    perNatural = originalProduct.getperNatural();
                }
                if(pType == null){
                    pType = originalProduct.getType().name();
                } 
                if(indicator == 1){
                    handmade = originalProduct.getHandmade();
                }
                Product product = new Product(pName, perNatural, pType, handmade);
                index = z;
                z = 21;
            }
        products[index] =  new Product(pName, perNatural, pType, handmade);
    }}

    public String[] getProductNames(){
        String [] producName = new String[20];
        for(int i =0; i<20;i++){
            if(products[i] != null){
                producName[i] = products[i].getName();
            } else{
                i = 100;
            }
        } 
        return producName;
    }

    public String getName(){
        return name;
    }
    
    public TypeCom getType(){
        return type;
    }
 
    public int getPopulation(){
        return population;
    }

    // public String getProblems(){
    //     return problems;
    // }

    public Product[] getProducts(){
        return products;
    }

    public void setName(String pName){
        this.name = pName;
    }

    public void setType(TypeCom pType){
        this.type = pType;
    }

    public void setPopulation(int pNumber){
        this.population = pNumber;
    }

    public void setProblems(String pProblems){
        this.problems = pProblems;
    }

    public void setProducts(Product[] pProducts){
        this.products = pProducts;
    }

    private static String enumToString(TypeCom tipo){
        return tipo.name();
    }

    private static TypeCom stringToEnum(String tipo){
        return TypeCom.valueOf(tipo.toUpperCase());
    }

    public void deleteProduct(int index){
        products[index] = null;
        Product[] newProducts = new Product[20];
        for(int i =0, j=0; i< products.length;i++){
            if(i!= index){
                newProducts[j++] = products[i]; 
            }
        }
        this.products = newProducts;
    }

    

}