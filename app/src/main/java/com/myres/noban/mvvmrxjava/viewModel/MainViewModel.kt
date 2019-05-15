package com.myres.noban.mvvmrxjava.viewModel

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.myres.noban.mvvmrxjava.model.Posts
import com.myres.noban.mvvmrxjava.repository.PostRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

import io.reactivex.schedulers.Schedulers

class MainViewModel(
    application: Application
) : AndroidViewModel(application) {

    private var postRepository: PostRepository = PostRepository(application)
    private val compositeDisposable = CompositeDisposable()

    var isLoading = ObservableField<Boolean>()
    var posts = MutableLiveData<List<Posts>>()

    fun loadRepositories() {
        isLoading.set(true)

        postRepository.getRepositories()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(this::onSuccess, this::onError)
            ?.let { compositeDisposable.add(it) }
    }

    private fun onSuccess(posts: List<Posts>?) {
        isLoading.set(false)
        this.posts.value= posts
    }

    private fun onError(throwable: Throwable) {
        isLoading.set(false)
        Log.e("Success",""+ throwable.message)
    }

    override fun onCleared() {
        super.onCleared()

        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

}
