package com.changhao.demo04;

public class TestLambda1 {
    // 3. 静态类
    static class Like2 implements ILike {
        public void lambda() {
            System.out.println("I like coding2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        // 4. 局部类
        class Like3 implements ILike {
            public void lambda() {
                System.out.println("I like coding3");
            }
        }

        like = new Like3();
        like.lambda();

        // 5. 匿名局部类，需要借助接口来实现
        like = new ILike() {
            public void lambda() {
                System.out.println("I like coding4");
            }
        };
        like.lambda();

        // 6. 用lambda简化
        like = () -> {
            System.out.println("I like coding5");
        };

        like.lambda();


    }

}

// 1. 实现接口，并且该接口只有一个方法，这种接口叫做函数式接口, functional interface
interface ILike {
    void lambda();
}

// 2. 实现具体的接口类
class Like implements ILike {
    public void lambda() {
        System.out.println("I like coding1");
    }
}


