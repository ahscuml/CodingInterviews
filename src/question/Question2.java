package question;

/**
 * 实现Singleton模式
 * 只能创建一个对象
 *
 * @author ahscuml
 * @date 2018/8/7
 * @time 16:17
 */
public class Question2 {
    private final static Question2 question2 = new Question2();

    private Question2() {
    }

    public Question2 getinstance() {
        return question2;
    }
}

/**
 * 懒汉式
 * */
class singletonLazy {
    private static volatile singletonLazy singletonLazy;
    public singletonLazy getInstance(){
        if (singletonLazy == null) {
            synchronized (singletonLazy.getClass()) {
                if (singletonLazy == null) {
                    singletonLazy = new singletonLazy();
                }
            }
        }
        return singletonLazy;
    }
    private singletonLazy(){}
}

/**
 * 饿汉式
 * */
class singletonHungry {
    private static final singletonHungry SINGLETONHUNGRY = new singletonHungry();
    private singletonHungry(){}
    public singletonHungry getInstance() {
        return SINGLETONHUNGRY;
    }
}