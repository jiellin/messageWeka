package main;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import data.Message;
import data.Word_Count;
import init.InitWeka;
import init.initDic;
import init.initMessageList;
import writeAndRead.WriteLine;

public class mainInit {

	public static void main(String[] args) throws IOException {

		/*
		 * 统计词频生成词频词典
		 * 
		 * @args[0] 原始数据地址
		 */
		Word_Count word_count = new Word_Count("data\\100W.utf8");
		Map<String, Integer> hashmap = word_count.getDictionMap();
		int count = hashmap.size();
//		word_count.printHashMap("data\\Dictionary.utf8"); // 测试词频词典生成

		/*
		 * 生成顺序词典
		 * 
		 * @args[0] 词频词典， arge[1] 词频最小值 mapDic 顺序词频词典
		 */
		initDic initdict = new initDic(hashmap, 5);
		Map<String, Integer> mapDic = new HashMap<String, Integer>();
		mapDic = initdict.getMapDic();
//		initdict.printHashMap("data\\lineMap.utf8"); // 测试顺序词典生成

		/*
		 * 生成MessageList
		 * 
		 * @args[0] 短信内容文件目录， arge[1] 短信类别文件目录 messages 短信list
		 */
		initMessageList initMess = new initMessageList("data\\80W.utf8",
				"data\\feature.utf8");
		ArrayList<Message> messages = initMess.getMessages();
		initMess.printMessageList("data\\messages.utf8"); // 测试短信list

		/*
		 * 生成MessageList
		 * 
		 * @args[0] 詞典， arge[1] 短信list
		 * 生成文件目录
		 */
		InitWeka initWeka = new InitWeka(mapDic, messages);
		initWeka.initArff("data\\message_test.arff", count);

	}

}
