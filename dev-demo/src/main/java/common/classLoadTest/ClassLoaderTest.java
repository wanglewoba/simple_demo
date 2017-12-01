package common.classLoadTest;/**
 * Created by admin on 2017/11/28.
 */


import java.io.InputStream;

/**
 * @author sunwenwu
 * @create 2017-11-28 15:24
 **/
public class ClassLoaderTest {
    public static int i = 0;
    static {
        i = i++;
        System.out.println("------------------->第次"+i+"加载");
    }
    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                if(findLoadedClass(name) == null){
                    try {
                        String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                        InputStream in = getClass().getResourceAsStream(fileName);
                        if(in == null){
                            return super.loadClass(name);
                        }
                        byte[] b = new byte[in.available()];
                        in.read(b);
                        return defineClass(name,b,0,b.length);
                    }catch (Exception e){
                        throw new ClassNotFoundException(name);
                    }
                }else{
                    return super.loadClass(name);
                }
            }
        };

        Object obj = myLoader.loadClass("common.classLoadTest.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());

        System.out.println(obj instanceof common.classLoadTest.ClassLoaderTest);

       /* System.out.println(new ClassLoaderTest() instanceof common.classLoadTest.ClassLoaderTest);

        Object o = Class.forName("common.classLoadTest.ClassLoaderTest").newInstance();
        System.out.println(o instanceof common.classLoadTest.ClassLoaderTest);

        Object o1 = ClassLoader.getSystemClassLoader().loadClass("common.classLoadTest.ClassLoaderTest").newInstance();
        System.out.println(o1 instanceof common.classLoadTest.ClassLoaderTest);

        Object o2 = ClassLoader.getSystemClassLoader().loadClass("java.lang.String").newInstance();
        Object o3 =Class.forName("java.lang.String").newInstance();
        System.out.println(o2 instanceof java.lang.String);
        System.out.println(o3 instanceof java.lang.String);
*/
//        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        

    }
}
