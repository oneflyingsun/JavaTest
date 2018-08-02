package javaCode.classLoad;

public class MyClassLoaderDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		MyClassLoader cl1 = new MyClassLoader();
		String className = "javaCode.classLoad.HelloService";
		Class<?> class1 = cl1.loadClass(className);

		MyClassLoader cl2 = new MyClassLoader();
		Class<?> class2 = cl2.loadClass(className);

		if (class1 != class2) {
		    System.out.println("different classes");
		}
	}

}
