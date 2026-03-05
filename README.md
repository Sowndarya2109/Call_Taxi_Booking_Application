CALL TAXI BOOKING APPLICATION

Description:
Design a taxi booking application where customers can book taxis available at certain points in a linear
route.

Problem Assumptions:
• Taxi Count: 4 taxis (scalable to any number)
• Points on Route: A, B, C, D, E, F — each 15 km apart
• Travel Time Between Points: 60 minutes
• Charges: Minimum Rs.100 for the first 5 km; Rs.10 per km thereafter
• Initial Position: All taxis stationed at A

Booking Rules:
• A free taxi at the pickup point is allocated first.
• If no free taxi is available at pickup, the nearest free taxi is allocated.
• If two taxis are free at the same point, the one with lower earnings is allocated.
• Taxis only charge from the pickup point to the drop point.
• If no taxi is available, the booking is rejected.

Modules:
Module 1: Call Taxi Booking
Sample Inputs and Outputs:
Input Output
Customer ID: 1 Pickup: A | Drop: B Pickup Time:
9
Taxi can be allotted. Taxi-1 is allotted.
Customer ID: 2 Pickup: B | Drop: D Pickup Time:
9
Taxi can be allotted. Taxi-2 is allotted.
Customer ID: 3 Pickup: B | Drop: C Pickup Time:
12
Taxi can be allotted. Taxi-1 is allotted.

Module 2: Display Taxi Details
Taxi-1 Total Earnings: Rs. 400
BookingID CustomerID From To PickupTime DropTime Amount
1 1 A B 9 10 200
3 3 B C 12 13 200
Taxi-2 Total Earnings: Rs. 350
BookingID CustomerID From To PickupTime DropTime Amount
2 2 B D 9 11 350

OUTPUT

<img width="400" height="400" alt="image" src="https://github.com/user-attachments/assets/32d4eeb1-9095-4224-b04b-dc97c55dcff1" />

<img width="300" height="300" alt="image" src="https://github.com/user-attachments/assets/a9b7a187-d7b8-4106-9b6e-1691a7fbb195" />

