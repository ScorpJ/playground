create table APP_SIGN_IN_REC(
  ID INTEGER(10) NOT NULL AUTO_INCREMENT,
  USER_ID INTEGER(10) NOT NULL,
  SEQ_NUM INTEGER(10) NOT NULL AUTO_INCREMENT,
  SIGN_IN_DTTM DECIMAL(20) NOT NULL,
  SIGN_IN_DT_STR  VARCHAR(10) NOT NULL,
  SIGN_IN_POINT INTEGER(10)  NOT NULL,
  constraint PK_APP_SIGN_IN_REC primary key (ID)
);

create table APP_CREDIT_HDR(
  ID INTEGER(10) NOT NULL AUTO_INCREMENT,
  USER_ID INTEGER(10) NOT NULL,
  BALANCE INTEGER(10) NOT NULL default 0,  
  constraint PK_APP_CREDIT_HDR primary key (ID)
);

create table APP_CREDIT_CHG_LN(
  ID INTEGER(10) NOT NULL AUTO_INCREMENT,
  USER_ID INTEGER(10) NOT NULL,
  CHANGE_TYPE VARCHAR(3) NOT NULL,
  CHANGE_CATEGORY VARCHAR(5) NOT NULL,
  CHANGE_CATEGORY_CD VARCHAR(255) NOT NULL,
  CREDIT_POINT INTEGER(10) NOT NULL default 0,
  CHANGE_ON_DTTM  DECIMAL(20) NOT NULL, 
  CHANGE_ON_DT_STR  VARCHAR(10) NOT NULL,
  constraint PK_APP_CREDIT_CHG_LN primary key (ID)
);

