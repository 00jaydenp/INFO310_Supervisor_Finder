CREATE TABLE STUDENT(
    studentID varchar(5) not null unique, 
    firstName varchar(20) not null, 
    lastName varchar(20) not null, 
    interest varchar(50) not null, 
    description varchar(50) not null, 
    phoneNumber varchar(20) not null, 
    gpa varchar(10) not null, 
    address varchar(50) not null, 

    constraint Student_PK primary key (studentID)
);