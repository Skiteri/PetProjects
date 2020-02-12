<h1>Курсовая работа</h1>
Фестиваль фильмов
</br>
</br>
<b>Цель: </b>полная автоматизация процесса взаимодействия действующих лиц, уменьшение вычислительной
работы (подсчет голосов, выявление победителя в определенной категории)
</br>
<b>Задачи исследования:</b>
</br>
<ul>
  <li>проанализировать данную предметную область;</li>
  <li>сконструировать графический интерфейс пользователей;</li>
  <li>спроектировать базу данных, определить используемые классы(переменные и методы класса);</li>
  <li>определить структуру проекта(контроллеры, классы, графические интерфейсы, необходимые ресурсы, тесты);</li>
  <li>обусловить функциональные способности системы;</li>
  <li>реализовать систему;</li>
  <li>протестировать работу проекта;</li>
</ul>
<b>Реализация: </b> Используя структуру паттерна MVC с помощью <a href = "https://github.com/Skiteri/PetProjects/tree/master/%D0%B2%D1%82%D0%BE%D1%80%D0%BE%D0%B9%D0%9A%D1%83%D1%80%D1%81/cinemaFestival/src/main/resources/FXML"> fxml файлов</a>, определяем <b>View</b>(вид) </br>нашей системы. 
Для<b> Model</b> будут организовны
<a href = "https://github.com/Skiteri/PetProjects/tree/master/%D0%B2%D1%82%D0%BE%D1%80%D0%BE%D0%B9%D0%9A%D1%83%D1%80%D1%81/cinemaFestival/src/main/java/com/cursovaya/objects"> сущности</a> - POJO - классы.
<a href = "https://github.com/Skiteri/PetProjects/tree/master/%D0%B2%D1%82%D0%BE%D1%80%D0%BE%D0%B9%D0%9A%D1%83%D1%80%D1%81/cinemaFestival/src/main/java/com/cursovaya/controllers"> Controller</a> классы связывают java - код с fxml файлами. C помощью JDBC создаем класс connection(был удалён в целях безопасности), который будет подключаться к базе данных и получать доступ к ним через <a href = https://github.com/Skiteri/PetProjects/tree/master/%D0%B2%D1%82%D0%BE%D1%80%D0%BE%D0%B9%D0%9A%D1%83%D1%80%D1%81/cinemaFestival/src/main/java/com/cursovaya/helpler">классы-помощники</a>, работающие c MySQL
