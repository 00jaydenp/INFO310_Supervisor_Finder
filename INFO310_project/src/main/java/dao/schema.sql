CREATE TABLE sysUser(
    userID varchar(5) not null unique,
    email varchar(50) not null unique,
    password varchar(20) not null,
    
    constraint sysUser_PK primary key (userID)
);

CREATE TABLE Student(
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
    constraint StudentUserID_FK foreign key (userID) references sysUser(userID)
);

CREATE TABLE Supervisor(
    staffID varchar(5) not null unique, 
    firstName varchar(20) not null, 
    lastName varchar(20) not null,
    email varchar(50) not null,
    interest varchar(50) not null,
    description varchar(50) not null,
    phoneNumber varchar(20) not null,
    userID varchar(5) not null unique,
     
    
    constraint Supervisor_PK primary key (staffID),
    constraint SupervisorUserID_FK foreign key (userID) references User(userID)
);

CREATE TABLE Project(
    projectID varchar(5) not null unique,
    staffID varchar(5) not null unique,
    description varchar(50) not null,
    status varchar (10) not null,
    openDate date,
    studentID varchar(5) not null,

    constraint Project_PK primary key (projectID),
    constraint ProjectStaffID_FK foreign key (staffID) references Supervisor(staffID),
    constraint ProjectStudentID_FK foreign key (studentID) references Student(studentID)
);
    
    

