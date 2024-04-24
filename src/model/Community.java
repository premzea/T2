package model;
import model.Representative;
import model.Products;
import java.util.ArrayList;

public class Community{
    private String name;
    private TypeCom type;
    private int population;
    private Representative rep;
    private String problems;
    private Products[] products = new Products[20];
    private TypeProblem problem; 
    

    // public Communities(String pName, String pType, int pPopulation, Representative pRep, String problems, Products[] pProducts, ){
    //     this.name = pName;
    //     this.type = stringToEnum(pType);
    //     this.population = pPopulation;
    //     this.rep = pRep;
    //     this.products = pProducts; 
        
    
    // }

    public Community(String pName, String pType, int pPopulation, String nameRep, String cellphone, String problem){
        this.name = pName;
        this.type = stringToEnum(pType);
        this.population = pPopulation;
        this.rep = new Representative(nameRep, cellphone);
        this.problem = stringToEnumProblem(problem);
    }

    public String toString(){
        return "Name: " + name + "\nType: " + type.name() + "\nPopulation: " + population + "\nName Representative: " + rep.getName() + "\nCellphone Representative: " + rep.getCellphone() + "\nProblematic: " + problem.name();
    }

    public Representative getRepresentative(){
        return rep;
    }

    public TypeProblem stringToEnumProblem(String problem){
        return TypeProblem.valueOf(problem.toUpperCase());
    }

    public String enumToStringProblem(TypeProblem problem){
        return problem.name().replace("_", " ");
    }

    public String getProblem() {
        return problem.name().replace("_", " ");
    }

    public void setProblem(TypeProblem problem) {
        this.problem = problem;
    }

    public void addProduct(String pName, double perNatural, String pType, boolean pHandmade){
        for (int i = 0; i< 20; i++){
            if (products[i] == null){
                products[i] = new Products(pName, perNatural, pType, pHandmade);
                i = 21;
            }
        }
    }

    public void modifyProduct(int index, String pName, double perNatural,String pType,boolean handmade){
        products[index] =  new Products(pName, perNatural, pType, handmade);
    }

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

    public Products[] getProducts(){
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

    public void setProducts(Products[] pProducts){
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
        Products[] newProducts = new Products[20];
        for(int i =0, j=0; i< products.length;i++){
            if(i!= index){
                newProducts[j++] = products[i]; 
            }
        }
        this.products = newProducts;
    }

    

}