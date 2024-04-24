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
    private String picPath;

    
    /**
    * Method is the Construcor
    *@param pName, type String
    *@param pType, type String
    *@param pNumber, int
    *@param pPicture, String
    */

    public Species(String pName, String pType, String pPicture, int pNumber){
            this.name = pName;
            this.type = TypeSpecies.valueOf(pType.toUpperCase());
            this.picturePath = pPicture;
            this.number = pNumber;
    }

    /**
    * Method gets name from atrributes
    *@return name, type String
    */

    public String getName(){
        return name;
    }

    /**
    * Method gets type from atrributes
    *@return name, type TypeSpecies
    */
    
    public TypeSpecies getType(){
        return type;
    }

    /**
    * Method gets the picture path from atrributes
    *@return name, type String
    */

    public String getPicture(){
        return picturePath;
    }

    /**
    * Method gets number of individuals from atrributes
    *@return name, type String
    */

    public int getNumber(){
        return number;
    }

    public String toString(){
        return "\nName: " + name + "\nType: " + type.name()  + "\nNumber of Individuals: " + number + "\nPicture Path: " +  picPath;
    }

    // public void setName(String pName){
    //     this.name = pName;
    // }

    // public void setType(String pType){
    //     this.type = stringtoEnum(pType);
    // }

    // public void setPicture(String pPicture){
    //     this.picturePath = pPicture;
    // }

    // public void setNumber(int pNumber){
    //     this.number = pNumber;
    // }


}