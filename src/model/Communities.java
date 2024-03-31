package model;
import model.Representative;
import model.Products;
import java.util.ArrayList;

public class Communities{
    private String name;
    private String type;
    private int population;
    private Representative rep;
    private String problems;
    private ArrayList<Products> products;
    

    public Communities(String pName, String pType, int pPopulation, Representative pRep, String problems, ArrayList<Products> pProducts){
        this.name = pName;
        this.type = pType;
        this.population = pPopulation;
        this.rep = pRep;
        this.products = pProducts; 
    
    }

    public String getName(){
        return name;
    }
    
    public String getType(){
        return type;
    }

    
    public int getPopulation(){
        return population;
    }

    public String getProblems(){
        return problems;
    }

    public ArrayList<Products> getProducts(){
        return products;
    }

    public void setName(String pName){
        this.name = pName;
    }

    public void setType(String pType){
        this.type = pType;
    }


    public void setPopulation(int pNumber){
        this.population = pNumber;
    }

    public void setProblems(String pProblems){
        this.problems = pProblems;
    }

    public void setProducts(ArrayList<Products> pProducts){
        this.products = pProducts;
    }
}