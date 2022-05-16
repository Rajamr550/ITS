# ITS

ITS  -   INTERVIEW TRACKING SYSTEM.
    Microservices
	       ITS-UserManagement --8003
      	 ITS-Admin    - port :8004
   	     ITS-TechPanel - port :8005
   	     ITS-HR    - port :8006

Other Mircoservices:
1.Eureka	- port : 8001
2.Api-Gateway	- port : 8002

Priority List
Priority -1 
Endpoints - 
1.ITS-Admin  ----- 1,2,3,4,6,7,8,9,10
2.ITS-Tech ----- 1,2,3
3.ITS-HR ----- 1,2,3

Priority - 2
Endpoints - 
1.ITS-Admin  ----- 5 - [Update Interview]
2.ITS-Tech ----- 4 - [Surrender as Tech 
				Panel Member]
3.ITS-HR ----- 4 - [Surrender as HR
				Panel Member]

Team member specific endpoints:

1.Nagaraju

ITS-Admin
8 - 	Search Employee (by 
	ID or Name)
9 - Delete Panel Member
10 - List All Panel Members 

2.Madhumita - 

ITS-Tech
1. View Interview 
Members
2. Give Rating to a 
candidate
3. View a candidate

3.Ruchi - 

ITS-HR
1. View Interview 
Members
2. Give Rating to a 
candidate
3. View a candidate

4.Raja - 

ITS-Admin
3. Share Candidate withTech/HR panel
4. Schedule Interview 
5. Update Interview
6. Cancel Interview 


5.Satyam

ITS-Admin
1. Add Candidate 
2. View Candidate Candidate
7. Add Panel Member
