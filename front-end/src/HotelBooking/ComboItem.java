/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelBooking;

import Model.RoomType;

/**
 *
 * @author Admin
 */
public class ComboItem
{
    private String key;
    private RoomType value;

    public ComboItem(String key, RoomType value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key;
    }

    public String getKey()
    {
        return key;
    }

    public RoomType getValue()
    {
        return value;
    }
}
