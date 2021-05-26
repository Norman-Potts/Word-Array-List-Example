
package Word.Array.List.Example;
/**
 *     Word-Array-List-Example
 *     
 *      The goal of .
 *      Count all the occurrences of words in a '"tale.txt". 
 *      Store each word in lowercase format. 
 *      A word will be considered to be one or more characters in length separated 
 *      by white space (space character, the new line character). 
 *      All commas, periods, exclamation points, question marks, and quotes are ignored.
 *      Print an out put that answers the following. 
 *              1. Total # of different words
 *              2. Total # of words
 *              3. The list of the 10 most frequent words and counts
 *              4. The list of words that occur exactly 13 times in the file.
 *              5. The # of different words that contain more than one 's'.
 * 
 *       This program uses two classes, Main and Word. 
 *       Word class is used to store each word. 
 *       Main starts program, reads text file into an array-list of 'words', 
 *       and process the output using the array-list.
 *      
 *      This java project was created by Norman Potts.
 *      Future improvements for the project will include organizing Main's  
 *      method into methods to separate the procedures. 
 *      Could also make multi threaded. 
 *      
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        run();        
    }
    

    
    public static void run() {    
        
        
       /// File is stored in a resources folder in the project
        final String filename = "resources/tale.txt";
        ArrayList<Word> wordlist;
        
        
        try {
            Scanner fin = new Scanner(new File(filename));
            fin.useDelimiter("\\s|\"|\\(|\\)|\\.|\\,|\\?|\\!|\\_|\\-|\\:|\\;|\\n");  // Filter - DO NOT CHANGE 
            /// Create the word list 
            wordlist = new ArrayList<Word>();// creates array list.
            while (fin.hasNext())  {
                String fileWord = fin.next().toLowerCase();
                if (fileWord.length() > 0) {
                    Word objword = new Word(fileWord);
                    //if word does not already exist add in array add to arrray list.                                        
                    if (wordlist.contains(objword) != true) {                                                                        
                        wordlist.add(objword);
                    } else {
                        int x = wordlist.indexOf(objword);
                        wordlist.get(x).incrementCount();
                    }
                }                
            }//End while fin hasnext
            fin.close();
            /// End of file read and wordlist build.                        
            
            
            

            /// Now... Analysis the arraylist and get answers for questions of this lab.                               
            /// 1. Total # of different words
            int countofwords = wordlist.size();
            System.out.println("Total # of different words: "+countofwords);                        
            
            
            
            
            /// 2. Total # of words
            int totalcountofwords = 0;
            while( countofwords  > 0) {
                countofwords--;
                //Word dis_word =  wordlist.get(countofwords);
                totalcountofwords += wordlist.get(countofwords).getCount();                          
            }// End while
            System.out.println(" Total # of words: "+totalcountofwords);
            
            
            
            
            /// 3. The list of the 10 most frequent words and counts
            Collections.sort(wordlist);
            System.out.println(" The list of the 10 most frequent words and counts ");
            int ten = 0;
            do {
                int a = ten+1;
                Word dis_word =  wordlist.get(ten);
                System.out.println("    "+a+". "+dis_word.toString());                
                ten++;
            } while(ten < 10);
            
            
            
            
            /// 4. The list of words that occur exactly 13 times in the file.
            System.out.println(" The list of words that occur exactly 13 times in the file.");
            countofwords = wordlist.size() - 1;
            while( countofwords  >= 0) {
                Word dis_word =  wordlist.get(countofwords);                               
                if( dis_word.getCount() == 13 ) {
                    System.out.println("    "+dis_word.getWord());
                }
                countofwords--; 
            }// End While
            
            
            
            
            /// 5. The # of different words that contain more than one 's'. 
            int SS = 0;
            countofwords = wordlist.size() - 1;
            while( countofwords  >= 0) {
                Word dis_word =  wordlist.get(countofwords);
                String x = dis_word.getWord();                
                /// For needle in haystack for loop
                int countofSS = 0;
                for (int i=0; i < x.length(); i++) {
                    char needle = 's';
                    if (x.charAt(i) == needle) {
                       countofSS++;
                    }
                }// End for                   
                if( countofSS > 1)
                { SS++; }            
                countofwords--; 
            }// End While
            System.out.println(" Count of words with more than one s "+SS);       
            
               
            
            
        } catch(FileNotFoundException e) {
               System.out.println("Exception caught: " + e.getMessage());
        }// End catch 
        
        
              
    }/// End of main   
}/// End of class Main




