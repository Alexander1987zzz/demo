package com.task.livecodetask;

//import java.util.Collection;
//import java.util.Iterator;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.List;
//
//public class LiveCodeClass {
//
//    @Component
//    public class A {
//        @Autowired
//        public B b;
//    }
//
//    @Component
//    public class B {
//        @Autowired
//        public A a;
//    }
////
//    @Component
//    public class A {
//        public void methodA() {
//            //some logic
//        }
//    }
//
//    @Component
//    public class B {
//        @Autowired
//        public A a;
//
//        public B() {
//            a.methodA();
//        }
//    }
//
//    interface C{}
//
//    @Component
//    public class A implements C{
//
//    }
//
//    @Component
//    public class B implements C{
//
//    }
//
//    @Component
//    @RequiredArgsConstructor
//    public class D {
//
//        private final C c;
//
//
//    }


//
//
//  void foo() throws Exception {
//
//        //какое исключение будет выброшено из блока?
//        try{
//            throw new Exception("1");
//        }
//        finally {
//            throw new Exception("2");
//        }

//
//      //как получить из пойманного исключения другое не изменяя код метода foo
//  }
//
//  void foo(){
//synchronized (obj){
//        //что означает этот блок?
//
//        void bar(){
//        obj.add();
//        }}}
//Что будет со вторым потоком если он одновременно пойдет в этот метод этого же класса?
//



//public static Supplier<Integer> incrementer(int start) {
//        return () -> start++;
//    }
//


//}
