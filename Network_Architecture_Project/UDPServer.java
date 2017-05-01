import java.io.*; 
import java.net.*;
import java.io.BufferedWriter;
import java.io.File; 
import java.io.FileWriter;
  
class UDPServer { 
  public static void main(String args[]) throws Exception 
    { 
   
      byte[] receiveData = new byte[1024]; 
      byte[] sendData  = new byte[1024]; 
		
	  //UDP Socket
	  DatagramSocket serverSocket = new DatagramSocket(33667);
	  
	  System.out.println("--------------------------------------");
	  System.out.println("*********** Server Running ***********");
	  System.out.println("--------------------------------------");
	  
	  try{
		while(true) 
        { 
  
          DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
          serverSocket.receive(receivePacket); 
          String sentence = new String(receivePacket.getData()); 
          
		  String appendedSentence = sentence + "**This is an added line from a server";
		  System.out.println(appendedSentence);
		  System.out.println("-----------------------------------------------------------");
		  System.out.println("*** Note: Added last line in server and Saved in server ***");
		  System.out.println("-----------------------------------------------------------");
		  
		  //Writing to local file
		  File localFile=new File("serverLocalFile.txt");
		  FileWriter fw = new FileWriter( localFile.getAbsoluteFile( ) );
	      BufferedWriter bw = new BufferedWriter( fw );
	      bw.write( appendedSentence );
		  bw.close();

          sendData = appendedSentence.getBytes();
		  InetAddress IPAddress = receivePacket.getAddress(); 
          int port = receivePacket.getPort();
  
          DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,port); 
  
          serverSocket.send(sendPacket); 
		  serverSocket.close();
        } 
	  }
	  catch(Exception e){
			System.out.println("*********** Server Closed ***********");
			System.out.println("--------------------------------------");
		}
 
    } 
}  
