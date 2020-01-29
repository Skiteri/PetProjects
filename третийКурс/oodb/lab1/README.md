<h1>Лабораторная работа 1</h1>

<b>Тема:</b> Разработка объектно-ориентированной модели данных прикладной задачи.

<b>Цель:</b> Научиться разрабатывать объектно-ориентированную модель данных прикладной задачи.

<b>Рассмотрим небольшой фрагмент задачи по добавлению товаров клиентов в корзину:</b><br> 
необходимо вести реестр клиентов, заказы клиентов
(у каждого может быть несколько), товары. 

<b>Выделим основные сущности:</b>
<br>
<a href = "https://github.com/Skiteri/oodb/blob/master/lab1/User.java">Клиент</a>
<br>
<a href = "https://github.com/Skiteri/oodb/blob/master/lab1/Item.java">Товар</a>
<br>
<a href = "https://github.com/Skiteri/oodb/blob/master/lab1/Order.java">Заказ</a>
<br>
<a href = "https://github.com/Skiteri/oodb/blob/master/lab1/UserToOrder.java">Отношение многие-ко-многим заказ-клиент</a>
