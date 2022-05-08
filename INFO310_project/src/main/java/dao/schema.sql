DROP TABLE application;
DROP TABLE project;
DROP TABLE supervisor;
DROP TABLE student;
DROP TABLE sysUser;


CREATE TABLE sysUser(
    email varchar(50) not null unique,
    password varchar(20) not null,
    
    constraint sysUser_PK primary key (email)
);

CREATE TABLE Student(
    studentID varchar(8) not null unique, 
    firstName varchar(20) not null, 
    lastName varchar(20) not null, 
    interests varchar(50) not null, 
    description varchar(255) not null, 
    phoneNumber varchar(20) not null, 
    gpa decimal(3,1) not null, 
    address varchar(50),
    email varchar(50) not null unique,
    hidden boolean not null default 0,
    
    constraint Student_PK primary key (studentID),
    constraint StudentEmail_FK foreign key (email) references sysUser (email)
        on delete cascade
);

CREATE TABLE Supervisor(
    staffID varchar(8) not null unique, 
    firstName varchar(20) not null, 
    lastName varchar(20) not null,
    interests varchar(50) not null,
    description varchar(255) not null,
    phoneNumber varchar(20) not null,
    email varchar(50) not null unique,
    hidden boolean not null default 0,
       
    constraint Supervisor_PK primary key (staffID),
    constraint SupervisorEmail_FK foreign key (email) references sysUser (email)
        on delete cascade
);




CREATE TABLE Project(
    projectID varchar(5) not null unique,
    name varchar(255) not null,
    description varchar(255) not null,
    status varchar (255) not null,
    date varchar(10),
    staffID varchar(8) not null,
    studentID varchar(8),
    hidden boolean not null default 0,

    constraint Project_PK primary key (projectID), 
    constraint StaffID_FK foreign key (staffID) references Supervisor (staffID)
        on delete cascade,
    constraint StudentID_FK foreign key (studentID) references Student (studentID)
        on delete cascade
);

CREATE TABLE Application(
    applicationID varchar(8) not null unique,
    projectID varchar(5) not null unique,
    studentID varchar(8) not null unique,

    constraint Application_PK primary key (applicationID),
    constraint Project_FK foreign key (projectID) references Project(projectID)
        on delete cascade,
    constraint Student_FK foreign key (studentID) references Student(studentID)
        on delete cascade
);


