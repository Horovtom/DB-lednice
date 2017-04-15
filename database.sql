CREATE TABLE "Difficulty" (
"id_difficulty" SERIAL NOT NULL,
"Level" varchar(15) UNIQUE NOT NULL,
PRIMARY KEY("id_difficulty"));

CREATE TABLE "Recipe" (
"id_recipe" SERIAL NOT NULL,
"name" varchar(255) NOT NULL,
"people_amount" int2 NOT NULL,
"description" text NOT NULL,
"Food_id_food" int4 NOT NULL,
"Difficulty_id_difficulty" int4 NOT NULL,
PRIMARY KEY("id_recipe"),
CONSTRAINT "ck_check" CHECK(people_amount >
0));

CREATE TABLE "Ingredient" (
"id_ingredient" SERIAL NOT NULL,
"name" varchar(255) NOT NULL,
"unit" varchar(63) NOT NULL,
"price_per_unit" numeric(6,2) NOT NULL,
"amount" int4 NOT NULL,
"expiration_date" date,
"Fridge_id_fridge" int4 NOT NULL,
PRIMARY KEY("id_ingredient"),
CONSTRAINT "ck_check" CHECK(amount > 0 AND
price_per_unit > 0));

CREATE TABLE "Fridge" (
"id_fridge" SERIAL NOT NULL,
"capacity" int4 NOT NULL,
"note" text,
PRIMARY KEY("id_fridge"),
CONSTRAINT "ck_check" CHECK(capacity > 0));

CREATE TABLE "Food" (
"id_food" SERIAL NOT NULL,
"name" varchar(255) NOT NULL,
PRIMARY KEY("id_food"));

CREATE TABLE "FoodType" (
"id_foodtype" SERIAL NOT NULL,
"typefood" varchar(255) UNIQUE NOT NULL,
PRIMARY KEY("id_foodtype"));

CREATE TABLE "Food_has_FoodType" (
"Food_id_food" int4 NOT NULL,
"FoodType_id_foodtype" int4 NOT NULL,
PRIMARY
KEY("Food_id_food","FoodType_id_foodtype"));

CREATE TABLE "Ingredient_has_Recipe" (
"Ingredient_id_ingredient" int4 NOT NULL,
"Recipe_id_recipe" int4 NOT NULL,
"ingredient_amount" int2 NOT NULL,
"amount_multiplicator" int2 NOT NULL,
PRIMARY
KEY("Ingredient_id_ingredient","Recipe_id_recipe"),
CONSTRAINT "ck_check" CHECK(ingredient_amount
> 0));

ALTER TABLE "Recipe" ADD CONSTRAINT "Ref_Recipe_to_Food"
FOREIGN KEY ("Food_id_food")
REFERENCES "Food"("id_food")
MATCH SIMPLE
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE "Recipe" ADD CONSTRAINT
"Ref_Recipe_to_Difficulty" FOREIGN KEY
("Difficulty_id_difficulty")
REFERENCES "Difficulty"("id_difficulty")
MATCH SIMPLE
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE "Ingredient" ADD CONSTRAINT
"Ref_Ingredient_to_Fridge" FOREIGN KEY ("Fridge_id_fridge")
REFERENCES "Fridge"("id_fridge")
MATCH SIMPLE
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
ALTER TABLE "Food_has_FoodType" ADD CONSTRAINT
"Ref_Food_has_FoodType_to_Food" FOREIGN KEY
("Food_id_food")
REFERENCES "Food"("id_food")
MATCH SIMPLE
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE "Food_has_FoodType" ADD CONSTRAINT
"Ref_Food_has_FoodType_to_FoodType" FOREIGN KEY
("FoodType_id_foodtype")
REFERENCES "FoodType"("id_foodtype")
MATCH SIMPLE
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE "Ingredient_has_Recipe" ADD CONSTRAINT
"Ref_Ingredient_has_Recipe_to_Ingredient" FOREIGN KEY
("Ingredient_id_ingredient")
REFERENCES "Ingredient"("id_ingredient")
MATCH SIMPLE
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE "Ingredient_has_Recipe" ADD CONSTRAINT
"Ref_Ingredient_has_Recipe_to_Recipe" FOREIGN KEY
("Recipe_id_recipe")
REFERENCES "Recipe"("id_recipe")
MATCH SIMPLE
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;