package common.util.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 文件读取器
* @Description 
 */
public class FileReader {
	
	protected String path;
	protected String fileName;
	protected String charset;
	protected BufferedReader br;
	protected InputStreamReader isr;
	protected FileInputStream fis;
	protected File file;

	public FileReader(String path, String fileName, String charset) throws Exception {
		this.path = path;
		this.fileName = fileName;
		this.charset=charset;
		this.init();
	}
	/**
	 * 初始化实体
	 * @throws Exception
	 */
	public void init() throws Exception {
		//构造BufferedReader
		this.file = new File(this.path, this.fileName);
		this.fis = new FileInputStream(this.file);
		if(this.charset==null){
			this.isr = new InputStreamReader(this.fis);
		}else{
			this.isr = new InputStreamReader(this.fis, this.charset);
		}
		
		this.br = new BufferedReader(this.isr);

	}
	/**
	 * 读取文件中的一行
	 * @return 一行内容
	 * @throws Exception
	 */
	public String readLine() throws Exception {
		return br.readLine();
	}
	/**
	 * 销毁资源
	 * @throws Exception
	 */
	public void destroy() throws Exception {
		if (this.br != null) {
			this.br.close();
		}
		if (this.isr != null) {
			this.isr.close();
		}
		if (this.fis != null) {
			this.fis.close();
		}
	}
	/**
	 * 删除读取的文件
	 * @return 删除是否成功
	 */
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
}
