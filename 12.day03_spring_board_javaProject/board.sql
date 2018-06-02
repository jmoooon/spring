CREATE TABLE IF NOT EXISTS BOARD(
SEQ NUMBER(5) PRIMARY KEY,
TITLE VARCHAR2(200),
WRITER VARCHAR2(20),
CONTENT VARCHAR2(2000),
REGDATE DATE DEFAULT SYSDATE,
CNT NUMBER(5) DEFAULT 0
);

CREATE TABLE IF NOT EXISTS USER(
ID VARCHAR2(8) PRIMARY KEY,
PASSWORD VARCHAR2(8),
NAME VARCHAR2(20),
ROLE VARCHAR2(5)
)
