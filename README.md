# Игра "Виселица"

## Цель 
Показать понимания принципов чистого кода, ООП дизайна
и шаблона проектирования MVC

## Правила игры
>Один из игроков загадывает слово — пишет на бумаге любые две буквы слова и отмечает места для остальных букв[2], например чертами (существует также вариант, когда изначально все буквы слова неизвестны). Также рисуется виселица с петлёй.
> 
>Согласно традиции русских лингвистических игр, слово должно быть именем существительным, нарицательным в именительном падеже единственного числа, либо множественного числа при отсутствии у слова формы единственного числа.
> 
>Второй игрок предлагает букву, которая может входить в это слово. Если такая буква есть в слове, то первый игрок пишет её над соответствующими этой букве чертами — столько раз, сколько она встречается в слове. Если такой буквы нет, то к виселице добавляется круг в петле, изображающий голову. Второй игрок продолжает отгадывать буквы до тех пор, пока не отгадает всё слово. За каждый неправильный ответ первый игрок добавляет одну часть туловища к виселице (обычно их 6: голова, туловище, 2 руки и 2 ноги, существует также вариант с 8 частями — добавляются ступни, а также самый длинный вариант, когда сначала за неотгаданную букву рисуются части самой виселицы).
> 
> Если туловище в виселице нарисовано полностью, то отгадывающий игрок проигрывает, считается повешенным. Если игроку удаётся угадать слово, он выигрывает и может загадывать слово.
 

[wiki виселица](https://ru.wikipedia.org/wiki/%D0%92%D0%B8%D1%81%D0%B5%D0%BB%D0%B8%D1%86%D0%B0_%28%D0%B8%D0%B3%D1%80%D0%B0%29)
## Кадры игры
### Начальный экран
````
   +---+		Игра Виселица
   |   |	1. Начать
   o   |	2. Язык/Language: Русский
  /|\  |	3. Тема: Общая
  / \  |	4. Уровень: Нормальный
+======+	5. Выход
Выберете пункт меню:
````
````
   +---+		Game Gallows
   |   |	1. Start
   o   |	2. Language: English
  /|\  |	3. Theme: General
  / \  |	4. Level: Medium
+======+	5. Exit
Select a menu item: 
````
### Игровой ход
````
   +---+		Игра Виселица, ход: 9
   |   |	Слово: Т_Е_С_Т_*_*_О_*_А_*_*_Е
       |	Отгадано (5): О, А, Е, Т, С
       |	Ошибки (2): У, Э
       |	Ввод: С
+======+	Буква 'С' есть в слове
Введите букву: 
````
````
   +---+		Game Gallows, turn: 7
   |   |	Word: *_E_S_*_I_N_G
   o   |	Hits (5): G, I, N, E, S
       |	Miss (2): A, L
       |	Input: L
+======+	The letter 'L' is not in the word
Input letter:
````
