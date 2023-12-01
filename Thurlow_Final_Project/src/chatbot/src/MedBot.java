package chatbot.src;
//Written by James Thurlow  
//Oct 2023
// This class contains the methods that effectively control the chatbot

import java.util.Scanner;

class MedBot{
    

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        String input;

        System.out.println("Hello! I am a medical chatbot. I can help you with your medical needs. Please enter your symptoms and" 
        +" I will see if I can help you. If you are finished, you can type 'done'.");
        
        while(true){
            input = keyboard.nextLine();
            if(input.equalsIgnoreCase("done")){
                System.out.println("Thank you for using this chatbot. I hope I was able to assist you. Goodbye!");
                break;
            }
            else{
                DiseaseSearch.getDisease(input);
            }
        }//end while
    } 

}