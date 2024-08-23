# Устанавливаем CS-Cart настройки:
# * Показывать мини-иконки в виде галереи --      нет
# * Показывать информацию о товаре во вкладках -- нет
# * Включить быстрый просмотр --                  да

# Устанавливаем настройки модуля:
# * Включить вертикальное отображение --          нет

@40_NoGallery01_HorizontalView
Feature: Мини-иконки без галереи, Вкладки товара, Горизонтальное отображение

  Scenario: Мини-иконки без галереи, Вкладки товара, Горизонтальное отображение
    And CS-Cart настройки: Показывать мини-иконки БЕЗ галереи, Показывать информацию о товаре Без вкладок, Включить быстрый просмотр
    And Переходим в настройки модуля
    And Настройки модуля: Включить горизонтальное отображение
    When Переходим на страницу редактирования товара
    And Переходим на витрину страницы товара
    And Переходим на страницу категории и открываем окно быстрого просмотра товара
    Then Делаем скриншот "@40_NoGallery01_HorizontalView Окно быстрого просмотра"

  Scenario Outline: Выполняем проверку на разных шаблонах товара
    When Переходим на страницу редактирования товара
    And Устанавливаем товару шаблон "<template>"
    And Переходим на витрину страницы товара
    And Делаем скриншот "<screenRu>"
    And Переключаем язык на "ar"
    Then Делаем скриншот "<screenRTL>"

    Examples:
      |template                               |screenRu                                                |screenRTL  |
      |abt__ut2_bigpicture_flat_template      |@40.00_NoGallery01_HorizontalView - БК плоский          |@40.02_NoGallery01_HorizontalView - БК плоский (RTL)        |
      |bigpicture_template                    |@40.10_NoGallery01_HorizontalView - Большая картинка    |@40.12_NoGallery01_HorizontalView - Большая картинка (RTL)  |
      |default_template                       |@40.20_NoGallery01_HorizontalView - Стандартный шаблон  |@40.22_NoGallery01_HorizontalView - Стандартный шаблон (RTL)|
      |abt__ut2_three_columns_template        |@40.30_NoGallery01_HorizontalView - Трехколоночный      |@40.32_NoGallery01_HorizontalView - Трехколоночный (RTL)    |
      |abt__ut2_bigpicture_gallery_template   |@40.40_NoGallery01_HorizontalView - Галерея             |@40.42_NoGallery01_HorizontalView - Галереи (RTL)           |
      |abt__ut2_cascade_gallery_template      |@40.50_NoGallery01_HorizontalView - Каскад              |@40.52_NoGallery01_HorizontalView - Каскад (RTL)            |
