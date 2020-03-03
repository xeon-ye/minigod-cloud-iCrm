package com.minigod.common.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DELSVN {
	public static void main(String[] args) {
		delSVN("E:/workspace/nd_server");
	}

	public static final void delSVN(String baseDir) {
		File file = new File(baseDir);
		if (!file.exists()) {
			System.out.println("path handler.");
			return;
		}
		List<File> list = new ArrayList<File>();
		getFiles(file, list);
		for (int i = 0; i < list.size(); i++) {
			File f = list.get(i);
			if (f.getAbsolutePath().contains(".svn")) {
				System.out.println((f.delete() ? "delete success. ["
						: "delete failure. [") + f.getAbsolutePath() + "]");
			}
		}
	}

	public static void getFiles(File file, List<File> res) {
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				getFiles(f, res);
			}
			res.add(f);
		}
	}
}
