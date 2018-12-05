简单思路：

    1、双向链表来存放缓存数据
    2、每次get完一个元素以后，先删除这个元素，再见这个元素添加到链表尾端。
    3、每次put完一个元素，校验容量是否超过设定的值，如果超过了，从链表首端删除多余的元素。

LinkedHashMap：

    1、LinkedHashMap是天然的双向链表。
    2、LinkedHashMap已经提供实现LRU算法的基础设施。
    3、LinkedHashMap不是并发安全的，并发场景下需要考虑并发控制。


参考链接：

1、LinkedHashMap： https://colobu.com/2015/09/07/LRU-cache-implemented-by-Java-LinkedHashMap/
