import java.io.*;
import java.util.Random;
import java.util.Scanner;

class DataBlock{
    int data;
    int value;

    //Sets Default Value to 0
    public DataBlock(){
        System.out.println("assigns!");
        data = 0;
        value = 0;
    }
};

class HashBlock{
    final private int DataBlockLength = 10;
    private DataBlock[] arr;

    public HashBlock(){
        arr = new DataBlock[DataBlockLength];
        //Creating instance for the datablock array...
        for(int i = 0;i < DataBlockLength; i++){
            arr[i] = new DataBlock();
        }
        System.out.println("called 2");        
    }

    public void pushblock(int data , int value , int hash){
        arr[hash].data = data;
        arr[hash].value = value;   
        System.out.println("pushed!");     
    }

    public void printHashBlock(){
        for(int i = 0; i < DataBlockLength ; i++){
            System.out.print("(" + arr[i].data + "," + arr[i].value + ") ");
        }
    }
};

class Hashing{
    final private int hashTableLength = 10;
    private HashBlock[] hashTable;   
    final private int randomNoLimit = 1000;

    //Constructor..
    public Hashing(){
        hashTable = new HashBlock[hashTableLength];
        //Creating Instance for the hashblock array...
        for(int i = 0 ;i < hashTableLength; i++){
            hashTable[i] = new HashBlock();
        }
    }

    //Hash Function i.e, hash = number % 10
    private int hashFunction(int number){
        int index;
        index = number % 10;
        return index;
    }

    //Input accepting function
    public void inputAcceptor(){
        System.out.print("Enter the no of values to insert into hash table :");
        Scanner scanObj = new Scanner(System.in);
        int count = scanObj.nextInt();
        Random randObj = new Random(); 
        System.out.println("works!");
        for(int i = 0; i < count ; i++){
            int data = randObj.nextInt(randomNoLimit) + 1;
            int value = randObj.nextInt(randomNoLimit) + 1;
            System.out.println(data);
            //hash1 = hashfunction(data) , hash2 = hashfunction(data/10)
            hashTable[hashFunction(data/10)].pushblock(data , value , hashFunction(data));
        }
        scanObj.close();
    }
    
    public void printHashTable(){
        for(int i = 0; i < hashTable.length ; i++){
            hashTable[i].printHashBlock();
            System.out.println("");
        }
    }
    /*
    public static int searchNumber(int number){
        int index;
        index = hashFunction(number);

        while(hashTable[index] != number){
            index++;
        }

        return index;
    }
    */
    public static void main(String[] args){
        Hashing mainobj = new Hashing();
        mainobj.inputAcceptor();
        mainobj.printHashTable();
    }
};
