package com.example.linked;

public class LinkedTest {
    public static void main(String[] args){
        DLLinkedList linkedList = new DLLinkedList();
        GoodsNode goodsNode1 = new GoodsNode(1,"耐克运动鞋",599.00);
        GoodsNode goodsNode2 = new GoodsNode(2,"耐克上衣",269.00);
        GoodsNode goodsNode3 = new GoodsNode(3,"阿迪达斯",489.00);
        GoodsNode goodsNode4 = new GoodsNode(4,"李宁运动鞋",846.00);

        linkedList.add(goodsNode1);
        linkedList.add(goodsNode2);
        linkedList.add(goodsNode3);
        linkedList.add(goodsNode4);

        linkedList.delNode(3);
        linkedList.list();
    }
}
