# Устанавливаем CS-Cart настройки:
# * Показывать мини-иконки в виде галереи --      да
# * Показывать информацию о товаре во вкладках -- да
# * Включить быстрый просмотр --                  да

# Устанавливаем настройки модуля
# * Включить вертикальное отображение --          да

@20_Gallery01_VerticalView
Feature: Мини-иконки в виде галереи, Вкладки товара, Вертикальное отображение

  Scenario: Мини-иконки в виде галереи, Вкладки товара, Вертикальное отображение
    And CS-Cart настройки: Показывать мини-иконки в виде галереи, Показывать информацию о товаре во вкладках, Включить быстрый просмотр
    And Переходим в настройки модуля
    And Настройки модуля: Включить вертикальное отображение
    When Переходим на страницу редактирования товара
    And Переходим на витрину страницы товара
    And Переходим на страницу категории и открываем окно быстрого просмотра товара
    Then Делаем скриншот "@20_@20_Gallery01_VerticalView - Окно быстрого просмотра"

  Scenario Outline: Выполняем проверку на разных шаблонах товара
    When Переходим на страницу редактирования товара
    And Устанавливаем товару шаблон "<template>"
    And Переходим на витрину страницы товара
    And Делаем скриншот "<screenRu>"
    And Переключаем на RTL язык
    Then Делаем скриншот "<screenRTL>"

    Examples:
      |template                               |screenRu                                                |screenRTL  |
      |abt__ut2_bigpicture_flat_template      |@20.00_@20_Gallery01_VerticalView - БК плоский          |@20.02_@20_Gallery01_VerticalView - БК плоский (RTL)        |
      |bigpicture_template                    |@20.10_@20_Gallery01_VerticalView - Большая картинка    |@20.12_@20_Gallery01_VerticalView - Большая картинка (RTL)  |
      |default_template                       |@20.20_@20_Gallery01_VerticalView - Стандартный шаблон  |@20.22_@20_Gallery01_VerticalView - Стандартный шаблон (RTL)|
      |abt__ut2_three_columns_template        |@20.30_@20_Gallery01_VerticalView - Трехколоночный      |@20.32_@20_Gallery01_VerticalView - Трехколоночный (RTL)    |
      |abt__ut2_bigpicture_gallery_template   |@20.40_@20_Gallery01_VerticalView - Галерея             |@20.42_@20_Gallery01_VerticalView - Галерея (RTL)           |
      |abt__ut2_cascade_gallery_template      |@20.50_@20_Gallery01_VerticalView - Каскад              |@20.52_@20_Gallery01_VerticalView - Каскад (RTL)            |
