package troubleShootSearch.element;

import troubleShootSearch.visitor.NaiveStemming;
import troubleShootSearch.visitor.VisitorI;

import java.util.ArrayList;

public class MyTree implements ElementI {
   
    //Node root;

     private String word;
     private MyTree left;
     private MyTree right;
     ArrayList<String> fileData = new ArrayList<String>();
   

     public MyTree(ArrayList<String> fileData) {
        
           this.fileData=fileData;
           String strJoin = String.join(" ",fileData);
         String[] str = strJoin.split( " " );

	 //parsing the fileinput into words and adding as nodes
         if(str!=null){
//             this.root = new Node(str[0]);
             for(int i=0;i<str.length;i++)
                 addNode(str[i]);
         }
     }

     public MyTree(String word){
         this.word=word;
         this.left=null;
         this.right=null;

     }
     //inserting each word into tree as node
     public void addNode(String word){
         if(this.word==null)
             this.word=word;
         else {
             if(this.word.compareTo(word)<0){
                 if(this.left!=null)
                     this.left.addNode(word);
                 else
                     this.left= new MyTree(word);
             }
             else{
                 if (this.right!=null)
                     this.right.addNode(word);
                 else
                     this.right=new MyTree(word);
             }
         }
     }
    

    //methos to check if the user input is matching with the words from the fileinput
    public void traverseInOrder(String data,NaiveStemming nm) {
      
        if (this.left != null) {
            this.left.traverseInOrder(data,nm);
        }

        
        if((this.word).indexOf(data)!=-1){
            if(!(this.word).equals(data)){
                (nm.naiveWord).add(data);
            }
            }
        if (this.right != null) {
            this.right.traverseInOrder(data,nm);
        }

    }

    /*public int getCount(){
        // System.out.println("Hi");
         for(int i=0;i<naiveword.size();i++)
          System.out.println("array:"+naiveword.get(i));
        System.out.println("arraysize:"+naiveword.size());
         return naiveword.size();
    }
    */
/*
      class Node{
          String word;
          Node left,right;

          Node(String word){
              this.word=word;
              left=null;
              right=null;
          }
      }

      public void insert(Node node,String word){

          if(node.word==null)
              node.word=word;
          else {
              if(node.word.compareTo(word)<0){
                  if(node.left!=null)
                      insert(node.left,word);
                  else
                      node.left= new Node(word);
              }
              else{
                  if (node.right!=null)
                      insert(node.right,word);
                  else
                      node.right=new Node(word);
              }
          }
      }

      public void traverseInOrder(Node node,String word) {
          if (node.left != null)
              traverseInOrder(node.left, word);
          System.out.println("Word :"+node.word);
          if ((node.word).indexOf(word) != -1){
              this.count++;
          if(node.right != null)
              traverseInOrder(node.right,word);
          }

      }

      public void checkWord(String word){
          traverseInOrder(root,word);
      }
      public int getCount(){
          return this.count;
      }
*/

    public ArrayList getFileData(){
        return fileData;
    }

    //Everytime Naive stemming visitor is created, accept method has to be invoked.
    @Override
    public void accept(VisitorI v, String s, CheckFile cf) {
         if(v instanceof NaiveStemming)
             ((NaiveStemming) v).visit(this,s);
    }
}
