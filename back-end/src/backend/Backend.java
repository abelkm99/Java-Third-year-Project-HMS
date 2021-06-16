/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

// File Name GreetingServer.java
import java.net.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import javax.naming.spi.DirStateFactory.Result;

import Model.BookRoom;
import Model.Employee;
import Model.Room;
import Model.RoomType;
import backend.Database.DatabaseConn;

import java.io.*;

public class Backend extends Thread {
    public DatabaseConn dbconn = new DatabaseConn();
    private ServerSocket serverSocket;

    public Backend(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();

                InputStream inputStream = server.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                System.out.println("got here");
                try {
                    List<Object> request = (List<Object>) objectInputStream.readObject();
                    System.out.println("Received [" + request.size() + "] messages from: " + server);
                    String command = (String) request.get(0);
                    if (command.equals("registerEmployee")) {
                        String EmployeeUsername = (String) request.get(1);
                        String EmployeePassword = (String) request.get(2);
                        String res = dbconn.registerEmployee(EmployeeUsername, EmployeePassword);

                        List<Object> obj = new ArrayList<>();
                        obj.add(res);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(obj);
                    }

                    // get all the rooms

                    if(command.equals("getRooms")){
                        List<Object> returnMessage = new ArrayList<>();
                        List<Room> allrooms = dbconn.getRooms();
                        returnMessage.add(allrooms);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                    }

                    // if get room types
                    if(command.equals("getRoomTypes")){
                        List<Object> returnMessage = new ArrayList<>();
                        List<RoomType> roomTypes = dbconn.getRoomTypes();
                        returnMessage.add(roomTypes);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                    }
                    // if getBooking
                    if(command.equals("getBooking")){
                        List<Object> returnMessage = new ArrayList<>();
                        List<BookRoom> AllBookings = dbconn.getBooking();
                        returnMessage.add(AllBookings);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                    }
                    // if report
                    if(command.equals("Report")){
                        List<Object> returnMessage = new ArrayList<>();
                        List<Integer> data = dbconn.Report();
                        returnMessage.add(data);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                    }
                    // getInfoInterval
                    if(command.equals("getInfoInterval")){
                        List<Object> returnMessage = new ArrayList<>();

                        Date start = (Date) request.get(1);
                        Date end = (Date) request.get(2);
                        List<BookRoom> IntervalBooking = dbconn.getInfoInterval(start,end);
                        returnMessage.add(IntervalBooking);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                        System.out.println("the command is get interval");

                    }
                    // getEmployees
                    if(command.equals("getEmployees")){
                        List<Object> returnMessage = new ArrayList<>();

                        List<Employee> allEmployees = dbconn.getEmployees();

                        returnMessage.add(allEmployees);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                    }

                    //updateAdmin
                    if(command.equals("updateAdmin")){
                        List<Object> returnMessage = new ArrayList<>();
                        String username = (String) request.get(1);
                        String newpassword = (String) request.get(2);
                        String oldPassword = (String) request.get(3) ;
                        int rs = dbconn.updateAdmin(username,newpassword,oldPassword);

                        returnMessage.add(rs);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                    }
                    // addRoom
                    if(command.equals("addRoom")){
                        List<Object> returnMessage = new ArrayList<>();
                        String RoomNo = (String) request.get(1);
                        int RoomTypeID = (int) request.get(2);
                        String  msg = dbconn.addRoom(RoomNo, RoomTypeID);

                        returnMessage.add(msg);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                    }
                    // deleteEmployee
                    if(command.equals("deleteEmployee")){
                        List<Object> returnMessage = new ArrayList<>();
                        String EmployeeUsername = (String) request.get(1);
                        int  rs = dbconn.deleteEmployee(EmployeeUsername);

                        returnMessage.add(rs);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                    }
                    // getRoomsNotChecked
                    if(command.equals("getRoomsNotChecked")){
                        List<Object> returnMessage = new ArrayList<>();
                        List<Room> rooms = dbconn.getRoomsNotChecked();
                        returnMessage.add(rooms);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                    }
                    // CheckIn
                    if(command.equals("CheckIn")){
                        List<Object> returnMessage = new ArrayList<>();

                        String Fname = (String) request.get(1);
                        String Lname = (String) request.get(2);
                        int Age = (int) request.get(3) ;
                        String PhoneNumber = (String) request.get(4);
                        Date date = (Date) request.get(5);
                        String RoomNo = (String) request.get(6);
                        String msg = dbconn.CheckIn(Fname, Lname, Age, PhoneNumber, date, RoomNo);

                        returnMessage.add(msg);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                    }
                    // CheckOut
                    if(command.equals("CheckOut")){
                        List<Object> returnMessage = new ArrayList<>();
                        BookRoom room =  (BookRoom) request.get(1);
                        String msg = dbconn.CheckOut(room);

                        returnMessage.add(msg);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                    }
                    // getBookedRoom
                    if(command.equals("getBookedRoom")){
                        List<Object> returnMessage = new ArrayList<>();

                        String RoomNo =  (String) request.get(1);
                        Entry<BookRoom, String> result = dbconn.getBookedRoom(RoomNo);

                        returnMessage.add(result);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                    }
                    // updateEmployee
                    if(command.equals("updateEmployee")){
                        List<Object> returnMessage = new ArrayList<>();
                        String username = (String) request.get(1);
                        String newpassword = (String) request.get(2);
                        String oldpassword = (String) request.get(3);
                        int rs = dbconn.updateEmployee(username, newpassword, oldpassword);

                        returnMessage.add(rs);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                    }
                    // getBookedRooms
                    if(command.equals("getBookedRooms")){
                        List<Object> returnMessage = new ArrayList<>();
                        List<BookRoom> AllBookings = dbconn.getBookedRooms();

                        returnMessage.add(AllBookings);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                    }
                    // loginEmployee
                    if(command.equals("loginEmployee")){
                        List<Object> returnMessage = new ArrayList<>();
                        String username = (String) request.get(1);
                        String password = (String) request.get(2);
                        boolean log = dbconn.loginEmployee(username, password);

                        returnMessage.add(log);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                    }
                     // loginAdmin
                     if(command.equals("loginAdmin")){
                        List<Object> returnMessage = new ArrayList<>();
                        String username = (String) request.get(1);
                        String password = (String) request.get(2);
                        boolean log = dbconn.loginAdmin(username, password);

                        returnMessage.add(log);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                    }
                    // checkconnection
                    if(command.equals("checkconnection")){
                        List<Object> returnMessage = new ArrayList<>();
                        String log = "connection with IP and PORT is Working";
                        returnMessage.add(log);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
                        objectOutputStream.writeObject(returnMessage);
                    }

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        int port = 3500;
        try {
            Thread t = new Backend(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
