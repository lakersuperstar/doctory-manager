package cn.caas.directory.util;

import java.io.File;

/**
 * 文件操作工具类
 * 
 * @author songk
 *
 */
public class FileUtil {

	/**
	 * 获取目录下所有的子文件夹和子文件
	 * 
	 * @param path
	 * @return
	 */
	public static String[] getChildFileName(String path) {
		File file = new File(path);
		if (file.exists() && file.isDirectory()) {
			return file.list();
		} else {
			return new String[] {};
		}
	}

	/**
	 * 判断路径是否是文件夹
	 * 
	 * @param path
	 * @return
	 */
	public static boolean isDirectory(String path) {
		File file = new File(path);
		if (file.exists()) {
			return file.isDirectory();
		} else {
			return false;
		}

	}

}
