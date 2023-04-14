package com.example.linked;

public class DLLinkedList {
    private GoodsNode node = new GoodsNode(0,"",0.0);

    /*
    * 往链表中添加节点
    * */
    public void add(GoodsNode goodsNode){
        GoodsNode temp = node;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = goodsNode;
    }
    /*
    * 按商品编号id值进行添加
    * */
    public void addOder(GoodsNode goodsNode){
        GoodsNode temp = node;
        boolean flg = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.id > goodsNode.id){
                break;
            } else if (temp.next.id == goodsNode.id) {
                flg = true;
                break;
            }
            temp = temp.next;
        }
        if(flg){
            System.out.println("已经存在改商品,不能重复添加对象");
        }else {
            goodsNode.next = temp.next;
            temp.next = goodsNode;
        }
    }
    /*
    * 修改节点
    * 1.先找到链表中的目标节点
    * 2.根据新的数据修改
    * 3.根据商品的编号进行查找
    * */
    public void updateNode(GoodsNode goodsNode){
        //如果链表为空
        if(node.next == null){
            System.out.println("链表为空");
            return;
        }
        GoodsNode temp = node.next;
        //标识符，表示找到了节点
        boolean flg = false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.id == goodsNode.id){
                flg = true;
                break;
            }
            temp = temp.next;
        }
        if(flg){
            //真正的修改了节点
            temp.name = goodsNode.name;
            temp.price = goodsNode.price;
        }else {
            //在整个链表中未找到目标节点
            System.out.println("在整个链表中未找到目标节点");
        }
    }
    /*
    * 节点的删除功能
    * 条件：根据节点的编号删除
    * */
    public void delNode(int goodsNode_id){
        GoodsNode temp = node;
        boolean flg = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.id == goodsNode_id){
                flg = true;
                break;
            }
            temp = temp.next;
        }
        if(flg){
            temp.next = temp.next.next;
        }else {
            System.out.println("未找到删除的节点");
        }
    }
    /*
    * 定义查看链表中每一个节点元素
    * */
    public void list(){
        if(node.next == null){
            System.out.println("空链表");
            return;
        }
        GoodsNode temp = node.next;
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
