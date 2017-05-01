import java.io.*; 
import java.net.*; 

class TCPServer { 

  public static void main(String argv[]) throws Exception 
    { 
      String clientMessage; 
      String serverResponseMessage; 

      

		try{
			//Creating server socket to LISTEN to client
			ServerSocket socket_object = new ServerSocket(33667);
			while(true) { 
			
			//Accept incomming listening socket
			Socket connectionSocket = socket_object.accept(); 

			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream  outToClient = new DataOutputStream(connectionSocket.getOutputStream()); 
			System.out.println("--------------------------------------");
			System.out.println("*********** Server Running ***********");
			System.out.println("--------------------------------------");
		   
		   
			   while(true){
					clientMessage = inFromClient.readLine();
				
					  if(clientMessage.equals("Hello")){
						//Respone message for Welcome message
						System.out.println("Welcome Message from client: " + clientMessage);
						System.out.println("--------------------------------------");
						serverResponseMessage = "Hello from server-Barath"+ '\n';
						outToClient.writeBytes(serverResponseMessage);
				   }else if(clientMessage.equals("Exit")){
					    //Respone message for End message
						System.out.println("End Message from client: " + clientMessage);
						System.out.println("--------------------------------------");
						serverResponseMessage = "Bye from server-Barath"+ '\n';
						outToClient.writeBytes(serverResponseMessage);
						socket_object.close();
						break;
				   }else {
					   //Respone message for general chat message
					   System.out.println("Message from client: " + clientMessage);
					   System.out.println("Note:Sending Capitalized reponse back");
					   System.out.println("--------------------------------------");
					   serverResponseMessage = clientMessage.toUpperCase() + '\n';
					   outToClient.writeBytes(serverResponseMessage);
				   } 
				}
			} 
		}
		catch(Exception e){
			System.out.println("*********** Server Closed ***********");
			System.out.println("--------------------------------------");
		}
  
  
    } 
} 
 
