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
		 * ͳ�ƴ�Ƶ���ɴ�Ƶ�ʵ�
		 * 
		 * @args[0] ԭʼ���ݵ�ַ
		 */
		Word_Count word_count = new Word_Count("data\\100W.utf8");
		Map<String, Integer> hashmap = word_count.getDictionMap();
		int count = hashmap.size();
//		word_count.printHashMap("data\\Dictionary.utf8"); // ���Դ�Ƶ�ʵ�����

		/*
		 * ����˳��ʵ�
		 * 
		 * @args[0] ��Ƶ�ʵ䣬 arge[1] ��Ƶ��Сֵ mapDic ˳���Ƶ�ʵ�
		 */
		initDic initdict = new initDic(hashmap, 5);
		Map<String, Integer> mapDic = new HashMap<String, Integer>();
		mapDic = initdict.getMapDic();
//		initdict.printHashMap("data\\lineMap.utf8"); // ����˳��ʵ�����

		/*
		 * ����MessageList
		 * 
		 * @args[0] ���������ļ�Ŀ¼�� arge[1] ��������ļ�Ŀ¼ messages ����list
		 */
		initMessageList initMess = new initMessageList("data\\80W.utf8",
				"data\\feature.utf8");
		ArrayList<Message> messages = initMess.getMessages();
		initMess.printMessageList("data\\messages.utf8"); // ���Զ���list

		/*
		 * ����MessageList
		 * 
		 * @args[0] �~�䣬 arge[1] ����list
		 * �����ļ�Ŀ¼
		 */
		InitWeka initWeka = new InitWeka(mapDic, messages);
		initWeka.initArff("data\\message_test.arff", count);

	}

}
