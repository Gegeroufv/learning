package dataStructure.chapter2.pojo;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/7 16:00
 */
public interface DoubleLinkedTrait {
    DoubleLinkedTrait getNext();

    void setNext(DoubleLinkedTrait node);

    DoubleLinkedTrait getPre();

    void setPre(DoubleLinkedTrait node);

    String getItem();

    void setItem(String item);

}
