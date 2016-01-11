package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import writeAndRead.ReadTxt;
import writeAndRead.WriteLine;

public class Word_Count {

	private Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<String, Integer>();

	public Word_Count(String sourceFile) throws IOException {
		ReadTxt readTxt = new ReadTxt(sourceFile);
		BufferedReader lineReader = readTxt.getRead();
		String line = "";
		String[] wordList = null;
		while ((line = lineReader.readLine()) != null) {
			wordList = line.split(" ");
			for (int i = 0; i < wordList.length; i++)
				if (!concurrentHashMap.containsKey(wordList[i]))
					concurrentHashMap.put(wordList[i], 1);
				else
					concurrentHashMap.put(wordList[i],
							concurrentHashMap.get(wordList[i]) + 1);
		}

		lineReader.close();
		readTxt.closeRead();
	}

	public Map getDictionMap(){
		return this.concurrentHashMap;
	}
	
	// ²âÊÔ´ÊµäÊä³ö
	public void printHashMap(String file) {
		Set set = concurrentHashMap.keySet();
		Iterator it = set.iterator();

		try {
			// WriteLine writer1 = new WriteLine("test\\dataresult.txt");
			WriteLine writer2 = new WriteLine(file);
			while (it.hasNext()) {
				Object object = it.next();
				 writer2.appendLine(object + ": " + concurrentHashMap.get(object));
//				writer2.appendLine(object.toString());
			}
			// writer1.closeWrite();
			writer2.closeWrite();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
