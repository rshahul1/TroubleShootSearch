package troubleShootSearch.driver;

import troubleShootSearch.element.CheckFile;
import troubleShootSearch.element.MyArrayList;
import troubleShootSearch.element.MyTree;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.Results;
import troubleShootSearch.visitor.ExactMatch;
import troubleShootSearch.visitor.NaiveStemming;
import troubleShootSearch.visitor.SemanticMatch;
import troubleShootSearch.visitor.VisitorI;

import java.util.ArrayList;
import java.util.HashMap;

public class Driver {

    public static String outFile;
    public static ArrayList<String> entireOutput=new ArrayList<String>();
    public static void main(String[] args) {
        if ((args.length != 5) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") || args[3].equals("${arg3}") || args[4].equals("${arg4}")){

            System.err.println("Error: Incorrect number of arguments. Program requires 5 arguments.");
            System.exit(0);
        }

        int debugValue = Integer.parseInt(args[4]);   //Storing Debug value
        MyLogger.setDebugValue(debugValue);
        if(debugValue < 0 || debugValue > 4) {
            MyLogger.Message("WARNING!! The assigned debug value is out of range. Check README for the value usage!");
            System.exit(0);
        }

        FileProcessor fp=new FileProcessor();
        ArrayList<String> userInput = new ArrayList<String>();
        userInput=fp.readLine(args[0]); //Reading userInput.txt file

        ArrayList<String> fileData=new ArrayList<String>();
        fileData=fp.readLine(args[1]);  //Reading technicalInfo.txt file

        ArrayList<String> semInput = new ArrayList<String>();
        semInput = fp.readLine(args[2]); //Reading synonyms.txt file

         outFile = args[3];    //output.txt file

        CheckFile checkFile = new CheckFile(fileData, semInput);
        MyArrayList arrayList = new MyArrayList();
        MyTree myTree = new MyTree(fileData);

        //creating instances of visitor 
        VisitorI exactMatch = new ExactMatch();
        VisitorI naiveStemming = new NaiveStemming();
        VisitorI semanticMatch = new SemanticMatch();

       //iterating for each userInput
       for(int i=0;i<userInput.size();i++){
           entireOutput.add("User Input - "+ userInput.get(i));
           entireOutput.add("Exact Match ----------");
           arrayList.accept(exactMatch,userInput.get(i),checkFile);
           entireOutput.add("Semantic Match ----------");
           arrayList.accept(semanticMatch,userInput.get(i),checkFile);
           entireOutput.add("Naive Stemming ----------");
           myTree.accept(naiveStemming,userInput.get(i),checkFile);
       }

        Results rs=new Results();
        
	//Printing into console and file
        if(debugValue!=0){
            rs.writeToStdout();
        }
        rs.writeToFile();


    }
}
