# Устанавливаем CS-Cart настройки:
# * Показывать мини-иконки в виде галереи --      да
# * Показывать информацию о товаре во вкладках -- да
# * Включить быстрый просмотр --                  да

# Устанавливаем настройки модуля
# * Включить вертикальное отображение --          да

@20
Feature: Мини-иконки в виде галереи, Вкладки товара, Вертикальное отображение

  Scenario: Устанавливаем необходимые настройки
    And CS-Cart настройки: Показывать мини-иконки в виде галереи, Показывать информацию о товаре во вкладках, Включить быстрый просмотр
    And Переходим в настройки модуля
    And Настройки модуля: Включить вертикальное отображение

  Scenario Outline: Выполняем проверку на разных шаблонах товара
    When Переходим на страницу редактирования товара "adizero Rush Shoes"
    And Устанавливаем товару шаблон "<template>"
    And Переходим на витрину страницы товара
    And Делаем скриншот "<screenRu>"
    And Переключаем на RTL язык
    Then Делаем скриншот "<screenRTL>"

    Examples:
      |template                               |screenRu  |screenRTL  |
      |abt__ut2_bigpicture_flat_template      |@20.00 Галерея, Вертикально - БК плоский          |@20.02 Галерея, Вертикально - БК плоский (RTL)        |
      |bigpicture_template                    |@20.10 Галерея, Вертикально - Большая картинка    |@20.12 Галерея, Вертикально - Большая картинка (RTL)  |
      |default_template                       |@20.20 Галерея, Вертикально - Стандартный шаблон  |@20.22 Галерея, Вертикально - Стандартный шаблон (RTL)|
      |abt__ut2_three_columns_template        |@20.30 Галерея, Вертикально - Трехколоночный      |@20.32 Галерея, Вертикально - Трехколоночный (RTL)    |
      |abt__ut2_bigpicture_gallery_template   |@20.40 Галерея, Вертикально - Галерея             |@20.42 Галерея, Вертикально - Галерея (RTL)           |
      |abt__ut2_cascade_gallery_template      |@20.50 Галерея, Вертикально - Каскад              |@20.52 Галерея, Вертикально - Каскад (RTL)            |