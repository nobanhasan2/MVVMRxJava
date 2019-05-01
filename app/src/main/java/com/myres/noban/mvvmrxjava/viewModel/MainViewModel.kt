package com.myres.noban.mvvmrxjava.viewModel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.myres.noban.mvvmrxjava.actions.MainActivityAction
import com.myres.noban.mvvmrxjava.model.Posts
import com.myres.noban.mvvmrxjava.repository.PostRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.function.Consumer

class MainViewModel(
    application: Application,
    val mainActivityAction: MainActivityAction
) : AndroidViewModel(application) {

    private var postRepository: PostRepository = PostRepository(application)
    private val compositeDisposable = CompositeDisposable()

    var isLoading = ObservableField<Boolean>()
    var posts = MutableLiveData<ArrayList<Posts>>()

    fun loadRepositories() {
        isLoading.set(true)

        compositeDisposable.add(
            postRepository.getRepositories()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeWith(object : DisposableObserver<ArrayList<Posts>>() {
                    override fun onNext(data: ArrayList<Posts>) {
                        posts.value = data
                    }

                    override fun onError(e: Throwable) {
                        mainActivityAction.showErrorInfo(e.message.toString())
                    }

                    override fun onComplete() {
                        isLoading.set(false)
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()

        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

}
