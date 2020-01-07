BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;


drop table track;
drop table album;

UPDATE playlist_names
SET is_private = false
WHERE is_private = true;

CREATE TABLE users (
  id serial PRIMARY KEY,
  username varchar(255) NOT NULL UNIQUE,     -- Username
  password varchar(32) NOT NULL,      -- Password
  salt varchar(256) NOT NULL,          -- Password Salt
  role varchar(255) NOT NULL default('user')
);

CREATE TABLE library (   
  user_id INTEGER,                             -- Join user to album
  FOREIGN KEY (user_id) REFERENCES users (id),   -- Foreign key to users.user_id
  album_id INTEGER      NOT NULL UNIQUE,                          -- Reference to API album ID
  notes    VARCHAR(255)                               -- Access with user_id AND album_id
);


INSERT INTO library VALUES (2,  2, 'This is an incredible album!!!');
INSERT INTO library VALUES (3,  4, 'I need to see this ASAP....');
INSERT INTO library VALUES (3,  6, 'Sounds better on CD.');
INSERT INTO library VALUES (3,  7, 'The first album I ever purchased.');
INSERT INTO library VALUES (3, 11, 'This is from Mom and Dads collection when there were my age.');
INSERT INTO library VALUES (3, 24, 'This is the one I stole from Ethan.  Ha!');
INSERT INTO library VALUES (3, 29, 'This is my 2nd copy since Seth borrowed my original one and never returned it.');
INSERT INTO library VALUES (3, 31, 'GARBAGE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!');
INSERT INTO library VALUES (3, 46, 'This really should be the Tech Elevator theme song.  Yeah!');
INSERT INTO library VALUES (3, 56, 'Great after dinner music when you are with that special someone.');
INSERT INTO library VALUES (3, 78, 'If I were more of a hillbilly, I would probably love this.');


CREATE TABLE playlist_names (
  user_id INTEGER,
  playlist_id   SERIAL       PRIMARY KEY,             -- Primary key
  is_private    BOOLEAN      DEFAULT TRUE NOT NULL,    -- Is playlist visible to other users?
  playlist_name VARCHAR(255) NOT NULL,                -- Playlist name
  FOREIGN KEY (user_id) REFERENCES users (id)   -- Foreign key to users.user_id
);

select * from playlist_names;

select * from playlist_contents where playlist_id = 3;

--add album to playlist

drop table playlist_names;
drop table playlist_contents;

insert into playlist_contents values(8,12);

delete from playlist_contents where playlist_id = 3 and album_id = 4;


--delete from playlist_contents where playlist_id = 3;
--delete from playlist_names

--update playlist_names set playlist_name = 'pie' where playlist_id = 7;


insert into playlist_names(user_id, playlist_name) 
values(2, '60s rock') 
RETURNING playlist_id;
insert into playlist_names(user_id, playlist_name) 
values(2, '80s rock') 
RETURNING playlist_id;
insert into playlist_names(user_id, playlist_name) 
values(2, 'Nighttime Jams') 
RETURNING playlist_id;
insert into playlist_names(user_id, playlist_name) 
values(2, 'Cool Fun Times') 
RETURNING playlist_id;
insert into playlist_names(user_id, playlist_name) 
values(2, 'Jock Jams 90s') 
RETURNING playlist_id;


CREATE TABLE playlist_contents (                      -- Join playlist to album
  playlist_id INTEGER,
  FOREIGN KEY (playlist_id) REFERENCES playlist_names (playlist_id), -- Foreign key to playlist_names.playlist_id
  album_id INTEGER NOT NULL                           -- Reference to API album ID
);

INSERT INTO playlist_contents VALUES (1, 4);
INSERT INTO playlist_contents VALUES (1, 11);
INSERT INTO playlist_contents VALUES (1, 7);
INSERT INTO playlist_contents VALUES (1, 9);
INSERT INTO playlist_contents VALUES (1, 1);
INSERT INTO playlist_contents VALUES (2, 3);
INSERT INTO playlist_contents VALUES (2, 6);
INSERT INTO playlist_contents VALUES (2, 8);
INSERT INTO playlist_contents VALUES (3, 4);
INSERT INTO playlist_contents VALUES (3, 13);
INSERT INTO playlist_contents VALUES (4, 15);
INSERT INTO playlist_contents VALUES (4, 5);
INSERT INTO playlist_contents VALUES (5, 10);
INSERT INTO playlist_contents VALUES (5, 11);
INSERT INTO playlist_contents VALUES (5, 13);



CREATE TABLE album (
  id INTEGER PRIMARY KEY,
  title VARCHAR(255),
  artist VARCHAR(255),
  genre VARCHAR(255),
  yearReleased INTEGER,
  lengthInMin INTEGER,
  imgUrl VARCHAR(255)
);


CREATE TABLE track (
  album_id INTEGER not null,
  FOREIGN KEY (album_id) REFERENCES album (id),
  track_id INTEGER not null,
  title VARCHAR(255)
);

INSERT INTO album VALUES (1, 'Crash', 'Dave Matthews Band', 'Alternative Rock', 1996, 69, 'https://i.ibb.co/6wfNx9b/1.jpg');
INSERT INTO track VALUES (1,  1, 'So Much to Say');
INSERT INTO track VALUES (1,  2, 'Two Step');
INSERT INTO track VALUES (1,  3, 'Crash into Me');
INSERT INTO track VALUES (1,  4, 'Too Much');
INSERT INTO track VALUES (1,  5, '#41');
INSERT INTO track VALUES (1,  6, 'Sya Goodbye');
INSERT INTO track VALUES (1,  7, 'Drive In, Drive Out');
INSERT INTO track VALUES (1,  8, 'Let You Down');
INSERT INTO track VALUES (1,  9, 'Lie in Our Graves');
INSERT INTO track VALUES (1, 10, 'Cry Freedom');
INSERT INTO track VALUES (1, 11, 'Tripping Billies');
INSERT INTO track VALUES (1, 12, 'So Much to Say');

INSERT INTO album VALUES (2, 'Under the Table and Dreaming', 'Dave Matthews Band', 'Alternative Rock', 1994, 63, 'https://i.ibb.co/RSGLd70/2.jpg');
INSERT INTO track VALUES (2,  1, 'The Best of Whats Around');
INSERT INTO track VALUES (2,  2, 'What Would You Say');
INSERT INTO track VALUES (2,  3, 'Satellite');
INSERT INTO track VALUES (2,  4, 'Rhyme & Reason');
INSERT INTO track VALUES (2,  5, 'Typical Situation');
INSERT INTO track VALUES (2,  6, 'Dancing Nancies');
INSERT INTO track VALUES (2,  7, 'Ants Marching');
INSERT INTO track VALUES (2,  8, 'Lover Lay Down');
INSERT INTO track VALUES (2,  9, 'Jimi Thing');
INSERT INTO track VALUES (2, 10, 'Warehouse');
INSERT INTO track VALUES (2, 11, 'Pay for What You Get');
INSERT INTO track VALUES (2, 12, '#34');
INSERT INTO track VALUES (2, 13, 'Granny (20th anniversary edition bonus track)');
INSERT INTO track VALUES (2, 14, 'Dancing Nancies (acoustic) (20th anniversary edition bonus track)');
INSERT INTO track VALUES (2, 15, 'The Song That Jane Likes (acoustic) (20th anniversary edition bonus track)');

INSERT INTO album VALUES (3, 'Sgt. Peppers Lonely Hearts Club Band', 'The Beatles', 'Art Rock', 1967, 40, 'https://i.ibb.co/xqVG5gt/3.jpg');
INSERT INTO track VALUES (3,  1, 'Sgt. Peppers Lonely Hearts Club Band');
INSERT INTO track VALUES (3,  2, 'With a Little Help from My Friends');
INSERT INTO track VALUES (3,  3, 'Lucy in the Sky with Diamonds ');
INSERT INTO track VALUES (3,  4, 'Getting Better');
INSERT INTO track VALUES (3,  5, 'Fixing a Hole');
INSERT INTO track VALUES (3,  6, 'Shes Leaving Home');
INSERT INTO track VALUES (3,  7, 'Being for the Benefit of Mr. Kite!');
INSERT INTO track VALUES (3,  8, 'Within You Without You');
INSERT INTO track VALUES (3,  9, 'When Im Sixty-Four');
INSERT INTO track VALUES (3, 10, 'Lovely Rita');
INSERT INTO track VALUES (3, 11, 'Good Morning Good Morning"');
INSERT INTO track VALUES (3, 12, 'Sgt. Peppers Lonely Hearts Club Band (Reprise)');
INSERT INTO track VALUES (3, 13, 'A Day in the Life');

INSERT INTO album VALUES (4, 'Nevermind', 'Nirvana', 'Grunge', 1991, 42, 'https://i.ibb.co/stPqd73/4.jpg');
INSERT INTO track VALUES (4,  1, 'Smells Like Teen Spirit');
INSERT INTO track VALUES (4,  2, 'In Bloom');
INSERT INTO track VALUES (4,  3, 'Come as You Are"');
INSERT INTO track VALUES (4,  4, 'Breed');
INSERT INTO track VALUES (4,  5, 'Lithium');
INSERT INTO track VALUES (4,  6, 'Polly');
INSERT INTO track VALUES (4,  7, 'Territorial Pissings');
INSERT INTO track VALUES (4,  8, 'Drain You');
INSERT INTO track VALUES (4,  9, 'Lounge Act');
INSERT INTO track VALUES (4,  10, 'Stay Away');
INSERT INTO track VALUES (4,  11, 'On a Plain');
INSERT INTO track VALUES (4,  12, 'Something in the Way');
INSERT INTO track VALUES (4,  13, 'Endless, Nameless');

INSERT INTO album VALUES (5, 'When We All Fall Asleep, Where Do We Go?', 'Billie Eilish', 'Art Pop', 2019, 43, 'https://i.ibb.co/3dCqN8V/5.jpg');
INSERT INTO track VALUES (5,  1, '!!!!!!!');
INSERT INTO track VALUES (5,  2, 'bad guy');
INSERT INTO track VALUES (5,  3, 'xanny');
INSERT INTO track VALUES (5,  4, 'you should see me in a crown');
INSERT INTO track VALUES (5,  5, 'all the good girls go to hell');
INSERT INTO track VALUES (5,  6, 'wish you were gay');
INSERT INTO track VALUES (5,  7, 'when the partys over');
INSERT INTO track VALUES (5,  8, '8');
INSERT INTO track VALUES (5,  9, 'my strange addiction');
INSERT INTO track VALUES (5, 10, 'bury a friend');
INSERT INTO track VALUES (5, 11, 'ilomilo');
INSERT INTO track VALUES (5, 12, 'listen before I go');
INSERT INTO track VALUES (5, 13, 'i love you');
INSERT INTO track VALUES (5, 14, 'goodbye');

INSERT INTO album VALUES (6, 'Lover', 'Taylor Swift', 'Pop Rock', 2019, 62, 'https://i.ibb.co/zNLp9sH/6.jpg');
INSERT INTO track VALUES (6,  1, 'I Forgot That You Existed');
INSERT INTO track VALUES (6,  2, 'Cruel Summer');
INSERT INTO track VALUES (6,  3, 'Lover');
INSERT INTO track VALUES (6,  4, 'The Man');
INSERT INTO track VALUES (6,  5, 'The Archer');
INSERT INTO track VALUES (6,  6, 'I Think He Knows');
INSERT INTO track VALUES (6,  7, 'Miss Americana & the Heartbreak Prince');
INSERT INTO track VALUES (6,  8, 'Paper Rings');
INSERT INTO track VALUES (6,  9, 'Cornelia Street');
INSERT INTO track VALUES (6, 10, 'Death by a Thousand Cuts');
INSERT INTO track VALUES (6, 11, 'London Boy');
INSERT INTO track VALUES (6, 12, 'Soon Youll Get Better');
INSERT INTO track VALUES (6, 13, 'False God');
INSERT INTO track VALUES (6, 14, 'You Need to Calm Down');
INSERT INTO track VALUES (6, 15, 'Afterglow');
INSERT INTO track VALUES (6, 16, 'Me!');
INSERT INTO track VALUES (6, 17, 'Its Nice to Have a Friend');
INSERT INTO track VALUES (6, 18, 'Daylight');

INSERT INTO album VALUES (7, 'The Dark Side of the Moon', 'Pink Floyd', 'Progressive Rock', 1973, 42, 'https://i.ibb.co/p1Lnmvp/7.jpg');
INSERT INTO track VALUES (7,  1, 'Speak to Me');
INSERT INTO track VALUES (7,  2, 'Breathe');
INSERT INTO track VALUES (7,  3, 'On the Run');
INSERT INTO track VALUES (7,  4, 'Time');
INSERT INTO track VALUES (7,  5, 'The Great Gig in the Sky');
INSERT INTO track VALUES (7,  6, 'Money');
INSERT INTO track VALUES (7,  7, 'Us and Them');
INSERT INTO track VALUES (7,  8, 'Any Colour You Like');
INSERT INTO track VALUES (7,  9, 'Brain Damage');
INSERT INTO track VALUES (7, 10, 'Eclipse');


INSERT INTO album VALUES (8, 'Witness', 'Katy Perry', 'Electropop', 2017, 57, 'https://i.ibb.co/bmpsyBk/8.jpg');
INSERT INTO track VALUES (8,  1, 'Witness');
INSERT INTO track VALUES (8,  2, 'Hey Hey');
INSERT INTO track VALUES (8,  3, 'Roulette');
INSERT INTO track VALUES (8,  4, 'Swish Swish');
INSERT INTO track VALUES (8,  5, 'Déjà Vu');
INSERT INTO track VALUES (8,  6, 'Power');
INSERT INTO track VALUES (8,  7, 'Mind Maze');
INSERT INTO track VALUES (8,  8, 'Miss You More');
INSERT INTO track VALUES (8,  9, 'Chained to the Rhythm');
INSERT INTO track VALUES (8, 10, 'Tsunami');
INSERT INTO track VALUES (8, 11, 'Bon Appétit');
INSERT INTO track VALUES (8, 12, 'Bigger Than Me');
INSERT INTO track VALUES (8, 13, 'Save as Draft');
INSERT INTO track VALUES (8, 14, 'Pendulum');
INSERT INTO track VALUES (8, 15, 'Into Me You See');

INSERT INTO album VALUES (9, 'Back to Black', 'Amy Winehouse', 'Contemporary R&B', 2006, 35, 'https://i.ibb.co/Z2JDBfY/9.jpg');
INSERT INTO track VALUES (9,  1, 'Rehab');
INSERT INTO track VALUES (9,  2, 'You Know Im No Good');
INSERT INTO track VALUES (9,  3, 'Me & Mr Jones');
INSERT INTO track VALUES (9,  4, 'Just Friends');
INSERT INTO track VALUES (9,  5, 'Back to Black');
INSERT INTO track VALUES (9,  6, 'Love is a Loosing Game');
INSERT INTO track VALUES (9,  7, 'Tears Dry on Their Own');
INSERT INTO track VALUES (9,  8, 'Wake Up Alone');
INSERT INTO track VALUES (9,  9, 'Some Unholy War');
INSERT INTO track VALUES (9, 10, 'He Can Only Hold Her');
INSERT INTO track VALUES (9, 11, 'Addicted');

INSERT INTO album VALUES (10, 'Tanabata', 'Tentochi', 'Ambient Landscape', 1991, 64, 'https://i.ibb.co/d5kfW4V/10.jpg');
INSERT INTO track VALUES (10,  1, 'Mokurai');
INSERT INTO track VALUES (10,  2, 'Sophet');
INSERT INTO track VALUES (10,  3, 'Deft Phase');

INSERT INTO album VALUES (11, 'Treat Myself', 'Meghan Trainor', 'Pop', 2020, 56, 'https://i.ibb.co/257pMWr/11.jpg');
INSERT INTO track VALUES (11,  1, 'Wave');
INSERT INTO track VALUES (11,  2, 'Workin On It');
INSERT INTO track VALUES (11,  3, 'Evil Twin');
INSERT INTO track VALUES (11,  4, 'No Excuses');


INSERT INTO album VALUES (12, 'Punk', 'Chai', 'Japan Pop', 2019, 31, 'https://i.ibb.co/rmJQ8kK/12.jpg');
INSERT INTO track VALUES (12,  1, 'Choose Go!');
INSERT INTO track VALUES (12,  2, 'Great Job');
INSERT INTO track VALUES (12,  3, 'Im Me');
INSERT INTO track VALUES (12,  4, 'Wintime');
INSERT INTO track VALUES (12,  5, 'This is Chai');
INSERT INTO track VALUES (12,  6, 'Fashionista');
INSERT INTO track VALUES (12,  7, 'Family Member');
INSERT INTO track VALUES (12,  8, 'Curly Adventure');
INSERT INTO track VALUES (12,  9, 'Feel the Beat');
INSERT INTO track VALUES (12, 10, 'Future');


INSERT INTO album VALUES (13, 'Father of the Bride', 'Vampire Weekend', 'Indie Rock', 2019, 58, 'https://i.ibb.co/198McXr/13.jpg');
INSERT INTO track VALUES (13,  1, 'Hold You Now');
INSERT INTO track VALUES (13,  2, 'Harmony Hall');
INSERT INTO track VALUES (13,  3, 'Bambina');
INSERT INTO track VALUES (13,  4, 'This Life');
INSERT INTO track VALUES (13,  5, 'Big Blue');
INSERT INTO track VALUES (13,  6, 'How Long?');
INSERT INTO track VALUES (13,  7, 'Unbearably White');
INSERT INTO track VALUES (13,  8, 'Rich Man');
INSERT INTO track VALUES (13,  9, 'Married in a Gold Rush');
INSERT INTO track VALUES (13, 10, 'My Mistake');
INSERT INTO track VALUES (13, 11, 'Sympathy');
INSERT INTO track VALUES (13, 12, 'Sunflower');
INSERT INTO track VALUES (13, 13, 'Flower Moon');
INSERT INTO track VALUES (13, 14, '2021');
INSERT INTO track VALUES (13, 15, 'We Belong Together');
INSERT INTO track VALUES (13, 16, 'Stranger');
INSERT INTO track VALUES (13, 17, 'Spring Snow');
INSERT INTO track VALUES (13, 18, 'Jerusalem, New York, Berlin');

INSERT INTO album VALUES (14, 'Homecoming: The Live Album', 'Beyoncé', 'Live', 2019, 109, 'https://i.ibb.co/cCDkQPN/14.jpg');
INSERT INTO track VALUES (14,  1, 'Welcome');
INSERT INTO track VALUES (14,  2, 'Crazy in Love');
INSERT INTO track VALUES (14,  3, 'Freedom');
INSERT INTO track VALUES (14,  4, 'Lift Every Voice and Sing');
INSERT INTO track VALUES (14,  5, 'Formation');
INSERT INTO track VALUES (14,  6, 'So Much Damn Swag');
INSERT INTO track VALUES (14,  7, 'Sorry');
INSERT INTO track VALUES (14,  8, 'Kitty Kat');
INSERT INTO track VALUES (14,  9, 'Bow Down');
INSERT INTO track VALUES (14, 10, 'I Been On');

INSERT INTO album VALUES (15, 'Frozen II', 'various', 'Disney Original Soundtrack', 2019, 31, 'https://i.ibb.co/fdx3PD9/15.jpg');
INSERT INTO track VALUES (15,  1, 'All Is Found');
INSERT INTO track VALUES (15,  2, 'Some Things Never Change');
INSERT INTO track VALUES (15,  3, 'Into the Unknown');
INSERT INTO track VALUES (15,  4, 'When I Am Older');
INSERT INTO track VALUES (15,  5, 'Reindeer(s) Are Better Than People');
INSERT INTO track VALUES (15,  6, 'Lost in the Woods');
INSERT INTO track VALUES (15,  7, 'Show Yourself');
INSERT INTO track VALUES (15,  8, 'The Next Right Thing');
INSERT INTO track VALUES (15,  9, 'Into the Unknown (end credits)');
INSERT INTO track VALUES (15, 10, 'All Is Found (end credits)');
INSERT INTO track VALUES (15, 11, 'Lost in the Woods (end credits)');




INSERT INTO album VALUES (16, 'Flash Gordon', 'Queen', 'Soundtrack', 1980, 35, 'https://i.ibb.co/5kZy8sn/16.jpg');

INSERT INTO album VALUES (17, 'Exile on Main St.', 'The Rolling Stones', 'Hard Rock', 1972, 67, 'https://i.ibb.co/Gvh4wp8/17.jpg');

INSERT INTO album VALUES (18, 'London Calling', 'The Clash', 'Post-Punk Rock', 1979, 65, 'https://i.ibb.co/1zsr5tN/18.jpg');

INSERT INTO album VALUES (19, 'Good News for People Who Love Bad News', 'Modest Mouse', 'Indie Rock', 2004, 49, 'https://i.ibb.co/fdZSt73/19.jpg');

INSERT INTO album VALUES (20, 'Strange Trails', 'Lord Huron', 'Indie Rock', 2015, 55, 'https://i.ibb.co/FXNfnkc/20.jpg');

INSERT INTO album VALUES (21, 'This Empty Northern Hemisphere', 'Gregory Alan Isakov', '', 2009, 48, 'https://i.ibb.co/Sxp4JFc/21.jpg');

INSERT INTO album VALUES (22, 'Odelay', 'Beck', 'Alternative Rock', 1996, 54, 'https://i.ibb.co/hWJqJww/22.jpg');

INSERT INTO album VALUES (23, 'Nine', 'Blink 182', 'Pop Punk', 2019, 41, 'https://i.ibb.co/KzCZGw8/23.jpg');

INSERT INTO album VALUES (24, 'Title', 'Meghan Trainor', 'Doo-Wop Pop', 2015, 32, 'https://i.ibb.co/6r8V8H3/24.jpg');

INSERT INTO album VALUES (25, 'Hail to the King', 'Avenged Sevenfold', 'Heavy Metal', 2013, 53, 'https://i.ibb.co/kB1q5pT/25.jpg');

INSERT INTO album VALUES (26, 'Aquarium', 'Aqua', 'Eurodance', 1997, 41, 'https://i.ibb.co/1QDM82r/26.jpg');

INSERT INTO album VALUES (27, 'The Fame Monster', 'Lady Gaga', 'Electropop', 2009, 84, 'https://i.ibb.co/wN5gLJs/27.jpg');

INSERT INTO album VALUES (28, 'Tragic Kingdom', 'No Doubt', 'Third-Wave Ska', 1995, 60, 'https://i.ibb.co/XW1pJBW/28.jpg');

INSERT INTO album VALUES (29, 'American IV: The Man Comes Around', 'Johnny Cash', 'Acoustic Rock', 2002, 52, 'https://i.ibb.co/TTKfz7B/29.jpg');

INSERT INTO album VALUES (30, 'Unknown Pleasures', 'Joy Division', 'Post-Punk', 1979, 39, 'https://i.ibb.co/T1jMhVq/30.jpg');

COMMIT TRANSACTION;