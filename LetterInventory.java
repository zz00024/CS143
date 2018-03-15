public class LetterInventory {
   
   private String data;
   private int[] numberLetter;
   private int sumofCount;
   private final int alphabetsNum = 26;
     
   public LetterInventory(String data) {
      data = data.toLowerCase();
      // array for number of each letter in string data
      numberLetter = new int[alphabetsNum];
      sumofCount = 0;
      for(int z = 0; z < numberLetter.length; z++) {
         numberLetter[z] = 0;
      }
      
      for(int i =0; i<data.length(); i++) {
         // a = 97 ~ z = 122,asciII table 
         char convertedNumber = data.charAt(i);
         int theIndex = (int) convertedNumber;   
         if(theIndex >= 'a' && theIndex <='z') {
            numberLetter[theIndex-'a'] += 1;   
            sumofCount += 1;
         }         
      }           
   }
   
   public LetterInventory(int[] array) {
      numberLetter = array;
      sumofCount = 0;
      for(int i =0; i < numberLetter.length; i++) {
         sumofCount += numberLetter[i];
      }            
   }
   
   // Returns a count of how many of this letter are in the inventory
   public int get(char letter) {
      String newLetter = Character.toString(letter).toLowerCase();
      char finalLetter = newLetter.charAt(0);
      int theIndex = (int)finalLetter;      
      if(!(theIndex >= 'a' && theIndex <='z')) {
         throw new IllegalArgumentException("the character is no a letter");
      }
      return this.numberLetter[theIndex - 'a'];
      
   }
   
   // Sets the count for the given letter to the given value
   public void set (char letter, int value) {
      letter = Character.toLowerCase(letter);
      int theIndex = (int)letter;
      if(!(theIndex >= 'a' && theIndex <='z')) {
         throw new IllegalArgumentException("the character is no a letter");
      }
      else if(value < 0) {
         throw new IllegalArgumentException("the value is negative");
      }
      else {
         this.sumofCount -= this.numberLetter[theIndex - 'a']; 
         this.numberLetter[theIndex - 'a']  = value;
         this.sumofCount += value; 
      } 
   }
   
   // Returns the sum of all of the counts in this inventory.
   public int size() {
      return this.sumofCount;
   }
   
   public boolean isEmpty() {
      return this.size()==0;
   }
      
   public String toString() {
      String toString = "[";
      for(int i =0; i < this.numberLetter.length; i++) {
         for(int j=0; j < this.numberLetter[i] ; j++) {            
            toString += (char)(i+97);          
         }
      }
      toString += "]";
      return toString;
   }
   
   // use object as a return type here?
   public LetterInventory add(LetterInventory other) {
      int[] newString = new int[alphabetsNum];
      for(int i =0; i < newString.length; i++) {
         newString[i] = this.get((char)(i+97)) + other.get((char)(i+97));
      }
      LetterInventory combinedObject = new LetterInventory(newString);      
      return combinedObject;
   }
   
   // use object as a return type here?
   public LetterInventory subtract(LetterInventory other) {
         int[] newString = new int[alphabetsNum];
         for(int i=0; i < newString.length;i++) {
            if(this.get((char)(i+97)) < other.get((char)(i+97))) {
               return null;
            }                  
            newString[i] = this.get((char)(i+97)) - other.get((char)(i+97));           
         }
         LetterInventory combinedObject = new LetterInventory(newString);
         return combinedObject;
   }   
}