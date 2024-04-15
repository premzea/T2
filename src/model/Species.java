package model;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Species{
    private String name;
    private TypeSpecies type;
    private String picturePath;
    private int number;

    public Species(String pName, String pType, String pPicture, int pNumber){
        this.name = pName;
        this.type = stringToEnum(pType);
        this.picturePath = pPicture;
        this.number = pNumber;
    }

    public Species(String pName, String pType, int pNumber){
        this.name = pName;
        this.type = stringtoEnum(pType);
        this.number = pNumber;
    }

    public String enumtoString(TypeSpecies type){
        return type.name();
    }

    public TypeSpecies stringtoEnum(String type){
        return TypeSpecies.valueOf(type.toUpperCase());
    }

    public String getName(){
        return name;
    }
    
    public TypeSpecies getType(){
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

    public int getNumber(){
        return number;
    }

    public void setName(String pName){
        this.name = pName;
    }

    public void setType(String pType){
        this.type = stringtoEnum(pType);
    }

    public void setPicture(String pPicture){
        this.picturePath = pPicture;
    }

    public void setNumber(int pNumber){
        this.number = pNumber;
    }


}