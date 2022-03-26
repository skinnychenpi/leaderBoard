CREATE TABLE problems
(
    problem_number integer primary key,
    description text
);

CREATE TABLE records
(
    submit_index serial primary key,
    user_name varchar(256),
    problem_number integer,
    time_cost numeric,
    submit_time integer
);

