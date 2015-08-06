package io.github.brightyoyo;

/**
 * @author goodev
 * @since 15/8/6
 */
public interface Heater {
    void on();  //加热器打开

    void off(); //加热器关闭

    boolean isHot(); // 加热是否完毕
}
