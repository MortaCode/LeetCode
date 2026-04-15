package 链表;

import java.util.HashMap;
import java.util.Map;

//双向链表+哈希<Integer, DListNode>
public class LRU {


    public static void main(String[] args) {
        LRU lru = new LRU(4);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.put(4,4);
        lru.put(5,5);
        System.out.println(lru.get(1));
    }

    class DListNode{
        private Integer key;
        private Integer value;
        private DListNode pre;
        private DListNode next;
        DListNode(){}
        DListNode(Integer key, Integer value){
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, DListNode> map;
    int size;
    int capacity;
    DListNode head, tail;

    public LRU(int capacity){
        map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DListNode node = map.get(key);
        if (node == null){
            return -1;
        }
        //移动到头节点
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        DListNode node = map.get(key);
        if (node == null){
            DListNode newNode = new DListNode(key, value);
            map.put(key, newNode);
            size++;
            //添加到头节点[新节点]
            addToHead(newNode);
            if (size > capacity){
                //删除尾节点
                Integer removeKey = removeTail();
                map.remove(removeKey);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }

    /**
     * 删除节点
     * @param node
     */
    private void removeNode(DListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


    /**
     * 添加到头节点
     * @param node
     */
    private void addToHead(DListNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    /**
     * 移动到头节点
     * @param node
     */
    private void moveToHead(DListNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 删除尾节点
     * @return
     */
    private Integer removeTail() {
        DListNode node = tail.pre;
        removeNode(node);
        return node.key;
    }


}
