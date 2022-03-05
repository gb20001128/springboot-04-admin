package com.admin;
//参数化测试,我们将可以使用不同的参数进行多次单元测试
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;

public class Parameterized {

    @ParameterizedTest
    @DisplayName("参数化测试1")
    @ValueSource(ints = {1, 2, 3}) //为参数化测试指定入参来源
    public void parameterizedTest1(int i) {
        System.out.println(i);//会逐个打印ValueSource里提供的参数值
    }


    @ParameterizedTest
    @DisplayName("方法来源参数")
    @MethodSource("method")      //指定方法名
    public void testWithExplicitLocalMethodSource(String name) {
        System.out.println(name);//会逐个打印method方法提供的字符串
    }

    static Stream<String> method() {
        return Stream.of("apple", "banana");
    }
}
