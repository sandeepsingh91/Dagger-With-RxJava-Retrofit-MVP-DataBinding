package test.com.testapp.ui;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import test.com.testapp.PostApi;
import test.com.testapp.base.BasePresenter;
import test.com.testapp.components.PresenterComponent;
import test.com.testapp.modal.Post;

public class TestPresenter extends BasePresenter {

    @Inject
    PostApi postApi;

    public TestPresenter(TestView view) {
        super(view);
    }


    public void loadPosts() {
        ((TestView) getView()).showLoading();
        postApi.getPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        ((TestView) getView()).hideLoading();
                    }
                })
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        System.out.println("TestPresenter.onNext");
                        ((TestView) getView()).updatePosts(posts);
                    }

                    @Override
                    public void onError(Throwable e) {
                        ((TestView) getView()).showError("unknown_error");
                        System.out.println("TestPresenter.onError");
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public void inject(PresenterComponent injector) {
        injector.inject(this);
    }
}
