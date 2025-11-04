package com.utils;

import java.io.*;

/**
* 类说明 : 
*/

public class FileUtil {
	public static byte[] FileToByte(File file) throws IOException {
		// 检查文件是否存在且不是目录
		if (!file.exists()) {
			throw new FileNotFoundException("文件不存在: " + file.getAbsolutePath());
		}
		if (file.isDirectory()) {
			throw new IOException("指定路径是目录而非文件: " + file.getAbsolutePath());
		}

		// 将数据转为流
		try (InputStream content = new FileInputStream(file)) {
			ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
			byte[] buff = new byte[100];
			int rc = 0;
			while ((rc = content.read(buff, 0, 100)) > 0) {
				swapStream.write(buff, 0, rc);
			}
			// 获得二进制数组
			return swapStream.toByteArray();
		}
	}
}
