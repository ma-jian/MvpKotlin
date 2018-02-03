package com.example.majian.demo.di;

import com.example.majian.demo.activity.FragmentActivity;
import com.example.majian.demo.activity.MainActivity;
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
public interface ComPonent {
    void inject(FragmentActivity activity);
    void inject(MainActivity activity);
}
