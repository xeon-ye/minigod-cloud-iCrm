package com.sunline.modules.dbs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import cn.hutool.core.date.DateUtil;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SFTPUtils {
	private static final Logger logger = Logger.getLogger(SFTPUtils.class);
	private static Session session = null;
	public static ChannelSftp channel = null;
	private static int ftpPort = 22;

	public static ChannelSftp getConnect(String ftpHost,String port,String ftpUserName,String priKeyBasePath){
	        
	        if(port != null && !port.equals("")){
	            ftpPort = Integer.parseInt(port);
	        }
	        JSch jsch = new JSch();
	        try{
	            jsch.addIdentity(priKeyBasePath);
	            session = jsch.getSession(ftpUserName, ftpHost, ftpPort);
	            logger.debug("session created.");
	            session.setTimeout(60000); 
	            session.setConfig("StrictHostKeyChecking", "no");
	            session.setConfig("UseDNS", "no");
	            session.connect(); // 经由过程Session建树链接
	            logger.debug("Opening SFTP Channel.");
	            channel = (ChannelSftp) session.openChannel("sftp"); // 打开SFTP通道
	            channel.connect(); // 建立SFTP通道的连接
	        }catch (JSchException e) {
	            logger.error("sftp getConnect error : "+e);
	        }
	        return channel;
	    }

	    public static void closeChannel() throws Exception {
	        try {
	            if (channel != null) {
	                channel.disconnect();
	            }
	            if (session != null) {
	                session.disconnect();
	            }
	        } catch (Exception e) {
	            logger.error("close sftp error", e);
	            throw new Exception( "close ftp error.");
	        }
	    }

	public static void uploadFile(String localFile, String directory) throws Exception{
	        InputStream input = null;
	        try {
	        	File file = new File(localFile);
	            input = new FileInputStream(file);
	            // 改变当前路径到指定路径
	            channel.cd(directory);
	            channel.put(input, file.getName());
	        } catch (Exception e) {
	            logger.error("Upload file error", e);
	            throw new Exception( "Upload file error.",e);
	        } finally {
	            if (input != null) {
	                try {
	                    input.close();
	                } catch (IOException e) {
	                    throw new Exception("Close stream error.");
	                }
	            }
	        	SFTPUtils.closeChannel();
	        }
	    }

	public static void downloadFile(String directory, String localFile) throws Exception {
	        OutputStream output = null;
	        File file = null;
	        try {
	            file = new File(localFile);
	            File parent = file.getParentFile();
				if (parent != null && !parent.exists()) {
					parent.mkdirs();
				}
				if (!checkFileExist(localFile)) {
		            file.createNewFile();
		        }
	            output = new FileOutputStream(file);
//	            channel.cd(directory);
	            channel.get(file.getName(), output);
	        } catch (Exception e) {
	            logger.error("Download file error", e);
	            throw new Exception("Download file error.",e);
	        } finally {
	            if (output != null) {
	                try {
	                    output.close();
	                } catch (IOException e) {
	                    throw new Exception("Close stream error.");
	                }
	            }
	            
	        }
	    }
	    private static boolean checkFileExist(String localPath) {
	        File file = new File(localPath);
	        return file.exists();
	    }
	    
	    @SuppressWarnings("rawtypes")
		public static List<String> listFiles(String directory) throws Exception {
	    	List<String> fileNameList = new ArrayList<String>(); 
	        try {
	        	Vector vector = channel.ls(directory);
	            Iterator it = vector.iterator(); 
	            while(it.hasNext()) { 

	                String fileName = ((LsEntry)it.next()).getFilename(); 
	                if(".".equals(fileName) || "..".equals(fileName)){ 
	                    continue; 
	                 } 
	                fileNameList.add(fileName); 
	            } 
	        } catch (SftpException e) {
	            logger.error("List file error", e);
	            throw new Exception("list file error.",e);
	        } finally{
	        	
	        }
	        return fileNameList;
	    }
	    
	    public static void deleteAllFile(String directory,List <String> files) throws Exception{
	        try {
//	            List <String> files=listFiles(directory);//返回目录下所有文件名称
//	            channel.cd(directory); //进入目录

	            for (String deleteFile : files) {
	            	channel.rm(deleteFile);//循环一次删除目录下的文件
	            }
	        } catch (Exception e) {
	            throw new Exception(e.getMessage(),e); 
	        } finally {
	        	SFTPUtils.closeChannel();
	        }

	    }
	    
	    public static void main(String[] args) throws Exception {
//	    	System.out.println(listFiles("/Outbox/").size());
//	    	uploadFile("E:\\workspace\\trunk\\sunline\\sunline-web-oms\\src\\main\\resources\\pgp\\DSG_VAHKL.20180905_1550.CSV.pgp", 
//	    			"/Outbox/");
	    	
//	    	downloadFile("/Outbox/", "C:\\Users\\JOY\\Desktop\\DSG_VAHKL.20180905_1550.CSV.pgp");
//	    	Date now = new Date();
//	    	String filePath = "/data/dbs/";
//	    	String filename = "DSG_VAHKL."+DateUtil.format(now, "yyyyMMdd_HHmm")+".CSV";
//			String folderName = DateUtil.format(now, "yyyy-MM-dd")+"/";
//			String localfile = filePath  + folderName  + filename;
//			String pgpfile = localfile + ".pgp";
//			System.out.println(filePath);
//			System.out.println(filename);
//			System.out.println(folderName);
//			System.out.println(localfile);
//			System.out.println(pgpfile);
	    	SFTPUtils.getConnect("dsg2.dbs.com", "9122", "HK9FPS", "C:\\Users\\JOY\\Desktop\\log\\test\\dp\\id_rsa2");
	    	List<String> listfiles = SFTPUtils.listFiles("Inbox");
		}
}
