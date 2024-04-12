package model;
import java.util.ArrayList;

public class Controller {

    public ArrayList<Communities> getComs() {
        return coms;
    }

    public String[] getComsNames(){
        String[] comsNames = new String[coms.size()];
        for(int i = 0; i < coms.size(); i++){
            comsNames[i] = coms.get(i).getName();
        }
        return comsNames;
    }

    public ArrayList<String> comsToString(){
        ArrayList<String> array = new ArrayList<>();
        for(int i = 0; i<coms.size(); i++){
            array.add(coms.get(i).getName());
        }
        return array;
    }

    public void setComs(ArrayList<Communities> coms) {
        this.coms = coms;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }

    public ArrayList<Communities> coms = new ArrayList<>();

    public ArrayList<Place> places = new ArrayList<>();

    public void addCommunity(String pName, String pType, int pPopulation, String nameRep, String cellphone){
        Communities community = new Communities(pName, pType, pPopulation, nameRep, cellphone);
        coms.add(community);
    }

    public void addPlace(String pName, String pType, double pArea, int day, int month, int year, String pCommunity){
        Place place = new Place(pName, pType, pArea, day, month, year, pCommunity);
        places.add(place);
    }

    public void addProduct(String comName, String pName, double perNatural, String pType, boolean pHandmade){
        for (int i=0; i< coms.size(); i++){
            if(coms.get(i).getName() == comName){
                coms.get(i).addProduct(pName, perNatural, pType, pHandmade);
                i = coms.size() + 1;
            }
        }
    }

    public void modifyProduct(String comName, String pName, double perNatural, String pType, String pHandmade){
        boolean handmade = pHandmade.equals("true")? true:false;
        Products product = new Products(pName, perNatural, pType, handmade);
        for (int i=0; i< coms.size(); i++){
            if(coms.get(i).getName().equals(comName)){
                for(int z = 0; z<20; z++){
                    if(coms.get(i).getProductNames()[z].equals(pName)){
                        coms.get(i).modifyProduct(z, product);
                        z = 21;
                    }   
                    i = 100;
                }
            }
        }
    }

    public String[] getProductsNames(String nomCom){
        String [] procNames = new String[20];
        for (int i=0; i< coms.size(); i++){
            if(coms.get(i).getName() == nomCom){
                procNames = coms.get(i).getProductNames();
                //list product names
            }
        }
        return procNames;
    }

    public boolean hasProducts(String comName){
        boolean value;
        Products output = null;
        for(int i = 0; i< coms.size(); i++){
            if(coms.get(i).getName().equals(comName)){
                output = coms.get(i).getProducts()[0];
                i = 123;
            }
            
        }
        value = output == null? false:true;
        return value;
        
    }


    public void deleteProduct(String comName, int index){
        for(int i = 0; i< coms.size(); i++){
            if(coms.get(i).getName().equals(comName)){
                coms.get(i).modifyProduct(index, null);
                i = 100;
                //should i somehow delete the product and move the whole index or just leave the null?
            }
            
        }
    }

}
