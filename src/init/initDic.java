package init;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import writeAndRead.ReadTxt;
import writeAndRead.WriteLine;

public class initDic {
	private Map<String, Integer> mapDic = new HashMap<String, Integer>();
	private int lineNum = 0;

	public Map<String, Integer> getMapDic() {
		return mapDic;
	}

	public initDic(Map hashMap, int k) {

//		BufferedReader bufferedReader = null;
//		String lineTxt = null;

//		ReadTxt read = new ReadTxt("test\\Dictionary.txt");
//		bufferedReader = read.getRead();

		Set set = hashMap.keySet();
		Iterator it = set.iterator();

		while (it.hasNext()) {
			Object object = it.next();
			if (Integer.parseInt(String.valueOf(hashMap.get(object))) >= k) {
				mapDic.put(object.toString(), lineNum++);
			}
		}

		// while ((lineTxt = bufferedReader.readLine()) != null) {
		// mapDic.put(lineTxt, lineNum++);
		// }
		// bufferedReader.close();
		// read.closeRead();

		System.out.println("Read dictionary and init the dicMap over!");
	}

	// ≤‚ ‘¥ µ‰ ‰≥ˆ
	public void printHashMap(String file) {
		Set set = mapDic.keySet();
		Iterator it = set.iterator();
		System.out.println("lineNum: " + lineNum);
		try {
			WriteLine writer2 = new WriteLine(file);
			while (it.hasNext()) {
				Object object = it.next();
				writer2.appendLine(mapDic.get(object) + "\t" + object.toString());
//				writer2.appendLine(object.toString());
			}
			writer2.closeWrite();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
