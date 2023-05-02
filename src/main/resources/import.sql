-- Insert roles
INSERT INTO roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'USER');

-- Insert users

INSERT INTO users (id, username, password) VALUES (1,'username1','password1');
INSERT INTO users (id, username, password) VALUES (2,'username2','password2');

--Insert clients

INSERT INTO clients (id, name, last_name, identification, email, birth_date, user_id) VALUES (1, 'John', 'Doe', '123456789', 'johndoe@mail.com', '1990-01-01',1);
INSERT INTO clients (id, name, last_name, identification, email, birth_date, user_id) VALUES (2, 'Jane', 'Doe', '987654321', 'janedoe@mail.com', '1992-05-15',2);

-- Insert Key foreign

INSERT INTO users_roles (user_id, roles_id) VALUES (1,1)
INSERT INTO users_roles (user_id, roles_id) VALUES (2,2)