/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientSocket;

import java.net.Socket;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

import Model.BookRoom;
import Model.Employee;
import Model.Room;
import Model.RoomType;

import java.io.*;
import java.net.*;




/**
 *
 * @author Abel
 */
public class Client {
    public String ip;
    public int port;
    public Client(String ip,int port){
        this.ip = ip;
        this.port = port;
    }
    public Client(){
        this.getIpAndPort();
    }

    public void getIpAndPort(){
        try {
                Scanner in = new Scanner(new File("ip.txt"));
                this.ip = in.nextLine();
                this.port = in.nextInt();
        } catch (Exception e) {

        }
    }
    public Socket Connect(){
        Socket client = null;
        try{
            client  = new Socket(this.ip, this.port);
        }catch(Exception e){
            e.printStackTrace();
        }
        return client;
    }

    public void SayHi(){
        try(Socket client = this.Connect()){
            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            
            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            
            System.out.println("Server says " + in.readUTF());
            client.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public String registerEmployee(String username,String password){
        String result = "";
        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("registerEmployee");
            obj.add(username);
            obj.add(password);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> response = (List<Object>) objectInputStream.readObject();
            result = (String) response.get(0);
            System.out.println(result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Room> getRooms() {
        List<Room> rooms = new ArrayList<>();
        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("getRooms");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> res = (List<Object>) objectInputStream.readObject();
            rooms = (List<Room>) res.get(0);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public List<RoomType> getRoomTypes() {
        List<RoomType> roomtypes = new ArrayList<>();
        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("getRoomTypes");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> res = (List<Object>) objectInputStream.readObject();
            roomtypes = (List<RoomType>) res.get(0);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roomtypes;
    }
    public List<BookRoom> getBooking() {
        List<BookRoom> AllBookings = new ArrayList<>();
        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("getBooking");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> res =  (List<Object>) objectInputStream.readObject();
            AllBookings = (List<BookRoom>) res.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AllBookings;
    }
    public List<Integer> Report(){
        List<Integer> data = new ArrayList<>();
        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("Report");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> res = (List<Object>) objectInputStream.readObject();
            data = (List<Integer>) res.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    public List<BookRoom> getInfoInterval(java.util.Date startiDate,java.util.Date endingDate){
        List<BookRoom> IntervalBooking = new ArrayList<>();
        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("getInfoInterval");
            obj.add(startiDate);
            obj.add(endingDate);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> res  =  (List<Object>) objectInputStream.readObject();
            IntervalBooking = (List<BookRoom>) res.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return IntervalBooking;
    }
    public List<Employee> getEmployees(){
        List<Employee> allEmployees = new ArrayList<>();

        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("getEmployees");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> res = (List<Object>) objectInputStream.readObject();
            allEmployees = (List<Employee>) res.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return allEmployees;
    }
    public int updateAdmin(String adminUsername,String adminNewPassword,String adminOldPassword){
        int rs = 0;
        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("updateAdmin");
            obj.add(adminUsername);
            obj.add(adminNewPassword);
            obj.add(adminOldPassword);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> res = (List<Object>) objectInputStream.readObject();
            rs = (int) res.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }
    public String addRoom(String RoomNo, int RoomTypeId) {
        String msg = "";
        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("addRoom");
            obj.add(RoomNo);
            obj.add(RoomTypeId);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> res = (List<Object>) objectInputStream.readObject();
            msg = (String) res.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
    public int deleteEmployee(String EmployeeUsername){
        int rs = 0;
        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("deleteEmployee");
            obj.add(EmployeeUsername);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> res = (List<Object>) objectInputStream.readObject();
            rs = (int) res.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    public List<Room> getRoomsNotChecked() {
        List<Room> rooms = new ArrayList<>();
        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("getRoomsNotChecked");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> res = (List<Object>) objectInputStream.readObject();
            rooms = (List<Room>) res.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }
    public String CheckIn(String Fname, String Lname, int Age, String PhoneNumber, java.util.Date date, String RoomNo) {
        String msg = "";
        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("CheckIn");
            obj.add(Fname);
            obj.add(Lname);
            obj.add(Age);
            obj.add(PhoneNumber);
            obj.add(date);
            obj.add(RoomNo);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> res = (List<Object>) objectInputStream.readObject();
            msg = (String) res.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
    public String CheckOut(BookRoom room){
        String msg = "";
        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("CheckOut");
            obj.add(room);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> res = (List<Object>) objectInputStream.readObject();
            msg = (String) res.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
    public  AbstractMap.Entry<BookRoom, String> getBookedRoom(String RoomNo) {
        BookRoom room = null;
        String msg = "";
        AbstractMap.Entry<BookRoom, String> result =new AbstractMap.SimpleEntry<>(room,msg);

        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("getBookedRoom");
            obj.add(RoomNo);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> res = (List<Object>) objectInputStream.readObject();
            result = (Entry<BookRoom, String>) res.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public int updateEmployee(String username,String newpassword,String oldpassword){
        int rs = 0;
        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("updateEmployee");
            obj.add(username);
            obj.add(newpassword);
            obj.add(oldpassword);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> res = (List<Object>) objectInputStream.readObject();
            rs = (int) res.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    public List<BookRoom> getBookedRooms() {
        List<BookRoom> AllBookings = new ArrayList<>();
        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("getBookedRooms");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> res = (List<Object>) objectInputStream.readObject();
            AllBookings =  (List<BookRoom>) res.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AllBookings;
    }
    
    public boolean loginEmployee(String username,String password){
        boolean log = false;
        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("loginEmployee");
            obj.add(username);
            obj.add(password);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> res = (List<Object>) objectInputStream.readObject();
            log = (boolean) res.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return log;
    }
    public boolean loginAdmin(String username,String password){
        boolean log = false;
        try(Socket client = this.Connect()) {
            List<Object> obj = new ArrayList<>();
            obj.add("loginAdmin");
            obj.add(username);
            obj.add(password);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(obj);


            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            List<Object> res = (List<Object>) objectInputStream.readObject();
            log = (boolean) res.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return log;
    }




}
