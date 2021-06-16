INSERT INTO `bookroom` (`BookId`, `FirstName`, `LastName`, `Age`, `PhoneNumber`, `RoomId`, `DateCheckedIn`, `DateCheckedOut`, `CheckdOut`) VALUES (NULL, 'Abel', NULL, NULL, NULL, '14', '2021-06-13', NULL, '1');




SELECT * FROM bookroom INNER JOIN room on bookroom.RoomId=room.RoomId INNER JOIN roomtype on room.RoomTypeID=roomtype.RoomTypeId
