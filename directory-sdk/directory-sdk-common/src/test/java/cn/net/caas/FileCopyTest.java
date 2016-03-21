package cn.net.caas;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.nio.ByteBuffer;

import java.nio.channels.FileChannel;

public class FileCopyTest {

	public static void main(String[] args) throws Exception {

		String sourcePath = "F:/copy-main/win7.0";

		String destPath1 = "G:/copy-1/win7.0";

		String destPath3 = "G:/copy-3/win7.0";

		long t1 = System.currentTimeMillis();

		nioCopy(sourcePath, destPath1);

		long t2 = System.currentTimeMillis();

		System.out.println(":" + (t2 - t1) + "ms");

		long t3 = System.currentTimeMillis();

		nioCopy2(sourcePath, destPath3);

		long t4 = System.currentTimeMillis();

		System.out.println(":" + (t4 - t3) + "ms");

	}

	private static void nioCopy(String sourcePath, String destPath)
			throws Exception {

		File source = new File(sourcePath);

		File dest = new File(destPath);

		if (!dest.exists()) {

			dest.createNewFile();

		}
		FileInputStream fis = new FileInputStream(source);

		FileOutputStream fos = new FileOutputStream(dest);

		FileChannel sourceCh = fis.getChannel();

		FileChannel destCh = fos.getChannel();

		ByteBuffer bytebuffer = ByteBuffer.allocate(1024 * 256);

		while ((sourceCh.read(bytebuffer)) > 0) {

			bytebuffer.flip();

			destCh.write(bytebuffer);

			bytebuffer.clear();

		}

		sourceCh.close();

		destCh.close();
		
		fis.close();
		
		fos.close();

	}

	private static void nioCopy2(String sourcePath, String destPath)
			throws Exception {

		File source = new File(sourcePath);

		File dest = new File(destPath);

		if (!dest.exists()) {

			dest.createNewFile();

		}
		FileInputStream fis = new FileInputStream(source);

		FileOutputStream fos = new FileOutputStream(dest);

		FileChannel sourceCh = fis.getChannel();

		FileChannel destCh = fos.getChannel();

		ByteBuffer bytebuffer = ByteBuffer.allocateDirect(1024 * 256);

		while ((sourceCh.read(bytebuffer)) > 0) {

			bytebuffer.flip();

			destCh.write(bytebuffer);

			bytebuffer.clear();

		}

		sourceCh.close();

		destCh.close();
		
		fis.close();
		
		fos.close();

	}
}
