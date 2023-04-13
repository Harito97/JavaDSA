package Hw5_21002139_PhamNgocHai.ex1.ex1_3;

import java.io.FileWriter;
import java.io.IOException;

import Hw5_21002139_PhamNgocHai.ex1.ex1_1.ArrayBinaryTree;

public class TestPrintArrayTreeToFile<E> {
    public static void main(String[] args) {
        ArrayBinaryTree<Integer> arrayTree = new ArrayBinaryTree<>();
        arrayTree.setRoot(1);
        arrayTree.setLeft(0, 5);
        arrayTree.setRight(0, 3);
        arrayTree.setLeft(1, 8);
        arrayTree.setRight(1, 6);
        arrayTree.setLeft(2, 2);
        arrayTree.setRight(2, 7);
        arrayTree.visualize(arrayTree.root(), 4);
        // print
        /*
         * 
         * --------------7
         * 
         * ---------3
         * 
         * --------------2
         * 
         * ----1
         * 
         * --------------6
         * 
         * ---------5
         * 
         * --------------8
         */
        
        // print to file
        System.out.println("\nWRITING TO FILE ...");
        String fileName = "/home/harito/Màn hình nền/Workspace/Java/HomeworkDAS/src/Hw5_21002139_PhamNgocHai/ex1/ex1_3/ArrayTreeWrite.txt";
        try {
            FileWriter writer = new FileWriter(fileName);
            arrayTree.writeFile(arrayTree.root(), 4, writer);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error when write file.");
            e.printStackTrace();
        }
    }

}
