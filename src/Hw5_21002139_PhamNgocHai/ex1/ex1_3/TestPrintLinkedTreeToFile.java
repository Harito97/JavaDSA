package Hw5_21002139_PhamNgocHai.ex1.ex1_3;

import java.io.FileWriter;
import java.io.IOException;

import Hw5_21002139_PhamNgocHai.ex1.ex1_2.LinkedBinaryTree;
import Hw5_21002139_PhamNgocHai.ex1.ex1_2.LinkedBinaryTree.Node;

public class TestPrintLinkedTreeToFile {
    public static void main(String[] args) {
        // build tree like expected
        LinkedBinaryTree<Integer> linkedTree = new LinkedBinaryTree<>();
        Node<Integer> rootNode = linkedTree.setRoot(1);
        Node<Integer> leftRootNode = linkedTree.setLeft(rootNode, 5);
        Node<Integer> rightRootNode = linkedTree.setRight(rootNode, 3);
        linkedTree.setLeft(leftRootNode, 8);
        linkedTree.setRight(leftRootNode, 6);
        linkedTree.setLeft(rightRootNode, 2);
        linkedTree.setRight(rightRootNode, 7);

        // print like expected on terminal
        linkedTree.visualize(rootNode, 4);
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
        String fileName = "/home/harito/Màn hình nền/Workspace/Java/HomeworkDAS/src/Hw5_21002139_PhamNgocHai/ex1/ex1_3/LinkedTreeWrite.txt";
        try {
            FileWriter writer = new FileWriter(fileName);
            linkedTree.writeFile(rootNode, 4, writer);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error when write file.");
            e.printStackTrace();
        }
    }
}
