# Устанавливаем CS-Cart настройки:
# * Показывать мини-иконки в виде галереи --      да
# * Показывать информацию о товаре во вкладках -- да
# * Включить быстрый просмотр --                  да

# Устанавливаем настройки модуля
# * Включить вертикальное отображение --          нет

@30_Gallery02_HorizontalView
Feature: Мини-иконки в виде галереи, Вкладки товара, Горизонтальное отображение

  Scenario: Мини-иконки в виде галереи, Вкладки товара, Горизонтальное отображение
    And CS-Cart настройки: Показывать мини-иконки "в виде" галереи, Показывать информацию о товаре "в виде" вкладок, Включить быстрый просмотр
    And Переходим в настройки модуля
    And "Отключаем" настройку модуля: Включить вертикальное отображение
    When Переходим на страницу редактирования товара
    And Переходим на витрину страницы товара
    And Переходим на страницу категории и открываем окно быстрого просмотра товара
    Then Делаем скриншот "@30_Gallery02_HorizontalView Окно быстрого просмотра"

  Scenario Outline: Выполняем проверку на разных шаблонах товара
    When Переходим на страницу редактирования товара
    And Устанавливаем товару шаблон "<template>"
    Then Сохраняем страницу товара
    And Переходим на витрину страницы товара
    And Делаем скриншот "<screenRu>"
    And Переключаем язык на "ar"
    Then Делаем скриншот "<screenRTL>"

    Examples:
      |template                               |screenRu                                              |screenRTL  |
      |abt__ut2_bigpicture_flat_template      |@30.00_Gallery02_HorizontalView - БК плоский          |@30.02_Gallery02_HorizontalView - БК плоский (RTL)        |
      |bigpicture_template                    |@30.10_Gallery02_HorizontalView - Большая картинка    |@30.12_Gallery02_HorizontalView - Большая картинка (RTL)  |
      |default_template                       |@30.20_Gallery02_HorizontalView - Стандартный шаблон  |@30.22_Gallery02_HorizontalView - Стандартный шаблон (RTL)|
      |abt__ut2_three_columns_template        |@30.30_Gallery02_HorizontalView - Трехколоночный      |@30.32_Gallery02_HorizontalView - Трехколоночный (RTL)    |
      |abt__ut2_bigpicture_gallery_template   |@30.40_Gallery02_HorizontalView - Галерея             |@30.42_Gallery02_HorizontalView - Галерея (RTL)           |
      |abt__ut2_cascade_gallery_template      |@30.50_Gallery02_HorizontalView - Каскад              |@30.52_Gallery02_HorizontalView - Каскад (RTL)            |
