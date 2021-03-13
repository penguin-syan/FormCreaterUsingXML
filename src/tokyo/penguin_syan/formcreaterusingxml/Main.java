/*
 *=============================================================
 * Project Name  : FormCreaterUsingXML
 * File Name     : Main.java
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

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * プログラム実行時に動作するMainクラス
 *
 * @author YutoMitsuta
 * @version 1.0
 */
public class Main {
	public static String workspace = ".\\workspaces\\";

	public static void main(String[] args) throws Exception{
		//ワークスペースとXMLファイルのパスを指定
//		String workspace = ".\\workspaces\\";
		String xml = ".\\sampleXML\\sample.xml";

		//画像等バイナリファイル用ディレクトリを作成
		new File(workspace + "images").mkdir();
		new File(workspace + "movies").mkdir();
		new File(workspace + "sounds").mkdir();

		//XMLファイルの読み込み
		SAXParserFactory spfactory = SAXParserFactory.newInstance();
		SAXParser parser = spfactory.newSAXParser();
		parser.parse(new File(xml), new XML());
	}

}