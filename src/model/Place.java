package model;
import java.util.Date;
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
    private String type;
    private String picturePath;
    private double area;
    private  Date openDate;
    private String community;
    private ArrayList<Species> species;

    public Place(String pName, String pType, String pPicturePath, double pArea, Date pDate, String pCommunity, ArrayList<Species> pSpecies){
        this.name = pName;
        this.type = pType;
        this.picturePath = pPicturePath;
        this.area = pArea;
        this.name = pCommunity;
        this.openDate = pDate;
        this.species = pSpecies;
    }

    public String getName(){
        return name;
    }

    
    public String getType(){
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

    public Date getDate(){
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
        this.type = pType;
    }

    public void setPicture(String pPicture){
        this.picturePath = pPicture;
    }

    public void setArea(double pArea){
        this.area= pArea;
    }

    public void setDate(Date pDate){
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