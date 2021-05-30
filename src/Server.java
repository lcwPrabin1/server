
/*MySQl database comes with software called workbench that you can use to
 perform database operations.So the workbench  is the client, and it connects to the MySQL database server
on the local host
*/

/*
Local web development
It's possible to run an apache IIS web server on your computer, and connect it to
using a browser on that same computer.
 */
/*
TCP and UDP
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
Each application needs data from the network is assigned a port, this includes clients connecting to a server that's on
the same machine(usually called host).
And when the data arrives, the port number is used  to route the data for the specific application that's waiting for it.
 */
/*
So every host connected to the internet  has an unique IP address, including yours.
 */
/*
IPv6 vs IPv4(Internet Protocol Version)
IPv4
-IPv4 uses a 32-bit address scheme that allows for over 4 billion unique addresses.
-Each devices that connected with internet have unique IP address.

IPv6
-4 billion IP addresses weren't enough, and so IPv6 was born.
-It uses a 128-bit address scheme
-IPv6 addresses are written in hexadecimal and separated by colons.(in case of Ipv4, it was written using 4 integers
 */
//java.net package consists of two sets of API(i.e.low level API and high level API)
public class Server{
    public static void main(String[] args){
        //let's start by creating by server socket
        try(ServerSocket sS = new ServerSocket(9916)){ //here port number is 9916 you can put port as your wish between 0 and 65,535

            //now the time to read data from client

            while(true){
                new Echoer(sS.accept()).start();


//                Socket socket = sS.accept();//accept method that connects to server
//                System.out.println("Client connected+");
//                //every client can connect to server using same port through it's own socket
//            /*
//            server uses i/o stream to send data to the client and receive data from the client
//            socket.getInputStream() and socket.getOutputStream methods will return the input and output strings associated with the server socket instance
//             */
//                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                PrintWriter output = new PrintWriter(socket.getOutputStream(),true);//if you don't write true then you'll have to go with the flush method after every string to the right to ensure the data is actually sent
//                String echoString = input.readLine();//BufferedReader.readline()
//                try{
//                    Thread.sleep(1000);
//                }catch (InterruptedException e){
//                    System.out.println(e.getMessage());
//                }
//                if(echoString .equals( "exit")){
//                    break;
//                }
//                output.println("Echo from server: "+echoString);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}