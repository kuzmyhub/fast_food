insert into dishes(name, description, cost, photo, available)
values('Бургер классический',
 'Булочки, котлета домашняя, лук, солёные огурчики, томаты, салат айзберг, кетчуп',
  350,
   pg_read_binary_file('C:\projects\job4j_fast_food\dish\img\menu\clasic.png')::bytea,
    true);

insert into dishes(name, description, cost, photo, available)
values('Чизбургер',
 'Булочки, котлета домашняя, солёные огурчики, сырный соус',
  390,
   pg_read_binary_file('C:\projects\job4j_fast_food\dish\img\menu\cheese.png')::bytea,
    true);

insert into dishes(name, description, cost, photo, available)
values('Бургер грибной',
 'Булочки, котлета домашняя, грибы, лук, томаты, салат латук, грибной соус',
  300,
   pg_read_binary_file('C:\projects\job4j_fast_food\dish\img\menu\mushrooms.png')::bytea,
    true);

insert into dishes(name, description, cost, photo, available)
values('Бургер веган',
 'Булочки, фалафель, солёные огурчики, томаты, салат латук, соус бешамель на воде',
  400,
   pg_read_binary_file('C:\projects\job4j_fast_food\dish\img\menu\vegan.png')::bytea,
    true);

insert into dishes(name, description, cost, photo, available)
values('Шаурма',
 'Лаваш, свинина, капуста, лук, морковь, томаты, петрушка, кефирный соус, томатный соус',
  250,
   pg_read_binary_file('C:\projects\job4j_fast_food\dish\img\menu\shawarma.png')::bytea,
    true);

insert into dishes(name, description, cost, photo, available)
values('Луковые кольца',
 'Лук в панировке обжаренный во фритюре',
  180,
   pg_read_binary_file('C:\projects\job4j_fast_food\dish\img\menu\onion.png')::bytea,
    true);

insert into dishes(name, description, cost, photo, available)
values('Картофель фри',
 'Картофель обжаренный во фритюре',
  120,
   pg_read_binary_file('C:\projects\job4j_fast_food\dish\img\menu\potato.png')::bytea,
    true);

insert into dishes(name, description, cost, photo, available)
values('Соус на выбор',
 'Томатный, сырный, грибной, майонезный, барбекю, сладкий чили',
  80,
   pg_read_binary_file('C:\projects\job4j_fast_food\dish\img\menu\sauce.png')::bytea,
    true);

