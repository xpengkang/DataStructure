package ds.tree;

import sun.misc.JavaLangAccess;

public class AvlTree <T extends Comparable>{
    //泛型T










    public static class AvlNode<T extends Comparable>{
        private T data;
        private AvlNode<T> left;
        private AvlNode<T> right;


        private int height;
        //自动生成的构造器
        public AvlNode(T data, AvlNode<T> left, AvlNode<T> right, int height) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }
}
