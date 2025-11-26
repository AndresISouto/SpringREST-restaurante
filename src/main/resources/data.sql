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

INSERT INTO providers (name) VALUES
('Local Fresh Produce Market'),
('National Dairy Supply Inc.'),
('Gourmet Spice Imports Co.'),
('Wholesale Meat & Poultry Distributors'),
('Artisan Bakery Grains'),
('Southwest Seafood & Fish'),
('Specialty Oils & Vinegars'),
('Frozen Foods Mega Supply'),
('Beverage & Drink Corp.'),
('Cleaning and Janitorial Supplies'),
('Eco-Friendly Packaging Solutions'),
('Italian Food Distributors (IFD)'),
('Asian Cuisine Supply (ACS)'),
('Regional Potato & Root Farmers'),
('Sweeteners and Confectionery Co.'),
('Canned & Dry Goods Wholesaler'),
('Certified Organic Farms'),
('Restaurant Equipment & Repair'),
('Local Microbrewery'),
('Coffee Bean & Tea Leaf Source');

INSERT INTO reviews (recipe_id, body) VALUES
-- Recipe 1: Classic Cheeseburger (ID 1)
(1, 'The cheeseburger was absolutely classic and delicious! Patty was juicy and the bun was perfectly toasted. A solid menu item.'),
-- Recipe 2: Margherita Pizza (ID 2)
(2, 'The Margherita Pizza was decent, but the crust was a little too thin and crispy for my taste. Good fresh basil flavor though.'),
-- Recipe 3: Spaghetti Bolognese (ID 3)
(3, 'Excellent Bolognese! Rich, meaty sauce and perfectly cooked pasta. Great value for the price.'),
-- Recipe 4: Chicken Caesar Salad (ID 4)
(4, 'The Chicken Caesar Salad was fresh, but the dressing lacked zest. The chicken was cooked well, but overall, it was uninspired.'),
-- Recipe 5: French Onion Soup (ID 5)
(5, 'Authentic and comforting. The caramelized onions were sweet and the cheese crust was bubbly and gooey. Highly recommend the soup!'),
-- Recipe 6: Tuna Sashimi (ID 6)
(6, 'Exceptional quality tuna! Very fresh and well-cut. A bit pricey, but worth it for the quality.'),
-- Recipe 7: Vegetable Curry (ID 7)
(7, 'The Vegetable Curry had great spice and flavor depth, but the vegetables were slightly overcooked and mushy.'),
-- Recipe 8: Grilled Steak Frites (ID 8)
(8, 'The steak was cooked exactly medium-rare as requested, and the frites were crispy. A flawless dish.'),
-- Recipe 9: Chocolate Lava Cake (ID 9)
(9, 'Rich, gooey center! A perfect dessert. It was served hot with a side of vanilla ice cream, exactly as it should be.'),
-- Recipe 10: Fish and Chips (ID 10)
(10, 'The fish batter was light and crispy, not greasy at all. The chips were thick-cut and well-seasoned.'),
-- Recipe 11: Beef Tacos (ID 11)
(11, 'Good, quick tacos. The seasoning on the beef was a little mild for my liking, but the fresh salsa helped.'),
-- Recipe 12: Penne alla Vodka (ID 12)
(12, 'The Penne alla Vodka sauce was silky smooth and delicious. A satisfying and indulgent pasta dish.'),
-- Recipe 13: Avocado Toast (ID 13)
(13, 'Simple but effective. The bread was toasted nicely, and the avocado was fresh. Perfect light lunch.'),
-- Recipe 14: Pad Thai (Chicken) (ID 14)
(14, 'This Pad Thai was disappointing. It was too sweet and lacked the necessary tanginess. The noodles were also a bit sticky.'),
-- Recipe 15: New York Cheesecake (ID 15)
(15, 'Easily the best cheesecake in the city! Creamy, dense, and the crust was perfect. A massive portion.'),
-- Recipe 16: Lentil Soup (ID 16)
(16, 'A hearty and flavorful soup, great for a cold day. Excellent texture and fresh herbs.'),
-- Recipe 17: Blackened Salmon (ID 17)
(17, 'The salmon was cooked beautifully—flaky and moist. The blackening spice added a nice kick without being overpowering.'),
-- Recipe 18: BBQ Pulled Pork Sandwich (ID 18)
(18, 'The pulled pork was tender, but the BBQ sauce was too vinegary. The coleslaw was a good crunchy complement.'),
-- Recipe 19: Gourmet Waffle (Dessert) (ID 19)
(19, 'The waffle itself was good, but the berries seemed a little past their prime. Could be improved with fresher toppings.'),
-- Recipe 20: House Salad (Side) (ID 20)
(20, 'A simple, fresh side salad. Nothing fancy, but the vinaigrette was light and flavorful.');

INSERT INTO sales (emmision_date, state, amount) VALUES
-- Recent Sales (PAID)
(CURRENT_DATE(), 'PAID', 45.75),
(CURRENT_DATE(), 'PAID', 12.99),
(CURRENT_DATE(), 'PAID', 78.50),
(CURRENT_DATE(), 'PAID', 9.50),
(CURRENT_DATE(), 'PAID', 105.25),
(CURRENT_DATE(), 'PAID', 21.40),
(CURRENT_DATE(), 'PAID', 33.60),
(CURRENT_DATE(), 'PAID', 55.00),

-- Sales from yesterday (PAID)
(DATE_SUB(CURRENT_DATE(), INTERVAL 1 DAY), 'PAID', 67.80),
(DATE_SUB(CURRENT_DATE(), INTERVAL 1 DAY), 'PAID', 18.99),
(DATE_SUB(CURRENT_DATE(), INTERVAL 1 DAY), 'PAID', 92.15),
(DATE_SUB(CURRENT_DATE(), INTERVAL 1 DAY), 'PAID', 11.20),

-- Older Sales (PAID)
(DATE_SUB(CURRENT_DATE(), INTERVAL 3 DAY), 'PAID', 40.00),
(DATE_SUB(CURRENT_DATE(), INTERVAL 5 DAY), 'PAID', 75.30),
(DATE_SUB(CURRENT_DATE(), INTERVAL 8 DAY), 'PAID', 29.99),

-- Pending Sales (for open/unpaid orders)
(CURRENT_DATE(), 'UNPAID', 50.50),
(CURRENT_DATE(), 'UNPAID', 14.75),

-- Canceled Sales
(DATE_SUB(CURRENT_DATE(), INTERVAL 2 DAY), 'UNPAID', 80.00),
(DATE_SUB(CURRENT_DATE(), INTERVAL 4 DAY), 'UNPAID', 22.00),
(DATE_SUB(CURRENT_DATE(), INTERVAL 1 DAY), 'UNPAID', 30.25);

INSERT INTO sales_recipes (sale_id, recipe_id, amount) VALUES
-- Sale 1 (Total: 45.75) - Family Meal
(1, 1, 4),    -- 4x Classic Cheeseburger
(1, 4, 1),    -- 1x Chicken Caesar Salad
(1, 9, 2),    -- 2x Chocolate Lava Cake

-- Sale 2 (Total: 12.99) - Simple Order
(2, 3, 1),    -- 1x Spaghetti Bolognese
(2, 20, 1),   -- 1x House Salad

-- Sale 3 (Total: 78.50) - Large Dinner
(3, 8, 2),    -- 2x Grilled Steak Frites
(3, 5, 2),    -- 2x French Onion Soup
(3, 15, 0),   -- 0x New York Cheesecake (This recipe is portions=8, likely sold whole, so 0 amount for the slice recipe)

-- Sale 4 (Total: 9.50) - Single Lunch Item
(4, 3, 1),    -- 1x Spaghetti Bolognese

-- Sale 5 (Total: 105.25) - Dessert and Mains
(5, 15, 1),   -- 1x New York Cheesecake (sold whole, amount 1 unit)
(5, 17, 3),   -- 3x Blackened Salmon

-- Sale 6 (Total: 21.40) - Quick Order
(6, 10, 1),   -- 1x Fish and Chips
(6, 12, 1),   -- 1x Penne alla Vodka

-- Sale 7 (Total: 33.60) - Tacos and Soup
(7, 11, 2),   -- 2x Beef Tacos (Set of 3)
(7, 16, 2),   -- 2x Lentil Soup

-- Sale 8 (Total: 55.00) - Pizza and Extras
(8, 2, 3),    -- 3x Margherita Pizza
(8, 20, 2),   -- 2x House Salad

-- Sale 9 (Total: 67.80) - Mains from yesterday
(9, 14, 2),   -- 2x Pad Thai (Chicken)
(9, 18, 2),   -- 2x BBQ Pulled Pork Sandwich

-- Sale 10 (Total: 18.99) - Single Dessert
(10, 19, 2),  -- 2x Gourmet Waffle (Dessert)

-- Sale 11 (Total: 92.15) - High-Value Order
(11, 6, 4),   -- 4x Tuna Sashimi

-- Sale 12 (Total: 11.20) - Simple Item
(12, 7, 1),   -- 1x Vegetable Curry

-- Sale 13 (Total: 40.00) - Variety
(13, 1, 2),   -- 2x Classic Cheeseburger
(13, 12, 1),  -- 1x Penne alla Vodka
(13, 4, 1),   -- 1x Chicken Caesar Salad

-- Sale 14 (Total: 75.30) - Larger Order
(14, 8, 1),   -- 1x Grilled Steak Frites
(14, 17, 2),  -- 2x Blackened Salmon

-- Sale 15 (Total: 29.99) - Mixed Order
(15, 10, 1),  -- 1x Fish and Chips
(15, 14, 1),  -- 1x Pad Thai (Chicken)

-- Sale 16 (PENDING, Total: 50.50)
(16, 3, 3),   -- 3x Spaghetti Bolognese
(16, 13, 2),  -- 2x Avocado Toast

-- Sale 17 (PENDING, Total: 14.75)
(17, 18, 1),  -- 1x BBQ Pulled Pork Sandwich
(17, 20, 2);  -- 2x House Salad

INSERT INTO ingredients_providers (ingredient_id, provider_id) VALUES
(1, 5),
(1, 16),
(2, 2),
(3, 3),
(3, 13),
(4, 1),
(4, 17),
(5, 4),
(6, 1),
(7, 15),
(8, 7),
(9, 6),
(10, 14),
(11, 16),
(12, 5),
(13, 8),
(14, 1),
(15, 2),
(16, 4),
(16, 17),
(17, 3),
(18, 14),
(19, 16),
(20, 13),
(18, 8),
(10, 17),
(15, 11),
(13, 9);
