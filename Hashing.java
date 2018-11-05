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
    private DataBlock[] arr = new DataBlock[DataBlockLength];

    public HashBlock(){
        System.out.println("called!");
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
    final int hashTableLength = 10;
    HashBlock[] hashTable = new HashBlock[hashTableLength];    
    final int randomNoLimit = 100;

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
            hashTable[hashFunction(data)].pushblock(data , value , hashFunction(data/10));
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
