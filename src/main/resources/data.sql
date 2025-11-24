INSERT INTO ingredients (name, amount, unit, price_per_unit, last_update) VALUES
('All-Purpose Flour', 50.00, 'kg', 0.75, CURRENT_DATE()),
('Whole Milk', 200.00, 'L', 1.10, CURRENT_DATE()),
('Black Peppercorns', 5.00, 'kg', 8.50, CURRENT_DATE()),
('Roma Tomatoes', 80.00, 'kg', 1.50, CURRENT_DATE()),
('Ground Beef (80/20)', 120.00, 'kg', 6.90, CURRENT_DATE()),
('Fresh Basil', 1.00, 'kg', 15.00, DATE_SUB(CURRENT_DATE(), INTERVAL 3 DAY)),
('Granulated Sugar', 100.00, 'kg', 0.95, CURRENT_DATE()),
('Extra Virgin Olive Oil', 50.00, 'L', 4.50, CURRENT_DATE()),
('Atlantic Salmon Fillets', 30.00, 'kg', 12.00, DATE_SUB(CURRENT_DATE(), INTERVAL 1 DAY)),
('Yellow Onions', 150.00, 'kg', 0.85, CURRENT_DATE()),
('Canned Black Beans', 25.00, 'Kg', 12.00, CURRENT_DATE()),
('Active Dry Yeast', 2.00, 'kg', 18.00, CURRENT_DATE()),
('Mayonnaise', 40.00, 'L', 3.20, CURRENT_DATE()),
('Lemons', 500.00, 'Kg', 0.35, CURRENT_DATE()),
('Parmesan Cheese (grated)', 10.00, 'kg', 9.50, DATE_SUB(CURRENT_DATE(), INTERVAL 2 DAY)),
('Chicken Breast (boneless)', 90.00, 'kg', 5.50, CURRENT_DATE()),
('Kosher Salt', 25.00, 'kg', 0.40, CURRENT_DATE()),
('Potatoes (Russet)', 200.00, 'kg', 0.60, CURRENT_DATE()),
('Baking Powder', 3.00, 'kg', 4.00, CURRENT_DATE()),
('Soy Sauce (low sodium)', 30.00, 'L', 2.50, CURRENT_DATE());

INSERT INTO recipes (name, portions, steps, precio_coste, precio_venta) VALUES
('Classic Cheeseburger', 1, 'Toast bun, cook patty, melt cheese, add lettuce, tomato, and sauce.', 2.50, 8.99),
('Margherita Pizza', 4, 'Prepare dough, spread tomato sauce, add fresh mozzarella and basil, bake until golden.', 4.20, 15.50),
('Spaghetti Bolognese', 1, 'Cook meat sauce with herbs, boil spaghetti, combine and top with parmesan.', 1.85, 9.50),
('Chicken Caesar Salad', 1, 'Grill chicken, chop romaine, toss with dressing, croutons, and parmesan.', 2.10, 7.99),
('French Onion Soup', 1, 'Caramelize onions, add beef stock, simmer, pour into bowl, top with bread and gruyère, broil.', 1.50, 6.75),
('Tuna Sashimi', 1, 'Slice fresh tuna, arrange on plate, serve with soy sauce, wasabi, and ginger.', 6.50, 18.00),
('Vegetable Curry', 2, 'Sauté vegetables, add curry paste and coconut milk, simmer until tender, serve with rice.', 3.10, 10.99),
('Grilled Steak Frites', 1, 'Season and grill steak to desired doneness, fry potatoes, serve with compound butter.', 7.80, 24.50),
('Chocolate Lava Cake', 1, 'Mix batter, pour into ramekin, bake until edges are firm and center is molten, serve with ice cream.', 1.25, 6.50),
('Fish and Chips', 1, 'Batter cod fillets, deep-fry fish and thick-cut chips, serve with tartar sauce.', 3.50, 11.50),
('Beef Tacos (Set of 3)', 1, 'Cook seasoned ground beef, warm tortillas, fill with beef, lettuce, cheese, and salsa.', 2.00, 8.75),
('Penne alla Vodka', 2, 'Cook penne pasta, prepare creamy tomato vodka sauce, toss pasta, garnish with parsley.', 2.60, 13.99),
('Avocado Toast', 1, 'Toast bread, mash avocado, season with salt and pepper, top with chili flakes.', 1.15, 5.99),
('Pad Thai (Chicken)', 1, 'Stir-fry noodles with chicken, eggs, and sauce, garnish with peanuts and lime.', 3.30, 12.50),
('New York Cheesecake', 8, 'Combine crust and filling, bake slowly, chill overnight, serve with fruit topping.', 5.50, 35.00),
('Lentil Soup', 4, 'Sauté vegetables, add lentils and broth, simmer until tender, season to taste.', 2.00, 8.50),
('Blackened Salmon', 1, 'Season salmon fillet with blackening spice, sear quickly in a hot pan, serve with a side of rice.', 5.10, 16.99),
('BBQ Pulled Pork Sandwich', 1, 'Shred slow-cooked pork, mix with BBQ sauce, pile onto a toasted bun with coleslaw.', 2.90, 9.25),
('Gourmet Waffle (Dessert)', 1, 'Cook waffle batter, top with seasonal berries, whipped cream, and powdered sugar.', 1.40, 7.25),
('House Salad (Side)', 1, 'Toss mixed greens, cucumber, and tomatoes with house vinaigrette.', 0.80, 4.00);

INSERT INTO recipes_ingredients (recipe_id, ingredient_id, amount, unit) VALUES
-- Recipe 1: Classic Cheeseburger
(1, 5, 150.0, 'Kg'),   -- Ground Beef
(1, 10, 10.0, 'Kg'),   -- Yellow Onions
(1, 17, 2.0, 'Kg'),    -- Kosher Salt
(1, 3, 1.0, 'L'), -- Black Peppercorns

-- Recipe 2: Margherita Pizza
(2, 1, 300.0, 'Kg'),   -- All-Purpose Flour
(2, 6, 20.0, 'Kg'),    -- Fresh Basil
(2, 17, 5.0, 'Kg'),    -- Kosher Salt
(2, 8, 15.0, 'L'), -- Olive Oil

-- Recipe 3: Spaghetti Bolognese
(3, 5, 100.0, 'Kg'),   -- Ground Beef
(3, 4, 150.0, 'Kg'),   -- Roma Tomatoes
(3, 10, 50.0, 'Kg'),   -- Yellow Onions
(3, 15, 10.0, 'Kg'),   -- Parmesan Cheese

-- Recipe 4: Chicken Caesar Salad
(4, 16, 120.0, 'Kg'),  -- Chicken Breast
(4, 15, 10.0, 'Kg'),   -- Parmesan Cheese
(4, 13, 20.0, 'L'), -- Mayonnaise

-- Recipe 5: French Onion Soup
(5, 10, 200.0, 'Kg'),  -- Yellow Onions
(5, 17, 3.0, 'Kg'),    -- Kosher Salt

-- Recipe 6: Tuna Sashimi (Simple)
(6, 9, 100.0, 'Kg'),   -- Atlantic Salmon (assuming tuna is available from same provider)

-- Recipe 7: Vegetable Curry
(7, 18, 150.0, 'Kg'),  -- Potatoes
(7, 10, 50.0, 'Kg'),   -- Yellow Onions
(7, 8, 10.0, 'L'), -- Olive Oil

-- Recipe 8: Grilled Steak Frites
(8, 17, 5.0, 'Kg'),    -- Kosher Salt
(8, 18, 250.0, 'Kg'),  -- Potatoes (Frites)

-- Recipe 9: Chocolate Lava Cake
(9, 7, 50.0, 'Kg'),    -- Granulated Sugar
(9, 1, 20.0, 'Kg'),    -- All-Purpose Flour

-- Recipe 10: Fish and Chips
(10, 17, 4.0, 'Kg'),   -- Kosher Salt
(10, 18, 300.0, 'Kg'),  -- Potatoes (Chips)
(10, 1, 50.0, 'Kg'),    -- All-Purpose Flour

-- Recipe 11: Beef Tacos
(11, 5, 120.0, 'Kg'),  -- Ground Beef
(11, 4, 30.0, 'Kg'),   -- Roma Tomatoes
(11, 19, 1.0, 'L'), -- Baking Powder (for seasoning mix)

-- Recipe 12: Penne alla Vodka
(12, 15, 20.0, 'Kg'),  -- Parmesan Cheese
(12, 2, 50.0, 'L'), -- Whole Milk (for creaminess)

-- Recipe 13: Avocado Toast
(13, 17, 1.0, 'Kg'),    -- Kosher Salt
(13, 1, 2.0, 'Kg'),    -- All-Purpose Flour (for the bread, assuming bread is made or bought)

-- Recipe 14: Pad Thai (Chicken)
(14, 16, 100.0, 'Kg'),  -- Chicken Breast
(14, 20, 10.0, 'L'), -- Soy Sauce

-- Recipe 15: New York Cheesecake
(15, 7, 200.0, 'Kg'),  -- Granulated Sugar
(15, 19, 1.0, 'L'), -- Baking Powder

-- Recipe 16: Lentil Soup
(16, 10, 100.0, 'Kg'),  -- Yellow Onions
(16, 17, 5.0, 'Kg'),    -- Kosher Salt
(16, 14, 1.0, 'Kg'),    -- Lemons (for zest/juice)

-- Recipe 17: Blackened Salmon
(17, 9, 150.0, 'Kg'),  -- Atlantic Salmon
(17, 8, 10.0, 'L'), -- Olive Oil

-- Recipe 18: BBQ Pulled Pork Sandwich
(18, 17, 4.0, 'Kg'),    -- Kosher Salt
(18, 7, 10.0, 'Kg'),    -- Granulated Sugar (for BBQ sauce)

-- Recipe 19: Gourmet Waffle
(19, 19, 2.0, 'L'), -- Baking Powder
(19, 2, 50.0, 'L'), -- Whole Milk
(19, 7, 20.0, 'Kg'),    -- Granulated Sugar

-- Recipe 20: House Salad
(20, 8, 15.0, 'L'), -- Olive Oil
(20, 14, 10.0, 'Kg'); -- Lemons (for vinaigrette)
