/*
 *=============================================================
 * Project Name  : FormCreaterUsingXML
 * File Name     : FileWright.java
 * Encoding      : UTF-8
 *
 * Copyright (c) 2021 penguin_syan. All rights reserved.
 *
 * Released under the MIT license
 * see https://opensource.org/licenses/MIT
 *=============================================================
 */

package tokyo.penguin_syan.formcreaterusingxml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput {

	public static void newIndex(){
		FileWriter fw = null;
		try {
			fw = new FileWriter(new File(Main.workspace + "index.php"));
			fw.write("<?php\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void addIndex(String text){
		FileWriter fw = null;
		try {
			fw = new FileWriter(new File(Main.workspace + "index.php"), true);
			fw.write(text);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * アンケート用の新しいページ（phpファイル）を作成
	 * @param pageName ページ名
	 */
	public static void newPage(String pageName) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(new File(Main.workspace + pageName + ".php"));
			fw.write("<!DOCTYPE html>\n\n");
			fw.write("<head>\n\t<meta charset=\"UTF-8\">\n</head>\n\n");
			fw.write("<body>\n<form method=\"post\">\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * アンケート用ページ（phpファイル）に指定のテキストを追加
	 * @param pageName ページ名（ファイル名）
	 * @param text 追加するテキスト
	 */
	public static void addPage(String text) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(new File(Main.workspace + XML.pageName + ".php"), true);
			fw.write(text);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
