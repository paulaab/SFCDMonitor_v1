package de.vodafone.innogarage.sfcdmonitoring;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by paulabohorquez on 5/31/17.
 */
public class IncomingMessages extends Thread {
    private Socket clientSocket;
    private String name;
    private InetAddress clientIP;
    private List<JSONObject> incomingData;
    private boolean close, online;

    public IncomingMessages (Socket clientSocket) {
        name  = clientSocket.getInetAddress().getHostName();
        clientIP = clientSocket.getInetAddress();
        this.clientSocket = clientSocket;
        incomingData = new CopyOnWriteArrayList<JSONObject>();
        close = false;
        online = false;
    }

    public void run(){

        System.out.print("Accepting requests...");


        try {
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String inmsg = null;
            JSONObject jObj = null;

            while (!close) {
                try {
                    char[] b = new char[1024];
                    int count = bufferedReader.read(b, 0, 1024);
                    inmsg = new String(b, 0, count);
                    inmsg = inmsg.substring(8);
                    System.out.println("Incomming message stream received:  " + inmsg);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //Try to save incoming string in a JSON Object an then add this object to incomingData list
                if (inmsg != null) {
                    try {
                        jObj = new JSONObject(inmsg);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("InputStreamThread: ", "Could not save Json Object with incoming stream");
                    }
                    incomingData.add(jObj);
                    Log.e("Incoming Message: ", clientSocket.getInetAddress() + " Message received: " + jObj.toString() + " => Placed in incomingData, parsed as JSON");
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        catch (IOException e){
            e.printStackTrace();
            return;
        }
/*
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("Closing inputStream error");
        }*/
    }

    public String getClientName() {
        return name;
    }
    public String getClientIP(){return clientIP.toString();}
    public List<JSONObject> getIncomingData(){return incomingData;}





}

