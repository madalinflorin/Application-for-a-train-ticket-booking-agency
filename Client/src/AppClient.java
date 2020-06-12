
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class AppClient {
	
	private Socket socket            = null; 
    private DataInputStream  input   = null; 
    private DataOutputStream out     = null; 
    private MainView m;
  
    // constructor to put ip address and port 
    public AppClient(String address, int port) 
    { 
        // establish a connection 
        try
        { 
        	socket = new Socket(address, port); 
            System.out.println("Connected"); 
            
         
            m=new MainView();
            ControlerOperatiiCalator c= new ControlerOperatiiCalator(m);
            
            // takes input from terminal 
            input  = new DataInputStream(System.in); 
  
            // sends output to the socket 
            out    = new DataOutputStream(socket.getOutputStream());
            
            
            try
            { 
                out.writeUTF("Client with ip "+ address+" connected"); 
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            } 
        } 
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
        
        
  
        // string to read message from input 
        String line = ""; 
  
        // keep reading until "Over" is input 
        while (!line.equals("Over")) 
        { 
            try
            { 
                line = input.readLine(); 
                out.writeUTF(line); 
                
                
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            } 
        } 
  
        // close the connection 
        try
        { 
            input.close(); 
            out.close(); 
            socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
        

    } 
 
	
	public static void main(String[] args)
	{
		
	 InetAddress localhost = null;
	try {
		localhost = InetAddress.getLocalHost();
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
    
	AppClient client = new AppClient((localhost.getHostAddress()).trim(),5000);
}
}
