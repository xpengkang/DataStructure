package ds.tree;

/**
 * 定义链表结构的tree
 */
public class BSTree {

    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        bsTree.put(7);
        bsTree.put(4);
        bsTree.put(13);
        bsTree.put(2);
        bsTree.put(5);
        bsTree.put(8);
        bsTree.put(14);

        Node node = bsTree.find(8);
        System.out.println(node.value);
    }

    /**
     * 构建节点
     */
    private static class Node{
        private int value;
        private Node left;//两个
        private Node right;


        //构造方法
        protected Node(Node left, int value, Node right){
            this.left = left;
            this.value = value;
            this.right = right;
        }

        /**
         * 自动生产
         * @return
         */
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }


    /**
     * 构造了有没有子树的节点node
     * @param value
     * @return
     */
    private Node createNode(int value){
        return new Node(null, value,  null);

    }
    private Node createNode(Node left,int value,Node right){
        return new Node(left, value, right);

    }


    Node parent;//父节点
    /**
     * 插入方法put
     */
    public boolean put(int value){
        if(parent == null){
            parent = createNode(value);
            return true;
        }
        //父节点否则不为空
        Node pt = parent;
        //遍历
        while(pt != null){
            if(pt.value > value){
                //parent = parent.left;

                if(pt.left == null){
                    pt.left = createNode(value);
                    return true;
                }
                //左子节点不为空
                else{
                    pt = pt.left;
                }
            }else if (pt.value < value){
                //在→
                if(pt.right == null){
                    pt.right = createNode(value);
                    return true;
                }else{
                    pt = pt.right;
                }

            }
            //如果不大于也不小于，就是等于，这个是不符合查找树的规则的
            return false;
        }

        return false;//为了不报错，先这样写todo
    }

    /**
     * 查
     * @param value
     * @return
     */
    public Node find(int value){
        while(parent.value != value){
            if(parent.value > value){
                parent = parent.left;
            }else if(parent.value < value){
                parent = parent.right;
            }else{
                return parent;
            }
        }
        return parent;
    }


}

