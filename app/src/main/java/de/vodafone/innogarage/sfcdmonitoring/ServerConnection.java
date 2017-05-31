package de.vodafone.innogarage.sfcdmonitoring;

import android.util.Log;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * Created by paulabohorquez on 5/31/17.
 */
public class ServerConnection {



    private ServerSocket serverSocket = null;
    private Socket client = null;
    private List<IncomingMessages> connections;


    public ServerConnection () {

        //Create the server socket
        try {
            serverSocket = new ServerSocket(MainActivity.PORT);
        } catch (IOException e1) {
            e1.printStackTrace();
            System.out.println("Could not create the socket on port: " + MainActivity.PORT);
        }

        new ServerConnectionListener().start();


    }

    private class ServerConnectionListener extends Thread{
        public void run (){

            //Start listening for client connections and launch a processing thread for each one found.
            while (true) {
                try {
                    System.out.print("Accepting requests1...");

                    serverSocket.accept();

                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("ERROR: Could not start listening requests on port " + MainActivity.PORT);
                }

                connections.add(new IncomingMessages(client));
                Log.e ("ServerConnection ","ConnectionListener: New SFCD added. IP= " + client.getInetAddress().toString());
                new IncomingMessages(client).start();
            }
        }

    }

    public List<IncomingMessages> getConnections(){
        return connections;
    }


}