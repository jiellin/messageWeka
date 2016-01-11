package init;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.lang.System;

import org.omg.Messaging.SyncScopeHelper;

import data.Message;
import writeAndRead.ReadTxt;
import writeAndRead.WriteLine;

public class initMessageList {
	private ArrayList<Message> messages = new ArrayList<Message>();
	Message message = new Message();

	public initMessageList(String contentFile, String typeFile) throws IOException {
		
		ReadTxt readTxt = new ReadTxt(contentFile);
		BufferedReader lineReader = readTxt.getRead();

		ReadTxt readTxtType = new ReadTxt(typeFile);
		BufferedReader lineReaderType = readTxtType.getRead();
		String str = null;
		int id = 0;
		String isOk = null;

		//80W
		while ((str = lineReader.readLine()) != null) {
			id++;
			isOk = lineReaderType.readLine();
			messages.add(message.fillMessage(str, isOk));
		}
		System.out.println("Init the ArrayList messages over!");
		lineReader.close();
		lineReaderType.close();
	}

	public ArrayList<Message> getMessages() {
		return this.messages;
	}
	
	public void printMessageList(String file) throws UnsupportedEncodingException{
		WriteLine writeLine = new WriteLine(file);
		for (Message message : messages) {
			writeLine.appendLine(message.getContent() + "\t" + message.getIsOK());
		}
		writeLine.closeWrite();
	}

}
