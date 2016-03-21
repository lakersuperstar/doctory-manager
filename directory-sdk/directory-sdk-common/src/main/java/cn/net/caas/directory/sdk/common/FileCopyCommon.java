package cn.net.caas.directory.sdk.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 
 * 
 * @author Administrator
 * 
 */
public class FileCopyCommon {
	
	/**
	 * 
	 * 
	 * @param sourcePath
	 * @param destPath
	 * @param bufferSize
	 * 
	 * @return {@link Boolean}
	 */
	public static boolean fileCopyHeap(String sourcePath, String destPath, int bufferSize) {
		
		return nioCopy(sourcePath, destPath, ByteBuffer.allocate(bufferSize));
		
	}
	
	/**
	 * 
	 * 
	 * @param sourcePath
	 * @param destPath
	 * @param bufferSize
	 * 
	 * @return {@link Boolean}
	 */
	public static boolean fileCopyDirect(String sourcePath, String destPath, int bufferSize) {
		
		return nioCopy(sourcePath, destPath, ByteBuffer.allocateDirect(bufferSize));
	}
	
	private static boolean nioCopy(String sourcePath, String destPath, ByteBuffer bytebuffer) {
		
		File source = null;
		
		File dest = null;
		
		FileInputStream fis = null;
		
		FileOutputStream fos = null;
		
		FileChannel sourceCh = null;
		
		FileChannel destCh = null;
		
		try {
			source = new File(sourcePath);
			
			dest = new File(destPath);
			
			if (!dest.exists()) {
				
				dest.createNewFile();
				
			}
			
			fis = new FileInputStream(source);
			
			fos = new FileOutputStream(dest);
			
			sourceCh = fis.getChannel();
			
			destCh = fos.getChannel();
			
			while ((sourceCh.read(bytebuffer)) > 0) {
				
				bytebuffer.flip();
				
				destCh.write(bytebuffer);
				
				bytebuffer.clear();
				
			}
			
			return true;
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			if (sourceCh != null) {
				try {
					
					sourceCh.close();
					
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
			}
			
			if (destCh != null) {
				try {
					
					destCh.close();
					
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
				
			}
			
			if (fis != null) {
				
				try {
					
					fis.close();
					
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
				
			}
			
			if (fos != null) {
				
				try {
					
					fos.close();
					
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
				
			}
			
		}
		
		return false;
	}
	
}
