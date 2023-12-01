package chatbot.src;
//Written by James Thurlow
//Oct 2023

//This is the main class for the chatbot program

import java.io.*;


class DiseaseSearch{
    
    static String[][] data;
    static int numOfDiseases;
    //public static 
    public static void load(){
        //This method will load the data from the csv file into the data array
        FileInputStream in = null;
        try{
            in = new FileInputStream("Training.csv");
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = null;
        try{
            line = br.readLine();
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
        int i = 0;
        while(line != null){
            String[] temp = line.split(",");
            for(int j = 0; j < temp.length; j++){
                data[i][j] = temp[j];
            }
            i++;
            try{
                line = br.readLine();
            }
            catch(IOException e){
                System.out.println("IO Exception");
            }
        }
        numOfDiseases = i;
    }

    public static int max(int[] arr){
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static String getDisease(String symptoms){
        //This method will use the data array to find the disease
        load(); 
        
        String result;

        String[] symptomList = symptoms.split("\\s+");
        String[] Diseases = new String[numOfDiseases];
        int[] symptomCount = new int[numOfDiseases];

        for(int i=0;i<numOfDiseases; i++){
            Diseases[i]= data[(data[i].length)-1][i];
        }

        for(int i=0;i<symptomList.length;i++){
            for(int j=0;j<numOfDiseases;j++){
                for(int k=0;k<data.length;k++){
                    if(data[k][j].equalsIgnoreCase(symptomList[i])){
                    symptomCount[j]++;
                }
                }
            }
        }
        result = Diseases[max(symptomCount)];
        return result;
    }
}