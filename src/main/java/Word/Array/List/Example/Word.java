package Word.Array.List.Example;

/** Class Word
 *  
 *      A class for words. Class Word receives lowercase strings in the 
 *      constructor. Class is set up based a UML diagram.
 *      The UML is copied below.
 *
 * 
 * Word class UML
 *  Word implements Comparable by word.
 *    - wordCharacters : String
 *    - count : integer
 *   + CONSTRUCTOR (word : String) 
 *     + getWord() : String 
 *     + getCount() : Integer 
 *     + incrementCount() : void 
 *     + toString() : String 
 *     + equals(wordtoCompare : Object) : Boolean 
 *     + compareTo(wordtoCompare : Word) : Integer
 * 
 * @author Norman
 */
public class Word implements Comparable<Word>
{    
    private String wordCharacter;  /// Store the characters in the word. 
    private int count; /// To store the freqeuncy of the word.               
    
    
    /** Constructor word
     *      Will take a string as input and create a word
     * @param word 
     */
    public Word(String word) { 
        wordCharacter = word;  
        incrementCount();
    }
    
    
    /// Method getWord
    public String getWord() {   return wordCharacter; }
    
    /// Method getCount
    public int getCount() {   return count; }
        
    /// Method incrementCount will increment the count of an existing word     
    public void incrementCount() {  count= count+1; }
    
 
    @Override
    public String toString() {        
       /// This method must return the word with the count attached as a string. I.e "word,#"         
        String wordWithCountAttached = ""+getWord()+","+getCount()+"";
        return wordWithCountAttached;
    }/// End of Method toString
    
    
    
           
    /** Override Method equals
     *      Compare the contents of the words in the class.
     * 
     * @param wordtoCompare
     * @return 
     */
    @Override
    public boolean equals(Object wordtoCompare ) {                
        /// Compare wordcharacter with wordtocompare
        /// return true if same, false if not same.                        
        boolean issame = false;
        
        if (wordtoCompare != null && wordtoCompare instanceof Word) 
        {           
            if (this.wordCharacter.equals(((Word)wordtoCompare).wordCharacter))
            {   issame = true;  }
            else         
            {   issame = false; }
        }    
        return issame;
        
    }/// End of override method equals.
    

    
    
    /** compareTo
     *      Receives a word to be compared to this word. Words are compared by
     *      the word's count.
     * 
     * @param wordtoCompare
     * @return 
     */
    public int compareTo(Word wordtoCompare) {        
        /// Use compareable interface Comparable<T> 
        if (this.count < wordtoCompare.count)
           return 1;
        else if (this.count > wordtoCompare.count)
           return -1;
        return 0;
    }/// End of compareTo method.
    
    
}/// End of class Word