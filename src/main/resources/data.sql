INSERT INTO dog (id, name, description)
VALUES (97, 'Rocky', 'Um Chihuahua marrom conhecido por ser protetor.'),
       (87, 'Bailey', 'Um Dachshund bege conhecido por ser brincalhão.'),
       (89, 'Charlie', 'Um Bulldog preto conhecido por ser curioso.'),
       (67, 'Cooper', 'Um Boxer bege conhecido por ser carinhoso.'),
       (73, 'Max', 'Um Dachshund tigrado conhecido por ser energético.'),
       (3, 'Buddy', 'Um Poodle conhecido por ser calmo.'),
       (93, 'Duke', 'Um Pastor Alemão branco conhecido por ser amigável.'),
       (63, 'Jasper', 'Um Shih Tzu cinza conhecido por ser protetor.'),
       (69, 'Toby', 'Um Doberman cinza conhecido por ser brincalhão.'),
       (101, 'Nala', 'Um Pastor Alemão manchado conhecido por ser leal.'),
       (61, 'Penny', 'Um Dogue Alemão branco conhecido por ser protetor.'),
       (1, 'Bella', 'Um Poodle dourado conhecido por ser calmo.'),
       (91, 'Willow', 'Um Dogue Alemão tigrado conhecido por ser calmo.'),
       (5, 'Daisy', 'Um Poodle manchado conhecido por ser carinhoso.'),
       (95, 'Mia', 'Um Dogue Alemão cinza conhecido por ser leal.'),
       (71, 'Molly', 'Um Chihuahua dourado conhecido por ser curioso.'),
       (65, 'Ruby', 'Um Dogue Alemão branco conhecido por ser protetor.'),
       (45, 'Prancer', 'Um cão demoníaco, neurótico, que odeia homens, animais e crianças, parecendo um gremlin.')
ON CONFLICT (id) DO UPDATE
    SET name        = EXCLUDED.name,
        description = EXCLUDED.description;