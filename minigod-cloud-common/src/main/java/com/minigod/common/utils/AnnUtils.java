package com.minigod.common.utils;

import com.minigod.common.exception.MiniGodException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class AnnUtils {
	private static final Logger logger = LoggerFactory.getLogger(AnnUtils.class);

	/** 
	 * 获取某包下（包括该包的所有子包）所有类 
	 * @param packageName 包名 
	 * @return 类的完整名称 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public static Set<Class<?>> getAllClasses(String packageName) throws ClassNotFoundException, IOException {
		Set<String> strClasses = getClassName(packageName, true);
		Set<Class<?>> set = new HashSet<Class<?>>();
		for (String c : strClasses) {
			//替换类似的路径com/yiminigod/sequence/service/SequenceService
			if (c.indexOf("/") > 0) {
				c = c.replace("/", ".");
			}
			Class<?> cls = Class.forName(c);
			if (cls != null) {
				if (logger.isDebugEnabled()) {
					logger.debug("scan calss [" + cls.getName() + "].");
				}
				set.add(cls);
			}
		}
		return set;
	}

	/** 
	 * 获取某包下所有类 
	 * @param packageName 包名 
	 * @param childPackage 是否遍历子包 
	 * @return 类的完整名称 
	 * @throws IOException 
	 */
	public static Set<String> getClassName(String packageName, boolean childPackage) throws IOException {
		Set<String> fileNames = new HashSet<String>();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		String packagePath = packageName.replace(".", "/");
		Enumeration<URL> en = loader.getResources(packagePath);
		while (en.hasMoreElements()) {
			URL url = (URL) en.nextElement();
			if (url != null) {
				String type = url.getProtocol();
				if (type.equals("file")) {
					fileNames.addAll(getClassNameByFile(url.getPath(), null, childPackage));
				} else if (type.equals("jar")) {
					fileNames.addAll(getClassNameByJar(url.getPath(), childPackage));
				}
			} else {
				fileNames.addAll(getClassNameByJars(((URLClassLoader) loader).getURLs(), packagePath, childPackage));
			}
		}
		return fileNames;
	}

	/** 
	 * 从项目文件获取某包下所有类 
	 * @param filePath 文件路径 
	 * @param className 类名集合 
	 * @param childPackage 是否遍历子包 
	 * @return 类的完整名称 
	 * @throws UnsupportedEncodingException 
	 */
	private static Set<String> getClassNameByFile(String filePath, Set<String> className, boolean childPackage) throws UnsupportedEncodingException {
		Set<String> myClassName = new HashSet<String>();

		filePath = java.net.URLDecoder.decode(filePath, "utf-8");

		File file = new File(filePath);
		File[] childFiles = file.listFiles();
		for (File childFile : childFiles) {
			if (childFile.isDirectory()) {
				if (childPackage) {
					myClassName.addAll(getClassNameByFile(childFile.getPath(), myClassName, childPackage));
				}
			} else {
				String childFilePath = childFile.getPath();
				if (childFilePath.endsWith(".class")) {

					childFilePath = childFilePath.substring(childFilePath.indexOf(File.separator + "classes" + File.separator) + 9, childFilePath.lastIndexOf("."));
					childFilePath = childFilePath.replace(File.separator, ".");
					myClassName.add(childFilePath);
				}
			}
		}

		return myClassName;
	}

	/** 
	 * 从jar获取某包下所有类 
	 * @param jarPath jar文件路径 
	 * @param childPackage 是否遍历子包 
	 * @return 类的完整名称 
	 */
	private static List<String> getClassNameByJar(String jarPath, boolean childPackage) {
		List<String> myClassName = new ArrayList<String>();
		String[] jarInfo = jarPath.split("!");
		String jar = jarInfo[0];
		//解决无法获取文件的问题
		int _index = jar.indexOf(File.separator);
		if (_index < 0) {
			_index = jar.indexOf("/");
		}
		String jarFilePath = jar.substring(_index);
		String packagePath = jarInfo[1].substring(1);
		try {
			jarFilePath = java.net.URLDecoder.decode(jarFilePath, "utf-8");
			JarFile jarFile = new JarFile(jarFilePath);
			Enumeration<JarEntry> entrys = jarFile.entries();
			while (entrys.hasMoreElements()) {
				JarEntry jarEntry = entrys.nextElement();
				String entryName = jarEntry.getName();
				if (entryName.endsWith(".class")) {
					if (childPackage) {
						if (entryName.startsWith(packagePath)) {
							entryName = entryName.replace(File.separator, ".").substring(0, entryName.lastIndexOf("."));
							myClassName.add(entryName);
						}
					} else {
						int index = entryName.lastIndexOf(File.separator);
						String myPackagePath;
						if (index != -1) {
							myPackagePath = entryName.substring(0, index);
						} else {
							myPackagePath = entryName;
						}
						if (myPackagePath.equals(packagePath)) {
							entryName = entryName.replace(File.separator, ".").substring(0, entryName.lastIndexOf("."));
							myClassName.add(entryName);
						}
					}
				}
			}
		} catch (Exception e) {
			throw new MiniGodException("load jar class handler.", e);
		}
		return myClassName;
	}

	/** 
	 * 从所有jar中搜索该包，并获取该包下所有类 
	 * @param urls URL集合 
	 * @param packagePath 包路径 
	 * @param childPackage 是否遍历子包 
	 * @return 类的完整名称 
	 * @throws UnsupportedEncodingException 
	 */
	private static List<String> getClassNameByJars(URL[] urls, String packagePath, boolean childPackage) throws UnsupportedEncodingException {
		List<String> myClassName = new ArrayList<String>();
		if (urls != null) {
			for (int i = 0; i < urls.length; i++) {
				URL url = urls[i];
				String urlPath = url.getPath();
				// 不必搜索classes文件夹  
				if (urlPath.endsWith("classes" + File.separator)) {
					continue;
				}
				String jarPath = urlPath + "!" + File.separator + packagePath;
				jarPath = java.net.URLDecoder.decode(jarPath, "utf-8");
				myClassName.addAll(getClassNameByJar(jarPath, childPackage));
			}
		}
		return myClassName;
	}

	public static void main(String[] args) {
		try {
			Set<Class<?>> set = getAllClasses("com.yiminigod");
			System.err.println(set);
		} catch (Exception e) {
			throw new MiniGodException("load jar class handler.", e);
		}
	}
}
