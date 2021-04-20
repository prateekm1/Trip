# Trip
				JAVA DEVELOPER ASSIGNMENT
Problem Statement: 
● Create a Rest Api application to track User Journey Trips. 
● A trip will have id, source, destination, start-time, end-time and distance covered. 
● Apart from basic endpoints it should have an api to get the total distance covered filtered by a user, user and date as well.

Solution:
1.	Software Used
•	Eclipse
•	MySQL

2.	Implementation
Basically, I have tried to create a web based java application where user can create TRIPS and manage its data.
First of all an user needs to register himself using the given UI with some basic details, using Username and Password to later login. Once logged in user is presented with few options such as to create a new trip, view all the trips he/she created till now and to filter trips data according to dates.
Once a user wants to create a new trip; firstly he/she asked for Source and Destination which is used as an input for the API used in background to calculate distance between these two points
(it works on real time hence requires internet connection), then user can provide the date and start and end time for the trip and once created the trip is stored in database with users unique id that can be used later to fetch these details.
( UI designed is very basic, not much effort was given since it was optional)
