package model;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Species;
import java.util.ArrayList;

public class Place{
    private String name;
    private TypePlace type;
    private String picturePath;
    private double area;
    private  MyDate openDate;
    private Community community;
    private Species[] species = new Species[15];
    private Department department;

    /**
    * Method is the Construcor
    *@param pName, type String
    *@param pType, type String
    *@param pArea, type String
    *@param day, type int
    *@param month, type int
    *@param year, type int
    *@param pCommunity, type Community
    *@param department, type String
    */
    
    public Place(String pName, String pType, double pArea, int day, int month, int year, Community pCommunity, String department){
        this.name = pName;
        this.type = TypePlace.valueOf(pType);
        this.area = pArea;
        this.community = pCommunity;
        this.openDate = new MyDate(day, month, year);
        this.department = Department.valueOf(department);
        
    }

    public String toString(){
        return "Name: " + name + "\nType: " + type.name().replace("_", " ") + "\nArea(km^2): " + area + "\nDate: " + openDate.toString() + "\nCommunity:" + community.toString() + "\nDepartment: " + department.name();
    }

    
    public String getName(){
        return name;
    }
    
    public TypePlace getType(){
        return type;
    }

    
    public void getPicture(){
    BufferedImage image = null;
    try {
        image = ImageIO.read(new File(picturePath));
        } catch (IOException e) {
        // Handle image loading errors (e.g., display an error message)
        System.err.println("Error loading image: " + e.getMessage());
        };

    if (image != null) {
    JLabel imageLabel = new JLabel(new ImageIcon(image));
    JFrame frame = new JFrame("Image Display");
    frame.getContentPane().add(imageLabel);
    frame.pack();
    frame.setVisible(true);
    }

    }

    public double getArea(){
        return area;
    }

    public MyDate getDate(){
        return openDate;
    }

    public String getCommunityName(){
        return community.getName();
    }

    public String getComInfo(){
        return community.toString();
    }


    public Species[] getSpecies(){
        return species;
    }

    public void setName(String pName){
        this.name = pName;
    }

    public void setType(String pType){
        this.type = TypePlace.valueOf(pType);
    }

    public void setPicture(String pPicture){
        this.picturePath = pPicture;
    }

    public void setArea(double pArea){
        this.area= pArea;
    }

    public void setDate(MyDate pDate){
        // do i set a date here or in ui?
        this.openDate = pDate;
    }

    public void setCommunity(Community pCommunity){
        this.community = pCommunity;
    }

    public void setSpecies(Species[] pSpecies){
        this.species = pSpecies;
    }

    public void addSpecies(String name, String pType, int pNumber){
        for (int i = 0; i< 15; i++){
            if (species[i] == null){
                species[i] = new Species(name, pType, pNumber);
                i = 21;
            }
        }
    }

    public String[] getSpeciesNames(){
        String [] specNames = new String[15];
        for(int i = 0; i<15; i++){
            if(species[i]!= null){
                specNames[i] = species[i].getName();
            }
        }
        return specNames;
    }

    public void modifySpecies(int index, String name,String pType,int pNumber){
        //change to make object here
        Species spec = new Species(name, pType, pNumber);
        species[index] =  spec;
    }

    public void deleteSpecies(int index){
        species[index] = null;
        Species[] newSpecies = new Species[15];
        for(int i =0, j=0; i< species.length;i++){
            if(i!= index){
                newSpecies[j++] = species[i]; 
            }
        }
        this.species = newSpecies;
        // me va a quedar un hueco en la lista?
        
    }

    public String getDepartment(){
        return department.name();
    }



    

    
}