INSERT INTO USERX (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE, PREMIUM) VALUES(TRUE, 'Admin', 'Istrator', '$2a$10$sk/DirzmRy2gEJb65Zp7hOfbZIf42PtrKvlxGAywzSbLtgmnJE5ku', 'admin', 'admin', '2016-01-01 00:00:00', TRUE)
INSERT INTO USERX_USERX_ROLE (USERX_USERNAME, ROLES) VALUES ('admin', 'ADMIN')
INSERT INTO USERX_USERX_ROLE (USERX_USERNAME, ROLES) VALUES ('admin', 'USER')
INSERT INTO USERX (ENABLED, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, CREATE_USER_USERNAME, CREATE_DATE, PREMIUM) VALUES(TRUE, 'Manager', 'Alex', '$2a$10$sk/DirzmRy2gEJb65Zp7hOfbZIf42PtrKvlxGAywzSbLtgmnJE5ku', 'manager', 'admin', '2016-01-01 00:00:00', TRUE)
INSERT INTO USERX_USERX_ROLE (USERX_USERNAME, ROLES) VALUES ('manager', 'MANAGER')
INSERT INTO USERX_USERX_ROLE (USERX_USERNAME, ROLES) VALUES ('manager', 'USER')
