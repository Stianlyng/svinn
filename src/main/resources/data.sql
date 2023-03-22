-- Insert sample users
INSERT INTO users (firstname, lastname, email, password, role)
VALUES ('John', 'Doe', 'john.doe@example.com', 'password123', 'ROLE_USER'),
       ('Jane', 'Smith', 'jane.smith@example.com', 'password456', 'ROLE_ADMIN');

-- Insert sample tokens for users
INSERT INTO token (token, user_id, expiry_date, is_expired, is_revoked)
VALUES ('sample_token_1', 1, '2023-04-22 12:00:00', FALSE, FALSE),
       ('sample_token_2', 2, '2023-04-22 12:00:00', FALSE, FALSE);

-- Insert sample data into demo table
INSERT INTO demo (name)
VALUES ('Demo Data 1'),
       ('Demo Data 2');