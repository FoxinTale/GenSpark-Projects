-- Database creation script for the final Genspark project. The topic for this one is "Client-Project Management".
-- This is primarioly the script to create or initialise the database during development and testing. 
-- Or to restore from if I manage to mess things up.

-- We drop our tables in the inverse order of creating them to make sure we're not dropping tables that contain data other tables rely on.
DROP TABLE IF EXISTS projects CASCADE;
DROP TABLE IF EXISTS clients CASCADE;
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users(
	userID int NOT NULL,
	userName varchar(255), 
	userPassword varchar(512),
	userLevel integer
);
-- "UserLeveL", in this denotes the permissions / role of the user. 

CREATE TABLE clients(
	clientID int NOT NULL,
	clientName varchar(255) NOT NULL,
	clientDesc tinytext 
	clientOrg varchar(512)
);

CREATE TABLE projects(
	projectID int NOT NULL,
	clientID int NOT NULL,
	projectName varchar(255),
	projectDesc text,
	projectStatus varchar(255),
	projectContract blob
);

CREATE TABLE tasks(
	taskID int NOT NULL,
	projectID int NOT NULL,
	taskName varchar(255),
	taskDesc varchar(2000),
	taskPriority smallint,
	taskStatus smallint,
	taskAssignee varchar(255)
};

-- Adding our constraints, such as primary and foreign keys.
ALTER TABLE users ADD PRIMARY KEY(userID);
ALTER TABLE clients ADD PRIMARY KEY(clientID);

ALTER TABLE projects ADD PRIMARY KEY(projectID),
	ADD CONSTRAINT project_FK FOREIGN KEY (clientID) REFERENCES clients(clientID);

ALTER TABLE tasks ADD PRIMARY KEY(taskID),
	ADD CONSTRAINT tasks_FK FOREIGN KEY (projectID) REFERENCES projects(projectID);

-- Adding values.
INSERT INTO users VALUES(1, 'Aubrey', 'password', 4);
INSERT INTO clients(clientName, clientOrg)  VALUES('Aubrey' , ' N/A, self');

