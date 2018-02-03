package com.example.majian.mvpkotlin.mvp
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import com.example.majian.mvpkotlin.utils.Preconditions
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : Presenter 基类 传入Module层 View层
 */
open class BasePresenter<M : IModule, V : IView> : IPresenter, LifecycleObserver {
    var mModule: M? = null
    var mView: V? = null
    var compositeDisposable: CompositeDisposable? = null

    constructor(module: M, view: V) {
        Preconditions.checkNotNull(module, "%s cannot be null", IModule::class.java.name)
        Preconditions.checkNotNull(view, "%s cannot be null", IView::class.java.name)
        this.mModule = module
        this.mView = view
        onStart()
    }

    constructor(view: V) {
        Preconditions.checkNotNull(view, "%s cannot be null", IView::class.java.name)
        this.mView = view
        onStart()
    }

    constructor(){
        onStart()
    }


    override fun onStart() {
        if (mView != null && mView is LifecycleOwner) {
            (mView as LifecycleOwner).lifecycle.addObserver(this)
            if (mModule != null && mModule is LifecycleObserver) {
                (mView as LifecycleOwner).lifecycle.addObserver(mModule as LifecycleObserver)
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestory(lifecycleOwner: LifecycleOwner) {
        lifecycleOwner.lifecycle.removeObserver(this)
    }

    override fun onDestory() {
        unDisposable()
        this.mModule = null
        this.mView = null
        compositeDisposable = null
    }

    fun addDisposable(disposable: Disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable!!.addAll(disposable)
    }

    fun unDisposable() {
        if (compositeDisposable != null) {
            compositeDisposable!!.clear()
        }
    }
}