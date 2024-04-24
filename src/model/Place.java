package model;


public class Place{
    private String name;
    private TypePlace type;
    // private String picturePath;
    private double area;
    private  MyDate openDate;
    private Community community;
    private Species[] species = new Species[15];
    private Department department;
    private String picPath;

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
    *@param picPath, type String
    */
    
    public Place(String pName, String pType, double pArea, int day, int month, int year, Community pCommunity, String department, String picPath){
        this.name = pName;
        this.type = TypePlace.valueOf(pType);
        this.area = pArea;
        this.community = pCommunity;
        this.openDate = new MyDate(day, month, year);
        this.department = Department.valueOf(department);
        this.picPath = picPath;
    }

    /**
    * Method shows places attributes as string
    *@return str, type String
    */

    public String toString(){
        String str = "Name: " + name + "\nType: " + type.name().replace("_", " ") + "\nArea(km^2): " + area + "\nDate: " + openDate.toString() + "\nCommunity:" + community.toString() + "\nDepartment: " + department.name();
        if(hasSpecies()){
            str = str + "\nSpecies";
            for(int i = 0; i< species.length; i++){
                str = str + "\nSpecies" + (i+1) + "\n" + species[i].toString();
            }
        }
        return str;
    }
    

    /**
    * Method gets name from atrributes
    *@return name, type String
    */
    
    public String getName(){
        return name;
    }

    /**
    * Method gets picPath
    *@return picPath, type String
    */

    public String getPicPath(){
        return picPath;
    }

    /**
    * Method gets type from attributes
    *@return type, type TypePlace
    */
    
    public TypePlace getType(){
        return type;
    }

    
    // /**
    // * Method gets type from attributes
    // *@return type, type TypePlace
    // */
    
    // public void getPicture(){
    // BufferedImage image = null;
    // try {
    //     image = ImageIO.read(new File(picturePath));
    //     } catch (IOException e) {
    //     // Handle image loading errors (e.g., display an error message)
    //     System.err.println("Error loading image: " + e.getMessage());
    //     };

    // if (image != null) {
    // JLabel imageLabel = new JLabel(new ImageIcon(image));
    // JFrame frame = new JFrame("Image Display");
    // frame.getContentPane().add(imageLabel);
    // frame.pack();
    // frame.setVisible(true);
    // }

    // }

    /**
    * Method gets Area from attributes
    *@return area, type double
    */

    public double getArea(){
        return area;
    }

    /**
    * Method gets date from attributes
    *@return date, type MyDate
    */

    public MyDate getDate(){
        return openDate;
    }

    /**
    * Method gets community's name from attributes
    *@return name, type String
    */

    public String getCommunityName(){
        return community.getName();
    }

    /**
    * Method gets commnity's information from atrributes
    *@return info, type String
    */

    public String getComInfo(){
        return community.toString();
    }

    /**
    * Method gets species array from attributes
    *@return species, type Species[]
    */

    public Species[] getSpecies(){
        return species;
    }   

    /**
    * Method checks if there is at least one species in the species array
    *@return value, type boolean 
    */

    public boolean hasSpecies(){
        boolean value = false;
        if(species[0] != null){
            value = true;
        }
        return value;
    }

    /**
    * Method checks if the species array is not full
    *@return value, type boolean 
    */

    public boolean canAddSpecies(){
        boolean value = false;
        if(species[14] == null){
            value = true;
        }
        return value;
    }



    // public void setName(String pName){
    //     this.name = pName;
    // }

    // public void setType(String pType){
    //     this.type = TypePlace.valueOf(pType);
    // }

    // public void setPicture(String pPicture){
    //     this.picturePath = pPicture;
    // }

    // public void setArea(double pArea){
    //     this.area= pArea;
    // }

    // public void setDate(MyDate pDate){
    //     // do i set a date here or in ui?
    //     this.openDate = pDate;
    // }

    // public void setCommunity(Community pCommunity){
    //     this.community = pCommunity;
    // }

    // public void setSpecies(Species[] pSpecies){
    //     this.species = pSpecies;
    // }

    /**
    * Method adds species to the place
    *@param name, String
    *@param pType, String
    *@param pNumber, int
    *@param picPath, String
    */

    public void addSpecies(String name, String pType, int pNumber, String picPath){
        for (int i = 0; i< 15; i++){
            if (species[i] == null){
                species[i] = new Species(name, pType, picPath, pNumber);
                i = 21;
            }
        }
    }

    /**
    * Method makes an array of the species names
    *@return specNames, type String []
    */

    public String[] getSpeciesNames(){
        String [] specNames = new String[15];
        for(int i = 0; i<15; i++){
            if(species[i]!= null){
                specNames[i] = species[i].getName();
            }
        }
        return specNames;
    }

    
    /**
    * Method modifies a species from the species array
    *@param name, String
    *@param pType, String
    *@param pNumber, int
    *@param picPath, String
    */

    public void modifySpecies(String name,String pType,int pNumber, String picPath){
        //change to make object here
        int index = 0;
        for (int z = 0; z < 15; z++) {
            if (species[z].getName().equals(name)) {
                if(pType == null){
                    pType = species[z].getType().name();
                }
                if(pNumber == -1){
                    pNumber = species[z].getNumber();
                }

                if(picPath == null){
                    picPath = species[z].getPicture();
                }
                index = z;
                z = 15;
            }
            
        }
        Species spec = new Species(name, pType, picPath, pNumber);
        species[index] =  spec;
    }

    /**
    * Method deletes a species from the species array
    *@param index, int
    */

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

    /**
    * Method gets the department
    *@return department, String
    */

    public String getDepartment(){
        return department.name();
    }


    
}