CREATE TABLE tododb.public.items (
    ID SERIAL PRIMARY KEY,
    ITEM_NAME VARCHAR(255) NOT NULL,
    DESCRIPTION TEXT NOT NULL,
    DATE DATE NOT NULL,
    STATUS BOOLEAN DEFAULT FALSE
);