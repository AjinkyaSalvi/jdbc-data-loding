CREATE SCHEMA SOCCER;

CREATE TABLE COUNTRY (
    Country_Name VARCHAR(20) PRIMARY KEY,
    Population DECIMAL(10 , 2 ),
    No_of_Worldcup_won INT,
    Manager VARCHAR(20)
);

CREATE TABLE PLAYERS (
    Player_id INT PRIMARY KEY,
    Name VARCHAR(40),
    Fname VARCHAR(20),
    Lname VARCHAR(35),
    DOB DATE,
    Country VARCHAR(20),
    Height_in_cms INT,
    Club VARCHAR(30),
    Position VARCHAR(10),
    Caps_for_Country INT,
    IS_CAPTAIN BOOLEAN,
    FOREIGN KEY (Country)
        REFERENCES COUNTRY (Country_Name)
);

CREATE TABLE MATCH_RESULTS (
    Match_id INT PRIMARY KEY,
    Date_of_Match DATE,
    Start_Time_Of_Match TIME,
    Team1 VARCHAR(25),
    Team2 VARCHAR(25),
    Team1_score INT,
    Team2_score INT,
    Stadium_Name VARCHAR(35),
    Host_City VARCHAR(20),
    FOREIGN KEY (Team1)
        REFERENCES COUNTRY (Country_Name),
    FOREIGN KEY (Team2)
        REFERENCES COUNTRY (Country_Name)
);

CREATE TABLE PLAYER_CARDS (
    Player_id INT PRIMARY KEY,
    Yellow_Cards INT,
    Red_Cards INT,
    FOREIGN KEY (Player_id)
        REFERENCES PLAYERS (Player_id)
);

CREATE TABLE PLAYER_ASSISTS_GOALS (
    Player_id INT PRIMARY KEY,
    No_of_Matches INT,
    Goals INT,
    Assists INT,
    Minutes_Played INT,
    FOREIGN KEY (Player_id)
        REFERENCES PLAYERS (Player_id)
);
