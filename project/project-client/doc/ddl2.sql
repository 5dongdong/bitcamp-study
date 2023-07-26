create table project_wheres(
  money_no int not null,
  wheres varchar(255) not null,
  price int not null,
  created_date datetime default now()
);

alter table project_wheres
  add constraint primary key (money_no),
  modify column money_no int not null auto_increment;
  

  
  
  
  