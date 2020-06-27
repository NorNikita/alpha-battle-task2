create table payments (
  id serial not null primary key,
  ref text,
  category_id bigint,
  user_id text not null,
  recipient_id text,
  description text,
  amount float
);