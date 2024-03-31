package ui;
import model.Communities;
import model.Place;
import model.Products;
import java.util.ArrayList;
import model.UserInteractions;
import java.util.Scanner;

public class COP16_DataSystem{

    public Scanner sc = new Scanner(System.in);

    public void main(String[] args){
        int entry = UserInteractions.askUserInput("Enter: \n 1.To modify information in the COP16 database \n 2.To consult information in the COP16 database", 2);  
        switch (entry) {
            case 1:
                
                break;
        
            case 2:
                break;
        }
    }


    public void administrativeMenu(){
        int entry = UserInteractions.askUserInput("Enter: \n1.To enter a community \n2.To enter a place \n3.To enter,modify or eliminate a product \n4.To enter a species \n5.To modify species data", 5);
        switch (entry) {
            case 1:
                
                break;
        
            case 2:
                break;
            
            case 3:
                break;
        } 
                
    } 

    public void consultsMenu(){
        
    }
    
    public void newCommunity(){
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Type 1:  ");
        int type_num = sc.nextInt();
    }
}
