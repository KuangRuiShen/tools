package mode.sigleton;

/**
 * @author krs
 * @time 2019年1月27日 下午2:37:55
 * @describe 单例模式的高效创建（延迟加载）
 */

public class SingletonInner {
	   /** 
     * 内部类实现单例模式 
     * 延迟加载，减少内存开销   
     */  
    private static class SingletonHolder {  
        private static SingletonInner instance = new SingletonInner();  
    }  
  
    /** 
     * 私有的构造函数 
     */  
    private SingletonInner() {}  
  
    public static SingletonInner getInstance() {  
        return SingletonHolder.instance;  
    }  
  
    protected void method() {  
        System.out.println("SingletonInner");  
    }

}
