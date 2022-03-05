package com.admin;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //使用这个注解,类下就可以使用Spring的功能,比如自动注入
@DisplayName("Junit 5功能测试类") //为测试类或者测试方法设置展示名称
public class Junit5Test {

    @Test
    @DisplayName("测试DisplayName注解1")
   void testDisplayName1(){
        System.out.println(1);
   }

    @Disabled //表示测试类或测试方法不执行
    @Test
    @DisplayName("测试DisplayName注解2")
    void testDisplayName2(){
        System.out.println(2);
    }


   @BeforeEach //在每个单元测试之前执行
   void testBeforeEach(){
       System.out.println("测试就要开始了...");
   }

   @AfterEach //在每个单元测试之后执行
    void AfterEach(){
       System.out.println("测试结束了");
   }

   @BeforeAll //在所有单元测试之前执行,需要声明静态
    static void BeforeAll(){
       System.out.println("所有测试就要开始了...");
   }

   @AfterAll //在所有单元测试之后执行,需要声明静态
    static void AfterAll(){
       System.out.println("所有测试结束了");
   }


   /*规定方法超出时间,超出时间测试出异常(此测试是超5000毫秒抛异常)*/
   @Timeout(value = 5000,unit = TimeUnit.MICROSECONDS)
   @Test
   void testTimeout()throws InterruptedException{
        Thread.sleep(1);
   }

   @RepeatedTest(5) //  重复测试5次
   @Test
   void testRepeated(){
       System.out.println(5);
   }

   int cal(int i,int j){
       return i+j;
   }


   //测试简单断言(如果前面的断言失败,后面的代码都不会执行.前面的值是期望值,后面的值是实际值)
   @DisplayName("测试简单断言")
   @Test
    void testSimpleAssertions(){
       int cal=cal(2,3);
       /*断言: 判断两个对象或两个原始类型是否相等 ,如果不相等,就提示这句话,当然也可以省略*/
       assertEquals(5,cal,"业务逻辑计算失败"); //简化了类名.静态方法名,用import static 替代,就可以直接写方法名
       Object obj1 = new Object();
       Object obj2 = new Object();
       /*断言: 判断两个对象引用是否指向同一个对象 */
       assertSame(obj1, obj2,"两个对象不一样");

   }

   //测试数组断言
    @Test
    @DisplayName("array assertion")
    public void testArray() {
        assertArrayEquals(new int[]{1, 2}, new int[] {1, 2},"数组内容不相等");
    }

    //组合断言(所有断言成功了才算成功)
    @Test
    @DisplayName("assert all")
    public void testAll() {
        assertAll("test",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(1 > 0)
        );
    }

    //异常断言(断言业务逻辑一定出现异常)
    @Test
    @DisplayName("异常断言")
    public void testException() {
        assertThrows(ArithmeticException.class, () -> {
            int i = 10 / 0;
        }, "业务逻辑居然正常运行!");
    }

    //快速失败(业务逻辑如果到一个程度符合失败情况,就立即宣布失败)
    @Test
    @DisplayName("快速失败")
    public void shouldFail() {
       if(2==2)
        fail("测试失败");
    }

    //测试前置条件(不满足的前置条件只会使得测试方法的执行终止)
    @Test
    @DisplayName("前置条件")
    void testAssumptions(){
       Assumptions.assumeTrue(true,"结果不是true");
        System.out.println("11111");
    }
}
