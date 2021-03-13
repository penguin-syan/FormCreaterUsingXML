/*
 *=============================================================
 * Project Name  : FormCreaterUsingXML
 * File Name     : XML.java
 * Encoding      : UTF-8
 *
 * Copyright (c) 2021 penguin_syan. All rights reserved.
 *
 * Released under the MIT license
 * see https://opensource.org/licenses/MIT
 *=============================================================
 */

package tokyo.penguin_syan.formcreaterusingxml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * XMLファイルを解析するクラスファイル
 * @author YutoMitsuta
 * @see https://docs.oracle.com/javase/jp/7/api/org/xml/sax/package-summary.html
 */
public class XML extends DefaultHandler{
	//各種グローバル変数を宣言
	private static boolean pageMode = false, text = false;
	static String pageName, q_id;


    //start Document
    public void startDocument() {
    	System.out.println("ドキュメント開始");
		FileOutput.newIndex();
    }


    /**
     * xmlファイル中に要素の開始を示すタグがあると動くメソッド
     * @param uri 謎
     * @param localName 要素名
     * @param qName 要素名
     * @param attributes 属性
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
    	switch(qName) {
    	case "page":
    		pageMode = true;
    		pageName = attributes.getValue(0);
    		FileOutput.newPage(pageName);
    		break;
    	case "title":
    		text = true;
    		FileOutput.addPage("\t<h1>");
    		break;
    	case "description":
    		text = true;
    		FileOutput.addPage("\t<p>");
    		break;
    	case "question":
    		FileOutput.addPage("\t<div>\n");
    		for(int i = 0; i < attributes.getLength(); i++) {
    			if(attributes.getLocalName(i).equals("id"))
    				q_id = attributes.getValue(i);
    		}
    		break;
    	case "Qtext":
    		text = true;
    		FileOutput.addPage("\t\t<h3>");
    		break;
    	case "Qdesc":
    		text = true;
    		FileOutput.addPage("\t\t<p>");
    		break;
    	case "Qans":
    		break;

    	}

    	System.out.println("要素開始:" + qName);
    	for(int i = 0; i < attributes.getLength(); i++) {
    		System.out.println("属性名:" + attributes.getLocalName(i));
    		System.out.println("属性値:" + attributes.getValue(i));
    	}
    }


    //Text
    public void characters(char[] ch, int offset, int length) {
    	if(pageMode) {
    		if(text)
    			FileOutput.addPage(new String(ch, offset, length));
    	}
    }


    //End Element
    public void endElement(String uri, String localName, String qName) {
    	switch(qName) {
    	case "page":
    		pageMode = false;
    		FileOutput.addPage("</form>\n</body>");
    		break;
    	case "title":
    		text = false;
    		FileOutput.addPage("</h1>\n");
    		break;
    	case "description":
    		text = false;
    		FileOutput.addPage("</p>\n");
    		break;
    	case "question":
    		FileOutput.addPage("\t</div>\n");
    		break;
    	case "Qtext":
    		text = false;
    		FileOutput.addPage("</h3>\n");
    		break;
    	case "Qdesc":
    		text = false;
    		FileOutput.addPage("<p>\n");
    		break;
    	}

    	System.out.println("要素終了:" + qName);
    }


    /**
     * xmlファイル終了時の処理
     */
    public void endDocument(){
    	System.out.println("ドキュメント終了");
    }

}
