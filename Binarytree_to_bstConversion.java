/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author purushottam
 */
public class Binary_tree {

    /**
     * @param args the command line arguments
     */
    static int i = 0;
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
        
    }
    static Node root = null;
    static ArrayList<Integer> arr = new ArrayList<Integer>();       //Array to store inorder traversalof binary tree
    
    static Node insert(Node root,int data){                         //Insert into binary tree
        Queue<Node> queue = new LinkedList<>();
        if(root!=null){
            queue.add(root);
            while(!queue.isEmpty()){
                Node temp = queue.poll();
                if(temp.left==null){
                    temp.left = new Node(data);
                    break;
                }
                else{
                    queue.add(temp.left);
                }
                
                if(temp.right==null){
                    temp.right = new Node(data);
                    break;
                }
                else{
                    queue.add(temp.right);
                }      
            }
        }
        else{
            root = new Node(data);
        }
        return root;
    }
    
    static void inorder(Node root){                                 //Inorder traversal of tree (Recursive approach)
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
   
    static void inorder1(Node root, ArrayList<Integer> arr){        // storing Inorder traversal of binary tree
        if(root!=null){
            inorder1(root.left,arr);
            arr.add(root.data);
            inorder1(root.right,arr);
        }
    }
        
    static Node bst(Node root, ArrayList<Integer> arr){         //copying the sorted data again in inorder traversal of binary tree
        if(root!=null && i<arr.size()){
            bst(root.left,arr);
            root.data = arr.get(i++);
            bst(root.right,arr);
        }
        return root;
    }
    
    static Node bstConversion(Node root){                       //utility function for BST conversion
       
        inorder1(root,arr);
        Collections.sort(arr);
        Node temp = bst(root,arr);
        return temp;
    }
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Node in Binary tree");
        int n = sc.nextInt();
        for(int j=0;j<n;j++){
          root = insert(root,sc.nextInt());
        }
        System.out.println("Inorder traversal of Binary tree");
        inorder(root);
        System.out.println("\n Inorder traversal of Binary search tree*******************");
        root = bstConversion(root);
        inorder(root);
    }
    
}
