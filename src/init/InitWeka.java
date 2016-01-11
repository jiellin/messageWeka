package init;

import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import data.Message;
import writeAndRead.ReadTxt;
import writeAndRead.WriteLine;

public class InitWeka {
	private Map<String, Integer> mapDict = new HashMap<String, Integer>();
	private ArrayList<Message> messages = new ArrayList<Message>();

	public InitWeka(Map<String, Integer> mapDict, ArrayList<Message> messages) {
		this.mapDict = mapDict;
		this.messages = messages;
	}

	public static boolean existsFile(File file) {
		if (!file.exists())
			return false;
		else
			return true;
	}

	public void initArff(String distFile, int count) throws IOException {
		File file = new File(distFile);
		if (file.isFile() && file.exists()) {
			file.delete();
		}

		if (!existsFile(file)) {
			WriteLine writeLine = new WriteLine(distFile);
			writeLine.appendLine("@relation test");
			writeLine.appendLine("");

			for (int i = 0; i < count; i++) {
				writeLine.appendLine("@attribute feature" + i + " real");
			}
			writeLine.appendLine("@attribute class {\"1\",\"0\"}");

			writeLine.appendLine("\n" + "@data");
			
			int num = 0;
			for (Message message : messages) {
				num++;
				System.out.println(num);
				String input = message.getContent();
				String[] token = input.split(" ");
				ArrayList<Integer> wordlist = new ArrayList<>();

				for (String string : token) {
					if (mapDict.get(string) != null) {
						int a = mapDict.get(string);
						if (!wordlist.contains(a)) {
							wordlist.add(a);
						}
					}
				}
				Collections.sort(wordlist);
				writeLine.append("{");
				for (Integer integer : wordlist) {
					writeLine.append(integer + " 1,");
				}
				writeLine.appendLine(mapDict.size() + " \""
						+ getType(message.getIsOK()) + "\"}");

			}
			writeLine.closeWrite();
		}
	}

	private String getType(String str) {
		if (Integer.parseInt(str) == 1) {
			return "1";
		} else {
			return "0";
		}
	}
}
