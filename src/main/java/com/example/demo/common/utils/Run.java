package com.example.demo.common.utils;

/**
 * @author jiwei.chen
 * @create 2018-10-17
 */
public class Run implements Runnable {

    private String name;

    public Run(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (this.name.equals("jack")){
            UserUtil.setLocalUser(this.name);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程名称："+Thread.currentThread().getName()+"，当前登录人信息："+UserUtil.getUserIfLogin());
    }
}
