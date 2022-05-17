package common;

public class Config {

    public static final String PLATFORM_AND_BROWSER = "win_chrome";

    /**
     * Удаляет куки браузера после прогона теста
     * если true, то очищаются куки
     */
    public static final Boolean CLEAR_COOKIES_AND_STORAGE = true;

    /**
     * Закрывает браузер после прогона сьюта (можно установить свой)
     * если true, то закрывается браузер
     */
    public static final Boolean HOLD_BROWSER_OPEN = true;
}
