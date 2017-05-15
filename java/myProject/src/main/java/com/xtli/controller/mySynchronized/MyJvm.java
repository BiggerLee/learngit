package com.xtli.controller.mySynchronized;

/*class MyJvm{
    private static MyJvm instance = null;
    private MyJvm(){}
    public static MyJvm getInstance(){
        if (instance == null) {
            instance = new MyJvm();        
        }
        return instance;
    }
}*/
//给单例加锁：直接加在方法上. 每个获取getInstance()方法的对象都需要锁等待。假如第一个线程进来发现instance为null就创建了，
//等第二个线程进来的时候其实instance已经存在对象了，但是还是会进行锁等待。造成效率低。
/*class MyJvm{
    private static MyJvm instance = null;
    private MyJvm(){}
    public static synchronized MyJvm getInstance(){
        if (instance == null) {
            instance = new MyJvm();        
        }
        return instance;
    }
}
*/
//懒汉单例:双重检索（double checking）的方式
class MyJvm{
  private static MyJvm instance = null;
  private MyJvm(){}
  public static MyJvm getInstance(){
      if (instance == null) {//第1个线程进来会进入锁然后创建对象，第2个线程再走到这的时候已经不会再进入同步块不会出现锁等待了
          synchronized(MyJvm.class){////静态方法里没有this，所以只能锁定类的字节码信息
              if (instance == null) {
                  instance = new MyJvm();        
              }
          }
      }
      return instance;
  }
}
