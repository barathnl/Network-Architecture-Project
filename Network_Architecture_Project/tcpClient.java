import java.io.*; 
import java.net.*; 
class TCPClient { 

    public static void main(String argv[]) throws Exception 
    { 
        String clientMessage; 
        String serverMessage; 
		   
		//Creating Socket to remote server
        Socket socket_object = new Socket("192.1.1.10", 33667); 
		
        DataOutputStream outToServer = new DataOutputStream(socket_object.getOutputStream()); 
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket_object.getInputStream())); 

		System.out.println("----------------------------------------------");
		System.out.println("*************** CHAT Application *************");
		System.out.println("----------------------------------------------");

		 
		while(true){
			System.out.print("CLIENT: ");
			clientMessage = inFromUser.readLine();
			if(clientMessage.equals("Hello")){
				outToServer.writeBytes(clientMessage + '\n');
				serverMessage = inFromServer.readLine(); 
				System.out.println("SERVER: " + serverMessage);
			}else if(clientMessage.equals("Exit")){
				outToServer.writeBytes(clientMessage + '\n');
				serverMessage = inFromServer.readLine(); 
				System.out.println("SERVER: " + serverMessage);
				System.out.println("----------------------------------------------");
				socket_object.close();
				break;
			}else {
				outToServer.writeBytes(clientMessage + '\n');
				serverMessage = inFromServer.readLine(); 
				System.out.println("SERVER: " + serverMessage);
			}
		}
  
                   
    } 
} 
