package common.util.file;

import java.io.*;

/**
 * 文件写入器
 * @Description
 */
public class FileWriter {
	
	protected String path;
	protected String fileName;
	protected String charset;
	protected BufferedWriter bw;
	protected OutputStreamWriter osw;
	protected FileOutputStream fos;
	protected File file;
	protected long total = 0;

	public FileWriter(String path, String fileName, String charset) throws Exception {
		this.path = path;
		this.fileName = fileName;
		this.charset = charset;
		this.init();
	}
	public FileWriter(String path, String fileName, String charset, boolean isInit) throws Exception {
		this.path = path;
		this.fileName = fileName;
		this.charset = charset;
		this.file = new File(this.path, this.fileName);
		if(isInit){
			this.init();
		}
		
	}
	public void init() throws Exception {
		// 如果path目录不存在，则创建此目录
		File dir = new File(this.path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		this.file = new File(this.path, this.fileName);
		this.fos = new FileOutputStream(this.file,false);
		if (this.charset == null) {
			this.osw = new OutputStreamWriter(this.fos);
		} else {
			this.osw = new OutputStreamWriter(this.fos, this.charset);
		}

		this.bw = new BufferedWriter(this.osw);

	}

	public void writeLine(String line) throws Exception {
		bw.write(line);
		bw.newLine();
		if ((++total) % 5000 == 0) {
			bw.flush();
		}
	}

	/**
	 * 
	 * 重写文件第一行，需要应用确保重写第一行之前，必须执行destroy
	 * @param fristLine
	 * @throws Exception
	 */
	public void reWriteFirstLine(String fristLine) throws Exception {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(this.file, "rw"); // 写文件
			raf.seek(0);
			raf.write(fristLine.getBytes(charset));
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			if (raf != null){
				raf.close();
			}
		}
	}
	
	
	/**
	 * 
	 * 重命名文件
	 * @param filePath  文件路径
	 * @param fileName  文件名
	 * @throws Exception
	 */
	public void renameTo(String filePath, String fileName)throws Exception {
		File newFile = new File(filePath, fileName);
		file.renameTo(newFile);
	}

	public void destroy() throws Exception {
		if (this.bw != null) {
			bw.flush();
			this.bw.close();
		}
		if (this.osw != null) {
			this.osw.close();
		}
		if (this.fos != null) {
			this.fos.close();
		}
		bw = null;
	}

	public boolean delete() {
		return this.file.delete();
	}

	public String getPath() {
		return path;
	}

	public String getFileName() {
		return fileName;
	}

	public File getFile() {
		return file;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}
	
	



	

}
