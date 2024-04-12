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
    private  Dates openDate;
    private String community;
    private ArrayList<Species> species;

    public Place(String pName, String pType, String pPicturePath, double pArea, int day, int month, int year, String pCommunity, ArrayList<Species> pSpecies){
        this.name = pName;
        this.type = stringToEnum(pType);
        this.picturePath = pPicturePath;
        this.area = pArea;
        this.name = pCommunity;
        this.openDate = new Dates(day,month,year);
        this.species = pSpecies;
    }

    public Place(String pName, String pType, double pArea, int day, int month, int year, String pCommunity){
        this.name = pName;
        this.type = stringToEnum(pType);
        this.area = pArea;
        this.name = pCommunity;
        this.openDate = new Dates(day, month, year);
        
    }

    public TypePlace stringToEnum(String tipo){
        return TypePlace.valueOf(tipo.toUpperCase());
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

    public Dates getDate(){
        return openDate;
    }

    public String getCommunity(){
        return community;
    }

    public ArrayList<Species> getSpecies(){
        return species;
    }


    public void setName(String pName){
        this.name = pName;
    }

    public void setType(String pType){
        this.type = stringToEnum(pType);
    }

    public void setPicture(String pPicture){
        this.picturePath = pPicture;
    }

    public void setArea(double pArea){
        this.area= pArea;
    }

    public void setDate(Dates pDate){
        // do i set a date here or in ui?
        this.openDate = pDate;
    }

    public void setCommunity(String pCommunity){
        this.community = pCommunity;
    }

    public void setSpecies(ArrayList<Species> pSpecies){
        this.species = pSpecies;
    }
}