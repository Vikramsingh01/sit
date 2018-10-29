package com.meganexus.SIT_AutomationTesting.utility;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class CheckNdeliusConnectivity {
	public static boolean pingHost() {
		
	    try {
	    	Socket socket = new Socket();
	    	String host ="172.16.23.40";
	    	int port = 7001;
	        socket.connect(new InetSocketAddress(host,port), 10);
	        return true;
	    } catch (IOException e) {
	        return false; // Either timeout or unreachable or failed DNS lookup.
	    }
	}
}
