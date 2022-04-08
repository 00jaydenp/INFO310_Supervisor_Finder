CREATE TABLE USER(
    userID varchar(5) not null unique,
    email varchar(50) not null unique,
    password varchar(20) not null,
    
    constraint User_PK primary key (studentID)
);

CREATE TABLE STUDENT(
    studentID varchar(5) not null unique, 
    firstName varchar(20) not null, 
    lastName varchar(20) not null, 
    interest varchar(50) not null, 
    description varchar(50) not null, 
    phoneNumber varchar(20) not null, 
    gpa varchar(10) not null, 
    address varchar(50) not null,
    userID varchar(5) not null unique,
    
    
    constraint Student_PK primary key (studentID),
    constraint StudentUserID_FK foreign key (userID) references User(userID)
);

CREATE TABLE Supervisor(
    staffID varchar(5) not null unique, 
    firstName varchar(20) not null, 
    lastName varchar(20) not null,
    email varchar(50) not null,
    interest varchar(50) not null,
    description varchar(50) not null,
    phoneNumber varchar(20) not null, 
     
    
    constraint Supervisor_PK primary key (staffID),
    constraint Supervisor_FK foreign key (userID) references User(userID)
);

