package Model;

import java.sql.Date;

public class BookRoom extends RoomType{
    public int BookId;
    public String FirstName;
    public String LastName;
    public int Age;
    public String PhoneNumber;
    public int RoomId;
    public Date DateCheckedIn;
    public Date DateCheckedOut;
    public boolean CheckedOut;
    public String RoomNo;
    public double payment;
    public boolean Done;

    public BookRoom(int BookId,String FirstName,String LastName,
                    int Age,String PhoneNUmber,int RoomId,
                    Date DateCheckedIN,Date DateCheckedOut,boolean CheckedOut,String RoomNo,
                    int RoomTypeId,String RoomTypeName,double RoomTypePrice,double payment,boolean Done)
    {
        super(RoomTypeId, RoomTypeName, RoomTypePrice);
        this.BookId = BookId;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Age = Age;
        this.PhoneNumber = PhoneNUmber;
        this.RoomId = RoomId;
        this.DateCheckedIn = DateCheckedIN;
        this.DateCheckedOut = DateCheckedOut;
        this.CheckedOut = !CheckedOut;
        this.RoomNo = RoomNo;
        this.payment = payment;
        this.Done = Done;
    }
    @Override
    public String toString() {
        String s =  Integer.toString(this.BookId) + " "+ this.FirstName + " "+this.LastName+" "+Integer.toString(this.Age)+" "+this.PhoneNumber
                    + " "+ Integer.toString(this.RoomId) + " "+ this.DateCheckedIn.toString()+" "+this.DateCheckedOut.toString()+ " "+ Boolean.toString(this.CheckedOut)
                    +" "+ Integer.toString(this.RoomTypeId) + " "+this.RoomTypeName+" "+Double.toString(this.RoomTypePrice);
        return s;
    }
}
