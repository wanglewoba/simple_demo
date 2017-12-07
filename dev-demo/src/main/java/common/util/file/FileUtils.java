package common.util.file;

import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @Title: FileUtils.java
 * @Description:文件工具类
 */
public class FileUtils {
	private static String FILE_SEPARATER = System.getProperty("file.separator");

	/**
	 * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
	 * 
	 * @param fileName
	 *            文件的名
	 */
	public static void readFileByBytes(String fileName) {
		File file = new File(fileName);
		InputStream in = null;
		try {
			System.out.println("以字节为单位读取文件内容，一次读一个字节：");
			// 一次读一个字节
			in = new FileInputStream(file);
			int tempbyte;
			while ((tempbyte = in.read()) != -1) {
				System.out.write(tempbyte);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		try {
			System.out.println("以字节为单位读取文件内容，一次读多个字节：");
			// 一次读多个字节
			byte[] tempbytes = new byte[100];
			int byteread = 0;
			in = new FileInputStream(fileName);
			FileUtils.showAvailableBytes(in);
			// 读入多个字节到字节数组中，byteread为一次读入的字节数
			while ((byteread = in.read(tempbytes)) != -1) {
				System.out.write(tempbytes, 0, byteread);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	/**
	 * 以字符为单位读取文件，常用于读文本，数字等类型的文件
	 * 
	 * @param fileName
	 *            文件名
	 */
	public static void readFileByChars(String fileName) {
		File file = new File(fileName);
		Reader reader = null;
		try {
			System.out.println("以字符为单位读取文件内容，一次读一个字节：");
			// 一次读一个字符
			reader = new InputStreamReader(new FileInputStream(file));
			int tempchar;
			while ((tempchar = reader.read()) != -1) {
				// 对于windows下，rn这两个字符在一起时，表示一个换行。
				// 但如果这两个字符分开显示时，会换两次行。
				// 因此，屏蔽掉r，或者屏蔽n。否则，将会多出很多空行。
				if (((char) tempchar) != 'r') {
					System.out.print((char) tempchar);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println("以字符为单位读取文件内容，一次读多个字节：");
			// 一次读多个字符
			char[] tempchars = new char[30];
			int charread = 0;
			reader = new InputStreamReader(new FileInputStream(fileName));
			// 读入多个字符到字符数组中，charread为一次读取字符数
			while ((charread = reader.read(tempchars)) != -1) {
				// 同样屏蔽掉r不显示
				if ((charread == tempchars.length)
						&& (tempchars[tempchars.length - 1] != 'r')) {
					System.out.print(tempchars);
				} else {
					for (int i = 0; i < charread; i++) {
						if (tempchars[i] == 'r') {
							continue;
						} else {
							System.out.print(tempchars[i]);
						}
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	/**
	 * 以行为单位读取文件，常用于读面向行的格式化文件
	 * 
	 * @param fileName
	 *            文件名
	 */
	public static void readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				System.out.println("line " + line + ": " + tempString);
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	/**
	 * 随机读取文件内容
	 * 
	 * @param fileName
	 *            文件名
	 */
	public static void readFileByRandomAccess(String fileName) {
		RandomAccessFile randomFile = null;
		try {
			System.out.println("随机读取一段文件内容：");
			// 打开一个随机访问文件流，按只读方式
			randomFile = new RandomAccessFile(fileName, "r");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 读文件的起始位置
			int beginIndex = (fileLength > 4) ? 4 : 0;
			// 将读文件的开始位置移到beginIndex位置。
			randomFile.seek(beginIndex);
			byte[] bytes = new byte[10];
			int byteread = 0;
			// 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
			// 将一次读取的字节数赋给byteread
			while ((byteread = randomFile.read(bytes)) != -1) {
				System.out.write(bytes, 0, byteread);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (randomFile != null) {
				try {
					randomFile.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	/**
	 * 显示输入流中还剩的字节数
	 * 
	 * @param in
	 */
	private static void showAvailableBytes(InputStream in) {
		try {
			System.out.println("当前字节输入流中的字节数为:" + in.available());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * A方法追加文件：使用RandomAccessFile
	 * 
	 * @param fileName
	 *            文件名
	 * @param content
	 *            追加的内容
	 */
	public static void appendMethodA(String fileName, String content) {
		try {
			// 打开一个随机访问文件流，按读写方式
			RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 将写文件指针移到文件尾。
			randomFile.seek(fileLength);
			randomFile.writeBytes(content);
			randomFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * B方法追加文件：使用FileWriter
	 * 
	 * @param fileName
	 * @param content
	 */
	public static void appendMethodB(String fileName, String content) {
		FileWriter writer = null;
		try {
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			writer = new FileWriter(fileName, true);
			writer.write(content + "\r\n"); // 加入换行
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	



	public static String trimExtension(String path) {
		File file = new File(path);
		String fileName = file.getName();
		if ((fileName != null) && (fileName.length() > 0)) {
			int i = fileName.lastIndexOf('.');
			if ((i > -1) && (i < (fileName.length()))) {
				fileName = fileName.substring(0, i);
			}
		}
		return fileName;
	}

	public static String trimExt(String fileName) {
		if ((fileName != null) && (fileName.length() > 0)) {
			int i = fileName.lastIndexOf('.');
			if ((i > -1) && (i < (fileName.length()))) {
				fileName = fileName.substring(0, i);
			}
		}
		return fileName;
	}

	/**
	 * 删除文件
	 * 
	 * @param delFilePath
	 * @return
	 */
	public static boolean deleteFile(String delFilePath) {
		boolean flag = false;
		File file = new File(delFilePath);
		if (file.exists()) {
			flag = file.delete();
		}
		return flag;
	}

	/**
	 * 根据文件名称构造BufferedWriter对象
	 * 
	 * @param path
	 *            文件路径
	 * @param fileName
	 *            文件名称
	 * @return
	 * @throws IOException
	 * @author lijunshi
	 */
	public static BufferedWriter createBufferedWriter(String path,
                                                      String fileName) throws IOException {
		if (!path.endsWith(FILE_SEPARATER)) {
			path = path + FILE_SEPARATER;
		}
		// 检查该路径是否存在
		File file = new File(path);
		if (!file.mkdirs()) {
			file.mkdir();
		}
		String fullFilePath = path + fileName;
		file = new File(fullFilePath);

		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		return bw;
	}

	/**
	 * 根据文件路径，文件名称判断该文件是否存在
	 * 
	 * @param filePath
	 * @param fileName
	 * @return true:文件存在，false:文件不存在
	 */
	public static boolean checkFileExist(String filePath, String fileName) {
		boolean existFlag = true;
		if (!filePath.endsWith(FILE_SEPARATER)) {
			filePath += FILE_SEPARATER;
		}
		String fullFileName = filePath + fileName;
		File file = new File(fullFileName);
		if (!file.isFile()) {
			existFlag = false;
		}
		if (!file.exists()) {
			existFlag = false;
		}
		if (file.isDirectory()) {
			existFlag = false;
		}

		return existFlag;
	}

	/**
	 * 
	 * @param rootPath
	 * @param cruentDate
	 * @return
	 */
	public static String createFileDirectory(String rootPath, String cruentDate) {
		String fullFilePath = null;
		if (!rootPath.endsWith(FILE_SEPARATER)) {
			rootPath += FILE_SEPARATER;
		}
		fullFilePath = rootPath + cruentDate;
		File file = new File(fullFilePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		String newFilePath = file.getPath();
		if (!newFilePath.endsWith(FILE_SEPARATER)) {
			newFilePath += FILE_SEPARATER;
		}
		return newFilePath;
	}

	/**
	 * 
	 * @param bw
	 * @param content
	 * @throws IOException
	 * @author lijunshi
	 */
	public static void writeContentToFile(BufferedWriter bw, String content)
			throws IOException {
		bw.write(content);
		bw.newLine();
		bw.flush();
	}

	public static void close(BufferedWriter bw) {
		if (null != bw) {
			try {
				bw.close();
			} catch (IOException e) {
				System.out.println("***close BufferedWriter failure : " + e);
			}
		}
	}

	public static void main(String[] args) {
		/*String fileName = "d:/newTemp.txt";
		String content = "new append!";*/

		// 按方法A追加文件
		// AppendToFile.appendMethodA(fileName, content);
		// AppendToFile.appendMethodA(fileName, "append end. n");
		// 显示文件内容
		// ReadFromFile.readFileByLines(fileName);
		// 按方法B追加文件
		// AppendToFile.appendMethodB(fileName, content);
		// AppendToFile.appendMethodB(fileName, "append end. n");
		// 显示文件内容
		// ReadFromFile.readFileByLines(fileName);
		System.out.println(FileUtils.createFileDirectory(
				"E:\\opt\\fundpay\\tempfile", "20140714"));
	}
}
