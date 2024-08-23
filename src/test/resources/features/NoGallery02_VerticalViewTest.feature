# Устанавливаем CS-Cart настройки:
# * Показывать мини-иконки в виде галереи --      нет
# * Показывать информацию о товаре во вкладках -- нет
# * Включить быстрый просмотр --                  да

# Устанавливаем настройки модуля:
# * Включить вертикальное отображение --          да

@50_NoGallery02_VerticalView
Feature: Мини-иконки без галереи, Вкладки товара, Вертикальное отображение

  Scenario: Мини-иконки без галереи, Вкладки товара, Вертикальное отображение
    And CS-Cart настройки: Показывать мини-иконки БЕЗ галереи, Показывать информацию о товаре Без вкладок, Включить быстрый просмотр
    And Переходим в настройки модуля
    And Настройки модуля: Включить вертикальное отображение
    When Переходим на страницу редактирования товара
    And Переходим на витрину страницы товара
    And Переходим на страницу категории и открываем окно быстрого просмотра товара
    Then Делаем скриншот "@50_NoGallery02 Окно быстрого просмотра"

  Scenario Outline: Выполняем проверку на разных шаблонах товара
    When Переходим на страницу редактирования товара
    And Устанавливаем товару шаблон "<template>"
    And Переходим на витрину страницы товара
    And Делаем скриншот "<screenRu>"
    And Переключаем язык на "ar"
    Then Делаем скриншот "<screenRTL>"

    Examples:
      |template                               |screenRu                                              |screenRTL  |
      |abt__ut2_bigpicture_flat_template      |@50.00_NoGallery02_VerticalView - БК плоский          |@50.02_NoGallery02_VerticalView - БК плоский (RTL)        |
      |bigpicture_template                    |@50.10_NoGallery02_VerticalView - Большая картинка    |@50.12_NoGallery02_VerticalView - Большая картинка (RTL)  |
      |default_template                       |@50.20_NoGallery02_VerticalView - Стандартный шаблон  |@50.22_NoGallery02_VerticalView - Стандартный шаблон (RTL)|
      |abt__ut2_three_columns_template        |@50.30_NoGallery02_VerticalView - Трехколоночный      |@50.32_NoGallery02_VerticalView - Трехколоночный (RTL)    |
      |abt__ut2_bigpicture_gallery_template   |@50.40_NoGallery02_VerticalView - Галерея             |@50.42_NoGallery02_VerticalView - Галерея (RTL)           |
      |abt__ut2_cascade_gallery_template      |@50.50_NoGallery02_VerticalView - Каскад              |@50.52_NoGallery02_VerticalView - Каскад (RTL)            |
