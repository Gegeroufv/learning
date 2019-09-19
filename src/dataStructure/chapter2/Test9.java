package dataStructure.chapter2;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/11 15:47
 */

/**
 * 汉诺塔问题
 * 三根针，其中一个从小到大
 * 排列着一些圆盘共64个，要求从一个移动到另一个，不许大压小排布
 *
 * 这里思维方式需要变化一下：
 * 递归的过程可能比较神秘，但是基本过程是把大象装进冰箱
 * 且是从结果推导过程！
 * 考虑问题主要是通过初始状态->递归状态->完成状态
 * 记住递归的无记忆性来选择参数和返回值
 * 对状态的抽象，这点一定要注意！！！
 *
 * 运行的时间可能会出现顺序不对
 * 这里还有用栈实现的非递归解法
 *
 * 画图的画看执行顺序会发现是对树的遍历，遍历且很有意思！
 */
public class Test9 {
    public static void main(String[] args) {
        move(3, 1, 3, 2);
    }

    private static void move(int n, int start, int goal, int temp) {
        if (n > 1) {
            move(n - 1, start, temp, goal);
            System.out.println("the " + n + " th from " + start + " move to " + goal);
            move(n - 1, temp, goal, start);
        }else {
            System.err.println("the " + n + " th from " + start + " move to " + goal);
        }
    }
}
