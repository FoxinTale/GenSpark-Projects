-- Database creation script for the final Genspark project. The topic for this one is "Client-Project Management".
-- This is primarioly the script to create or initialise the database during development and testing. 
-- Or to restore from if I manage to mess things up.

-- We drop our tables in the inverse order of creating them to make sure we're not dropping tables that contain data other tables rely on.
DROP TABLE IF EXISTS projects CASCADE;
DROP TABLE IF EXISTS clients CASCADE;
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users(
	userID int NOT NULL,
	clientID int NOT NULL,
	userName varchar(255), 
	userPassword varchar(512),
	userLevel integer
);
-- "UserLevel", in this denotes the permissions / role of the user. 

CREATE TABLE clients(
	clientID int NOT NULL,
	clientName varchar(255) NOT NULL,
	clientDesc text,
	clientOrg varchar(512)
);

CREATE TABLE projects(
	projectID int NOT NULL,
	clientID int NOT NULL,
	projectName varchar(255),
	projectDesc text,
	projectStatus varchar(255),
	projectNotes text,
	projectDeadline datetime,
	projectContract mediumblob
);

CREATE TABLE tasks(
	taskID int NOT NULL,
	projectID int NOT NULL,
	taskName varchar(255),
	taskDesc varchar(2000),
	taskPriority smallint,
	taskStatus smallint,
	taskNotes text,
	taskAssignee varchar(255),
	taskDeadline datetime,
	taskCompletion datetime,
	taskSoftDelete bit
);

-- Adding our constraints, such as primary and foreign keys.
	
ALTER TABLE clients ADD PRIMARY KEY(clientID);

ALTER TABLE users ADD PRIMARY KEY(userID),
	ADD CONSTRAINT client_FK FOREIGN KEY (clientID) REFERENCES clients(clientID);

ALTER TABLE projects ADD PRIMARY KEY(projectID),
	ADD CONSTRAINT project_FK FOREIGN KEY (clientID) REFERENCES clients(clientID);

ALTER TABLE tasks ADD PRIMARY KEY(taskID),
	ADD CONSTRAINT tasks_FK FOREIGN KEY (projectID) REFERENCES projects(projectID);

-- Adding values.
INSERT INTO users VALUES(1, 'Aubrey', 'password', 4);
INSERT INTO clients(clientID, clientName, clientOrg)  VALUES(1, 'Aubrey' , ' N/A, self');



