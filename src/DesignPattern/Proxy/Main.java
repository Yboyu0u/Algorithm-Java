package DesignPattern.Proxy;

import DesignPattern.Proxy.Aop.AopBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args){
//        Browser browser = new Browser("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();

//        IBrowser browser = new BrowserProxy("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser browser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now-start.get());
                });
        browser.show();
        System.out.println("loading time: "+end.get());

        browser.show();
        System.out.println("loading time: "+end.get());
    }
}
