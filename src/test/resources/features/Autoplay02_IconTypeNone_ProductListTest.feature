# Устанавливаем CS-Cart настройки:
# * Показывать мини-иконки в виде галереи --      нет
# * Показывать информацию о товаре во вкладках -- нет
# * Включить быстрый просмотр --                  да

# Устанавливаем настройки модуля:
# * Включить вертикальное отображение --          нет

# Устанавливаем настройки товара:
# * Автовоспроизведение           --              да
# * Показывать в списках товаров  --              да
# * Тип иконки                    --              Без иконки

@65_Autoplay02_IconTypeNone_ProductList
Feature: Автовоспроизведение видео на всех страницах, Без иконки, Горизонтальное отображение

  Scenario: Автовоспроизведение видео на всех страницах, Без иконки, Горизонтальное отображение
    And CS-Cart настройки: Показывать мини-иконки БЕЗ галереи, Показывать информацию о товаре Без вкладок, Включить быстрый просмотр
    And Переходим в настройки модуля
    And Настройки модуля: Включить горизонтальное отображение
    When Переходим на страницу редактирования товара
    And Устанавливаем товару шаблон "abt__ut2_cascade_gallery_template"

  Scenario Outline: Выполняем проверку Автовоспроизведения с разными типами видео
    When Переходим на страницу редактирования товара
    When Переходим во вкладку АВ: Видео галерея
    When Активируем настройку "ab__vg__autoplay__" для видео с типом "<Video type>"
    When Активируем настройку "ab__vg__show_in_list__" для видео с типом "<Video type>"
    When У настройки `Тип иконки` выбираем значение "none" для видео с типом "<Video type>"

    And Переходим на витрину страницы товара
    And Проверяем, что видео с автовоспроизведением присутствует среди мини-иконок
    And Делаем скриншот видео с автовоспроизведением "<screenRu on product page>"
    And Проверяем, что во вкладке товара видео с автовоспроизведением отсутствует
    And Переключаем язык на "ar"
    And Делаем скриншот видео с автовоспроизведением "<screenRTL on product page>"
    And Переключаем язык на "ru"
    And Переходим на страницу категории и открываем окно быстрого просмотра товара
    And Делаем скриншот видео <Icon> с автовоспроизведением в окне быстрого просмотра "<Quick view>"
    And Закрываем окно быстрого просмотра
    And Проверяем, что видео автовоспроизводится на странице категории
    Then Делаем скриншот "<screenRu category page>"
    And Переключаем язык на "ar"
    Then Делаем скриншот "<screenRTL category page>"

    Examples:
      |Video type |Icon |screenRu on product page                             |screenRTL on product page                                    |Quick view                                             |screenRu category page                                   |screenRTL category page                                       |
      |YouTube    |1    |@65_Autoplay02 - YouTube, Страница товара с Autoplay |@65_Autoplay02 - YouTube, Страница товара с Autoplay (RTL)   |@65_Autoplay02 - YouTube, Быстрый просмотр с Autoplay  |@65_Autoplay02 - YouTube, страница категории с Autoplay  |@65_Autoplay02 - YouTube, Страница категории с Autoplay (RTL) |
      |Vimeo      |2    |@65_Autoplay02 - Vimeo, Страница товара с Autoplay   |@65_Autoplay02 - Vimeo, Страница товара с Autoplay (RTL)     |@65_Autoplay02 - Vimeo, Быстрый просмотр с Autoplay    |@65_Autoplay02 - Vimeo, страница категории с Autoplay    |@65_Autoplay02 - Vimeo, Страница категории с Autoplay (RTL)   |
      |Ссылка     |3    |@65_Autoplay02 - Link, Страница товара с Autoplay    |@65_Autoplay02 - Link, Страница товара с Autoplay (RTL)      |@65_Autoplay02 - Link, Быстрый просмотр с Autoplay     |@65_Autoplay02 - Link, страница категории с Autoplay     |@65_Autoplay02 - Link, Страница категории с Autoplay  (RTL)   |
      |Ресурс     |4    |@65_Autoplay02 - Resource, Страница товара с Autoplay|@65_Autoplay02 - Resource, Страница товара с Autoplay (RTL)  |@65_Autoplay02 - Resource, Быстрый просмотр с Autoplay |@65_Autoplay02 - Resource, страница категории с Autoplay |@65_Autoplay02 - Resource, Страница категории с Autoplay (RTL)|
