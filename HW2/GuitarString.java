import java.util.*;
import java.util.Random;
/*
import java.io.*;
import javax.swing.*;
*/

public class GuitarString {
   
   private int capacity;
   private Queue<Double> ringBuffer;
   public double decayFactor = 0.996; 
   
   /*
   public static void main(String[] args){
      double random = Math.random();
      System.out.println(random);
   }
   */
   
   public GuitarString(double frequency) {
         ringBuffer= new LinkedList<Double>();
         // capacity N (sampling rate divided by frequency, rounded to the nearest integer)
         capacity = (int)Math.rint((StdAudio.SAMPLE_RATE/frequency)); 
         if(frequency <= 0 || capacity <2 ) {
            throw new IllegalArgumentException("the size or frequency is not valid");
         }
         else {
            // initializes it to represent a guitar string at rest by enqueueing N zeros
            for(int i = 0; i < capacity; i++) {
               ringBuffer.add((double)0);
            }
         }
   }
   
   public GuitarString(double[] init) {
      if(init.length < 2) {
         throw new IllegalArgumentException("the size of the array is not valid");
      }
      else {
         ringBuffer = new LinkedList<Double>();
         for(int i = 0; i < init.length; i++) {
            ringBuffer.add(init[i]);
         }
      }
   }
   
   
   public void pluck() {
      //Random randomNum = Math.random();
      for(int j = 0; j < capacity; j++) {
         ringBuffer.remove();
      }
      for(int i = 0; i < capacity; i++) {
         double random = Math.random() - 0.5;
         ringBuffer.add(random);
      }
   }
   
   
   public void tic() {
      double num1 = ringBuffer.remove();
      double num2 = ringBuffer.peek();
      ringBuffer.add( 0.5 * decayFactor * (num1+num2) );    
   }
   
   
   public double sample() {
      return ringBuffer.peek();
   }
   
   
}