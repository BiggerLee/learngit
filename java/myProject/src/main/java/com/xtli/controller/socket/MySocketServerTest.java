package com.xtli.controller.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class MySocketServerTest {
	public static void main(String[] args) throws InterruptedException {
		try {
			InetAddress local = InetAddress.getByAddress(
					new byte[]{127,0,0,1});
			SocketAddress add = new InetSocketAddress(local,8111);
			while (true) {
				try(ServerSocket serverSk = new ServerSocket();)
				{
					serverSk.bind(add);
					Socket sk = serverSk.accept();
					BufferedReader bsIn = new BufferedReader(new InputStreamReader(sk.getInputStream()));
					PrintStream psOut = new PrintStream(sk.getOutputStream());
					System.out.println(bsIn.readLine());
					psOut.println("这是服务器端发过去的请求");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
