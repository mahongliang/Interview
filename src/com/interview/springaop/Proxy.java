package com.interview.springaop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Proxy {

	public static Object newProxyInstance(Class infce, InvocationHandler h) throws Exception{
		String methodStr = "";
		String rt = "\r\n";

		Method[] methods = infce.getMethods();
		// 对inface所用方法，重新组织
		for (Method m : methods) {
			methodStr += "    @Override" + rt + "    public  " + m.getReturnType() + " " + m.getName() + "() {" + rt
					+ "        try {" + rt + "        Method md = " + infce.getName() + ".class.getMethod(\""
					+ m.getName() + "\");" + rt + "        h.invoke(this, md);" + rt
					+ "        }catch(Exception e) {e.printStackTrace();}" + rt + "    }" + rt;
		}

		// 生成代理类源文件
		String srcCode = "package com.interview.springaop;" + rt + "import java.lang.reflect.Method;" + rt
				+ "public class $Proxy1 implements " + infce.getName() + "{" + rt
				+ "    public $Proxy1(InvocationHandler h) {" + rt + "        this.h = h;" + rt + "    }" + rt
				+ "    com.interview.springaop.InvocationHandler h;" + rt + methodStr + rt + "}";

		String fileName = "E:\\JavaProj\\Interview\\src\\com\\interview\\springaop\\$Proxy1.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(srcCode);
		fw.flush();
		fw.close();

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();

		URL[] urls = new URL[] { new URL("file:/"+"E:/JavaProj/Interview/src/") };
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.interview.springaop.$Proxy1");

		Constructor ctr = c.getConstructor(InvocationHandler.class);
		Object m = ctr.newInstance(h);
		return m;
	}
}
