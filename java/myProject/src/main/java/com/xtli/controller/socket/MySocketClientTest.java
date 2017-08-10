package com.xtli.controller.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MySocketClientTest {
	public static void main(String[] args) {
		try {

			while(true) {
				@SuppressWarnings("resource")
				Socket skClient = new Socket("127.0.0.1",8111);
				BufferedReader brIn = new BufferedReader(new InputStreamReader(skClient.getInputStream()));
				PrintStream ps = new PrintStream(skClient.getOutputStream());
				ps.println("这是客户端发送过去请求");
				System.out.println(brIn.readLine());
				ps.println("这是客户端发送过去请求2");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
