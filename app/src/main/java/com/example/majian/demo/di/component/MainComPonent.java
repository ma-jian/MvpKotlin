package com.example.majian.demo.di.component;

import com.example.majian.demo.activity.MainActivity;
import com.example.majian.demo.di.module.MainModule;
import com.example.majian.mvpkotlin.di.compoent.AppComponent;
import com.example.majian.mvpkotlin.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by majian
 * Date : 2018/1/16
 * Describe :
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = MainModule.class)
public interface MainComPonent {
    void inject(MainActivity activity);
}
