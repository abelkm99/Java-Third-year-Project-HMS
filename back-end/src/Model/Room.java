package Model;


public class Room extends RoomType{
    
    public int RoomId;
    public String RoomNo;
    public boolean checked;

    public Room(int RoomId,String RoomNo,boolean checked,int RoomTypeId,String RoomTypeName,double RoomTypePrice) {
        super(RoomTypeId, RoomTypeName, RoomTypePrice);
        this.RoomId = RoomId;
        this.RoomNo = RoomNo;
        this.checked = checked;
    }
    

}
