/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class RoomType implements Serializable{
    public int RoomTypeId;
    public String RoomTypeName;
    public double RoomTypePrice;
    public RoomType(int RoomTypeId,String RoomTypeName,double RoomTypePrice){
        this.RoomTypeId = RoomTypeId;
        this.RoomTypeName = RoomTypeName;
        this.RoomTypePrice = RoomTypePrice;
    }
    
}
