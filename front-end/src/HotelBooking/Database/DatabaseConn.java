/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelBooking.Database;

import Model.BookRoom;
import Model.Employee;
import Model.Room;
import Model.RoomType;

import java.sql.*;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.*;

/**
 *
 * @author Admin
 */
public class DatabaseConn {

    public Connection Connect() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/hotel";
        try {
            con = DriverManager.getConnection(url, "root", "");
            System.out.println("connected to the database successfully");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    

    public String addRoom(String RoomNo, int RoomTypeId) {
        String msg = "";
        boolean alreadyExits = false;
        try (Connection conn = this.Connect()) {
            System.out.println(RoomNo);
            String searchQuery = "SELECT * FROM room WHERE RoomNo=?";
            PreparedStatement pstm = conn.prepareStatement(searchQuery);
            pstm.setString(1, RoomNo);
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                alreadyExits = true;
                msg = "room No already exists";
            }
            rs.close();
            pstm.close();


            if(!alreadyExits){
                String insertQuery = "INSERT INTO `room` (`RoomId`, `RoomNo`, `RoomTypeID`) VALUES (NULL,?,?)";
                pstm = conn.prepareStatement(insertQuery);
                pstm.setString(1, RoomNo);
                pstm.setInt(2, RoomTypeId);
                pstm.execute();
                msg = "room has been added Successfully";
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    public List<RoomType> getRoomTypes() {
        System.out.println("about to fetch some thing RoomTypes");

        List<RoomType> roomtypes = new ArrayList<>();
        String sql = "SELECT * FROM roomtype";
        try (Connection conn = this.Connect()) {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(sql);

            while (result.next()) {
                RoomType temp = new RoomType(result.getInt("RoomTypeId"), result.getString("RoomTypeName"),
                        result.getDouble("RoomTypePrice"));

                roomtypes.add(temp);
            }
            System.out.println("successfull fetched RoomTypes");
            conn.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        // roomtypes.forEach((temp)->{System.out.println(temp.RoomTypeName+"
        // "+temp.RoomTypeId+" "+temp.RoomTypePrice);});
        return roomtypes;
    }

    public List<Room> getRooms() {
        String sql = "SELECT RoomId,RoomNo,checked,roomtype.RoomTypeID,roomtype.RoomTypeName,roomtype.RoomTypePrice FROM room INNER JOIN roomtype ON roomtype.RoomTypeId = room.RoomTypeID";
        List<Room> rooms = new ArrayList<>();
        try (Connection conn = this.Connect()) {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
                Room r = new Room(result.getInt("RoomId"), result.getString("RoomNo"), result.getBoolean("checked"),
                        result.getInt("RoomTypeId"), result.getString("RoomTypeName"),
                        result.getDouble("RoomTypePrice"));
                rooms.add(r);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public List<Room> getRoomsNotChecked() {
        String sql = "SELECT RoomId,RoomNo,checked,roomtype.RoomTypeID,roomtype.RoomTypeName,roomtype.RoomTypePrice FROM room INNER JOIN roomtype ON roomtype.RoomTypeId = room.RoomTypeID WHERE room.checked=?";
        List<Room> rooms = new ArrayList<>();
        try (Connection conn = this.Connect()) {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setBoolean(1, false);
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                Room r = new Room(result.getInt("RoomId"), result.getString("RoomNo"), result.getBoolean("checked"),
                        result.getInt("RoomTypeId"), result.getString("RoomTypeName"),
                        result.getDouble("RoomTypePrice"));
                rooms.add(r);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public List<BookRoom> getBooking() {
        String sql = "SELECT * FROM bookroom INNER JOIN room on bookroom.RoomId=room.RoomId INNER JOIN roomtype on room.RoomTypeID=roomtype.RoomTypeId";
        List<BookRoom> AllBookings = new ArrayList<>();
        try (Connection conn = this.Connect()) {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(sql);
            System.out.println(result);
            while (result.next()) {
                BookRoom Br = new BookRoom(result.getInt("BookId"), result.getString("FirstName"),
                        result.getString("LastName"), result.getInt("Age"), result.getString("PhoneNUmber"),
                        result.getInt("RoomId"), result.getDate("DateCheckedIN"), result.getDate("DateCheckedOut"),
                        result.getBoolean("checked"), result.getString("RoomNo"), result.getInt("RoomTypeId"),
                        result.getString("RoomTypeName"), result.getDouble("RoomTypePrice"),result.getDouble("payment"),
                        result.getBoolean("done")
                        );
                AllBookings.add(Br);

            }
            System.out.println("finished fetching the data");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AllBookings;
    }

    public List<BookRoom> getBookedRooms() {
        String sql = "SELECT * FROM bookroom INNER JOIN room on bookroom.RoomId=room.RoomId INNER JOIN roomtype on room.RoomTypeID=roomtype.RoomTypeId WHERE bookroom.done=?";
        List<BookRoom> AllBookings = new ArrayList<>();
        try (Connection conn = this.Connect()) {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setBoolean(1, false);
            ResultSet result = pstm.executeQuery();
            System.out.println(result);
            while (result.next()) {
                BookRoom Br = new BookRoom(result.getInt("BookId"), result.getString("FirstName"),
                        result.getString("LastName"), result.getInt("Age"), result.getString("PhoneNUmber"),
                        result.getInt("RoomId"), result.getDate("DateCheckedIN"), result.getDate("DateCheckedOut"),
                        result.getBoolean("checked"), result.getString("RoomNo"), result.getInt("RoomTypeId"),
                        result.getString("RoomTypeName"), result.getDouble("RoomTypePrice"),result.getDouble("payment"),
                        result.getBoolean("done")
                        );
                AllBookings.add(Br);

            }
            System.out.println("finished fetching the data");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AllBookings;
    }

    public Room getRoom(String RoomNo) {
        Room r = null;
        try (Connection conn = this.Connect()) {
            String sql = "SELECT RoomId,RoomNo,checked,roomtype.RoomTypeID,roomtype.RoomTypeName,roomtype.RoomTypePrice FROM room INNER JOIN roomtype ON roomtype.RoomTypeId = room.RoomTypeID WHERE RoomNo=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, RoomNo);
            ResultSet result = pstm.executeQuery();
            if (result.next()) {
                r = new Room(result.getInt("RoomId"), result.getString("RoomNo"), result.getBoolean("checked"),
                        result.getInt("RoomTypeId"), result.getString("RoomTypeName"),
                        result.getDouble("RoomTypePrice"));
            }
            conn.close();
        } catch (Exception e) {
        }
            return r;
    }

    public String CheckIn(String Fname, String Lname, int Age, String PhoneNumber, java.util.Date date, String RoomNo) {
        String msg = "";
        Room r = getRoom(RoomNo);
        if (getRoom(RoomNo) != null && !r.checked) {
            try (Connection conn = this.Connect()) {
                

                String insertQuery = "INSERT INTO `bookroom` (`BookId`, `FirstName`, `LastName`, `Age`, `PhoneNumber`, `RoomId`, `DateCheckedIn`, `DateCheckedOut`) VALUES (NULL,?, ?, ?, ?, ?, ?, NULL)";
                
                PreparedStatement pstm = conn.prepareStatement(insertQuery);
                pstm.setString(1, Fname);
                pstm.setString(2, Lname);
                pstm.setInt(3, Age);
                pstm.setString(4, PhoneNumber);
                pstm.setInt(5, r.RoomId);
                pstm.setDate(6, new java.sql.Date(date.getTime()));

                pstm.execute();
                pstm.close();

                String updateQuery = "UPDATE `room` SET `checked` = ? WHERE `room`.`RoomId` = ?";
                pstm = conn.prepareStatement(updateQuery);
                pstm.setBoolean(1, true);
                pstm.setInt(2, r.RoomId);
                pstm.execute();
                pstm.close();

                conn.close();
                msg = "Room Booked Successfully";
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            msg = (r==null)?"invalid room No":"room is already booked";
        }
        return msg;
    }

    public  AbstractMap.Entry<BookRoom, String> getBookedRoom(String RoomNo) {

        BookRoom room = null;
        String msg = "";

        try (Connection conn = this.Connect()) {

            // first look for unbooked hotel;

            
            String sql = "SELECT * FROM bookroom,room,roomtype WHERE bookroom.RoomId = room.RoomId and room.RoomTypeID = roomtype.RoomTypeId AND room.RoomNo = ? and bookroom.done=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, RoomNo);
            pstm.setBoolean(2, false);
            ResultSet result = pstm.executeQuery();
            if (result.next()) {
                 if(result.getBoolean("checked")){
                    room = new BookRoom(result.getInt("BookId"), result.getString("FirstName"),
                    result.getString("LastName"), result.getInt("Age"), result.getString("PhoneNUmber"),
                    result.getInt("RoomId"), result.getDate("DateCheckedIN"), result.getDate("DateCheckedOut"),
                    result.getBoolean("checked"), result.getString("RoomNo"), result.getInt("RoomTypeId"),
                    result.getString("RoomTypeName"), result.getDouble("RoomTypePrice"),
                    result.getDouble("payment"),result.getBoolean("done")
                    );
                 }else{
                     msg = "Room Is Not Booked";
                 }
            }else{
                msg = "ROOM Number Doesn't Exist";
            }
            result.close();
            pstm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        AbstractMap.Entry<BookRoom, String> result =new AbstractMap.SimpleEntry<>(room,msg);
        return result;
    }

    public String CheckOut(BookRoom room){
        String s = "";
        try(Connection conn = this.Connect()){
            java.util.Date date = new java.util.Date();
            
            String sql = "UPDATE bookroom SET bookroom.payment=?,bookroom.DateCheckedOut=? WHERE bookroom.BookId=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setDouble(1, room.payment);
            pstm.setDate(2, new Date(date.getTime()));
            pstm.setInt(3, room.BookId);
            pstm.execute();
            pstm.close();

            sql = "UPDATE room,bookroom SET bookroom.done=?,room.checked=? WHERE room.RoomId=bookroom.RoomId and room.RoomId=? and bookroom.BookId =?";
            pstm = conn.prepareStatement(sql);
            pstm.setBoolean(1, true);
            pstm.setBoolean(2, false);
            pstm.setInt(3, room.RoomId);
            pstm.setInt(4, room.BookId);
            pstm.execute();
            pstm.close();

            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return s;
    }
    public List<Employee> getEmployees(){
        List<Employee> allEmployees = new ArrayList<>();

        try(Connection conn = this.Connect()) {
            String sql = "SELECT * FROM employee";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                allEmployees.add(new Employee(rs.getInt("EmployeeId"), rs.getString("EmployeeUsername"), rs.getString("EmployeePassword")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allEmployees;
    }

    public String registerEmployee(String EmployeeUsername,String EmployeePassword){
        String msg = "";
        try(Connection conn = this.Connect()){
            boolean alreadyExist = false;
            String selectQuery = "SELECT * FROM employee WHERE employee.EmployeeUsername=?";
            PreparedStatement pstm = conn.prepareStatement(selectQuery);
            pstm.setString(1, EmployeeUsername);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                alreadyExist = true;
                msg = "Employee Username already exists";
            }
            pstm.close();
            if(!alreadyExist){
                String insertQuery = "INSERT INTO `employee` (`EmployeeId`, `EmployeeUsername`, `EmployeePassword`) VALUES (NULL, ?, ?);";
                pstm = conn.prepareStatement(insertQuery);
                pstm.setString(1, EmployeeUsername);
                pstm.setString(2, EmployeePassword);
                pstm.execute();
                pstm.close();
                msg = "Employee has been registerd Succesfully";
            }
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return msg;
    }
    public int deleteEmployee(String EmployeeUsername){
        int rs = 0;
        try(Connection conn = this.Connect()){
            String selectQuery = "DELETE FROM employee WHERE employee.EmployeeUsername=?";
            PreparedStatement pstm = conn.prepareStatement(selectQuery);
            pstm.setString(1, EmployeeUsername);
            rs = pstm.executeUpdate();
            
            pstm.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    public int updateAdmin(String adminUsername,String adminNewPassword,String adminOldPassword){
        int rs = 0;
        try(Connection conn = this.Connect()){
            String selectQuery = "UPDATE admin SET AdminUsername=?,AdminPasssword=? WHERE admin.AdminUsername=? AND admin.AdminPasssword=?";
            PreparedStatement pstm = conn.prepareStatement(selectQuery);
            pstm.setString(1, adminUsername);
            pstm.setString(2, adminNewPassword);
            pstm.setString(3, adminUsername);
            pstm.setString(4, adminOldPassword);
            rs = pstm.executeUpdate();
            pstm.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    public int updateEmployee(String username,String newpassword,String oldpassword){
        int rs = 0;
        try(Connection conn = this.Connect()){
            String selectQuery = "UPDATE employee SET EmployeeUsername=?,EmployeePassword=? WHERE employee.EmployeeUsername=? AND employee.EmployeePassword=?";
            PreparedStatement pstm = conn.prepareStatement(selectQuery);
            pstm.setString(1, username);
            pstm.setString(2, newpassword);
            pstm.setString(3, username);
            pstm.setString(4, oldpassword);
            rs = pstm.executeUpdate();
            pstm.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    public int[]  Report(){
        int[] data = new int[3];
        int TotalRoom = 0;
        int TotalBooked = 0;
        int TotalPayment = 0;
        try(Connection conn = this.Connect()){

            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT COUNT(*) as room_count FROM room");
            if(rs.next()){
                TotalRoom = rs.getInt("room_count");
            }
            rs.close();
            stm.close();

            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT COUNT(*) as room_count FROM room where room.checked=1");
            if(rs.next()){
                TotalBooked = rs.getInt("room_count");
            }
            rs.close();
            stm.close();


            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT SUM(bookroom.payment) AS total_payment FROM bookroom");
            if(rs.next()){
                TotalPayment = rs.getInt("total_payment");
            }
            rs.close();
            stm.close();

            data[0] = TotalRoom;
            data[1] = TotalBooked;
            data[2] = TotalPayment;
        }catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public List<BookRoom> getInfoInterval(java.util.Date startiDate,java.util.Date endingDate){
        String sql = "select * from bookroom,roomtype,room where room.RoomId=bookroom.RoomId and room.RoomTypeID=roomtype.RoomTypeId AND bookroom.DateCheckedIn >= ? and bookroom.DateCheckedIn <=?";
        List<BookRoom> IntervalBooking = new ArrayList<>();
        try (Connection conn = this.Connect()) {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setDate(1,new Date(startiDate.getTime()));
            pstm.setDate(2,new Date (endingDate.getTime()));
            ResultSet result = pstm.executeQuery();
            System.out.println(result);
            while (result.next()) {
                BookRoom Br = new BookRoom(result.getInt("BookId"), result.getString("FirstName"),
                        result.getString("LastName"), result.getInt("Age"), result.getString("PhoneNUmber"),
                        result.getInt("RoomId"), result.getDate("DateCheckedIN"), result.getDate("DateCheckedOut"),
                        result.getBoolean("checked"), result.getString("RoomNo"), result.getInt("RoomTypeId"),
                        result.getString("RoomTypeName"), result.getDouble("RoomTypePrice"),result.getDouble("payment"),
                        result.getBoolean("done")
                        );
                        IntervalBooking.add(Br);

            }
            System.out.println("finished fetching the data");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IntervalBooking;
    }
    public boolean loginEmployee(String username,String password){
        boolean log = false;
        try(Connection con = this.Connect()){
            String sql = "SELECT * FROM employee WHERE employee.EmployeeUsername=? AND employee.EmployeePassword=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                log = true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return log;
    }

    public boolean loginAdmin(String username,String password){
        boolean log = false;
        try(Connection con = this.Connect()){
            String sql = "SELECT * FROM admin WHERE admin.AdminUsername=? AND admin.AdminPasssword=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                log = true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return log;
    }

}
