import java.io.*;
import java.net.Socket;

//Why Echoer class ?:multiple clients can interact with single server
public class Echoer extends Thread{
    private Socket socket;

    public Echoer(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);

            while(true){
                String echoString = input.readLine();
                System.out.println("Received client input: "+echoString);
                if(echoString.equals("exit") ){
                    break;
                }
                try{
                    Thread.sleep(15000);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
                   output.println(echoString);
            }

        }catch (IOException e){
            System.out.println("Oops: "+e.getMessage());
        }finally {
            try {
                socket.close();
            }catch (IOException e){

            }
        }
    }
}
/*
we're going do this time is kick off a new thread for the client, and then call the accept method again.
So each client thread will be responsible for creating the i/o streams, listening for requests on the client,
 and then responding to those events.
 */