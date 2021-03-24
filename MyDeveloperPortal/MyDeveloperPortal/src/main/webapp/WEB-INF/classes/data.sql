DROP TABLE IF EXISTS SKILLS;

CREATE TABLE SKILLS(
   id INT AUTO_INCREMENT  PRIMARY KEY,
   skills VARCHAR(250)
);

INSERT into SKILLS(id, skills) VALUES (1, 'Core Java Programming');
INSERT into SKILLS(id, skills) VALUES (2, 'Java Spring Framework');
INSERT into SKILLS(id, skills) VALUES (3, 'JavaScript');
INSERT into SKILLS(id, skills) VALUES (4, 'Node JS');
INSERT into SKILLS(id, skills) VALUES (5, 'Angular JS');
INSERT into SKILLS(id, skills) VALUES (6, 'PHP');

