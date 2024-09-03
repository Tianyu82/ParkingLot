Interview Question: Can you design a parking lot?

(tip: say your understanding of a common parking lot, and ask the interviewer about the feasibility)

Requirements: Single level multi-type parking lot

1. The parking lot should have multiple parking spots where customers can park their cars.
2. Customers can collect a parking ticket from the entrance and can pay the parking fee at the exit point
3. The system should not allow more vehicles than the maximum capacity of the parking lot.
4. The system should support multiple types of parking spots such as Compact, Large, and Motorcycle.
5. The system should support parking for different types of vehicles like car, truck, and motorcycle.
6. Trucks can only be parked in LargeSpot, motorbikes can only be parked at motorbike spots, cars can be parked at compact or large spots
7. The parking lot should have a display board showing any free parking spots for each parking spot type.
8. Motorcycle rate is $3/hr, compact rate is $4/hr, large rate is $6/hr

Step 1: think about how does the system interacts with users/players
        On entering:
        The user choose the vehicle type
        The system returns a ticket object
        On leaving:
        The user scans the ticket (id/bar-code)
        The system calculates the parking fee

Step 2: unfold the blackbox
        The parking lot holds three counters: motor, compact, large
        The parking lot has methods to update the the counters depending on the vehicle type
        The ticket object holds the rate related to this parking, the starting time, the ending time, and the ticket id 



