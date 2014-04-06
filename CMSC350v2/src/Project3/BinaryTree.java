/*
 * CMSC350 Project 2 Stephen Drollinger Valimere@gmail.com DATE 15 December 2013
 * NetBeans IDE 7.4
 */
package Project3;

import java.awt.*;
import java.util.*;
import javax.swing.*;

class BinaryTree<E>
{
    protected static class Node<E>
    {
        protected Node<E> left;
        protected E element;
        protected Node<E> right;
        protected int height;
    }
    protected Node<E> root;

    public BinaryTree()
    {
    }

    public BinaryTree(E element)
    {
        root = new Node();
        root.element = element;
    }

    public BinaryTree(BinaryTree<E> left, E element, BinaryTree<E> right)
    {
        root = new Node();
        root.left = left.root;
        root.element = element;
        root.right = right.root;
    }

    public ArrayList<E> preorder()
    {
        ArrayList<E> list = new ArrayList();
        preorder(root, list);
        return list;
    }

    private void preorder(Node<E> node, ArrayList<E> list)
    {
        if (node == null)
            return;
        list.add(node.element);
        preorder(node.left, list);
        preorder(node.right, list);
    }

    public ArrayList<E> inorder()
    {
        ArrayList<E> list = new ArrayList();
        inorder(root, list);
        return list;
    }

    private void inorder(Node<E> node, ArrayList<E> list)
    {
        if (node == null)
            return;
        inorder(node.left, list);
        list.add(node.element);
        inorder(node.right, list);
    }

    public ArrayList<E> postorder()
    {
        ArrayList<E> list = new ArrayList();
        postorder(root, list);
        return list;
    }

    private void postorder(Node<E> node, ArrayList<E> list)
    {
        if (node == null)
            return;
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.element);
    }

    public void iterativePreorder()
    {
        Stack<Node<E>> rightChildren = new Stack();

        Node<E> node = root;
        rightChildren.push(null);
        while (node != null)
        {
            System.out.print(node.element + " ");
            if (node.right != null)
                rightChildren.push(node.right);
            node = node.left;
            if (node == null)
                node = rightChildren.pop();
        }
    }

    public boolean isBalanced()
    {
        return isBalanced(root);
    }

    private boolean isBalanced(Node<E> node)
    {
        if (node == null)
            return true;
        return Math.abs(height(node.left) - height(node.right)) <= 1
                && isBalanced(node.left) && isBalanced(node.right);
    }

    private int height(Node<E> node)
    {
        if (node == null)
            return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }
    
    public int numberOfNodes()
    {
        return numberOfNodes(root);
    }
    
    private int numberOfNodes(Node<E> node)
    {
        if (root == null)
            return 0;
        return numberOfNodes(node.left) + numberOfNodes(node.right) + 1;
    }
    
    public int totalDepth()
    {
        return totalDepth(root, 1);
    }
    
    public int totalDepth(Node<E> node, int depth)
    {
         if (root == null)
            return 0;
         return totalDepth(node.left, depth + 1) + 
                 totalDepth(node.right, depth + 1) + depth;
    }
    
    private int maximumFactor;
    private Node<E> mostUnbalancedNode;
    
    public void maximumBalanceFactor()
    {
        maximumFactor = 0;
        maximumBalanceFactor(root);
    }
    
    private void maximumBalanceFactor(Node<E> node)
    {
        if (node == null)
            return;
        int balanceFactor = Math.abs(height(node.left) - height(node.right));
        if (balanceFactor > maximumFactor)
        {
            maximumFactor = balanceFactor;
            mostUnbalancedNode = node;
        }
        maximumBalanceFactor(node.left);
        maximumBalanceFactor(node.right);
    }
        
   
    
    private static final int SIZE = 1000;
    
    private class TreeDrawing extends JPanel
    {
        private static final int LEVEL_HEIGHT = 75, RADIUS = 20, X_OFFSET = 5;

        private void draw(Graphics graphics, Node<E> node, int x, int level, int parentX)
        {
            if (node == null)
                return;
            int y = level * LEVEL_HEIGHT;
            if (parentX > 0)
                graphics.drawLine(x, y, parentX, y - LEVEL_HEIGHT);
            draw(graphics, node.left, x / 2, level + 1, x);
            draw(graphics, node.right, x + x / 2, level + 1, x);
            graphics.setColor(Color.LIGHT_GRAY);
            graphics.fillOval(x - RADIUS, y - RADIUS, RADIUS * 2, RADIUS * 2);
            graphics.setColor(Color.BLACK);
            graphics.drawString("" + node.element, x - X_OFFSET, y);
        }
        
        @Override
        protected void paintComponent(Graphics graphics)
        {
            super.paintComponent(graphics);
            draw(graphics, root, SIZE / 2, 1, 0);
        }
    }

    public void display()
    {
        JFrame drawing = new JFrame();
        drawing.setSize(SIZE, SIZE / 2);
        drawing.add(new TreeDrawing());
        drawing.setVisible(true);
    }
}