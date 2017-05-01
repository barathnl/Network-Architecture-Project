import java.io.*; 
import java.io.FileWriter;
import java.net.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner; 
  
class UDPClient { 
    public static void main(String args[]) throws Exception 
    { 
	  byte[] sendData = new byte[1024]; 
      byte[] receiveData = new byte[4096]; 
	  String fileSentence = null;
	  
      DatagramSocket socket_object = new DatagramSocket(); 
      InetAddress IPAddress = InetAddress.getByName("192.1.1.2"); 
    
	  System.out.println("--------------------------------------");
	  System.out.println("**** CLIENT - Text file content: *****");
	  System.out.println("--------------------------------------");
	 	  
		try {
			fileSentence = new Scanner(new File("sampleText.txt")).useDelimiter("\\z").next();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	  System.out.println(fileSentence);
	  sendData = fileSentence.getBytes(); 
	  
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 33667); 
      socket_object.send(sendPacket); 
  
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
      socket_object.receive(receivePacket); 
  
      String modifiedFileSentence = new String(receivePacket.getData()); 
  
	  System.out.println("--------------------------------------");
      System.out.println("**** SERVER - Appended Last Line *****");
	  System.out.println("--------------------------------------");
	  System.out.println(modifiedFileSentence);
	  System.out.println("--------------------------------------");
      socket_object.close(); 
      } 
} 
