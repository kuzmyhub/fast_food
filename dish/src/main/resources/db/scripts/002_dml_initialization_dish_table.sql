insert into dishes(name, description, cost, available)
values('Бургер классический',
 'Булочки, котлета домашняя, лук, солёные огурчики, томаты, салат айзберг, кетчуп',
  350,
    true)
    ON CONFLICT DO NOTHING;

insert into dishes(name, description, cost, available)
values('Чизбургер',
 'Булочки, котлета домашняя, солёные огурчики, сырный соус',
  390,
    true)
    ON CONFLICT DO NOTHING;

insert into dishes(name, description, cost, available)
values('Бургер грибной',
 'Булочки, котлета домашняя, грибы, лук, томаты, салат латук, грибной соус',
  300,
    true)
    ON CONFLICT DO NOTHING;

insert into dishes(name, description, cost, available)
values('Бургер веган',
 'Булочки, фалафель, солёные огурчики, томаты, салат латук, соус бешамель на воде',
  400,
    true)
    ON CONFLICT DO NOTHING;

insert into dishes(name, description, cost, available)
values('Шаурма',
 'Лаваш, свинина, капуста, лук, морковь, томаты, петрушка, кефирный соус, томатный соус',
  250,
    true)
    ON CONFLICT DO NOTHING;

insert into dishes(name, description, cost, available)
values('Луковые кольца',
 'Лук в панировке обжаренный во фритюре',
  180,
    true)
    ON CONFLICT DO NOTHING;

insert into dishes(name, description, cost, available)
values('Картофель фри',
 'Картофель обжаренный во фритюре',
  120,
    true)
    ON CONFLICT DO NOTHING;

insert into dishes(name, description, cost, available)
values('Соус на выбор',
 'Томатный, сырный, грибной, майонезный, барбекю, сладкий чили',
  80,
    true)
    ON CONFLICT DO NOTHING;

