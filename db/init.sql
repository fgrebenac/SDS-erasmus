CREATE DATABASE erasmus_app;
\connect erasmus_app;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE country(
	id UUID PRIMARY KEY  DEFAULT uuid_generate_v4(),
	name VARCHAR(50) NOT NULL,
	icon VARCHAR(255));
		

CREATE TABLE app_user(
	id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(255) NOT NULL,
	home_country_id UUID  NOT NULL,
	CONSTRAINT fk_home_country_id FOREIGN KEY(home_country_id) REFERENCES country(id),
	token VARCHAR(50));

CREATE TABLE category(
	id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	name VARCHAR(50) NOT NULL,
	category_id UUID,
	CONSTRAINT fk_parent_category FOREIGN KEY(category_id) REFERENCES category(id));
	
CREATE TABLE thread(
	id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	title VARCHAR(50),
	content VARCHAR(50),
	user_id UUID NOT NULL,
	CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES app_user(id),
	category_id UUID NOT NULL,
	CONSTRAINT fk_category_id FOREIGN KEY(category_id) REFERENCES category(id));

CREATE TABLE app_comment(
	id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	content VARCHAR(50) NOT NULL,
	user_id UUID NOT NULL,
	CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES app_user(id),
	app_comment_id UUID,
	CONSTRAINT fk_app_comment_id FOREIGN KEY(app_comment_id) REFERENCES app_comment(id),
	thread_id UUID,
	CONSTRAINT fk_thread_id FOREIGN KEY(thread_id) REFERENCES thread(id));
	

