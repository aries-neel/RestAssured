package com.payme.APITestingFramework.Rough;

import java.net.InetAddress;
import java.net.UnknownHostException;



public class IPAddress {
	
// this will be used after completing exc we need to send mail with this attachment 
	
	public static void main(String[] args) throws UnknownHostException {
		
		System.out.println("http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/APITestingFramework/Extent_20Reports/");

	}

}
// 192.168.0.126
// http://localhost:8080/job/APITestingFramework/Extent_20Reports/
// http://192.168.0.126:8080/job/APITestingFramework/Extent_20Reports/